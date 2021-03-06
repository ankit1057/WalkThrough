/*
 * MIT License
 *
 * Copyright (c) 2016 Robots and Pencils
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.robotsandpencils.walkthrough.presentation.main;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.robotsandpencils.walkthrough.R;
import com.robotsandpencils.walkthrough.databinding.ActivityWalkthroughBinding;
import com.robotsandpencils.walkthrough.presentation.common.Navigator;
import com.robotsandpencils.walkthrough.presentation.common.dependency.dagger.DaggerWrapper;
import com.robotsandpencils.walkthrough.presentation.communication.LayoutTheme;
import com.robotsandpencils.walkthrough.presentation.communication.WalkThroughManager;
import com.robotsandpencils.walkthrough.presentation.main.paging.screens.Page;

import java.util.List;

import javax.inject.Inject;

public class WalkThroughActivity extends AppCompatActivity implements WalkThroughPresenter.View,
                                                                      WalkThroughPresenter.Spinner {

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private ActivityWalkthroughBinding mBinding;

    @Inject
    Navigator mNavigator;

    @Inject
    WalkThroughPresenter mPresenter;

    @Inject
    WalkThroughManager mWalkThroughManager;

    private ProgressDialog progress;

    private Page.Listener listener = new Page.Listener() {
        @Override
        public void onClose(String exitText) {
            mWalkThroughManager.onComplete(exitText);
            finish();
        }

        @Override
        public void onNext(List<Page> pageList) {
            if (pageList.size() > 0) {
                mNavigator.showPagerFragment(getSupportFragmentManager(), pageList,
                        mWalkThroughManager.getLayoutConfiguration().getLayoutTheme());
            }
        }

        @Override
        public void onBack() {
            mNavigator.onUpPressed(getSupportFragmentManager());
            checkForExit(1, WalkThroughManager.WALKTHROUGH_DEFAULT_EXIT_MESSAGE);
        }

        @Override
        public boolean onNextPage() {
            return mNavigator.onNextPagePressed();
        }

        @Override
        public boolean onPreviousPage() {
            return mNavigator.onPreviousPagePressed();
        }

        @Override
        public boolean onDeletePage() {
            return mNavigator.onDeletePagePressed();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerWrapper.getObjectGraph().inject(this);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_walkthrough);
        mBinding.fragmentContainer.setBackgroundColor(ContextCompat.getColor(this, mWalkThroughManager.getDefaultColor()));
        mPresenter.attach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mNavigator.clear();
        mPresenter.detach();
    }

    @Override
    public void onResume() {
        super.onResume();
        mWalkThroughManager.setSpinner(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mWalkThroughManager.setSpinner(null);
    }

    @Override
    public void showWalkThrough() {
        List<Page> layouts = mWalkThroughManager.getLayoutConfiguration().getLayouts();
        for (Page page : layouts) {
            page.setListener(listener);
        }

        mNavigator.showPagerFragment(getSupportFragmentManager(), layouts,
                mWalkThroughManager.getLayoutConfiguration().getLayoutTheme());
    }

    @Override
    public void showProgress() {
        LayoutTheme layoutTheme = mWalkThroughManager.getLayoutConfiguration().getLayoutTheme();
        String message = getString(layoutTheme.getProgressMessage());

        if (layoutTheme.useVerticalProgressDialog()) {
            View view = View.inflate(this, R.layout.vertically_centered_progress_dialog, null);
            TextView progressMessage = (TextView) view.findViewById(R.id.progress_message);
            progressMessage.setText(message);
            progress = ProgressDialog.show(this, null, null, true);
            progress.setContentView(view);
        } else {
            progress = new ProgressDialog(this);
            progress.setMessage(message);
            progress.setIndeterminate(false);
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.show();
        }

        if (progress.getWindow() != null) {
            progress.getWindow().setBackgroundDrawable(layoutTheme.getProgressBackground());
        }
    }

    @Override
    public void hideProgress() {
        progress.dismiss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        checkForExit(0, WalkThroughManager.WALKTHROUGH_DEFAULT_EXIT_MESSAGE);
    }

    private void checkForExit(int fragmentCount, String exitText) {
        if (getSupportFragmentManager().getBackStackEntryCount() <= fragmentCount) {
            mWalkThroughManager.onComplete(exitText);
            finish();
        }
    }
}

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

package com.robotsandpencils.walkthrough.presentation.communication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

import com.robotsandpencils.walkthrough.R;

/**
 * Created by lesfriesen on 2016-10-14.
 * Purpose: Provide theme values to the layout for parent layout customization.
 */

public class LayoutTheme {

    @ColorRes
    private int mPagerIndicatorFillColor = R.color.colorWhite;

    @ColorRes
    private int mPagerIndicatorStrokeColor = R.color.colorWhite;

    private int mPageListEnterAnimation = R.anim.in_from_right;

    private int mPageListExitAnimation = R.anim.out_to_left;

    private int mPageListPopEnterAnimation = R.anim.in_from_left;

    private int mPageListPopExitAnimation = R.anim.out_to_right;

    @StringRes
    private int mProgressMessage = R.string.loading_please_wait;

    private Drawable mProgressBackground = new ColorDrawable(Color.TRANSPARENT);

    private boolean mUseVerticalProgressDialog = false;

    @ColorRes
    public int getPagerIndicatorFillColor() {
        return mPagerIndicatorFillColor;
    }

    private void setPagerIndicatorFillColor(@ColorRes int pagerIndicatorFillColor) {
        mPagerIndicatorFillColor = pagerIndicatorFillColor;
    }

    @ColorRes
    public int getPagerIndicatorStrokeColor() {
        return mPagerIndicatorStrokeColor;
    }

    private void setPagerIndicatorStrokeColor(@ColorRes int pagerIndicatorStrokeColor) {
        mPagerIndicatorStrokeColor = pagerIndicatorStrokeColor;
    }

    public int getPageListEnterAnimation() {
        return mPageListEnterAnimation;
    }

    public void setPageListEnterAnimation(int pageListEnterAnimation) {
        mPageListEnterAnimation = pageListEnterAnimation;
    }

    public int getPageListExitAnimation() {
        return mPageListExitAnimation;
    }

    public void setPageListExitAnimation(int pageListExitAnimation) {
        mPageListExitAnimation = pageListExitAnimation;
    }

    public int getPageListPopEnterAnimation() {
        return mPageListPopEnterAnimation;
    }

    public void setPageListPopEnterAnimation(int pageListPopEnterAnimation) {
        mPageListPopEnterAnimation = pageListPopEnterAnimation;
    }

    public int getPageListPopExitAnimation() {
        return mPageListPopExitAnimation;
    }

    public void setPageListPopExitAnimation(int pageListPopExitAnimation) {
        mPageListPopExitAnimation = pageListPopExitAnimation;
    }

    @StringRes
    public int getProgressMessage() {
        return mProgressMessage;
    }

    public void setProgressMessage(@StringRes int progressMessage) {
        mProgressMessage = progressMessage;
    }

    public Drawable getProgressBackground() {
        return mProgressBackground;
    }

    public void setProgressBackground(Drawable progressBackground) {
        mProgressBackground = progressBackground;
    }

    public boolean useVerticalProgressDialog() {
        return mUseVerticalProgressDialog;
    }

    public void setVerticalProgressDialog(boolean useVerticalProgressDialog) {
        mUseVerticalProgressDialog = useVerticalProgressDialog;
    }

    public static class Builder {

        @ColorRes
        private int mPagerIndicatorFillColor = R.color.colorWhite;

        @ColorRes
        private int mPagerIndicatorStrokeColor = R.color.colorWhite;

        private int mPageListEnterAnimation = R.anim.in_from_right;

        private int mPageListExitAnimation = R.anim.out_to_left;

        private int mPageListPopEnterAnimation = R.anim.in_from_left;

        private int mPageListPopExitAnimation = R.anim.out_to_right;

        @StringRes
        private int mProgressMessage = R.string.loading_please_wait;

        private Drawable mProgressBackground = new ColorDrawable(Color.TRANSPARENT);

        private boolean mUseVerticalProgressDialog = false;

        public Builder setPagerIndicatorFillColor(@ColorRes int pagerIndicatorFillColor) {
            mPagerIndicatorFillColor = pagerIndicatorFillColor;
            return this;
        }

        public Builder setPagerIndicatorStrokeColor(@ColorRes int pagerIndicatorStrokeColor) {
            mPagerIndicatorStrokeColor = pagerIndicatorStrokeColor;
            return this;
        }

        public int getPageListEnterAnimation() {
            return mPageListEnterAnimation;
        }

        public Builder setPageListEnterAnimation(int pageListEnterAnimation) {
            mPageListEnterAnimation = pageListEnterAnimation;
            return this;
        }

        public int getPageListExitAnimation() {
            return mPageListExitAnimation;
        }

        public Builder setPageListExitAnimation(int pageListExitAnimation) {
            mPageListExitAnimation = pageListExitAnimation;
            return this;
        }

        public int getPageListPopEnterAnimation() {
            return mPageListPopEnterAnimation;
        }

        public Builder setPageListPopEnterAnimation(int pageListPopEnterAnimation) {
            mPageListPopEnterAnimation = pageListPopEnterAnimation;
            return this;
        }

        public int getPageListPopExitAnimation() {
            return mPageListPopExitAnimation;
        }

        public Builder setPageListPopExitAnimation(int pageListPopExitAnimation) {
            mPageListPopExitAnimation = pageListPopExitAnimation;
            return this;
        }

        @StringRes
        public int getProgressMessage() {
            return mProgressMessage;
        }

        public Builder setProgressMessage(@StringRes int progressMessage) {
            mProgressMessage = progressMessage;
            return this;
        }

        public Builder setProgressBackground(Drawable progressBackground) {
            mProgressBackground = progressBackground;
            return this;
        }

        public Builder setVerticalProgressDialog(boolean useVerticalProgressDialog) {
            mUseVerticalProgressDialog = useVerticalProgressDialog;
            return this;
        }

        public LayoutTheme build() {
            LayoutTheme layoutTheme = new LayoutTheme();
            layoutTheme.setPagerIndicatorFillColor(mPagerIndicatorFillColor);
            layoutTheme.setPagerIndicatorStrokeColor(mPagerIndicatorStrokeColor);
            layoutTheme.setPageListEnterAnimation(mPageListEnterAnimation);
            layoutTheme.setPageListExitAnimation(mPageListExitAnimation);
            layoutTheme.setPageListPopEnterAnimation(mPageListPopEnterAnimation);
            layoutTheme.setPageListPopExitAnimation(mPageListPopExitAnimation);
            layoutTheme.setProgressMessage(mProgressMessage);
            layoutTheme.setProgressBackground(mProgressBackground);
            layoutTheme.setVerticalProgressDialog(mUseVerticalProgressDialog);
            return layoutTheme;
        }
    }
}

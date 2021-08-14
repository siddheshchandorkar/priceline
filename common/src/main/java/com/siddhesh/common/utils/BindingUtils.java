package com.siddhesh.common.utils;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class BindingUtils {

    private static final String VISIBILITY = "android:visibility";

    @BindingAdapter({VISIBILITY})
    public static void setVisibility(View view, Boolean isVisible) {
        if (isVisible == null)
            isVisible = false;
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }


}

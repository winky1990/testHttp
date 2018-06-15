package com.winky.test;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class LoadingDialog extends Dialog {

    protected LoadingDialog(@NonNull Context context) {
        this(context, R.style.loadingDialogStyle);
    }

    protected LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
    }
}

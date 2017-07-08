package com.yushilei.dynamicproxy.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity基类
 */

public class BaseActivity extends AppCompatActivity {

    private boolean isResume = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppStack.inStack(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        isResume = false;
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isResume = true;
    }

    @Override
    protected void onPause() {
        isResume = false;
        super.onPause();
    }

    public boolean isResume() {
        return isResume;
    }

    public void showDialog(AlertDialog dialog) {
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        AppStack.outStack(this);
        super.onDestroy();
    }
}

package com.yushilei.dynamicproxy.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by Administrator on 2017/7/8.
 */

public class DialogUtil {
    public static AlertDialog getForceQuitDialog(Activity activity) {
        return new AlertDialog.Builder(activity).setTitle("温馨提示")
                .setMessage("强制退出")
                .setCancelable(false)
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog1, int which) {
                        dialog1.dismiss();
                    }
                }).create();
    }
}

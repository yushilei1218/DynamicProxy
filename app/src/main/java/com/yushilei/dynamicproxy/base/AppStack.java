package com.yushilei.dynamicproxy.base;

import android.app.Activity;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Stack;

/**
 * App内部维护栈
 */

public class AppStack {
    private AppStack() {
    }

    private static final Stack<BaseActivity> mStack = new Stack<>();

    public static void inStack(BaseActivity inActivity) {
        mStack.addElement(inActivity);
    }

    public static void outStack(BaseActivity outActivity) {
        if (mStack.contains(outActivity)) {
            mStack.remove(outActivity);
        }
    }

    @Nullable
    public static BaseActivity getTopActivity() {
        if (mStack.size() > 0)
            return mStack.peek();
        return null;
    }
}

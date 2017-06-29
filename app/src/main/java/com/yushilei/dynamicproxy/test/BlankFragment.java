package com.yushilei.dynamicproxy.test;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yushilei.dynamicproxy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private static final String SHOW_TYPE = "SHOW_TYPE";
    private static final int TYPE_SHOWED = 0x002;
    private static final int SHOW_UN_CHECK = 0x003;

    private TextView mTv;

    public BlankFragment() {
    }

    public static BlankFragment instance(int type) {
        BlankFragment fg = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SHOW_TYPE, type);
        fg.setArguments(bundle);
        return fg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mTv = ((TextView) view.findViewById(R.id.fg_blank_tv));
        int type = getArguments().getInt(SHOW_TYPE);
        String msg = "";
        switch (type) {
            case 0:
                msg = "未传入Bundle";
                break;
            case TYPE_SHOWED:
                msg = "TYPE_SHOWED";
                break;
            case SHOW_UN_CHECK:
                msg = "SHOW_UN_CHECK";
                break;
        }
        mTv.setText(msg);
    }
}

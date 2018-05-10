package com.example.dinglong.douyincommentdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dinglong on 2018/5/9.
 * 类说明:
 */

public class CommentBottomSheetDialog extends BottomSheetDialog {

    private View mContentView;
    private Context context;

    public CommentBottomSheetDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public CommentBottomSheetDialog(@NonNull Context context, int theme) {
        super(context, theme);
        this.context = context;

    }

    @Override
    protected void onStart() {
        super.onStart();
        fixHeight();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        this.mContentView = view ;
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        this.mContentView = view;
    }

    private void fixHeight(){
        if(null == mContentView){
            return;
        }

        View parent = (View) mContentView.getParent();
        BottomSheetBehavior behavior = BottomSheetBehavior.from(parent);
        behavior.setPeekHeight(ScreenUtils.getScreenHeight(context)*2/3);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) parent.getLayoutParams();
        params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        parent.setLayoutParams(params);
    }
}

package com.example.admin.questionlistactivity.screens.common;

import android.content.Context;
import android.view.View;

public abstract class BaseViewMvc implements ViewMvc {

    private View mRootView;

    public void setRootView(View mRootView) {
        this.mRootView = mRootView;
    }

    @Override
    public View getRoot() {
        return mRootView;
    }

    public   <T extends View> T findViewById(int id){
        return  getRoot().findViewById(id);
    }

    public Context getContext(){
        return getRoot().getContext();
    }
}

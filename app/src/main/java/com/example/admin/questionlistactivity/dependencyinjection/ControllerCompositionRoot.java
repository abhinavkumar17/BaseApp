package com.example.admin.questionlistactivity.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.example.admin.questionlistactivity.questions.StackoverflowApi;
import com.example.admin.questionlistactivity.screens.common.ViewMvcFactory;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    public StackoverflowApi getStackoverflowApi() {
        return mCompositionRoot.getStackoverflowApi();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }
}

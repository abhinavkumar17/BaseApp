package com.example.admin.questionlistactivity.screens.common;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.questionlistactivity.CustomApplication;
import com.example.admin.questionlistactivity.dependencyinjection.CompositionRoot;
import com.example.admin.questionlistactivity.dependencyinjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication) getApplication()).getCompositionRoot(),
                    this
            );
        }
        return mControllerCompositionRoot;
    }
}

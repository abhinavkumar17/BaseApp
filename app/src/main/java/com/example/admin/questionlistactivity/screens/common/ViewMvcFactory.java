package com.example.admin.questionlistactivity.screens.common;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.admin.questionlistactivity.adapter.QuestionListItemViewImpl;
import com.example.admin.questionlistactivity.adapter.QuestionListItemViewMvc;
import com.example.admin.questionlistactivity.screens.main.QuestionListViewImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public QuestionListViewImpl getQuestionsListViewMvc(@Nullable ViewGroup parent) {
        return new QuestionListViewImpl(mLayoutInflater, parent);
    }
}

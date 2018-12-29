package com.example.admin.questionlistactivity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.questionlistactivity.R;
import com.example.admin.questionlistactivity.questions.Question;
import com.example.admin.questionlistactivity.screens.common.BaseObservableViewMvc;

import java.util.ArrayList;
import java.util.List;

public class QuestionListItemViewImpl extends BaseObservableViewMvc<QuestionListItemViewMvc.Listner> implements QuestionListItemViewMvc {

    TextView mTextView;
    Question mQuestion;

    public QuestionListItemViewImpl(LayoutInflater inflater, ViewGroup parent){
        setRootView(inflater.inflate(R.layout.layout_question_list_item,parent,false));
        mTextView = findViewById(R.id.txt_title);
        getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listner listener : getListeners()) {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });
    }

    @Override
    public void bindQuestions(Question questions) {
        mQuestion = questions;
        mTextView.setText(questions.getTitle());
    }
}

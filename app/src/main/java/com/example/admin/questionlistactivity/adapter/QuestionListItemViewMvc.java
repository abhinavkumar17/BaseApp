package com.example.admin.questionlistactivity.adapter;

import com.example.admin.questionlistactivity.questions.Question;
import com.example.admin.questionlistactivity.screens.common.ObservableViewMvc;

public interface QuestionListItemViewMvc extends ObservableViewMvc<QuestionListItemViewMvc.Listner> {
    public interface Listner {
        void onQuestionClicked(Question question);
    }

    void bindQuestions(Question questions);
}

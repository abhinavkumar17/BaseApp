package com.example.admin.questionlistactivity.screens.questionlist.screens.main;

import com.example.admin.questionlistactivity.questions.Question;
import com.example.admin.questionlistactivity.screens.common.ObservableViewMvc;

import java.util.List;

public interface QuestionListViewMvc extends ObservableViewMvc<QuestionListViewMvc.Listner> {
    public interface Listner{
        void onQuestionClicked(Question question);
    }

    public void bindQuestions(List<Question> questions);
}

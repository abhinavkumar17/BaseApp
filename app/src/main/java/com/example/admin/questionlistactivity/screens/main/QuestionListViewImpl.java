package com.example.admin.questionlistactivity.screens.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.admin.questionlistactivity.R;
import com.example.admin.questionlistactivity.adapter.QuestionListItemViewMvc;
import com.example.admin.questionlistactivity.adapter.QuestionListViewAdapter;
import com.example.admin.questionlistactivity.questions.Question;
import com.example.admin.questionlistactivity.screens.common.BaseObservableViewMvc;
import com.example.admin.questionlistactivity.screens.questionlist.screens.main.QuestionListViewMvc;

import java.util.List;

public class QuestionListViewImpl extends BaseObservableViewMvc<QuestionListViewMvc.Listner> implements com.example.admin.questionlistactivity.screens.questionlist.screens.main.QuestionListViewMvc,QuestionListItemViewMvc.Listner {

    private RecyclerView mRecyclerQuestions;
    private QuestionListViewAdapter mAdapter;

    public QuestionListViewImpl(LayoutInflater inflater, ViewGroup parent){
        setRootView(inflater.inflate(R.layout.activity_question_list,parent,false));
        mRecyclerQuestions = findViewById(R.id.recycler_questions);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new QuestionListViewAdapter(inflater,this);
        mRecyclerQuestions.setAdapter(mAdapter);
        }


    @Override
    public void bindQuestions(List<Question> questions) {
        mAdapter.bindQuestions(questions);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listner mlistner:getListeners()){
            mlistner.onQuestionClicked(question);
            }
        }
}

package com.example.admin.questionlistactivity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.questionlistactivity.R;
import com.example.admin.questionlistactivity.questions.Question;

import java.util.ArrayList;
import java.util.List;


public class QuestionListViewAdapter extends RecyclerView.Adapter<QuestionListViewAdapter.QuestionListViewHolder>
        implements QuestionListItemViewMvc.Listner {

    QuestionListItemViewMvc.Listner mOnQuestionClickListener;
    LayoutInflater inflater;
    private List<Question> mQuestions = new ArrayList<>();

    public QuestionListViewAdapter(LayoutInflater inflater,QuestionListItemViewMvc.Listner mOnQuestionClickListener ) {
        this.inflater = inflater;
        this.mOnQuestionClickListener = mOnQuestionClickListener;
    }

   public void bindQuestions(List<Question> questions) {
        mQuestions = questions;
    }



    public static class QuestionListViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        QuestionListItemViewImpl mQuestionListItemViewImpl;

        public QuestionListViewHolder(QuestionListItemViewImpl mQuestionListItemViewImpl) {
            super(mQuestionListItemViewImpl.getRoot());
            this.mQuestionListItemViewImpl = mQuestionListItemViewImpl;
        }
    }

    @NonNull
    @Override
    public QuestionListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        QuestionListItemViewImpl viewMvc = new QuestionListItemViewImpl(inflater, parent);
        viewMvc.registerListener(this);
        return new QuestionListViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionListViewHolder questionListViewHolder, int position) {
        questionListViewHolder.mQuestionListItemViewImpl.bindQuestions(mQuestions.get(position));

    }

    @Override
    public void onQuestionClicked(Question question) {
        mOnQuestionClickListener.onQuestionClicked(question);

    }

    @Override
    public int getItemCount() {
        if (mQuestions == null)
            return 0;
        else
            return mQuestions.size();
    }
}

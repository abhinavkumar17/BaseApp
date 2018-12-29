package com.example.admin.questionlistactivity.screens.questionlist.screens.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.admin.questionlistactivity.screens.common.BaseActivity;
import com.example.admin.questionlistactivity.screens.common.Constants;
import com.example.admin.questionlistactivity.questions.Question;
import com.example.admin.questionlistactivity.questions.QuestionSchema;
import com.example.admin.questionlistactivity.questions.QuestionsListResponseSchema;
import com.example.admin.questionlistactivity.questions.StackoverflowApi;
import com.example.admin.questionlistactivity.screens.main.QuestionListViewImpl;
import com.example.admin.questionlistactivity.screens.questionlist.screens.main.QuestionListViewMvc;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.admin.questionlistactivity.screens.common.Constants.BASE_URL;

public class QuestionListActivity extends BaseActivity implements QuestionListViewMvc.Listner {
    QuestionListViewImpl mQuestionListViewImpl;
    StackoverflowApi mStackoverflowApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQuestionListViewImpl = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null);
        mStackoverflowApi = getCompositionRoot().getStackoverflowApi();
        setContentView(mQuestionListViewImpl.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQuestionListViewImpl.registerListener(this);

        mStackoverflowApi.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
                .enqueue(new Callback<QuestionsListResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                        bindQuestions(response.body().getQuestions());
                    }

                    @Override
                    public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "This is my Toast message!",
                                Toast.LENGTH_LONG).show();
                    }
                });

    }

    private void bindQuestions(List<QuestionSchema> questionSchemas) {
        List<Question> questions = new ArrayList<>(questionSchemas.size());
        for (QuestionSchema questionSchema : questionSchemas) {
            questions.add(new Question(questionSchema.getId(), questionSchema.getTitle()));
        }
        mQuestionListViewImpl.bindQuestions(questions);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mQuestionListViewImpl.unregisterListener(this);
    }

    @Override
    public void onQuestionClicked(Question question) {
        Toast.makeText(getApplicationContext(), "This is my Toast message!"+question.getTitle(),
                Toast.LENGTH_LONG).show();
    }
}

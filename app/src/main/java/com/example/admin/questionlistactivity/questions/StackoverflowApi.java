package com.example.admin.questionlistactivity.questions;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.admin.questionlistactivity.screens.common.Constants.STACKOVERFLOW_API_KEY;

public interface StackoverflowApi {

    @GET("/questions?key=" + STACKOVERFLOW_API_KEY + "&sort=activity&order=desc&site=stackoverflow&filter=withbody")
    Call<QuestionsListResponseSchema> fetchLastActiveQuestions(@Query("pagesize") Integer pageSize);

   // @GET("/questions/{questionId}?key=" + SyncStateContract.Constants.STACKOVERFLOW_API_KEY + "&site=stackoverflow&filter=withbody")
    //Call<QuestionDetailsResponseSchema> fetchQuestionDetails(@Path("questionId") String questionId);
}

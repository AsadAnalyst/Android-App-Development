package com.example.bsaia.RestAPI_Examples;

import com.example.bsaia.CardViewExample.MyModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MyController {
    //ye hmne interface bnaya ha , not java class.
    //MCQ. interface by default abstract hota ha
    @GET("posts")
    Call<List<MyModelClass>> getAllPosts();
    @GET("posts/1/comments")
    Call<List<MyCommentsModel>> getAllComments();
    @GET("posts/{id}/comments")
    Call<List<MyCommentsModel>> getAllComments(@Path("id") int id);
    @GET("comments")
    Call<List<MyCommentsModel>> getCommentsByQuery(@Query("postId") int id);
    @GET("name")
    Call<List<MyCommentsModel>> getCommentsByName(@Query("name") int id);
    @GET("comments")
    Call<List<MyCommentsModel>> getMyCommentsBySortQuery(@Query("PostId") int id,
                                                         @Query("_sort") String sort,
                                                         @Query("_order") String orderBy);
    @GET("comments")
    Call<List<MyCommentsModel>> getMyCommentsByMap(@QueryMap Map<String,String> Argument);
    @POST("posts")
    Call<MyModelClass> createPost(@Body MyModelClass post);


}

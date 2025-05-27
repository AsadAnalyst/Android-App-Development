package com.example.bsaia.RestAPI_Examples;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bsaia.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestAPIMainActivity extends AppCompatActivity {
    MyRetrofit myRetrofit;
    MyController myController;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rest_apimain);

        recyclerView=findViewById(R.id.myrestrecyclerview);
        myController=MyRetrofit.ConnectRetrofit().create(MyController.class);
        //GetRecord(); //ye phle records wala kam ha
        //GetComments();
        //GetCommentsQuery();
        //GetCommentsByName();
        //GetCommentsBySort();
        //GetMyCommentsByMapQuery();
        CreateMyPost();
    }

    private void GetComments() {
        Call<List<MyCommentsModel>> list =
                myController.getAllComments(2);
        list.enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.isSuccessful())
                {
                    for (MyCommentsModel comments : response.body())
                    {
                        Log.d("TAG",
                                "Post_ID "+comments.getPostId()
                                +" ID "+comments.getId()
                                +" User_Name "+comments.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }
    private void GetCommentsQuery() {
        Call<List<MyCommentsModel>> list =
                myController.getCommentsByQuery(2);
        list.enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.isSuccessful())
                {
                    for (MyCommentsModel comments : response.body())
                    {
                        Log.d("TAG",
                                "Post_ID "+comments.getPostId()
                                        +" ID "+comments.getId()
                                        +" User_Name "+comments.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }
    private void GetCommentsByName() {
        Call<List<MyCommentsModel>> list =
                myController.getCommentsByName(2);
        list.enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.isSuccessful())
                {
                    for (MyCommentsModel comments : response.body())
                    {
                        Log.d("TAG",
                                "Post_ID "+comments.getPostId()
                                        +" ID "+comments.getId()
                                        +" User_Name "+comments.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }
    private void GetCommentsBySort(){
        Map<String,String> Argument=new HashMap<>();
        //Argument.put("postId","3");
        //Argument.put("_sort","id");
        //Argument.put("_order","desc");//desc means descending order.
        Call<List<MyCommentsModel>> list =
                myController.getMyCommentsBySortQuery(2,"id","desc");
        list.enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.isSuccessful())
                {
                    for (MyCommentsModel comments : response.body())
                    {
                        Log.d("TAG",
                                "Post_ID "+comments.getPostId()
                                        +" ID "+comments.getId()
                                        +" User_Name "+comments.getName());
                    }
                }
            }
            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }
    private void GetMyCommentsByMapQuery(){
        Map<String,String> Argument=new HashMap<>();
        Argument.put("postId","3");
        Argument.put("_sort","id");
        Argument.put("_order","desc");//desc means descending order.
        Call<List<MyCommentsModel>> list =
                myController.getMyCommentsByMap(Argument);
        list.enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.isSuccessful())
                {
                    for (MyCommentsModel comments : response.body())
                    {
                        Log.d("TAG",
                                "Post_ID "+comments.getPostId()
                                        +" ID "+comments.getId()
                                        +" User_Name "+comments.getName());
                    }
                }
            }
            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }
    private void GetRecord() {
        myController.getAllPosts().enqueue(new Callback<List<MyModelClass>>() {
            @Override
            public void onResponse(Call<List<MyModelClass>> call, Response<List<MyModelClass>> response) {
                if(response.body().size()>0)
                {
                    Toast.makeText(RestAPIMainActivity.this, "Data Received", Toast.LENGTH_SHORT).show();

                    List<MyModelClass> list =response.body();
                    MyRestAdapter adapter=new MyRestAdapter(list,
                            RestAPIMainActivity.this);
                    LinearLayoutManager layoutManager=new
                            LinearLayoutManager(RestAPIMainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<MyModelClass>> call, Throwable t) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void CreateMyPost(){
        MyModelClass obj=new MyModelClass(10,2,"Title","Body");
        Call<MyModelClass> myPost=myController.createPost(obj);
        myPost.enqueue(new Callback<MyModelClass>() {
            @Override
            public void onResponse(Call<MyModelClass> call, Response<MyModelClass> response) {
                if(response.isSuccessful())
                {
                    Log.d("TAG",""+ response.body().getUserId()
                    +"\n"+ response.body().getId()
                    +"\n"+ response.body().getTitle()
                    +"\n"+ response.body().getBody());
                }
            }
            @Override
            public void onFailure(Call<MyModelClass> call, Throwable t) {

            }
        });
    }
}
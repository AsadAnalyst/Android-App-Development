package com.example.bsaia.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bsaia.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewExampleOneMainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapterRecyclerView adapter;
    List<Mobile> mobileList=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view_example_one_main);

        recyclerView=findViewById(R.id.recyclerviewexampleone);
        adapter=new MyAdapterRecyclerView(mobileList);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        LoadData();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void LoadData()
    {
        Mobile mobile = new Mobile("Note 1","Samsung","10000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 2","Samsung","12000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 3","Samsung","14000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 4","Samsung","16000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 5","Samsung","18000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 6","Samsung","20000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 7","Samsung","22000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 8","Samsung","24000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 9","Samsung","26000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 10","Samsung","28000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 11","Samsung","30000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 12","Samsung","32000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 13","Samsung","34000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 14","Samsung","36000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 15","Samsung","38000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 16","Samsung","40000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 17","Samsung","42000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 18","Samsung","44000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 19","Samsung","46000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 20","Samsung","48000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 21","Samsung","50000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 22","Samsung","52000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 23","Samsung","54000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 24","Samsung","56000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 25","Samsung","58000");
        mobileList.add(mobile);
        mobile = new Mobile("Note 26","Samsung","60000");
        mobileList.add(mobile);

        adapter.notifyDataSetChanged();//ye keu us hota ha??
    }
}
package com.example.bsaia.CardViewExample;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.bsaia.R;
import com.example.bsaia.databinding.ActivityCardViewMain2Binding;

import java.util.ArrayList;
import java.util.List;

public class CardViewMainActivity extends AppCompatActivity {
    //scrollling view activity bnae ha hamne
    //layout_height ko match_parent krna ha in xml file
    private ActivityCardViewMain2Binding binding;
    //ye khud bnaege
    public List<MyModel> list;
    public MyCardViewAdapter adapter;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCardViewMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        //yaha pr krenge kam
        recyclerView=findViewById(R.id.recyclerviewcardview);
        list=new ArrayList<>();
        adapter=new MyCardViewAdapter(this,list);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new GridSpacing(2,12,true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        Insert();
    }
    //yaha ek class bnaege for GridSpacing
    private class GridSpacing extends RecyclerView.ItemDecoration{
        int count,spacing;
        boolean EdgeInclude;

        public GridSpacing(int count, int spacing, boolean edgeInclude) {
            this.count = count;
            this.spacing = spacing;
            EdgeInclude = edgeInclude;
        }
    }
    //yaha ek fun bnagee
    public void Insert()
    {
        int[] image=new int[]{
                R.drawable.m,R.drawable.m,
                R.drawable.m,R.drawable.m,
                R.drawable.m,R.drawable.m,
                R.drawable.m,R.drawable.m

                
        };
        MyModel obj=new MyModel("First",10,image[0]);
        list.add(obj);

        obj=new MyModel("Second",20,image[1]);
        list.add(obj);

        obj=new MyModel("Third",30,image[2]);
        list.add(obj);

        obj=new MyModel("Fourth",40,image[3]);
        list.add(obj);

        obj=new MyModel("Fifth",50,image[4]);
        list.add(obj);

        obj=new MyModel("Sixth",60,image[5]);
        list.add(obj);

        obj=new MyModel("Seventh",70,image[6]);
        list.add(obj);

        obj=new MyModel("Eight",80,image[7]);
        list.add(obj);

    }
}
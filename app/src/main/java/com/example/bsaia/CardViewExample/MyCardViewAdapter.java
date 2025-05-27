package com.example.bsaia.CardViewExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bsaia.R;

import java.util.List;

public class MyCardViewAdapter extends RecyclerView.Adapter<MyCardViewAdapter.ViewHolder>{
    //yaha 2 data members bnaege
    public Context context;
    public List<MyModel> list;
    public MyCardViewAdapter(Context context, List<MyModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.mycardlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyModel obj=list.get(position);
        holder.Name.setText(obj.getName());
        holder.TotalDownload.setText(String.valueOf(obj.getTotalDownload()));
        //glide library kya krti ha? search on internet...
        // ,3rd party library ha ye, dependency add ki gradle me
        Glide.with(context).load(obj.getThumbnail()).into(holder.Thumbnail);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //inner class bnaege idr
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Thumbnail;
        TextView Name,TotalDownload;
        public ViewHolder(@NonNull View view) {
            super(view);
            Thumbnail=view.findViewById(R.id.imgcardview);
            Name=view.findViewById(R.id.txtcardview1);
            TotalDownload=view.findViewById(R.id.txtcardview2);

        }
    }
}

package com.example.bsaia.FirebaseExamples.FirebaseExampeTwo;

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

import java.util.ArrayList;

public class FirebaseAdapter extends RecyclerView.Adapter<FirebaseAdapter.ViewHolder>{

    ArrayList<Student_BSAI> studentList;
    Context context;

    public FirebaseAdapter(ArrayList<Student_BSAI> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.studentlistlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(studentList.get(position).getName());
        //image choti bhari ho skti , thats why phle glide me dalenge then imageview pr.
        Glide.with(context).load(studentList.get(position).getPicture()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.firebaseimageviewexampletwo);
            textView=itemView.findViewById(R.id.txtfirebaseexampletwo);
        }
    }
}

package com.example.bsaia.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bsaia.R;

import java.util.List;

public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.ViewHolder> {//extend krna ha
    private List<Mobile> mobileList;
    //Q: why all apps use Recycler view not the list view?
    //list viw ma 1k entry pri or hmne ne iosko attach kr diya list view k sath
    //or mobile pr max 15 a skti , hmne scroll kiya agla 15 a gae , lekin jldi sy
    //scoll krenge to application crash ho jaege.
    //is waaja sy hm recycler_view use krtay han , jo 2 upr wali or 2 nechy wali 2 rakhy ga
    //ta kay apk mobile me load nh ho server sy load ho
    //or hm jitna mrzi scroll kr le , application crash ni hogi

    public MyAdapterRecyclerView(List<Mobile> mobileList) {
        this.mobileList = mobileList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mymobilelayout,parent,false);
        /*ViewHolder obj = new ViewHolder(view);
        return obj;*/
        //or
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mobile mobile = mobileList.get(position);
        holder.mobileName.setText(mobile.getMobileName());
        holder.mobileCompany.setText(mobile.getMobileCompany());
        holder.mobilePrice.setText(mobile.getMobilePrice());
    }

    @Override
    public int getItemCount() {
        return mobileList.size();
    }

    //inner class bnaege idr
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mobileName,mobileCompany,mobilePrice;
        public ViewHolder(@NonNull View view) {//itemView likha hoga iosko view kr dena ha
            super(view);
            mobileName=view.findViewById(R.id.txtmobilename);
            mobileCompany=view.findViewById(R.id.txtmobilecompany);
            mobilePrice=view.findViewById(R.id.txtmobileprice);
        }
    }
}

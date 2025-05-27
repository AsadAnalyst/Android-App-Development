package com.example.bsaia.ListViewExamples.MultiColumnListViewMainActivityExample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bsaia.R;

import java.util.ArrayList;
import java.util.HashMap;

//yaha hm class ko extend krenge baseadapter sy
public class MyMultiColumnListAdapter extends BaseAdapter {
    Activity activity;
    //alt+insert , contructor khud bn jaega is se
    public MyMultiColumnListAdapter(Activity activity, ArrayList<HashMap<String, String>> list) {
        this.activity = activity;
        this.list = list;
    }

    //ye copy kiya ha hmne multilistiewmainActivity...
    public ArrayList<HashMap<String,String>> list;
    public  static final String First_Column="First";
    public  static final String Second_Column="Second";
    public  static final String Third_Column="Third";
    public  static final String Fourth_Column="Fourth";


    //jb hm extend krenge to ye method khuds bn jaenge (extend k liye start m dekh , cmnt dla ha mayny)
    @Override
    public int getCount() {
        return list.size();//return 0 ,khtm kr k list.size() , is se ye hoga jitne list ka size ha utni dafa chalega
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);//changed from null
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("CutPasteId")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder=new ViewHolder();
        //yaha jo hmne ana new layout bnaya th
        // ab ios layjout ko hmne adapter ko dena ha
        //getview 1st pr chlta ha , to hm is method me isko attach krenge
        //setContent view , activity jorne liye
        //layoutinflitor keu bnaty , search on net?
        LayoutInflater inflater=activity.getLayoutInflater();
        //yaha , ye jo convert view aya ha
        if(view==null){//agr hm ye if nhi lgaengeb , to ye hr dafa infilate krega , lekin agr ye line likhenge to bs 1st tie infliate krega, beause wo dkehngea null ha to dal dega
            view=inflater.inflate(R.layout.multicolumnlistview,null);
            //root null, means iska koi parent nhi ha
            //direct findbyview nhi kr skty , because ya java class ha , activty nii ha, so hm view. kenge
            viewHolder.textViewFirst=view.findViewById(R.id.txtlistfirst);
            viewHolder.textViewSecond=view.findViewById(R.id.txtlistsecond);
            viewHolder.textViewThird=view.findViewById(R.id.txtlistthird);
            viewHolder.textViewFourth=view.findViewById(R.id.txtlistforth);

            view.setTag(viewHolder);
        }
        else {
            //is se ye hoga agr alreafy bind to chl jaega
            viewHolder= (ViewHolder) view.getTag();
        }


        HashMap<String,String> hashMap=list.get(position);//isme 4 values honge is case me
        viewHolder.textViewFirst.setText(hashMap.get(First_Column));
        viewHolder.textViewSecond.setText(hashMap.get(Second_Column));
        viewHolder.textViewThird.setText(hashMap.get(Third_Column));
        viewHolder.textViewFourth.setText(hashMap.get(Fourth_Column));

        return view;
    }


    //inner class bnaege idhr
    public class ViewHolder{
        TextView textViewFirst,textViewSecond,textViewThird,textViewFourth;

    }
}

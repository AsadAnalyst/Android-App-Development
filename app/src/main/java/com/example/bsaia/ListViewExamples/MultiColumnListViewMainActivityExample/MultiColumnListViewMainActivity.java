package com.example.bsaia.ListViewExamples.MultiColumnListViewMainActivityExample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiColumnListViewMainActivity extends AppCompatActivity {
    ListView listView;
    public ArrayList<HashMap<String,String>> list;
    public  static final String First_Column="First"; //final means constant
    public  static final String Second_Column="Second";
    public  static final String Third_Column="Third";
    public  static final String Fourth_Column="Fourth";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multi_column_list_view_main);

        listView=findViewById(R.id.lstmulticolumn);
        LoadData(); //yaha is wajas sy call kiya k automatic chl jae ye
        MyMultiColumnListAdapter adapter =new MyMultiColumnListAdapter(this,list);
        //show krange
        listView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void LoadData(){
        list=new ArrayList<HashMap<String,String>>();

        HashMap <String,String>hashMap1=new HashMap<String,String>();
        hashMap1.put(First_Column,"Ali");//key,value
        hashMap1.put(Second_Column,"Ahmad");
        hashMap1.put(Third_Column,"Zubair");
        hashMap1.put(Fourth_Column,"Kashif");
        list.add(hashMap1);

        HashMap <String,String> hashMap2=new HashMap<String,String>();
        hashMap2.put(First_Column,"Maria");//key,value
        hashMap2.put(Second_Column,"Anna");
        hashMap2.put(Third_Column,"Ruskhsana");
        hashMap2.put(Fourth_Column,"Shumaila");
        list.add(hashMap2);

        HashMap <String,String> hashMap3=new HashMap<String,String>();
        hashMap3.put(First_Column,"Alina");//key,value
        hashMap3.put(Second_Column,"Maria");
        hashMap3.put(Third_Column,"Ruskhsana");
        hashMap3.put(Fourth_Column,"Shumaila");
        list.add(hashMap3);

        HashMap <String,String> hashMap4=new HashMap<String,String>();
        hashMap4.put(First_Column,"Hania");//key,value
        hashMap4.put(Second_Column,"Anna");
        hashMap4.put(Third_Column,"Ruskhsana");
        hashMap4.put(Fourth_Column,"Maria");
        list.add(hashMap4);
    }
}
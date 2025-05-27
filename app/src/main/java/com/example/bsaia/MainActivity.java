package com.example.bsaia; //pori application ka name ha ye

//ye hamari library hain
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //har activity ka ek life cycle hota ha..
    //or ye 1st cycle ha ); line tk
    @Override//iska matlb ha k hm AppCompatActivity say
    //override kr rhy hain is fuction ko
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//call back metthod
        EdgeToEdge.enable(this);
        //activity class ka function ha setContentView...
        //setContentView use krnty hian layout jo view k sath attach krne mai..
        //also search this on net , imp question for exam
        setContentView(R.layout.activity_main);
        //iska purpose ye hota ha k mobile kay
        //nechy jo buttons hoty iosk upr hi secreen ai (not full secreen mode)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //1st
    //@Override iska matlb ye k ye hamari activty ka fun...
    //nhi ha , ye hmne AppCompatActivity say override kiya ha
    @Override
    protected void onStart() {
        super.onStart();
        //check krne k liye k ye chala ha ya ni
        // ye ek message ha jo console pr aiga jb ye function call hoga

        //left botton ma cat wala icon ha waha ja kr..
        //hme TAG (Jo hamar var ha) likhna ha

        //or check krna ha k wo called hua ha ya ni ...
        //agr call hua hoga then ye a jaega ..
        //2025-01-27 09:37:21.768 15317-15317 TAG     com.example.bsaia    D  ONStart() is called

        Log.d("TAG","ONStart() is called"); //log white hona chaye
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","OnPause ia Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","onResume ia Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG","onRestart ia Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy ia Called");
    }

}
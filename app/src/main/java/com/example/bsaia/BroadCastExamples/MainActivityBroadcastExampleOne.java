package com.example.bsaia.BroadCastExamples;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

public class MainActivityBroadcastExampleOne extends AppCompatActivity {
    //broadcast receiver kya krta ha? parity bit check?
    //
    //onResume ma khna ha kay muhe register kr do is annoucement k lye.
    //annoucements hoti (eg. low battery message notification etc).

    //manifest file me receiver ka kam krege
    AirplaneModeBroadCast obj=new AirplaneModeBroadCast();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_broadcast_example_one);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //khud bnaya ha onStart()

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(obj,intentFilter);
        //chcek why we regiter?
        //register jis app ko kiya hoga bs wohi iosko get kr skti ha
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(obj);
    }
}
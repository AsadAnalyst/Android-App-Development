package com.example.bsaia.IntentExamples;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;
import com.google.android.material.snackbar.Snackbar;

public class intentFirstActivity extends AppCompatActivity {
    //
    TextView textView;
    //
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_first);

        //sari bounding hm onCreate me krenge
        textView=findViewById(R.id.textaddone);//ye bound kr diya ha
        textView.setText("0");

        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Go_to_secondActivity(View view) {//agr view class ka object nh hoga tio ye fun ni chalega

        //intent use hota ha ek activity sy dosri ma jane k liye
        Intent intent =new Intent(this,intentSecondActivity.class);
        startActivity(intent);
    }

    public void Add_One(View view) {
        int value=Integer.valueOf(String.valueOf(textView.getText()));
        value=value+1;
        textView.setText(String.valueOf(value));
    }

    public void Send_Data_To_SecondActivity(View view) {
        Intent intent=new Intent(this, intentSecondActivity.class);
        intent.putExtra("Key1",50);
        intent.putExtra("Key2",20);
        startActivity(intent);
    }

    public void Show_Toast(View view) {
        //double space kre sy auto likh deta ha
        //toast message wo hota ha jo secreen pr thori der k liye show hota ha , jb charge krty phone , etcc

        //Toast.makeText(this, "My Toast", Toast.LENGTH_SHORT).show();

        //color etc ap change kr skty ho , wo ap stack overflow sy khud dekhna

        Snackbar.make(view,"My Toast",Snackbar.LENGTH_SHORT).show();

    }
}
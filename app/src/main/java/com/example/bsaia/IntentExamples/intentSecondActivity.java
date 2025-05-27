package com.example.bsaia.IntentExamples;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

public class intentSecondActivity extends AppCompatActivity {
    TextView txtValue1,txtValue2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_second);

        //bind kr rhy hain hm
        txtValue1=findViewById(R.id.txtintentvalue1);
        txtValue2=findViewById(R.id.txtintentvalue2);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=getIntent();//jaha sy bhi intent aya hoga iosko receive krega

        int value1=intent.getIntExtra("Key1",0);
        int value2=intent.getIntExtra("Key2",0);

        //yaha value de denge
        txtValue1.setText(String.valueOf(value1));
        txtValue2.setText(String.valueOf(value2));
    }
}
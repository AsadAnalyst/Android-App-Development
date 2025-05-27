package com.example.bsaia.SharedPreferenceExample;

import android.content.SharedPreferences;
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

public class SharedPrefMainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_pref_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences=getSharedPreferences("MyFile",0);//0 means private mode, is application k ilaa koi...
        // or file is ko access ni kr skti agr hm 0 krenge , agr 1 likhnege to iska matlb k public ha


    }

    //
    //this is used for store data
    public void Save_Pref(View view) {
        //SharedPreferences.Editor,measns mujhe ios file ko write krne k acces do
        SharedPreferences.Editor editor=
                sharedPreferences.edit();//object sharedPreferences ko write dy diye hmne
        editor.putInt("K1",100);
        editor.putString("k2","Ali");
        editor.commit();//appply vs commit dekhna google pr lazmiii...
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    public void Show_Pref(View view) {
    int value1=sharedPreferences.getInt("K1",0);
    String value2=sharedPreferences.getString("k2","");
        Toast.makeText(this, "Value 1 "+value1+" Value 2 "+value2, Toast.LENGTH_SHORT).show();
    }
}
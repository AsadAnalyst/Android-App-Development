package com.example.bsaia.PermissionExamples;

import static android.Manifest.permission.CAMERA;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

public class PermissionExampleOneMainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_permission_example_one_main);

        textView=findViewById(R.id.txtpermissionone);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Request_For_Permission(View view)
    {
        if(!Check_Permission())
        {
            Request_Permissions();
        }
        else {
            textView.setText("Permission Already Granted");
        }
    }

    public void check_For_Permission(View view)
    {
        if(Check_Permission())
        {
            textView.setText("Permission Granted Already");
        }
        else {
            textView.setText("Permission not granted Yet");
        }
    }

    //khud sy functon bnenge
    public  boolean Check_Permission()
    {
        int r1= ContextCompat.checkSelfPermission(this,CAMERA);
        return r1== PackageManager.PERMISSION_GRANTED;
    }
    public  void Request_Permissions()
    {
        ActivityCompat.requestPermissions(this,new String[]{CAMERA},101);

    }
    //ye automatic call hoga ane k bad
    //(remove kese krty permission , internet sy check kr lena)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==101 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            textView.setText("Permission Granted");
        }
    }
}
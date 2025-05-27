package com.example.bsaia.SQLiteExample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

import java.util.HashMap;

public class NewContactActivity extends AppCompatActivity {
    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_contact);

        firstName=findViewById(R.id.edtfirstname);
        secondName=findViewById(R.id.edtsecondname);
        phoneNumber=findViewById(R.id.edtphonenumber);
        emailAddress=findViewById(R.id.edtemail);
        homeAddress=findViewById(R.id.edthomeaddress);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void AddToDatabase(View view) {
        HashMap<String,String> contact=new HashMap<String,String>();
        contact.put("firstName",firstName.getText().toString());
        contact.put("secondName",secondName.getText().toString());
        contact.put("phoneNumber",phoneNumber.getText().toString());
        contact.put("emailAddress",emailAddress.getText().toString());
        contact.put("homeAddress",homeAddress.getText().toString());

        DbQueries dbQueries=new DbQueries(getApplicationContext());
        //this ki bajae hm getApplicationContext pas kr denge,bcz ye zyada bhtr ha , ye auto get kr deta
        dbQueries.Insert(contact);
        //if we want save hone k bd wapis main actvity ma chala jae
        //to is se ye hoga k save hone k bd wapis main ma chala jaega
        Intent intent=new Intent(this, MainActivitySQLite.class);
        startActivity(intent);
    }
}
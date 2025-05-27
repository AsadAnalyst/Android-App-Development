package com.example.bsaia.SQLiteExample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

import java.util.HashMap;

public class EditContactActivity extends AppCompatActivity {
    EditText edtfirstName,edtsecondName,edtphoneNumber,edtemailAddress,edthomeAddress;
    String contactID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_contact);

        edtfirstName=findViewById(R.id.editfirstname);
        edtsecondName=findViewById(R.id.editsecondname);
        edtphoneNumber=findViewById(R.id.editphonenumber);
        edtemailAddress=findViewById(R.id.editemailaddress);
        edthomeAddress=findViewById(R.id.edithomeaddress);

        //get the intent
        Intent intent=getIntent();
        contactID=intent.getStringExtra("id");
        //filed ma data dalne k liye
        DbQueries db=new DbQueries(getApplicationContext());
        HashMap<String,String> contact=db.getSingleRecord(contactID);
        edtfirstName.setText(contact.get("firstName"));
        edtsecondName.setText(contact.get("secondName"));
        edtphoneNumber.setText(contact.get("phoneNumber"));
        edtemailAddress.setText(contact.get("emailAddress"));
        edthomeAddress.setText(contact.get("homeAddress"));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void update_contact(View view) {
        String firstName = edtfirstName.getText().toString();
        String secondName = edtsecondName.getText().toString();
        String phoneNumber = edtphoneNumber.getText().toString();
        String emailAddress = edtemailAddress.getText().toString();
        String homeAddress = edthomeAddress.getText().toString();

        HashMap<String, String> contact = new HashMap<>();
        contact.put("_id", contactID);
        contact.put("firstName", firstName);
        contact.put("secondName", secondName);
        contact.put("phoneNumber", phoneNumber);
        contact.put("emailAddress", emailAddress);
        contact.put("homeAddress", homeAddress);

        DbQueries db = new DbQueries(getApplicationContext());
        long result = db.updateContact(contact,contactID);

        if (result == -1) {
            Toast.makeText(this, "Failed to update the contact", Toast.LENGTH_SHORT).show();
        } else {
            // If update is successful
            Toast.makeText(this, "Contact updated successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivitySQLite.class);
            startActivity(intent);
        }
    }
    public void delete_contact(View view) {
        DbQueries DBQueries=new DbQueries(getApplicationContext());
        DBQueries.deleteContact(contactID);
        Toast.makeText(this, "Contact Has been deleted Successfully", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, MainActivitySQLite.class);
        startActivity(intent);
    }

}
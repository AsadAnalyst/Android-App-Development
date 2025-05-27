package com.example.bsaia.Test;

import android.annotation.SuppressLint;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestMainActivity extends AppCompatActivity {
    EditText name, cnic, roll_number,cgpa;
    DatabaseReference dbReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test_main);

        FirebaseDatabase database = FirebaseDatabase
                .getInstance("https://bs-ai-a-0110-default-rtdb.firebaseio.com");
        dbReference=database.getReference();

        name=findViewById(R.id.txttestname);
        cnic=findViewById(R.id.txttestcnic);
        roll_number=findViewById(R.id.txttestrollnumber);
        cgpa=findViewById(R.id.txttestcgpa);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void sumbit_form_test(View view) {
        String enteredName = name.getText().toString();
        String enteredCnic = cnic.getText().toString();
        String enteredRoll = roll_number.getText().toString();
        String enteredCgpa = cgpa.getText().toString();

        DatabaseReference sectionRef = dbReference.child("BSAI-Test");

        sectionRef.child(enteredName).child("CNIC").setValue(enteredCnic);
        sectionRef.child(enteredName).child("Roll Number").setValue(enteredRoll);
        sectionRef.child(enteredName).child("CGPA").setValue(enteredCgpa);

        name.setText("");
        cnic.setText("");
        roll_number.setText("");
        cgpa.setText("");
        Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
    }

    public void show_test_database(View view) {
        //recycler view pr show krna ha
    }
}
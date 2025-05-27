package com.example.bsaia.FirebaseExamples;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseMainActivity extends AppCompatActivity {
    DatabaseReference dbReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_firebase_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://bs-ai-a-0110-default-rtdb.firebaseio.com");
        //ye URL hmne Firebase kay project se liya ha
        dbReference=database.getReference();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //ye hmne bnaya

    @Override
    protected void onStart() {
        super.onStart();
        dbReference.child("BSAI(A)").setValue("SMD");

/*      Test_User testUser=new Test_User();
        testUser.setName("Mohammad Ali");
        testUser.setEmail("abcd@nu.edu.pk");
        dbReference.setValue(testUser);*/

/*      dbReference.child("BSAI").child("SMD").
                child("S1").setValue("Ali");
        dbReference.child("BSAI").child("SMD").
                child("S2").setValue("Ahmad");
        dbReference.child("BSAI").child("SMD").
                child("S3").setValue("Zubair");


        dbReference.child("BSAI").child("Recomender System").
                child("S1").setValue("Zubair");
        dbReference.child("BSAI").child("Recomender System").
                child("S2").setValue("Amna");
        dbReference.child("BSAI").child("Recomender System").
                child("S3").setValue("Alina");*/

        /*DatabaseReference sectionRef = dbReference.child("BSAI-6A");

        sectionRef.child("Student-01").child("name").setValue("Ali");
        sectionRef.child("Student-01").child("email").setValue("a@gamil.com");
        sectionRef.child("Student-01").child("gpa").setValue("3.6");
        sectionRef.child("Student-01").child("course").setValue("SMD");

        sectionRef.child("Student-02").child("name").setValue("Sara");
        sectionRef.child("Student-02").child("email").setValue("sara@example.com");
        sectionRef.child("Student-02").child("gpa").setValue("3.8");
        sectionRef.child("Student-02").child("course").setValue("AI");

        sectionRef.child("Student-03").child("name").setValue("Ahmed");
        sectionRef.child("Student-03").child("email").setValue("ahmed@example.com");
        sectionRef.child("Student-03").child("gpa").setValue("3.2");
        sectionRef.child("Student-03").child("course").setValue("ML");

        sectionRef.child("Student-04").child("name").setValue("Fatima");
        sectionRef.child("Student-04").child("email").setValue("fatima@example.com");
        sectionRef.child("Student-04").child("gpa").setValue("3.9");
        sectionRef.child("Student-04").child("course").setValue("DL");

        sectionRef.child("Student-05").child("name").setValue("Usman");
        sectionRef.child("Student-05").child("email").setValue("usman@example.com");
        sectionRef.child("Student-05").child("gpa").setValue("2.9");
        sectionRef.child("Student-05").child("course").setValue("DSA");

        sectionRef.child("Student-06").child("name").setValue("Zara");
        sectionRef.child("Student-06").child("email").setValue("zara@example.com");
        sectionRef.child("Student-06").child("gpa").setValue("3.7");
        sectionRef.child("Student-06").child("course").setValue("CV");

        sectionRef.child("Student-07").child("name").setValue("Bilal");
        sectionRef.child("Student-07").child("email").setValue("bilal@example.com");
        sectionRef.child("Student-07").child("gpa").setValue("3.1");
        sectionRef.child("Student-07").child("course").setValue("NLP");

        sectionRef.child("Student-08").child("name").setValue("Ayesha");
        sectionRef.child("Student-08").child("email").setValue("ayesha@example.com");
        sectionRef.child("Student-08").child("gpa").setValue("3.4");
        sectionRef.child("Student-08").child("course").setValue("SMD");

        sectionRef.child("Student-09").child("name").setValue("Hassan");
        sectionRef.child("Student-09").child("email").setValue("hassan@example.com");
        sectionRef.child("Student-09").child("gpa").setValue("3.3");
        sectionRef.child("Student-09").child("course").setValue("AI");

        sectionRef.child("Student-10").child("name").setValue("Noor");
        sectionRef.child("Student-10").child("email").setValue("noor@example.com");
        sectionRef.child("Student-10").child("gpa").setValue("3.5");
        sectionRef.child("Student-10").child("course").setValue("ML");

        sectionRef.child("Student-11").child("name").setValue("Hamza");
        sectionRef.child("Student-11").child("email").setValue("hamza@example.com");
        sectionRef.child("Student-11").child("gpa").setValue("2.8");
        sectionRef.child("Student-11").child("course").setValue("CV");*/
        getRecord();
    }
    public void getRecord()
    {
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue()!=null)
                {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren())
                    {
                        String value = dataSnapshot.getValue().toString();
                        Log.d("TAG"," "+value);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
package com.example.bsaia.FileHandling;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandlingExample extends AppCompatActivity {
    EditText editText;
    TextView textView;
    String FileName="MyTextFile";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_file_handling_example);

        editText=findViewById(R.id.edtfilehandling);
        textView=findViewById(R.id.txtfilehandling);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Save_Into_File(View view) {
        String value=editText.getText().toString();
        try {
            FileOutputStream outputStream=openFileOutput(FileName, Context.MODE_PRIVATE);
            outputStream.write(value.getBytes());
            editText.setText(" ");
            Log.d("TAG","Data Written Into File");
            outputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void Show_From_File(View view) {
        String value="";
        try {
            FileInputStream inputStream=openFileInput(FileName);
            InputStreamReader reader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String data=bufferedReader.readLine();
            if(data==null){
                Toast.makeText(this, "File is Empty", Toast.LENGTH_SHORT).show();

            }
            else{
                while (data !=null){
                    value=value+data;
                    data=bufferedReader.readLine();
                }
                bufferedReader.close();
                reader.close();
                inputStream.close();
                //jis sequence sy open kiya ha iosy seq sy close
                //jo phle open kiya wo last ma close
            }
            textView.setText(value);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
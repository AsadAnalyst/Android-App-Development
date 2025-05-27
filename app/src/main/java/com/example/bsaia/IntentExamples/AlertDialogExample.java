package com.example.bsaia.IntentExamples;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

public class AlertDialogExample extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alert_dialog_example);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Open_AlertDlog(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(AlertDialogExample.this);

        builder.setMessage("Are you Sure ?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogExample.this,
                                "OK Clicked", Toast.LENGTH_SHORT).show();
                        textView=findViewById(R.id.textViewAlert1);
                        textView.setText("0");
                        //int value=Integer.valueOf(String.valueOf(textView.getText()));
                        //value=value+1;
                        //textView.setText(String.valueOf(value));
                    }

                })
                .setNegativeButton("Cancel",null);
        AlertDialog alert=builder.create();
        alert.show();
    }
}
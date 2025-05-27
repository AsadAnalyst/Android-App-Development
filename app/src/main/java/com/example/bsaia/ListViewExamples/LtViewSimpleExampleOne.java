package com.example.bsaia.ListViewExamples;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

public class LtViewSimpleExampleOne extends AppCompatActivity {

    ListView listView;
    String[] mobileList={"Note 5","Note 6","Note 7","Note 8","Note 9","Note 10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lt_view_simple_example_one);

        listView=findViewById(R.id.lstsimpleexampleone);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,mobileList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LtViewSimpleExampleOne.this,
                        "Position "+position, Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(adapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
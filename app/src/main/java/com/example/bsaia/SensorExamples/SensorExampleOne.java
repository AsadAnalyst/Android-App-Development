package com.example.bsaia.SensorExamples;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;
import android.graphics.Color;


public class SensorExampleOne extends AppCompatActivity implements SensorEventListener {
    //we implement SensorEventListner
    TextView textView;
    SensorManager sensorManager;
    View v;
    boolean color=false;
    long recentTimeUpdate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sensor_example_one);
        textView=findViewById(R.id.txtsensorone);
        v = findViewById(R.id.main);
        recentTimeUpdate=System.currentTimeMillis();
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            getSensorValues(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void getSensorValues(SensorEvent event)
    {
        float[] values=event.values;
        //x,y,z axex hoty real world me
        float x=values[0];
        float y=values[1];
        float z=values[2];
        //gravity ka squre equal.....
        float acceleration=(x*x + y*y + z*z)/(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long realTime=event.timestamp;
        if(acceleration>=2)
        {
            //150ms , miliSecond
            if (realTime-recentTimeUpdate<150)
            {
                return;
            }
            recentTimeUpdate=realTime;
            textView.setText("Mobile was moved");
            if(color)
            {
                v.setBackgroundColor(Color.BLUE);
            }
            else {
                v.setBackgroundColor(Color.GREEN);
            }
            color=!color;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
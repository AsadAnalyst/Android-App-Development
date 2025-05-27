package com.example.bsaia.ServiceExamples;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyServiceExampleOne extends Service {
    private Handler handler;
    private Runnable runnable;
    private int counter = 0;
    private boolean isCount = false;

    @Override
    public void onCreate() {
        super.onCreate();
        handler=new Handler();
        isCount=true;
        startCounting();
    }

    private void startCounting() {
        runnable=new Runnable() {
            @Override
            public void run() {
                if(isCount) {
                    counter++;
                    Log.d("TAG","Counting = "+counter);
                    handler.postDelayed(this,2000);
                }
            }
        };
        handler.post(runnable);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isCount=false;
        handler.removeCallbacks(runnable);
        Log.d("TAG","Service is Stopped.");
    }
}

package com.example.bsaia.BroadCastExamples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeBroadCast extends BroadcastReceiver {
    //extend with "BroadcastReceiver".
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirplaneModeChange(context.getApplicationContext()))
        {
            Toast.makeText(context, "AirPlaneMode is On", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "AirPlaneMode is Off", Toast.LENGTH_SHORT).show();
        }
    }
    
    //ye hmne khud bnaya function
    public boolean isAirplaneModeChange(Context context)
    {   
        boolean a= Settings.System.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON,0)!=0;
        //global means whole mobile ki , local means specific.
        return a;
    }
}

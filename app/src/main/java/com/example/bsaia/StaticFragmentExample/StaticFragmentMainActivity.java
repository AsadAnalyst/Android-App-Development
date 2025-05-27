package com.example.bsaia.StaticFragmentExample;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

public class StaticFragmentMainActivity extends AppCompatActivity
        implements ContactsFragments.ListSelectionListner {//ContactsFragments java class sy liya ye
    //for inheritance we "extend" , but for interface we "implements"
    //slides ma sraa btaya hua ye question kese krna ha

    //*****IMP*******************************
    //koi bhi fragment communcate kr skta khud,
    //activity k throuh krty communication , through interface
    //interfcae waha hoga jisne application start krne ha
    //*************
    public static String [] contactsArray;
    public static String [] contactsDetailArray;
    public DeatilsFragment deatilsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_static_fragment_main);

        contactsArray=getResources().getStringArray(R.array.contacts_array);
        contactsDetailArray=getResources().getStringArray(R.array.details_array);

        deatilsFragment= (DeatilsFragment) getSupportFragmentManager().findFragmentById(R.id.detailfragementid);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onSelection(int position) {
        //jis activity ne communication krne wo apne andr ek interface bnaega
        if(deatilsFragment.getCurrentIndex()!=position)
        {
            deatilsFragment.ContactIndex(position);
        }
    }
}
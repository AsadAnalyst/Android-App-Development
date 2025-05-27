package com.example.bsaia.FragmentExamples;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bsaia.R;
//agr hm chaty hian k hamarri app resposive ho to hm isk liye...
//fragment use krenge.
//ek activity k upr different fragment hoty hain.
//fragment is nothing without activity(eg. child is nothing without parent)
//screen k size k according fragments show ho rhy hoty hain
//STATIC-Fragment->screen ka size fix krden k screen pr n number of fragment show honge.
//DYNAMIC-FRAGMENT->screen k size k according fragment chnage honge , ya click krne pr change.
//Fragment ka LifeCycle , dependent on Activity LifeCycle
//what is hamburger menu?
//(MUST READ SLIDES OF FRAGMENT , IMP FOR EXAM PERSPECTIVE)
//IMP...
//java class kay sath layout attact krna ho to layout inflator use krty
//agr activity kay sath attach krna ho to setcontentview use krty
public class FragmentExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //******************
        //we comment this because hmne is pr apne fragment lgane hain..
        //iska apna layout nhi lgana
        //(lekin crash ho rhi app , so i uncomment , now working fine)
        setContentView(R.layout.activity_fragment_example_one_main);
        //******************

        Configuration config=getResources().getConfiguration();
        //getResources() , activity class ka method ha ye.

        //dynamic fragment add krne k 4 steps hain
        //1-fragment manager class ka obj
        //2-transaction class ka object
        //3-transaction k sath replace krenge layout ko
        //4-transaction k sath commit
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(config.orientation==Configuration.ORIENTATION_LANDSCAPE){
            LM_Fragment lmFragment=new LM_Fragment();
            fragmentTransaction.replace(android.R.id.content,lmFragment);
        }
        else{
            PM_Fragment pmFragment=new PM_Fragment();
            fragmentTransaction.replace(android.R.id.content,pmFragment);
        }
        fragmentTransaction.commit();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
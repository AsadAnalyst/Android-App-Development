package com.example.bsaia.FragmentExamples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bsaia.R;

//fragmment k liye extend krenge with fregment
public class LM_Fragment extends Fragment {
    //LM menas LANDSCAPE Mode

    //yaha method khud bnaty , automatic nhi bnenge
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //new return bnanege , old wala remove
        return  inflater.inflate(R.layout.lm_fragment, container,false);
    }
}

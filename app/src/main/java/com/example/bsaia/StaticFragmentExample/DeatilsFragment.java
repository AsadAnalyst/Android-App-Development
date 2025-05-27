package com.example.bsaia.StaticFragmentExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bsaia.R;

public class DeatilsFragment extends Fragment {
    //iska layout hmne bnana ha , contactsdetails.xml

    public TextView contactDetailTextview;
    int currentIndex=-1;
    int length;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contactdetailslayout,
                container,false);
    }
    public int getCurrentIndex()
    {
        return currentIndex;
    }
    public void ContactIndex(int index)
    {
        //check krna kay user ne list view ma hi click kiya ya khe or
        //if khe or click kiya to obviously ni position chaye hme
        if(index < 0 || index >= length)
        {
            return;
        }
        currentIndex=index;
        contactDetailTextview.setText(StaticFragmentMainActivity.contactsDetailArray[index]);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        contactDetailTextview=getActivity().findViewById(R.id.txtxdetailsfragment);
        length=StaticFragmentMainActivity.contactsDetailArray.length;
    }
}

package com.example.bsaia.StaticFragmentExample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.bsaia.R;

public class ContactsFragments  extends ListFragment {//listfragment because list pr show krna contacts hmne
    //is java class ka layout is waja sy ni bnaya because we use ListFragment(it is itself a layout)
    //abstract class ha ye , so we define this in another
    public  ListSelectionListner mlistner=null;
    public interface ListSelectionListner{
        public void onSelection(int position);
    }
    public void onAttach(@NonNull Context context){

        super.onAttach(context);
        mlistner=(ListSelectionListner) getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //if we use .CHOICE_MODE_MULTI , then Tick waly box bne ge
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.contact,
                StaticFragmentMainActivity.contactsArray));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mlistner.onSelection(position);
    }
}

package com.example.androidtv_1;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClickFragment extends android.support.v17.leanback.app.ErrorFragment{


    public ClickFragment() {
        // Required empty public constructor
    }

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.setContent();
        return inflater.inflate(R.layout.fragment_click, container, false);
    } */

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        this.setContent();
    }



    void setContent(){

        setImageDrawable(getResources().getDrawable(R.drawable.error));
        setMessage(getResources().getString(R.string.content_not_found));
        setDefaultBackground(true);
        setButtonText(getResources().getString(R.string.ok));
        setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(ClickFragment.this).commit();
            }
        });

    }

}

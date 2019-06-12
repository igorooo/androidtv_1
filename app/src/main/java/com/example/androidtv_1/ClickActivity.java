package com.example.androidtv_1;

import android.app.Activity;
import android.os.Bundle;

public class ClickActivity extends Activity {

    private ClickFragment clickFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testClick();
    }

    void testClick(){

        this.clickFragment = new ClickFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment, clickFragment).commit();
    }
}

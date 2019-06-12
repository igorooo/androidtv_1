package com.example.androidtv_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoActivity extends Activity {

    private VideoFragment videoFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testClick();

    }

    void testClick(){

        this.videoFragment = new VideoFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment, videoFragment).commit();
    }


}

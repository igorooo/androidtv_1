package com.example.androidtv_1;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v17.leanback.app.GuidedStepFragment;
import android.support.v17.leanback.widget.GuidanceStylist;
import android.support.v17.leanback.widget.GuidedAction;
import android.widget.Toast;

import java.util.List;

public class GuidedStepActivity extends Activity {

    private static final int ACTION_CONTINUE = 0;
    private static final int ACTION_BACK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(null == savedInstanceState){
            GuidedStepFragment.add(getFragmentManager(), new FirstStepFragment());
        }
    }

    private static void addAction(List actions, long id, String title, String desc){
        actions.add(new GuidedAction.Builder().id(id).title(title).description(desc).build());
    }







    public static class FirstStepFragment extends GuidedStepFragment{

        @NonNull
        @Override
        public GuidanceStylist.Guidance onCreateGuidance(Bundle savedInstanceState) {

            String title = "Title 1";
            String breadcrumb = "Breadcrumb 1";
            String description = "Description 1";
            Drawable icon = getActivity().getDrawable(R.drawable.icon);

            return new GuidanceStylist.Guidance(title, description, breadcrumb, icon);
        }

        @Override
        public void onCreateActions(@NonNull List<GuidedAction> actions, Bundle savedInstanceState) {
            addAction(actions, ACTION_CONTINUE, "Continue", "Go to second step fragment");
            addAction(actions, ACTION_BACK, "Cancel", "Go back");
        }

        @Override
        public void onGuidedActionClicked(GuidedAction action) {

            switch ((int) action.getId()){
                case ACTION_CONTINUE:
                    Toast.makeText(getActivity(), "Continue",Toast.LENGTH_LONG).show();
                    //FragmentManager fm = getFragmentManager();
                    //GuidedStepFragment.add(fm, new VideoFragment());

                    break;
                case ACTION_BACK:
                    getActivity().finish();
                    break;
            }
        }
    }


}

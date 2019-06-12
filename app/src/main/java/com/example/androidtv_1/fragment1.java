package com.example.androidtv_1;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.app.ErrorFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.nio.charset.CodingErrorAction;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment1 extends BrowseFragment {

    String MainFragmentTAG = "Main fragment TAG";


    public fragment1() {
        // Required empty public constructor
    }

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    } */

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(MainFragmentTAG, " MainF - ConActivityCreated");
        this.setupUIElements();
        this.loadRows();
        this.setupEventListeners();
    }

    private void setupUIElements(){
        setTitle("My First Tv App");
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.header_background));
        setSearchAffordanceColor(getResources().getColor(R.color.search_color));
    }


    private void loadRows(){

        int NUM_ROWS = 2;

        ArrayObjectAdapter myRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        for( int i = 0; i < NUM_ROWS; i++){
            HeaderItem gridItemPresenterHeader = new HeaderItem(0, "Text Presenter "+i);
            ItemGridPresenter myGridPresenter = new ItemGridPresenter();
            ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(myGridPresenter);
            gridRowAdapter.add("Error Fragment");
            gridRowAdapter.add("Guided Steps");
            gridRowAdapter.add("Video");
            //gridRowAdapter.add(new VideoActivity());

            List<Card> cardList = CardList.buildCardList(getActivity(), 3);
            HeaderItem cardPresenterHeader = new HeaderItem(1, "Moj CardPresenter");
            CardPresenter cardPresenter = new CardPresenter();
            ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

            for(int j = 0; j<3; j++){
                cardRowAdapter.add(cardList.get(j));
            }
            myRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
            myRowsAdapter.add(new ListRow(gridItemPresenterHeader, gridRowAdapter));
        }

        setAdapter(myRowsAdapter);
    }

    private void setupEventListeners(){
        setOnSearchClickedListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Implement own search ", Toast.LENGTH_LONG).show();

            }
        });

        setOnItemViewClickedListener(new ItemViewClickListener());
    }

    private final class ItemViewClickListener implements OnItemViewClickedListener {


        @Override
        public void onItemClicked(Presenter.ViewHolder viewHolder, Object item, RowPresenter.ViewHolder viewHolder1, Row row) {

            if(item instanceof String){
                Toast.makeText(getActivity(), ((String) item), Toast.LENGTH_SHORT).show();

                if(((String) item).compareTo("Error Fragment") == 0){
                    Intent intent = new Intent(getActivity(), ClickActivity.class);
                    startActivity(intent);
                }

                if(((String) item).compareTo("Guided Steps") == 0){
                    Intent intent = new Intent(getActivity(), GuidedStepActivity.class);
                    startActivity(intent);
                }

                if(((String) item).compareTo("Video") == 0){
                    Intent intent = new Intent(getActivity(), VideoActivity.class);
                    startActivity(intent);
                }
            }


        }
    }


}

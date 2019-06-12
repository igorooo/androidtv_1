package com.example.androidtv_1;

import android.content.Context;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.util.Log;
import android.view.ViewGroup;

public class CardPresenter extends Presenter {

    private static final String TAG = "TAG1";
    private static Context mContext;
    private static int CARD_WIDTH = 300;
    private static int CARD_HEIGHT = 200;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        Log.d(TAG, "*** onCreateVievHolder - wywolano ***");
        mContext = parent.getContext();

        ImageCardView cardView = new ImageCardView(mContext);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        cardView.setBackgroundColor(mContext.getResources().getColor(R.color.header_background));

        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        Log.d(TAG, "onBindViewHolder");
        Card card = (Card) item;
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        cardView.setTitleText(card.title);
        cardView.setContentText(card.description);
        cardView.setMainImage(card.image);
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        Log.d(TAG, "*** onUnbindViewHolder - wywolano ***");
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        cardView.setMainImage(null);

    }
}

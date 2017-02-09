package com.homer.pageflip;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class Main extends Activity {

    private Pager pageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        pageView = (Pager) findViewById(R.id.pager);
        Bitmap currPageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        Bitmap nextPageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg2);
        pageView.setBitmaps(currPageBitmap, nextPageBitmap);


    }

}
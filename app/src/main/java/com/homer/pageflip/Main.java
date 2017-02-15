package com.homer.pageflip;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

public class Main extends Activity {

    private Pager pageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageView = new Pager(this);
        setContentView(pageView);

        final View view = getLayoutInflater().from(this).inflate(R.layout.sample_main, null, false);
        view.setDrawingCacheEnabled(true);


        view.measure(View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.EXACTLY));

        int a = view.getMeasuredWidth();
        int b = view.getMeasuredHeight();

        view.layout(0, 0, a, b);
        view.buildDrawingCache(true);

        Bitmap background = Bitmap.createBitmap(view.getDrawingCache());

        pageView.setBitmaps(background, background);


    }

}
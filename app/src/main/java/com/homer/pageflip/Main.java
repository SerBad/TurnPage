package com.homer.pageflip;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Main extends Activity {

    private Pager pageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        pageView = (Pager) findViewById(R.id.pager);
        View view = LayoutInflater.from(this).inflate(R.layout.sample_main,new LinearLayout(this), false);
        view.setDrawingCacheEnabled(true);
        view.findViewById(R.id.main);

        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);

        Bitmap background = Bitmap.createBitmap(view.getDrawingCache());

        pageView.setBitmaps(background, background);

    }

}
package com.homer.pageflip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhoutingjie on 2017/3/3.
 */

public class WaveView extends View {
    private Context context;
    private Bitmap image1;
    private Bitmap image2;
    private Bitmap image3;
    private Matrix mShaderMatrix;
    /*
     * https://www.desmos.com/calculator
     * 0.5\left(\frac{4}{4+x^4}\right)^{2.5}\sin \left(0.75\pi x-0.5\pi \right)
    * 0.5\left(\frac{4}{4+x^4}\right)^{2.5}\sin \left(0.75\pi x+0.5\pi \right)
    *0.1\left(\frac{4}{4+x^4}\right)^{2.5}\sin \left(0.75\pi x-.05\pi \right)
    * 0.5\left(\frac{4}{4+x^4}\right)^{2.5}\sin \left(0.75\pi x-0.2\pi \right)
    *
    * */

    private Paint mViewPaint;

    public WaveView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public WaveView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    private void init() {
        mShaderMatrix = new Matrix();
        mViewPaint = new Paint();
        mViewPaint.setAntiAlias(true);
        image1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.bg_tree1);
        image2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.bg_tree2);
        image3 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.bg_tree3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}

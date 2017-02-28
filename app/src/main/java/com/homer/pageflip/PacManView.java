package com.homer.pageflip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhoutingjie on 2017/2/27.
 * <p>
 * https://connoratherton.com/loaders
 */

public class PacManView extends View {
    private Context context;

    private int width;
    private int height;
    private float angleValue = 0.0f;
    private float value = 20.0f;
    private float beanX = 0;


    public PacManView(Context context) {
        super(context);
        init(context);
    }

    public PacManView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PacManView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getMeasuredWidth();
        height = getMeasuredHeight();

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //paint.setStrokeWidth(strokeWidth);
        //  value = strokeWidth;


        //RectF绘制的是左上和右下的坐标点
        canvas.drawArc(new RectF(width / 3 + value, value, width / 3 + height - value, height - value), 45 - angleValue, 270 + angleValue * 2, true, paint);

        if (beanX == 0||beanX<=width / 3 + height-40 ) {
            beanX = width *2/ 4.0f;
        }
        canvas.drawCircle(beanX, height / 2.0f, 20.0f, paint);


//        ObjectAnimator anim = ObjectAnimator.ofFloat(this, "rotation", -180.0f, 180.0f);
//        anim.setDuration(2000);
//        anim.setInterpolator(new OvershootInterpolator());
//        anim.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//
//                invalidate();
//
//            }
//        });
//
//        anim.start();
        startAnimation();
    }

    public void startAnimation() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                angleValue += 1;
                if (angleValue >= 45) {
                    angleValue = 0.0f;
                }
                beanX -= 1;
                invalidate();
            }
        }, 10);
    }
}

package com.homer.pageflip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

/**
 * Created by zhoutingjie on 2017/2/27.
 * <p>
 * http://codepen.io/jackrugile/full/JddmaX
 */

public class RainbowView extends View {
    private Context context;
    private float strokeWidth = 10.0f;
    private int width;
    private int height;
    private float startAngle = 0.0f;
    private int  i=0;

    public RainbowView(Context context) {
        super(context);
        init(context);
    }

    public RainbowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RainbowView(Context context, AttributeSet attrs, int defStyle) {
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
        float value = 0.f;
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        value = strokeWidth;

        canvas.drawArc(new RectF(value, value, width - value, height - value), startAngle, 180, false, paint);
        paint.setColor(Color.YELLOW);
        value = strokeWidth + 20.0f;
        canvas.drawArc(new RectF(value, value, width - value, height - value), startAngle, 180, false, paint);
        paint.setColor(Color.GREEN);
        value = strokeWidth + 40.0f;
        canvas.drawArc(new RectF(value, value, width - value, height - value), startAngle, 180, false, paint);
        paint.setColor(Color.CYAN);
        value = strokeWidth + 60.0f;
        canvas.drawArc(new RectF(value, value, width - value, height - value), startAngle, 180, false, paint);
        paint.setColor(Color.BLUE);
        value = strokeWidth + 80.0f;
        canvas.drawArc(new RectF(value, value, width - value, height - value), startAngle, 180, false, paint);

        ObjectAnimator anim = ObjectAnimator.ofFloat(this, "rotation", -180.0f, 180.0f);
        anim.setDuration(2000);
        anim.setInterpolator(new OvershootInterpolator());
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                invalidate();

            }
        });

        anim.start();
        //startAnimation();
    }

    public void startAnimation() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                startAngle += 1;
                if (startAngle >= 360) {
                    startAngle = 00.0f;
                }
                Log.i("xx", startAngle + "");
                invalidate();
            }
        });
    }
}

package com.homer.pageflip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by zhoutingjie on 2017/2/27.
 * https://connoratherton.com/loaders
 */

public class TriangleView extends View {
    private Context context;
    private float strokeWidth = 10.0f;
    private int width;
    private int height;
    private float startAngle = 0.0f;
    private boolean next = false;

    public TriangleView(Context context) {
        super(context);
        init(context);
    }

    public TriangleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TriangleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        float value = 0.f;
        final Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);


        value = strokeWidth;

        final Path path1 = new Path();
        path1.moveTo(width / 2 - 100, 0);
        path1.lineTo(width / 2, height / 2);
        path1.lineTo(width / 2 + 100, 0);
        path1.close();

        final Path path2 = new Path();
        path2.moveTo(width / 2 - 100, height);
        path2.lineTo(width / 2, height / 2);
        path2.lineTo(width / 2 + 100, height);
        path2.close();


        canvas.drawPath(next ? path1 : path2, paint);

        ObjectAnimator anim = ObjectAnimator.ofFloat(this, "rotationY", 135, 225,135);
        anim.setDuration(2000);
        anim.setInterpolator(new LinearInterpolator());
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
//                if (next) {
//                    next = false;
//                } else {
//                    next = true;
//                }

                invalidate();

            }
        });

        anim.start();

    }

}

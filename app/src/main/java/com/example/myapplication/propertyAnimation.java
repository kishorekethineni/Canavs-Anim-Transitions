package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class propertyAnimation extends View {
    final int AnimatorDuration=4000;
    final int AnimationDelay=1000;
    final int ColorAdjust=5;
    float x,y,radius;
    Paint paint;
    AnimatorSet animatorSet;

    public propertyAnimation(Context context) {
        super(context);
    }
    public propertyAnimation(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        paint=new Paint();
        animatorSet=new AnimatorSet();

    }
    void setRadius(float r)
    {
       radius =r;
       paint.setColor(Color.GREEN|(int) radius/ColorAdjust);
       invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        @SuppressLint("ObjectAnimatorBinding")
        ObjectAnimator growcircle=ObjectAnimator.ofArgb(this,"radius",0,w);
        growcircle.setDuration(AnimatorDuration);
        growcircle.setInterpolator(new LinearInterpolator());
        ObjectAnimator shrinkcircle=ObjectAnimator.ofFloat(this,"radius",0,w);
        shrinkcircle.setDuration(AnimatorDuration);
        shrinkcircle.setInterpolator(new DecelerateInterpolator());
        shrinkcircle.setStartDelay(AnimationDelay);
        animatorSet.play(growcircle).before(shrinkcircle);
    }
    @Override
public boolean onTouchEvent(MotionEvent event)
{
    switch (event.getAction())
    {
        case MotionEvent.ACTION_DOWN:
            x=event.getX();
            y=event.getY();
            if (animatorSet!=null&&animatorSet.isRunning())
            {
                animatorSet.cancel();
                animatorSet.start();
            }


            break;
    }
   return super.onTouchEvent (event) ;
}
protected void onDraw(Canvas canvas)
{
    super.onDraw(canvas);
    canvas.drawCircle(x,y,radius,paint);

}
}

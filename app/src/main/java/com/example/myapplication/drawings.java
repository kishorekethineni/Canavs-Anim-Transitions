package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class drawings extends View {
    Paint p;
    Path path;
    public drawings(Context context)
    {
        super(context);
        p=new Paint();
        path=new Path();
        p.setColor(Color.GREEN);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10f);
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.YELLOW);
        canvas.drawPath(path,p);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_UP:
                path.lineTo(event.getX(),event.getY());
                break;
        }
        invalidate();
        return true;
    }
}

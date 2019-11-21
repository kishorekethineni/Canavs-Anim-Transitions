package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class View extends android.view.View
{
    Paint p;
    Bitmap bitmap;
    int x=90;
    public View(Context context)
    {
        super(context);
        p=new Paint();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("DrawAllocation")
    @Override
    public void onDraw(Canvas canvas)
    {
       // bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background);
        canvas.drawColor(Color.YELLOW);
        super.onDraw(canvas);
        p.setColor(Color.BLACK);
        p.setTextSize(52);
        canvas.drawText("android",100,100,p);
        p.setColor(Color.BLUE);
        p.setUnderlineText(true);
        canvas.drawRect(200,250,500,800,p);
        p.setColor(Color.RED);
        p.setStrokeWidth(120);
        canvas.drawLine(500,500,700,500,p);
        p.setColor(Color.GREEN);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(700,500,200,p);
       // canvas.drawBitmap(bitmap,700,700,null);
        p.setStyle(Paint.Style.FILL);
        canvas.drawArc(500,300,900,700,x+180,45,true,p);
        canvas.drawArc(500,300,900,700,x,45,true,p);
        x=x+10;
    }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent)
    {
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                invalidate();
                break;


        }
        return true;
    }
}

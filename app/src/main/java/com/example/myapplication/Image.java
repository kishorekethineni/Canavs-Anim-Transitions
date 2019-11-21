package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class Image extends View {
    Bitmap b1,b2,b3,bg;
    Paint paint;
    int x=0,k=0,k1=0;
    int y=10;
    Bitmap[] arr=new Bitmap[3];
    public Image(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint=new Paint();
        b1= BitmapFactory.decodeResource(getResources(),R.drawable.mario1);
        b2= BitmapFactory.decodeResource(getResources(),R.drawable.mario2);
        b3= BitmapFactory.decodeResource(getResources(),R.drawable.mario3);
        arr[0]=b1;
        arr[1]=b2;
        arr[2]=b3;
        bg=BitmapFactory.decodeResource(getResources(),R.drawable.background);
      /*  ByteArrayOutputStream bos = new ByteArrayOutputStream(500);
        b1.compress(Bitmap.CompressFormat.JPEG, 25, bos);
        b2.compress(Bitmap.CompressFormat.JPEG, 25, bos);*/
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        @SuppressLint("DrawAllocation")
        Rect r1= new Rect(0,0,bg.getWidth(),bg.getHeight());
        @SuppressLint("DrawAllocation")
        Rect r2=new Rect(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.drawBitmap(bg,r1,r2,null);
        canvas.drawBitmap(arr[k],x,canvas.getHeight()-arr[k].getHeight()-400-y,null);
        x=x+20;
        k=k+1;
        if(k==2)
        {
            k=0;
        }
        if (x>=canvas.getWidth())
        {
            x=10;
        }


    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                saartFan();
                break;
            case MotionEvent.ACTION_UP:
                startfan();
                break;
        }
        return true;
    }

    private void startfan() {
        x=x+25;
        y=y+45;
        invalidate();
    }

    private void saartFan() {
       // x=x+25;
        y=y-25;
        invalidate();
    }

}

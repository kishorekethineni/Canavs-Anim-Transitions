package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class surfaceView extends SurfaceView implements Runnable {
    SurfaceHolder surfaceHolder;
    Paint p;
    int x = 90;
    boolean isrunning;
    Canvas canvas;
    Thread thread=null;

    //Normal constructor
    public surfaceView(Context context) {
        super(context);
        intialising();
    }
    //For XML setContentView();
    public surfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void intialising() {
        surfaceHolder=getHolder();
        p=new Paint();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                startThread();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    private void startThread() {
        thread =new Thread(this);
        thread.start();
    }

    @Override
    public void onDraw(Canvas canvas) {

        if (surfaceHolder.getSurface().isValid()) {
            canvas.drawColor(Color.RED);
            p.setColor(Color.GREEN);
            p.setStyle(Paint.Style.STROKE);
            //canvas.drawCircle(700, 500, 200, p);
            // canvas.drawBitmap(bitmap,700,700,null);
            p.setStyle(Paint.Style.FILL);
            canvas.drawArc(500, 300, 900, 700, x + 180, 45, true, p);
            canvas.drawArc(500, 300, 900, 700, x, 45, true, p);
            //canvas.drawArc(500, 300, 900, 800, 800, 50, true, p);
            x = x + 10;
        }
    }


    @SuppressLint("WrongCall")
    @Override
    public void run() {
        do
        {
            try {
                synchronized (this)
                {
                    Thread.sleep(0);
                    canvas=surfaceHolder.lockCanvas();
                    onDraw(canvas);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                if (canvas!=null)
                {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                    postInvalidate();
                }

            }
        }
        while (isrunning);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                isrunning=true;
                invalidate();
                startThread();
                break;
            case MotionEvent.ACTION_UP:
                stopRunning();
                break;
        }
        return super.onTouchEvent(event);
    }

    private void stopRunning() {
        isrunning=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

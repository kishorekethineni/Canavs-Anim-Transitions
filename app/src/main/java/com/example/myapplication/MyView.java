package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class MyView extends SurfaceView {
    Paint P;
    SurfaceHolder surfaceHolder;
    Canvas c;
    int x = 90;

    public MyView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        P = new Paint();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @SuppressLint({"WrongCall", "NewApi"})
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (surfaceHolder.getSurface().isValid()) {
                    c = surfaceHolder.lockCanvas();
                    onDraw(c);
                    surfaceHolder.unlockCanvasAndPost(c);
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas) {
        P.setColor(Color.GREEN);
        P.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(700, 500, 200, P);

        // canvas.drawBitmap(bitmap,700,700,null);
        P.setStyle(Paint.Style.FILL);
        canvas.drawArc(500, 300, 900, 700, x + 180, 45, true, P);
        canvas.drawArc(500, 300, 900, 700, x, 45, true, P);
        x = x + 10;
    }

    /*@Override
    public void run() {
        do {
            try {
                synchronized (this) {
                    Thread.sleep(300);
                    c = surfaceHolder.lockCanvas();
                    draw(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }*/
}

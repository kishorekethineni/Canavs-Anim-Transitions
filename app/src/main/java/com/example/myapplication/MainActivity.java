package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyView myview;
    Image image;
    View view;
    drawings drawings;
    surfaceView surfaceView;
    propertyAnimation propertyAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        myview=new MyView(this);
        //view=new View(this);
        //surfaceView=new surfaceView(this);
        //propertyAnimation=new propertyAnimation(this);
        //setContentView(view);
          setContentView(myview);
        //CustomEditText customEditText=new CustomEditText(this);
        //setContentView(R.layout.activity_main);
       image=new Image(this);
        //drawings=new drawings(this);
       //setContentView(drawings);

    }
}

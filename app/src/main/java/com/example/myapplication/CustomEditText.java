package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;

public class CustomEditText extends AppCompatEditText
{
    Drawable lighticon,darkicon;
   /* public CustomEditText(Context context, AttributeSet attributeSet,int defStylAttr) {
        super(context);
        init();
    }*/
  public CustomEditText(Context c,AttributeSet a)
   {
       super(c,a);
        init();
   }


    void init()
    {
       darkicon= ResourcesCompat.getDrawable(getResources(),R.drawable.cancel_dark,null);
       lighticon= ResourcesCompat.getDrawable(getResources(),R.drawable.cancel_light,null);
       addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
                showlighticon();
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
       setOnTouchListener(new OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               boolean isclick = false;
               float startXicon = getWidth() - getPaddingEnd() - lighticon.getIntrinsicWidth();
               if (event.getX() > startXicon) {
                   isclick = true;
               }
               if (isclick)
               {
                   switch (event.getAction())
                   {
                       case MotionEvent.ACTION_DOWN:
                           getText().clear();
                           break;
                       case MotionEvent.ACTION_UP:
                           showdarkicon();
                           break;
                   }
               }
                   return true;
               }

       });
    }


    void showlighticon()
    {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,lighticon,null);
    }

    void showdarkicon()
    {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,darkicon,null);
    }
}

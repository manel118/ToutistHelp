package com.example.touristhelp;

import android.app.Dialog;
import android.content.Context;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class DialogImage extends Dialog {
    ImageView image ;
    ImageView closeButton ;
    public DialogImage(@NonNull Context context,int ImageRes) {
        super(context);
        setContentView(R.layout.bugger_image);
        image = findViewById(R.id.BigImage);
       // closeButton =findViewById(R.id.closing);
        image.setImageResource(ImageRes);

        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dismiss();
                return false;
            }
        });
//        closeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });

    }
}

package com.myproject.websitemanager.ui.home.createwebsiteactivity.ui.webpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;


public class TransformViewModel extends View {
        Rect rect;
        Paint paint;

    public TransformViewModel(Context context) {

        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect = new Rect(0,100,200,300);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect,paint);
    }
}
package com.example.bsaia.GesturesExamples.GestureExampleTwo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class MultiTouchViewClass extends View {
    public Paint paint,myPaint;
    public Path path;
    public static final int size=60;
    public SparseArray<PointF> activePoint;
    public int[] color={Color.GREEN,Color.BLACK,Color.BLUE,
                        Color.MAGENTA,Color.DKGRAY,Color.RED};

    public MultiTouchViewClass(Context context) {
        super(context);
        Pointers();
    }

    private void Pointers() {
        activePoint=new SparseArray<PointF>();
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //boundary ko stork bolty hain
        myPaint= new Paint(Paint.ANTI_ALIAS_FLAG);
        myPaint.setTextSize(40);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
         int pointIndex =event.getActionIndex();
         int pointID=event.getPointerId(pointIndex);
         int actionMask=event.getActionMasked();
         switch (actionMask)
         {
             case MotionEvent.ACTION_DOWN:
             case MotionEvent.ACTION_POINTER_DOWN:
             {
                 PointF pointF=new PointF();
                 pointF.x=event.getX(pointIndex);
                 pointF.y=event.getY(pointIndex);
                 activePoint.put(pointID,pointF);

             }
             break;
             case MotionEvent.ACTION_MOVE:
             {
                 for(int size=event.getPointerCount(),i=0;i<size;i++) {
                     PointF pointF = activePoint.get(event.getPointerId(i));
                     if (pointF != null) {
                         pointF.x = event.getX();
                         pointF.y = event.getY();
                     }
                 }
             }
             break;
             case MotionEvent.ACTION_UP:
             case MotionEvent.ACTION_POINTER_UP:
             case MotionEvent.ACTION_CANCEL:
                 activePoint.remove(pointID);
                 break;
             default:
                 for (int size=event.getPointerCount(),i=0;i<size;i++){
                     PointF pointF = activePoint.get(event.getPointerId(i));
                     if (pointF != null) {
                         pointF.x = event.getX();
                         pointF.y = event.getY();
                     }
                 }
         }
         invalidate();
         return true;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for (int size=activePoint.size(),i=0;i<size;i++){
            PointF pointF = activePoint.valueAt(i);
            if (pointF != null) {
              paint.setColor(color[i]);
              canvas.drawCircle(pointF.x,pointF.y,60,paint);
            }
        }
    }
}

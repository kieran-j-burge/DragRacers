package android.webdevk.dragracers.Views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.webdevk.dragracers.Objects.Car;
import android.webdevk.dragracers.Services.Impl.LocalStorageServiceImpl;
import android.webdevk.dragracers.Tools.GraphicsHandler;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PitStopView extends View {

    LocalStorageServiceImpl localStorageService = new LocalStorageServiceImpl();
    GraphicsHandler graphicsHandler = new GraphicsHandler();


    List<Car> carsFromStorage = new ArrayList<>();
    List<Car> pitStop = new ArrayList<>();

    public PitStopView(Context context) {
        super(context);
    }

    public PitStopView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PitStopView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PitStopView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

//        this.setLayoutParams(new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.FILL_PARENT));



    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

//        Paint bgColor = new Paint();
//        bgColor.setColor(Color.GREEN);
//        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(),bgColor);
    }



}

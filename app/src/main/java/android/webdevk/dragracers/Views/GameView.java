package android.webdevk.dragracers.Views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.webdevk.dragracers.GameActivity;
import android.webdevk.dragracers.Objects.Car;
import android.webdevk.dragracers.R;
import android.webdevk.dragracers.Services.Impl.LocalStorageServiceImpl;
import android.webdevk.dragracers.Tools.GraphicsHandler;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class GameView extends View {

    //Public classes
    LocalStorageServiceImpl localStorageService = new LocalStorageServiceImpl();
    GraphicsHandler graphicsHandler = new GraphicsHandler();

    Path track = new Path();

    TextView coinsTV;

    Integer height;
    Integer width;
    Integer coins=0;
    double multiplier = 1;

    List<Car> onTrackFromStorage = new ArrayList<>();

    ArrayList<Car> onTrack= new ArrayList<>();

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    Paint p = new Paint();

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        //Set display metrics of the screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);

        width = 0;
        height = 0;

        coins = localStorageService.getCoinsFromStorage(getContext());
        coins = 100000;
        onTrackFromStorage = setCarsFromStorageImg(localStorageService.getOnTrackFromStorage(getContext()));

        for(Car c: onTrackFromStorage){
            onTrack.add(c);
        }

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //Here you can get the size!
        height = this.getMeasuredHeight();
        width = this.getMeasuredWidth();
        setTrack();
    }

    private List<Car> setCarsFromStorageImg(List<Car> carsFromStorage) {
        for (Car c : carsFromStorage){
            c.setImage(graphicsHandler.setCarGraphic(getContext(), c.getLevel()));
        }
        return carsFromStorage;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        // onDestroy() called
    }



    private void setTrack(){
        track.moveTo(width*0.05f, height*0.6f);
        track.lineTo(width*0.05f,  height*0.5f);
        track.quadTo(width*0.1f, height*0.15f, width*0.35f, height*0.3f);
        track.quadTo(width*0.55f, height*0.5f, width*0.65f, height*0.3f);
        track.quadTo(width*0.70f, height*0.2f, width*0.75f, height*0.2f);
        track.quadTo(width*0.80f, height*0.21f, width*0.80f, height*0.3f);
        track.lineTo(width*0.80f,  height*0.4f);
        track.quadTo(width*0.80f, height*0.5f, width*0.55f, height*0.55f);
        track.quadTo(width*0.35f, height*0.6f, width*0.65f, height*0.65f);
        track.quadTo(width*0.75f, height*0.68f, width*0.75f, height*0.8f);
        track.quadTo(width*0.75f, height*0.9f, width*0.55f, height*0.9f);
        track.quadTo(width*0.45f, height*0.9f, width*0.35f, height*0.7f);
        track.quadTo(width*0.30f, height*0.55f, width*0.20f, height*0.7f);
        track.quadTo(width*0.15f, height*0.8f, width*0.27f, height*0.8f);
        track.quadTo(width*0.43f, height*0.85f, width*0.27f, height*0.9f);
        track.quadTo(width*0.05f, height*0.9f, width*0.05f, height*0.7f);
        track.close();
    }



    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);



        Paint ballPaint = new Paint();
        ballPaint.setColor(Color.GREEN);
        Paint pathPaint = new Paint();
        pathPaint.setColor(Color.BLUE);

        canvas.drawPath(track, ballPaint);

        p.setColor(Color.RED);

        TextView txtView = (TextView) ((Activity)getContext()).findViewById(R.id.coinsTV);
        txtView.setText(""+coins+"");

        // To place the text view somewhere specific:
            PathMeasure pm = new PathMeasure(track, false);
            float fSegmentLen = pm.getLength() / 2000;//we'll get 100 points from path to animate the circle
            float afP[] = {0f, 0f};
            float afP1[] = {0f, 0f};

            List<Car> removeList = new ArrayList<>();
            for(Car c: onTrack){
                if (c.getPosition() <= 2000) {
                    pm.getPosTan(fSegmentLen * c.getPosition() , afP, null);
                    pm.getPosTan(fSegmentLen * c.getPosition()-c.getSpeed() , afP1, null);
                    canvas.drawBitmap(rotateBitmap(c.getImage(),afP,afP1), afP[0], afP[1],p);
                    Integer posAdd = (int) Math.round(c.getSpeed() * multiplier);
                    c.setPosition( c.getPosition() + posAdd);
                } else {
                    coins = coins + c.getCoins();
                    c.setPosition(c.getPosition() - 2000);
                    c.setLapsLeft(c.getLapsLeft() - 1);
                    if (c.getLapsLeft() == 0){
                        ((GameActivity) getContext()).ranOutOfLaps(c);
                        removeList.add(c);
                    }
                }
            }
            for (Car c: removeList){
                onTrack.remove(c);
            }
            invalidate();
    }

    public static Bitmap rotateBitmap(Bitmap source, float[] posNew, float[] posOld)
    {
        float rotAng = (float) Math.toDegrees(Math.atan2(posOld[0] - posNew[0],posOld[1] - posNew[1]));

        Matrix matrix = new Matrix();
        matrix.postRotate(-rotAng);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    public ArrayList<Car> getOnTrack() {
        return onTrack;
    }

    public void setOnTrack(ArrayList<Car> onTrack) {
        this.onTrack = onTrack;
    }


    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}

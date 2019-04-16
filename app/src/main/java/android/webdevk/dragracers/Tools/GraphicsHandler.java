package android.webdevk.dragracers.Tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.webdevk.dragracers.R;

public class GraphicsHandler {

    public Bitmap setCarGraphic(Context context, Integer level){

        Bitmap carGraphic;
        switch(level) {
            case 1:
                carGraphic=BitmapFactory.decodeResource(context.getResources(), R.drawable.car_level_1);
                break;
            case 2:
                carGraphic=BitmapFactory.decodeResource(context.getResources(), R.drawable.car_level_2);
                break;
            case 3:
                carGraphic=BitmapFactory.decodeResource(context.getResources(), R.drawable.car_level_3);
                break;
            case 4:
                carGraphic=BitmapFactory.decodeResource(context.getResources(), R.drawable.car_level_4);
                break;
            case 5:
                carGraphic=BitmapFactory.decodeResource(context.getResources(), R.drawable.car_level_5);
                break;
            case 6:
                carGraphic=BitmapFactory.decodeResource(context.getResources(), R.drawable.car_level_6);
                break;
            default:
                carGraphic=BitmapFactory.decodeResource(context.getResources(), R.drawable.car_level_3);
        }
        carGraphic = scaleDown(carGraphic,100,false);
        return carGraphic;
    }

    public Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                            boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }
}

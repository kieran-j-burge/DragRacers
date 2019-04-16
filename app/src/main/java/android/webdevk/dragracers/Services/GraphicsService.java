package android.webdevk.dragracers.Services;

import android.graphics.Bitmap;

public interface GraphicsService {

    Bitmap setCarGraphic(Integer level);
    Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                     boolean filter);
}

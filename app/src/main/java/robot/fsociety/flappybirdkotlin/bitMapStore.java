package robot.fsociety.flappybirdkotlin;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class bitMapStore {
    Bitmap background;

    public bitMapStore(Resources resources) {
        background = BitmapFactory.decodeResource(resources,R.drawable.background);
        background = scaleImage(background);
    }

    //get the background
    public Bitmap getBackground(){
        return background;
    }

    //get the background Width
    int getBackgroundWidth(){
        return background.getWidth();
    }

    //get the background height
    int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float withHeightRatio = getBackgroundWidth() / getBackgroundHeight();

        //Get the scale width of the bitMap
        int backgroundScaleWidth = (int) (withHeightRatio * AppConstants.SCREEN_HEIGHT);

        return Bitmap.createScaledBitmap(bitmap,backgroundScaleWidth,AppConstants.SCREEN_HEIGHT,false);


    }



}

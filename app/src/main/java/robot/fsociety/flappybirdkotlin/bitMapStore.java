package robot.fsociety.flappybirdkotlin;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class bitMapStore {
    Bitmap background;

    public bitMapStore(Resources resources) {
        background = BitmapFactory.decodeResource(resources,R.drawable.background);
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

}

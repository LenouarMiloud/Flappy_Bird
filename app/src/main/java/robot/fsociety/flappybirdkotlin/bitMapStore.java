package robot.fsociety.flappybirdkotlin;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class bitMapStore {
    Bitmap background;
    Bitmap[] birds;
    Bitmap tubeTop,tubeBottom;


    public bitMapStore(Resources resources) {
        background = BitmapFactory.decodeResource(resources,R.drawable.background);
        background = scaleImage(background);
        birds = new Bitmap[4];
        birds[0] = BitmapFactory.decodeResource(resources,R.drawable.bird_frame1);
        birds[1] = BitmapFactory.decodeResource(resources,R.drawable.bird_frame2);
        birds[2] = BitmapFactory.decodeResource(resources,R.drawable.bird_frame3);
        birds[3] = BitmapFactory.decodeResource(resources,R.drawable.bird_frame4);
        tubeTop = BitmapFactory.decodeResource(resources,R.drawable.red_tube_top);
        tubeBottom = BitmapFactory.decodeResource(resources,R.drawable.red_tube_bottom);
    }

    //get the bird Bitmap
    public Bitmap getBird(int frame){
        return birds[frame];
    }

    // get the Bird width
    public int getBirdWidth(){
        return birds[0].getWidth();
    }

    // get the Bird height
    public int getBirdHeight(){
        return birds[0].getHeight();
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

    public Bitmap getTubeTop() {
        return tubeTop;
    }

    public Bitmap getTubeBottom() {
        return tubeBottom;
    }

    public int getTubeWidth(){
        return tubeTop.getWidth();
    }

    public int getTubeHeight(){
        return tubeTop.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float withHeightRatio = getBackgroundWidth() / getBackgroundHeight();

        //Get the scale width of the bitMap
        int backgroundScaleWidth = (int) (withHeightRatio * AppConstants.SCREEN_HEIGHT);

        return Bitmap.createScaledBitmap(bitmap,backgroundScaleWidth,AppConstants.SCREEN_HEIGHT,false);


    }



}

package robot.fsociety.flappybirdkotlin;

import android.graphics.Canvas;

public class GameEngine {

    BackgrounImage backgrounImage;
    Bird bird;

    public GameEngine() {
        backgrounImage = new BackgrounImage();
        bird = new Bird();
    }

    public void updateAndDrawBackgroundImage(Canvas canvas){
        backgrounImage.setBackgroundImageX(backgrounImage.getBackgroundImageX() - backgrounImage.getBackgroundImageVelocity());
        if(backgrounImage.getBackgroundImageX() < -AppConstants.getBitmapStore().getBackgroundWidth()){
            backgrounImage.setBackgroundImageX(0);
        }

        canvas.drawBitmap(AppConstants.getBitmapStore().getBackground(),backgrounImage.getBackgroundImageX(),backgrounImage.getBackgroundImageY(),null);
        if (backgrounImage.getBackgroundImageX() < -(AppConstants.getBitmapStore().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstants.getBitmapStore().getBackground(),backgrounImage.getBackgroundImageX() + AppConstants.getBitmapStore().getBackgroundWidth(),backgrounImage.getBackgroundImageY(),null);

        }

    }

    public void updateAndDrawBird(Canvas canvas){
        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapStore().getBird(currentFrame),bird.getBirdX(),bird.getBirdY(),null);
        currentFrame++;
        if(currentFrame > Bird.maxFrame){
            currentFrame =0;
        }
        bird.setCurrentFrame(currentFrame);
    }

}

package robot.fsociety.flappybirdkotlin;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgrounImage backgrounImage;
    Bird bird;
    static int gameState;
    ArrayList<MyTube> tubes;
    Random random;

    public GameEngine() {
        backgrounImage = new BackgrounImage();
        bird = new Bird();
        gameState = 0;
        tubes = new ArrayList<>();
        random = new Random();
        for (int i=0;i<AppConstants.numberTubes;i++){
            int tubeX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceTubes;
            int topTubeOffsetY = AppConstants.minTubeOffSetY + random.nextInt(AppConstants.maxTubeOffSetY - AppConstants.minTubeOffSetY+1);
            MyTube tube = new MyTube(tubeX,topTubeOffsetY);
            tubes.add(tube);
        }
    }

    public void updateAndDrawTubes(Canvas canvas){
        if (gameState == 1){
            for(int i=0;i<AppConstants.numberTubes;i++){
                if(tubes.get(i).getTubeX() < - AppConstants.getBitmapStore().getTubeWidth()){
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() + AppConstants.numberTubes * AppConstants.distanceTubes);
                    int topTubeOffSetY = AppConstants.minTubeOffSetY + random.nextInt(AppConstants.maxTubeOffSetY - AppConstants.minTubeOffSetY + 1 );
                    tubes.get(i).setTopTubOffSetY(topTubeOffSetY);
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstants.tubeVelosity);
                    canvas.drawBitmap(AppConstants.getBitmapStore().getTubeTop(),tubes.get(i).getTubeX(),tubes.get(i).getTubeTopY(),null);
                    canvas.drawBitmap(AppConstants.getBitmapStore().getTubeBottom(),tubes.get(i).getTubeX(),tubes.get(i).getTubeBottomY(),null);
                }
            }
        }
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

        if(gameState == 1){
            if(bird.getBirdY() < AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapStore().getBirdHeight() || bird.getVelocity() < 0){
                bird.setVelocity(bird.getVelocity() + AppConstants.gravity);
                bird.setBirdY(bird.getBirdY() + bird.getVelocity());
            }
        }

        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapStore().getBird(currentFrame),bird.getBirdX(),bird.getBirdY(),null);
        currentFrame++;
        if(currentFrame > Bird.maxFrame){
            currentFrame =0;
        }
        bird.setCurrentFrame(currentFrame);
    }

}

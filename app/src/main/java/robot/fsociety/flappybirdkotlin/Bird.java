package robot.fsociety.flappybirdkotlin;

public class Bird {
    int birdX,birdY,currentFrame;
    public static int maxFrame;

    //Constructor
    public Bird(){
        birdX = AppConstants.SCREEN_WIDTH / 2 - AppConstants.getBitmapStore().getBirdWidth()/2;
        birdY = AppConstants.SCREEN_HEIGHT / 2 - AppConstants.getBitmapStore().getBirdHeight()/2;
        currentFrame = 0;
        maxFrame = 3;
    }

    public int getBirdX() {
        return birdX;
    }

    public void setBirdX(int birdX) {
        this.birdX = birdX;
    }

    public int getBirdY() {
        return birdY;
    }

    public void setBirdY(int birdY) {
        this.birdY = birdY;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public static int getMaxFrame() {
        return maxFrame;
    }

    public static void setMaxFrame(int maxFrame) {
        Bird.maxFrame = maxFrame;
    }
}

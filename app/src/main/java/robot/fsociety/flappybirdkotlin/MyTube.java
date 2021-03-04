package robot.fsociety.flappybirdkotlin;

import java.util.Random;

public class MyTube {
    private int tubeX,topTubOffSetY;
    private Random random;
    private int tubeColor;

    public MyTube(int tubeX, int topTubOffSetY) {
        this.tubeX = tubeX;
        this.topTubOffSetY = topTubOffSetY;
        random = new Random();
    }

    public void setTubeColor(){
        tubeColor = random.nextInt(2);
    }

    public int getTubeColor(){
        return tubeColor;
    }

    public int getTopTubOffSetY() {
        return topTubOffSetY;
    }

    public void setTopTubOffSetY(int topTubOffSetY) {
        this.topTubOffSetY = topTubOffSetY;
    }

    public int getTubeX() {
        return tubeX;
    }

    public void setTubeX(int tubeX) {
        this.tubeX = tubeX;
    }

    public int getTubeTopY(){
        return topTubOffSetY - AppConstants.getBitmapStore().getTubeHeight();
    }

    public int getTubeBottomY(){
        return topTubOffSetY + AppConstants.gapTopBottom;
    }

}

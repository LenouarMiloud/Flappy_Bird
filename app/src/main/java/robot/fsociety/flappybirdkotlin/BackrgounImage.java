package robot.fsociety.flappybirdkotlin;

public class BackrgounImage {

    private int backgroundImageX;
    private int backgroundImageY;
    private int backgroundImageVelocity;
    //Constructor
    public BackrgounImage(){
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundImageVelocity= 3;
    }

    //Getter and Setter


    public int getBackgroundImageX() {
        return backgroundImageX;
    }

    public void setBackgroundImageX(int backgroundImageX) {
        this.backgroundImageX = backgroundImageX;
    }

    public int getBackgroundImageY() {
        return backgroundImageY;
    }

    public void setBackgroundImageY(int backgroundImageY) {
        this.backgroundImageY = backgroundImageY;
    }

    public int getBackgroundImageVelocity() {
        return backgroundImageVelocity;
    }
}

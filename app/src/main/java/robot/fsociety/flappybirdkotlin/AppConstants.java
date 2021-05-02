package robot.fsociety.flappybirdkotlin;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {

    static bitMapStore BitMapStore;
    static GameEngine gameEngine;
    static int SCREEN_WIDTH,SCREEN_HEIGHT;
    static int gravity;
    static int velocity_when_jump;
    static int gapTopBottom;
    static int numberTubes;
    static int tubeVelosity;
    static int minTubeOffSetY;
    static int maxTubeOffSetY;
    static int distanceTubes;
    static soundBank soundBank;
    static Context gameActivityContext;

    public static void initialization(Context context){
        setScreenSize(context);
        BitMapStore = new bitMapStore(context.getResources());
        setGameConstants();
        gameEngine = new GameEngine();
        soundBank = new soundBank(context);

    }

    public static soundBank getSoundBank(){
        return soundBank;
    }

    //define GetMap Store
    public static bitMapStore getBitmapStore(){
        return BitMapStore;
    }
    //define GetGameEngine
    public static GameEngine  getGameEngine(){
        return gameEngine;
    }

    private static void setScreenSize(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }
    public static void setGameConstants(){
        AppConstants.gravity = 3;
        AppConstants.velocity_when_jump = -40;
        gapTopBottom = 600;
        AppConstants.numberTubes = 2;
        AppConstants.tubeVelosity = 12;
        AppConstants.minTubeOffSetY = (int) (AppConstants.gapTopBottom / 2.0);
        AppConstants.maxTubeOffSetY = AppConstants.SCREEN_HEIGHT - AppConstants.minTubeOffSetY - AppConstants.gapTopBottom;
        AppConstants.distanceTubes = AppConstants.SCREEN_WIDTH * 3 / 4;
    }

}

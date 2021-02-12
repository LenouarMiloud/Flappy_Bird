package robot.fsociety.flappybirdkotlin;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {

    static bitMapStore BitMapStore;
    static GameEngine gameEngine;
    static int SCREEN_WIDTH,SCREEN_HEIGHT;

    public static void initialization(Context context){
        setScreenSize(context);
        BitMapStore = new bitMapStore(context.getResources());
        gameEngine = new GameEngine();
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

}

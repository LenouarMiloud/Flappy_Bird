package robot.fsociety.flappybirdkotlin;

import android.content.Context;

public class AppConstants {

    static bitMapStore BitMapStore;
    static GameEngine gameEngine;

    public static void initialization(Context context){
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

}

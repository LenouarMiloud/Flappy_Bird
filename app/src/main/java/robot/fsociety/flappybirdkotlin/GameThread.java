package robot.fsociety.flappybirdkotlin;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
    SurfaceHolder surfaceHolder;
    boolean isRunning;
    long startTime,loopTime;
    long DELAY = 33;

    public GameThread(SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning){
            startTime = SystemClock.uptimeMillis();
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (surfaceHolder){
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            loopTime = SystemClock.uptimeMillis() - startTime;
            if(loopTime < DELAY){
                try {
                    Thread.sleep(DELAY - loopTime);
                }catch (InterruptedException IE){
                    Log.e("Interrupted","Interrupted while sleeping");
                }
            }
        }
    }
    //return wether the thread is running
    public boolean isRunning(){
        return isRunning;
    }

    //
    public void setIsRunning(boolean state){
        isRunning = state;
    }


}

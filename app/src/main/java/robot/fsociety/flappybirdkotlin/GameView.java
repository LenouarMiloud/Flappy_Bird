package robot.fsociety.flappybirdkotlin;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;

    public GameView(Context context) {
        super(context);
        initView();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        if(!gameThread.isRunning()){
            gameThread = new GameThread(holder);
            gameThread.start();
        }else {
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        if(gameThread.isRunning()){
            gameThread.setIsRunning(false);
            boolean retry = true;
            while (retry){
                try {
                    gameThread.join();
                    retry = false;
                }catch (InterruptedException IE){
                    IE.printStackTrace();
                }
            }
        }
    }

    private void initView() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        //detect the tap
        if (action == MotionEvent.ACTION_DOWN){
            AppConstants.getGameEngine().gameState = 1;
            AppConstants.getGameEngine().bird.setVelocity(AppConstants.velocity_when_jump);
        }
        return true;
    }
}

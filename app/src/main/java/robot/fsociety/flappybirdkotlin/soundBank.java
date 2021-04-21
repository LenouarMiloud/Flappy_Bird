package robot.fsociety.flappybirdkotlin;

import android.content.Context;
import android.media.MediaPlayer;

public class soundBank {

    Context context;
    MediaPlayer swoosh,point,hit,win;

    public soundBank(Context context) {
        this.context = context;
        swoosh = MediaPlayer.create(context,R.raw.swoosh);
        point = MediaPlayer.create(context,R.raw.point);
        hit = MediaPlayer.create(context,R.raw.hit);
        win = MediaPlayer.create(context,R.raw.wing);

    }

    public void playSwoosh(){
        if(swoosh != null){
            swoosh.start();
        }
    }

    public void playPoint(){
        if(point != null){
            point.start();
        }
    }

    public void playHit(){
        if(hit != null){
            hit.start();
        }
    }

    public void playWin(){
        if(win != null){
            win.start();
        }
    }

}

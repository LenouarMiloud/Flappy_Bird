package robot.fsociety.flappybirdkotlin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class gameOver extends AppCompatActivity {

    TextView scoreTextView;
    TextView personalBestTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        int score = getIntent().getExtras().getInt("Score");
        SharedPreferences sharedPreferences = getSharedPreferences("myFile",0);
        int scoreSP = sharedPreferences.getInt("ScoreSp",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(score > scoreSP){
            scoreSP = score;
            editor.putInt("scoreSP",scoreSP);
            editor.commit();
        }
        scoreTextView = findViewById(R.id.ScoreTextView);
        personalBestTextView = findViewById(R.id.BestScoreTextView);

        scoreTextView.setText(score);
        personalBestTextView.setText(scoreSP);
    }
    public void restart(View view){
        Intent intent = new Intent(gameOver.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
    public void exit(View view){
        finish();
    }
}


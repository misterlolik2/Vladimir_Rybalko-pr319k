package com.example.vladimir_rybalko_pr319k;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private int seconds;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    public void OnClickReset(View view) {
        running = false;
        seconds = 0;
    }

        private void runTimer() {
        final TextView TextView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
             int hours =seconds/3600;
             int minutes = (seconds%3600)/60;
             int secon = seconds%60;

             String time = String.format("%d:%02d:%02d", hours, minutes, secon);
             TextView.setText(time);
             if(running){
                 seconds++;
             }
             handler.postDelayed(this,1000);
            }
        });

        }


    public void OnClickStart(View view) {
        running = true;
    }

    public void OnClickStop(View view) {
        running = false;
    }
}
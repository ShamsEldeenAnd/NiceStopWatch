package com.developer.shams.nicestopwatch;

import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    ImageView bgCircle, icAnchor;
    Animation spinningAnim;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btnstart);
        btnStop = findViewById(R.id.stop);
        icAnchor = findViewById(R.id.icanchor);
        bgCircle = findViewById(R.id.bgcircl);
        timer = findViewById(R.id.timer);
        //optional animation
        btnStop.setAlpha(0);

        //loading animation
        spinningAnim = AnimationUtils.loadAnimation(this, R.anim.spinninganim);

        //customize fonts
        setFonts();

        //starting stopwatch
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //starting animation
                icAnchor.startAnimation(spinningAnim);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();

                //starting Timer
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icAnchor.clearAnimation();
                timer.stop();
                btnStop.animate().alpha(0).translationY(0).setDuration(300).start();
                btnStart.animate().alpha(1).setDuration(300).start();
            }
        });
    }

    private void setFonts() {
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");
        //set fonts
        btnStart.setTypeface(MMedium);
        btnStop.setTypeface(MMedium);
    }
}

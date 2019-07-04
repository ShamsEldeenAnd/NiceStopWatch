package com.developer.shams.nicestopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvsplash, tvsubsplash;
    Button btnGet;
    ImageView splash;
    Animation splashAnim, tvsplashAnim, btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvsplash = findViewById(R.id.tvSplash);
        tvsubsplash = findViewById(R.id.tvSubsplash);
        btnGet = findViewById(R.id.btnget);
        splash = findViewById(R.id.splash);

        // loading animation
        splashAnim = AnimationUtils.loadAnimation(this, R.anim.splashanim);
        tvsplashAnim = AnimationUtils.loadAnimation(this, R.anim.tvsplashanim);
        btnAnim = AnimationUtils.loadAnimation(this, R.anim.btnanim);
        //start animation
        splash.startAnimation(splashAnim);
        tvsplash.startAnimation(tvsplashAnim);
        tvsubsplash.startAnimation(tvsplashAnim);
        btnGet.startAnimation(btnAnim);


        setFonts();


        //start StopWatch Activity
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stopWatch = new Intent(MainActivity.this,StopWatchActivity.class);
                startActivity(stopWatch);
            }
        });
    }

    private void setFonts() {
        Typeface MReguler = Typeface.createFromAsset(getAssets(), "fonts/MR.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");

        //set fonts
        tvsplash.setTypeface(MReguler);
        tvsubsplash.setTypeface(MLight);
        btnGet.setTypeface(MMedium);
    }

}

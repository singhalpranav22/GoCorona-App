package com.pranav.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    ImageView splashim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashim = findViewById(R.id.ivSplash);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        splashim.startAnimation(anim);


        Thread timer=new Thread(){


            @Override
            public void run() {

                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
                super.run();
            }
        };

        timer.start();


    }


}
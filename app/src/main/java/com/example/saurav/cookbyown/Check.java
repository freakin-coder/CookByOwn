package com.example.saurav.cookbyown;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by saurav on 5/18/2020.
 */

public class Check extends AppCompatActivity {
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_check);

        TextView t=(TextView) findViewById(R.id.load);
        ImageView i= (ImageView) findViewById(R.id.imgv);
        Animation anm= AnimationUtils.loadAnimation(this,R.anim.zoomin);
        Animation anms= AnimationUtils.loadAnimation(this,R.anim.fadein);
        i.startAnimation(anms);
        t.startAnimation(anm);

        SharedPreferences settings = getSharedPreferences("PREFS",0);
        password = settings.getString("password","");


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(password.equals("")){
                    Intent intent = new Intent(getApplicationContext(), Signup.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 2000);
    }
}

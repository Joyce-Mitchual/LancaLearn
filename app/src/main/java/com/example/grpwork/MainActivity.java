package com.example.grpwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int LANCALEARN_SCREEN=5000;

    //Variables
    Animation topAmin, bottomAmin;
    ImageView image;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();

        //Animation
        topAmin= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAmin= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        image= findViewById(R.id.imageView);
        logo= findViewById(R.id.textView);
//        groupname= findViewById(R.id.textView2);

        image.setAnimation(topAmin);
        logo.setAnimation(bottomAmin);
//        groupname.setAnimation(bottomAmin);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Dashboard.class);
                Pair[ ]pairs=new Pair[2];
                pairs[0]=new Pair<View, String>(image,"logo_image");
                pairs[1]=new Pair<View, String>(logo,"logo_text");


                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }

            }
        }, LANCALEARN_SCREEN);

    }
}
package com.example.ramayan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

import com.example.ramayan.activity.LoginActivity;
import com.example.ramayan.activity.ValmikiActivity;

public class MainActivity extends AppCompatActivity {
private Handler handler;
private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_main);

        videoView=findViewById(R.id.splash_video_view);
        getData();

      //  getSupportActionBar().hide();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                SharedPreferences sharedPreferences=getSharedPreferences("hasLogin",MODE_PRIVATE);
                boolean editor=sharedPreferences.getBoolean("auth",false);
                if (editor){
                    Intent homeActivity=new Intent(MainActivity.this, ValmikiActivity.class);
                    startActivity(homeActivity);
                    finish();
                }else{
                    Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }



            }
        },11000);
    }


   public void getData(){
       Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash);
       videoView.setVideoURI(uri);
       videoView.start();
    }
}
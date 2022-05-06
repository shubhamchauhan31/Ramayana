package com.example.ramayan.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ramayan.R;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout tv_loginTitle,layoutBottom,linearLayoutLeftSide;

    private TextView btn_skip_login;

    private TextView info,message,join;

    private ImageView homePage;

    private AlertDialog.Builder builder;




    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_login);
       // getSupportActionBar().hide();
        homePage=findViewById(R.id.open_home_page);
        layoutBottom=findViewById(R.id.layout_bottom_move);
        btn_skip_login=findViewById(R.id.skip_login_test_app);
        linearLayoutLeftSide=findViewById(R.id.login_activity_linear_layout);
        builder = new AlertDialog.Builder(this,R.color.purple_500);

        info=findViewById(R.id.login_activity_info);
        message=findViewById(R.id.login_activity_purpose);
        join=findViewById(R.id.login_activity_join);

        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ValmikiActivity.class));
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this,AppMemberActivity.class));
                finish();
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,AppPurpose.class));
                finish();
            }

        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUrl=true;

                startActivity(new Intent(LoginActivity.this,JoinUsActivity.class));
                finish();
            }
        });

        btn_skip_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(LoginActivity.this,SkipLoginActivity.class);
                startActivity(intent);*/
                Intent intent = new Intent(LoginActivity.this,ValmikiActivity.class);
                startActivity(intent);
            }
        });
        getLeftToRightAnimation();
        getBottomToUpAnimation();
        getLinearLayout();

    }

    public void getLinearLayout(){
        Animation animation= AnimationUtils.loadAnimation(LoginActivity.this,R.anim.bounce);
        linearLayoutLeftSide.startAnimation(animation);
    }
    private void getBottomToUpAnimation() {
        Animation animation= AnimationUtils.loadAnimation(LoginActivity.this,R.anim.move_bottom);
        layoutBottom.startAnimation(animation);
    }

    private void getLeftToRightAnimation() {
        Animation animation= AnimationUtils.loadAnimation(LoginActivity.this,R.anim.move_right);
        homePage.startAnimation(animation);
    }

    private void getUrl(String s){

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
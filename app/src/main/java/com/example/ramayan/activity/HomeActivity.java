package com.example.ramayan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ramayan.R;
import com.example.ramayan.fragments.BlankFragmentOne;
import com.example.ramayan.model.PrefManager;

public class HomeActivity extends AppCompatActivity {

    private FrameLayout frameLayout1;
    private RelativeLayout layout;
    private boolean isButtonShown = false;


    private TextView tv_shlok1,tv_shlok2,tv_shlok3,tv_shlok4,tv_shlok5,tv_shlok6,tv_shlok7,tv_shlok8,tv_shlok9,tv_shlok10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        layout=findViewById(R.id.relative_layout);
        frameLayout1=findViewById(R.id.frame_layout);

      //  getSupportActionBar().hide();

        tv_shlok1=findViewById(R.id.shlok_one);
        tv_shlok2=findViewById(R.id.shlok_two);
        tv_shlok3=findViewById(R.id.shlok_three);
        tv_shlok4=findViewById(R.id.shlok_four);
        tv_shlok5=findViewById(R.id.shlok_five);
        tv_shlok6=findViewById(R.id.shlok_six);
        tv_shlok7=findViewById(R.id.shlok_seven);
        tv_shlok8=findViewById(R.id.shlok_eight);
        tv_shlok9=findViewById(R.id.shlok_nine);
        tv_shlok10=findViewById(R.id.shlok_ten);



        PrefManager prefManager = new PrefManager(getApplicationContext());
        if(prefManager.isFirstTimeLaunch()){
            prefManager.setFirstTimeLaunch(false);
            startActivity(new Intent(HomeActivity.this, SkipLoginActivity.class));
            finish();
        }

        tv_shlok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(isButtonShown){
                    isButtonShown=false;
                    layout.setVisibility(View.VISIBLE);
                    frameLayout1.setVisibility(View.GONE);

                }else{
                    isButtonShown=true;
                    layout.setVisibility(View.GONE);
                    frameLayout1.setVisibility(View.VISIBLE);
                    BlankFragmentOne blankFragmentOne=new BlankFragmentOne();
                    setFragment(blankFragmentOne);
                }*/

                startActivity(new Intent(HomeActivity.this,ValmikiActivity.class));




            }
        });

    }

}
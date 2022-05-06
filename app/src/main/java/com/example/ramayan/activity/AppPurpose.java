package com.example.ramayan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ramayan.R;

public class AppPurpose extends AppCompatActivity {

    private ImageView imageViewBackBtn;
    private TextView textViewTelegram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_app_purpose);

        imageViewBackBtn=findViewById(R.id.app_purpose_back_btn);

        imageViewBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppPurpose.this,LoginActivity.class));
                finish();
            }
        });
        textViewTelegram=findViewById(R.id.app_purpose_telegram);
        textViewTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUrl("https://t.me/AdhyatmikPratiyogita");
            }
        });
    }

    private void getUrl(String s){

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AppPurpose.this,LoginActivity.class));
        finish();

    }
}
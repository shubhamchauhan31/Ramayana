package com.example.ramayan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ramayan.R;

public class JoinUsActivity extends AppCompatActivity {

    private ImageView imageViewBackBtn;
    private Button buttonTelegramGroup,buttonFacebookPage,buttonYoutubeChannel,buttonTelegramChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_join_us);

        init();

        imageViewBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinUsActivity.this,LoginActivity.class));
                finish();
            }
        });

        buttonTelegramGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUrl("http://www.telegram.me/AdhyatmikPratiyogita");
            }
        });

        buttonFacebookPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUrl("https://www.facebook.com/granthvachan/");
            }
        });

        buttonYoutubeChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUrl("https://youtube.com/channel/UCL5YQBvsefUKXvUChBVQtVA\n");
            }
        });

        buttonTelegramChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUrl("http://www.telegram.me/AdhyatmikPratiyogita");
            }
        });

    }

    private void init(){
        imageViewBackBtn=findViewById(R.id.join_us_back_btn);
        buttonTelegramGroup=findViewById(R.id.join_us_telegram_group);
        buttonFacebookPage=findViewById(R.id.join_us_facebook_page);
        buttonYoutubeChannel=findViewById(R.id.join_us_youtube_channel);
        buttonTelegramChannel=findViewById(R.id.join_us_telegram_channel);

    }

    private void getUrl(String s){
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(JoinUsActivity.this,LoginActivity.class));
        finish();
    }
}
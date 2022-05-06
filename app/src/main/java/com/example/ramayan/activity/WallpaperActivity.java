package com.example.ramayan.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.ramayan.R;

public class WallpaperActivity extends AppCompatActivity {

    private ImageView imageViewForward,imageViewBackward,imageViewBackBtn;
    private ImageSwitcher imageSwitcher;
    int[] wallpaperImage={R.drawable.family,R.drawable.ramayana,R.drawable.sri_ram_family_photo,R.drawable.hanuman};
    int switcherImageLength = wallpaperImage.length;
    int counter = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        imageSwitcher=findViewById(R.id.wallpaper_switcher);
        imageViewBackBtn=findViewById(R.id.wallpaper_back_btn);
        imageViewBackward=findViewById(R.id.wallpaper_backword);
        imageViewForward=findViewById(R.id.wallpaper_forword);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT
                ));
                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageResource(R.drawable.sri_ram_family_photo);
                //switcherImageView.setMaxHeight(100);
                return switcherImageView;
            }
        });



        imageViewForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (counter == switcherImageLength){
                    counter = 0;
                    imageSwitcher.setImageResource(wallpaperImage[counter]);
                    Animation aniIn = AnimationUtils.loadAnimation(WallpaperActivity.this, android.R.anim.slide_in_left);
                    imageSwitcher.setInAnimation(aniIn);
                }
                else{
                    imageSwitcher.setImageResource(wallpaperImage[counter]);
                }
        }
        });

        imageViewBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (counter == switcherImageLength){
                    counter = 0;
                    imageSwitcher.setImageResource(wallpaperImage[counter]);
                    Animation aniOut = AnimationUtils.loadAnimation(WallpaperActivity.this, android.R.anim.slide_out_right);

                    imageSwitcher.setOutAnimation(aniOut);

                }
                else{
                    imageSwitcher.setImageResource(wallpaperImage[counter]);
                }

            }
        });
        imageViewBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WallpaperActivity.this,ValmikiActivity.class));
                finish();
            }
        });
    }
}
package com.example.ramayan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.ramayan.R;
import com.example.ramayan.apptheme.Constant;
import com.example.ramayan.apptheme.Method;
import com.example.ramayan.apptheme.Utils;

import yuku.ambilwarna.AmbilWarnaDialog;

public class ColorPickerActivity extends AppCompatActivity {

    private ImageView imageViewColorBackBtn;

    private TextView tvColored,tvDark,tvLight;

    private SharedPreferences app_preferences;

    private SharedPreferences.Editor editor;

    private int appColor;

    private Toolbar toolbar;

    private LinearLayout layoutOne,layoutTwo;

    private int appTheme;

    private int themeColor;

    private Method method;

    private int mDefaultColor;

    private int sanskritTheme;

    private int hindiTheme;

    private ImageView imageViewDohaSanskrit,imageViewDohaHindi;

    private TextView tv_sanskrit,tv_hindi;


    @SuppressLint({"ResourceAsColor", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);

        appColor = app_preferences.getInt("color", 0);

        appTheme = app_preferences.getInt("theme", 0);

        sanskritTheme=app_preferences.getInt("sanskrit",0);

        hindiTheme=app_preferences.getInt("hindi",0);

        themeColor = appColor;

        setContentView(R.layout.activity_color_picker);

        toolbar=findViewById(R.id.color_picker_toolbar);
        toolbar.setBackgroundColor(Constant.color);

        editor = app_preferences.edit();

        tv_hindi=findViewById(R.id.color_picker_hindi_meaning_tv);

        tv_sanskrit=findViewById(R.id.color_picker_sanskrit_doha_tv);

        mDefaultColor = ContextCompat.getColor(ColorPickerActivity.this, R.color.purple_500);

        method = new Method();

        imageViewColorBackBtn=findViewById(R.id.colored_picker_bck_btn);

        tvColored=findViewById(R.id.color_picker_tv_colored);

        tvDark=findViewById(R.id.colored_picker_tv_dark);

        tvLight=findViewById(R.id.colored_picker_tv_light);

        layoutOne=findViewById(R.id.color_picker_layout_one);
        layoutOne.setBackgroundColor(Constant.color);


        layoutTwo=findViewById(R.id.color_picker_layout_two);
        layoutTwo.setBackgroundColor(Constant.color);

        imageViewDohaSanskrit=findViewById(R.id.color_picker_sanskrit_tv_background);

        imageViewDohaHindi=findViewById(R.id.color_picker_hindi_text);

        app_preferences=getSharedPreferences("dark",MODE_PRIVATE);

        imageViewDohaSanskrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   tv_sanskrit.setBackgroundColor(Constant.sanskritdhoa);
*//*
                tv_hindi.setBackgroundColor(Constant.hindiMeanning);
*//*
                editor.putInt("color", Constant.light_Theme);
                editor.putInt("theme", Constant.light_Theme);*/

                changeSanskritBackground(true);
               // editor.commit();
            }
        });

        imageViewDohaHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeHindiTextColor(true);
            }
        });
        imageViewColorBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
             //   startActivity(new Intent(ColorPickerActivity.this,ValmikiActivity.class));
                finish();
            }
        });

        tvColored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAppTheme(true);

            }
        });

        tvDark.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
             //   Utils.changeToTheme(ColorPickerActivity.this, R.color.black);
/*
                toolbar.setBackgroundColor(R.color.black);
                layoutOne.setBackgroundColor(R.color.black);
                layoutTwo.setBackgroundColor(R.color.black);
*/

                toolbar.setBackgroundColor(Constant.darkTheme);
                layoutOne.setBackgroundColor(Constant.darkTheme);
                layoutTwo.setBackgroundColor(Constant.darkTheme);
                editor.putInt("color", Constant.darkTheme);
                editor.putInt("theme", Constant.darkTheme);

                //Apply the save
                editor.commit();

               // editor.putInt("theme",appColor);
            }
        });

        tvLight.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(Constant.light_Theme);
                layoutOne.setBackgroundColor(Constant.light_Theme);
                layoutTwo.setBackgroundColor(Constant.light_Theme);
                editor.putInt("color", Constant.light_Theme);
                editor.putInt("theme", Constant.light_Theme);
                //Apply the save
                editor.apply();
            }
        });


    }





    private void changeAppTheme(boolean supportsAlpha) {
/*
        colorize();
*/

        AmbilWarnaDialog dialog = new AmbilWarnaDialog(ColorPickerActivity.this, mDefaultColor, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                 Constant.color = color;
                method.setColorTheme();
                editor.putInt("color", color);
                editor.putInt("theme", Constant.theme);
                editor.commit();
                startActivity(new Intent(ColorPickerActivity.this,ColorPickerActivity.class));
                finish();
               // textViewSanskrit.setBackgroundColor(mDefaultColor);

                //startActivity(new Intent(ColorPickerActivity.this,ValmikiActivity.class));
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(ColorPickerActivity.this, "Action canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
    private void changeSanskritBackground(boolean supportsAlpha) {
/*
        colorize();
*/

        AmbilWarnaDialog dialog = new AmbilWarnaDialog(ColorPickerActivity.this, mDefaultColor, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                 Constant.color = color;
                method.setColorTheme();
                editor.putInt("sanskrit", Constant.sanskritdhoa);
                editor.putInt("sanskrit", Constant.sanskritdhoa);
                editor.commit();

               tv_sanskrit.setBackgroundColor(Constant.sanskritdhoa);
               tv_hindi.setBackgroundColor(Constant.sanskritdhoa);
                //startActivity(new Intent(ColorPickerActivity.this,ValmikiActivity.class));
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(ColorPickerActivity.this, "Action canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
    private void changeHindiTextColor(boolean supportsAlpha) {

        AmbilWarnaDialog dialog = new AmbilWarnaDialog(ColorPickerActivity.this, mDefaultColor, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                 Constant.color = color;
                method.setColorTheme();
                editor.putInt("hindi", Constant.hindiMeanning);
                editor.putInt("hindi", Constant.hindiMeanning);
                editor.apply();
               // editor.commit();

/*
               tv_sanskrit.setBackgroundColor(Constant.sanskritdhoa);
*/
               tv_hindi.setTextColor(Constant.hindiMeanning);
               tv_sanskrit.setTextColor(Constant.hindiMeanning);
                //startActivity(new Intent(ColorPickerActivity.this,ValmikiActivity.class));
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(ColorPickerActivity.this, "Action canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

}

package com.example.ramayan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ramayan.R;
import com.example.ramayan.activity.ui.home.HomeFragment;
import com.example.ramayan.apptheme.Constant;
import com.example.ramayan.db.MyDatabaseHelper;
import com.example.ramayan.fragments.ParayanVidhiFragment;
import com.google.android.material.navigation.NavigationView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class ParayanVidhiActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private ImageView imageViewZoomIn, imageViewSearch, imageViewMyFav, imageViewZoomOut,imageViewColorPickerParayanVidhi;

    private RecyclerView parayanVidhiRV;

    private DrawerLayout drawerLayoutParayanVidhi;

    private NavigationView parayanVidhiNavView;

    private ActionBarDrawerToggle toggle;

    private Toolbar toolbar;

    private TextView tvParayanVidhiFisrtAdhyaTitle;

    private TextView tvSanskrritSlokOne;

    private  TextView tvHindiSlokeOne;

    private LinearLayout layoutParayanVidhiOne;

    private CoordinatorLayout coordinatorLayoutParayanVidhi;

    private ActionBarDrawerToggle drawerToggle;

    int mDefaultColor;

    private Constant constant;

    private SharedPreferences.Editor editor;

    private SharedPreferences app_preferences;

    private int deftheme;

    private int themeColor;

    private int color;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        app_preferences = PreferenceManager.getDefaultSharedPreferences(ParayanVidhiActivity.this);
        color = app_preferences.getInt("color", 0);
        deftheme = app_preferences.getInt("theme", 0);
        themeColor = color;
        constant.color = color;

        setContentView(R.layout.activity_parayan_vidhi);


        toolbar = findViewById(R.id.parayan_vidhi_activity_toolbar);
        setSupportActionBar(toolbar);

       // toolbar.setBackgroundColor(Constant.color);

/*
        mDefaultColor = ContextCompat.getColor(this, R.color.purple_500);
*/


        layoutParayanVidhiOne=findViewById(R.id.parayan_vidhi_layout_one);

        coordinatorLayoutParayanVidhi = findViewById(R.id.parayan_vidhi_coordinator_layout);

/*
        imageViewColorPickerParayanVidhi=findViewById(R.id.parayan_vidhi_select_color);
*/

        layoutParayanVidhiOne=findViewById(R.id.parayan_vidhi_layout_one);

/*
        imageViewColorPickerParayanVidhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(ParayanVidhiActivity.this,ColorPickerActivity.class));
               finish();
            }
        });
*/

        tvParayanVidhiFisrtAdhyaTitle=findViewById(R.id.parayan_vidhi_first_adhya_title);

        tvHindiSlokeOne=findViewById(R.id.parayan_vidhi_hindi_sholk_meaning);

        tvSanskrritSlokOne=findViewById(R.id.parayan_vidhi_with_sanskrit);

/*
        parayanVidhiRV = findViewById(R.id.paranaya_kand_activity_rv);
*/

        imageViewSearch = findViewById(R.id.parayan_vidhi_activity_search_dhoe);

        imageViewMyFav = findViewById(R.id.parayan_vidhi_activity_fav_dhoe);

        drawerLayoutParayanVidhi = findViewById(R.id.parayan_vidhi_drawer);
        drawerToggle = setupDrawerToggle();

        // Setup toggle to display hamburger icon with nice animation
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        // Tie DrawerLayout events to the ActionBarToggle
        drawerLayoutParayanVidhi.addDrawerListener(drawerToggle);

        parayanVidhiNavView = findViewById(R.id.parayan_vidhi_nav_view);
        setupDrawerContent(parayanVidhiNavView);

        imageViewZoomIn = findViewById(R.id.parayan_vidhi_activity_zoom_in);

        imageViewZoomOut = findViewById(R.id.parayan_vidhi_activity_zoom_out);

        layoutParayanVidhiOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(ParayanVidhiActivity.this,layoutParayanVidhiOne);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    popupMenu.setGravity(Gravity.CENTER);
                }
                popupMenu.getMenuInflater().inflate(R.menu.option, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.add_to_fav:
                                String san=tvSanskrritSlokOne.getText().toString();
                                String hin=tvHindiSlokeOne.getText().toString();
                                String messsage=san+hin;

                                if (messsage.isEmpty()){
                                    Toast.makeText(ParayanVidhiActivity.this,"SomeThing Went Wromg",Toast.LENGTH_SHORT).show();
                                }else{
                                    MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper(ParayanVidhiActivity.this);
                                    myDatabaseHelper.addFav(san,hin);;
//                                    Log.d("Shubham",);
                                    Toast.makeText(ParayanVidhiActivity.this, "Add To Favourite Successfully", Toast.LENGTH_SHORT).show();
                                }

                                break;

                            case R.id.share_this_Data:

                                String sanskrit = tvSanskrritSlokOne.getText().toString();
                                String hindi = tvHindiSlokeOne.getText().toString();
                                String message = sanskrit + hindi;
                                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                                sharingIntent.setType("text/plain");
                                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Valmiki Ramayan");
                                sharingIntent.putExtra(Intent.EXTRA_TEXT, message);
                                startActivity(Intent.createChooser(sharingIntent, "Message"));
                                break;

                            case R.id.copy_to_clipbord:
                                String sanskrit_copy = tvSanskrritSlokOne.getText().toString();
                                String hindi_copy = tvHindiSlokeOne.getText().toString();
                                String messagecopy = sanskrit_copy + hindi_copy;
                                ClipboardManager clipboard = (ClipboardManager) ParayanVidhiActivity.this.getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clip = ClipData.newPlainText("Copied Text", messagecopy);
                                clipboard.setPrimaryClip(clip);
                                Toast.makeText(ParayanVidhiActivity.this,"Text Copied",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }

                        return true;
                    }
                });
                popupMenu.show();
                return true;

            }
        });


        imageViewZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = tvParayanVidhiFisrtAdhyaTitle.getScaleX();
                float y = tvParayanVidhiFisrtAdhyaTitle.getScaleY();

                float hindiSlokeOneX=tvHindiSlokeOne.getScaleX();
                float hindiSlokeOneY=tvHindiSlokeOne.getScaleY();

                float sanskritSlokeOneX=tvSanskrritSlokOne.getScaleX();
                float sanskritSlokeOneY=tvSanskrritSlokOne.getScaleY();

                float layoutOneX=layoutParayanVidhiOne.getScaleX();
                float layoutOneY=layoutParayanVidhiOne.getScaleY();


                tvParayanVidhiFisrtAdhyaTitle.setScaleX(x+0.001f);
                tvParayanVidhiFisrtAdhyaTitle.setScaleY(y+0.001f);

                tvHindiSlokeOne.setScaleX(hindiSlokeOneX+0.001f);
                tvHindiSlokeOne.setScaleY(hindiSlokeOneY+0.001f);

                tvSanskrritSlokOne.setScaleX(sanskritSlokeOneX+0.001f);
                tvSanskrritSlokOne.setScaleY(sanskritSlokeOneY+0.001f);

                layoutParayanVidhiOne.setScaleX(layoutOneX+0.0001f);
                layoutParayanVidhiOne.setScaleY(layoutOneY+0.0001f);

            }
        });

        imageViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = tvParayanVidhiFisrtAdhyaTitle.getScaleX();
                float y = tvParayanVidhiFisrtAdhyaTitle.getScaleY();

                float hindiSlokeOneX=tvHindiSlokeOne.getScaleX();
                float hindiSlokeOneY=tvHindiSlokeOne.getScaleY();

                float sanskritSlokeOneX=tvSanskrritSlokOne.getScaleX();
                float sanskritSlokeOneY=tvSanskrritSlokOne.getScaleY();

                float layoutOneX=layoutParayanVidhiOne.getScaleX();
                float layoutOneY=layoutParayanVidhiOne.getScaleY();

                tvParayanVidhiFisrtAdhyaTitle.setScaleX(x-0.001f);
                tvParayanVidhiFisrtAdhyaTitle.setScaleY(y-0.001f);


                tvHindiSlokeOne.setScaleX(hindiSlokeOneX-0.001f);
                tvHindiSlokeOne.setScaleY(hindiSlokeOneY-0.001f);

                tvSanskrritSlokOne.setScaleX(sanskritSlokeOneX-0.001f);
                tvSanskrritSlokOne.setScaleY(sanskritSlokeOneY-0.001f);


                layoutParayanVidhiOne.setScaleX(layoutOneX-0.0001f);
                layoutParayanVidhiOne.setScaleY(layoutOneY-0.0001f);

            }
        });

        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ParayanVidhiActivity.this, MyFavActivity.class));
                finish();
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ParayanVidhiActivity.this, SearchActivity.class));
                finish();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            int id = item.getItemId();
            switch (id) {

                case R.id.nav_home:
                    Intent h = new Intent(ParayanVidhiActivity.this, ValmikiActivity.class);
                    h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(h);
                    return true;
                case R.id.nav_path_vidhi:
                    Intent i = new Intent(ParayanVidhiActivity.this, PathVidhiActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    return true;
                case R.id.parayan_vidhi:
                    Intent g = new Intent(ParayanVidhiActivity.this, ParayanVidhiActivity.class);
                    g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(g);
                    return true;


                case R.id.balkand:
                    startActivity(new Intent(ParayanVidhiActivity.this, BalkandActivity.class));
                    return true;
                case R.id.ayodhya_kand:
                    startActivity(new Intent(ParayanVidhiActivity.this, AyodhyaKandActivity.class));

                    return true;
                case R.id.aranya_kand:
                    startActivity(new Intent(ParayanVidhiActivity.this, AranayaKandActivity.class));
                    return true;

                case R.id.kishkindha_kand:
                    startActivity(new Intent(ParayanVidhiActivity.this, KishkindhakandActivity.class));
                    return true;

                case R.id.sundara_kanda:
                    startActivity(new Intent(ParayanVidhiActivity.this, SunderKandActivity.class));
                    return true;

                case R.id.lanka_kand:
                    startActivity(new Intent(ParayanVidhiActivity.this, LankaKandActivity.class));
                    return true;


                case R.id.my_fav_dohe:
                    startActivity(new Intent(ParayanVidhiActivity.this, MyFavActivity.class));
                    return true;

                case R.id.ramayan_arti:
                    startActivity(new Intent(ParayanVidhiActivity.this, RamayanArtiActivity.class));
                    return true;
            }

            return false;
    }

    private void openDialog(boolean supportsAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, mDefaultColor, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor=color;
                coordinatorLayoutParayanVidhi.setBackgroundColor(mDefaultColor);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(getApplicationContext(), "Action canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked

        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                Intent h= new Intent(ParayanVidhiActivity.this,ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);
                break;

            case R.id.nav_path_vidhi:
                Intent i= new Intent(ParayanVidhiActivity.this,PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;

            case R.id.parayan_vidhi:
                Intent g= new Intent(ParayanVidhiActivity.this,ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                break;


            case R.id.balkand:
                startActivity(new Intent(ParayanVidhiActivity.this,BalkandActivity.class));
                break;

            case R.id.ayodhya_kand:
                startActivity(new Intent(ParayanVidhiActivity.this,AyodhyaKandActivity.class));
                break;

            case R.id.aranya_kand:
                startActivity(new Intent(ParayanVidhiActivity.this,AranayaKandActivity.class));
                break;

            case R.id.kishkindha_kand:
                startActivity(new Intent(ParayanVidhiActivity.this,KishkindhakandActivity.class));
                break;

            case R.id.sundara_kanda:
                startActivity(new Intent(ParayanVidhiActivity.this,SunderKandActivity.class));
                break;

            case R.id.lanka_kand:
                startActivity(new Intent(ParayanVidhiActivity.this,LankaKandActivity.class));
                break;


            case R.id.my_fav_dohe:
                startActivity(new Intent(ParayanVidhiActivity.this,MyFavActivity.class));
                break;

            case R.id.ramayan_arti:
                startActivity(new Intent(ParayanVidhiActivity.this,RamayanArtiActivity.class));
                break;
            default:
                break;
        }


        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayoutParayanVidhi.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, drawerLayoutParayanVidhi, toolbar, R.string.open, R.string.close);
    }

}
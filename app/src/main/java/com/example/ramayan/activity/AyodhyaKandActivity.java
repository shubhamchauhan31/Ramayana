package com.example.ramayan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.ramayan.R;
import com.example.ramayan.fragments.AyodhyaKandFragment;
import com.google.android.material.navigation.NavigationView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class AyodhyaKandActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imageViewSearch,imageViewMyFav, imageViewZoomIn,imageViewZoomOut,imageViewDrawer;

    private Toolbar ayodhyaKandToolbar;

    private DrawerLayout drawerLayoutAyodhyaKand;

    private NavigationView ayodhyaKandNavView;

    private ActionBarDrawerToggle toggle;

    private CoordinatorLayout coordinatorLayoutAyodhyaKand;

    private Spinner spinnerAyodhyaKand;

    private RelativeLayout relativeLayoutAyodhyaKand;

    private String[] ayodhyaKandData={"1. गोस्वामी तुलसीदास\n","2. गोस्वामी तुलसीदास\n","3. गोस्वामी तुलसीदास\n","4. गोस्वामी तुलसीदास\n","5. गोस्वामी तुलसीदास\n","6. गोस्वामी तुलसीदास\n","7. गोस्वामी तुलसीदास\n","8. गोस्वामी तुलसीदास\n"};





    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayodhya_kand);


        ayodhyaKandToolbar=findViewById(R.id.ayodhya_kand_activity_toolbar);
        setSupportActionBar(ayodhyaKandToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        spinnerAyodhyaKand=findViewById(R.id.ayodhya_kand_spinner);
        ArrayAdapter<String> al=new ArrayAdapter<String>(AyodhyaKandActivity.this,android.R.layout.simple_spinner_item,ayodhyaKandData);
        al.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAyodhyaKand.setAdapter(al);
        coordinatorLayoutAyodhyaKand=findViewById(R.id.ayodhya_kand_constraint_layout);
         //imageViewColorPicker=findViewById(R.id.ayodhya_kand_select_color);
        imageViewDrawer=findViewById(R.id.ayodhya_kand_activity_drawar_menu);
        drawerLayoutAyodhyaKand=findViewById(R.id.ayodhya_kand_drawer);
        imageViewSearch=findViewById(R.id.ayodhya_kand_activity_search_dhoe);
        imageViewMyFav=findViewById(R.id.ayodhya_kand_activity_fav_dhoe);
        imageViewZoomIn=findViewById(R.id.ayodhya_kand_activity_zoom_in);
        imageViewZoomOut=findViewById(R.id.ayodhya_kand_activity_zoom_out);
        relativeLayoutAyodhyaKand=findViewById(R.id.relative_layout_ayodhya_kand);

        ayodhyaKandNavView=findViewById(R.id.ayodhya_kand_nav_view);
        ayodhyaKandNavView.setVisibility(View.GONE);

        imageViewZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = relativeLayoutAyodhyaKand.getScaleX();
                float y = relativeLayoutAyodhyaKand.getScaleY();
                relativeLayoutAyodhyaKand.setScaleX(x+0.1f);
                relativeLayoutAyodhyaKand.setScaleY(y+0.1f);
                relativeLayoutAyodhyaKand.setVisibility(View.VISIBLE);
                Toast.makeText(AyodhyaKandActivity.this, "Zoom In", Toast.LENGTH_SHORT).show();

            }
        });

       /* imageViewColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(true);
            }
        });*/

        imageViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = relativeLayoutAyodhyaKand.getScaleX();
                float y = relativeLayoutAyodhyaKand.getScaleY();
                relativeLayoutAyodhyaKand.setScaleX(x-0.1f);
                relativeLayoutAyodhyaKand.setScaleY(y-0.1f);
                relativeLayoutAyodhyaKand.setVisibility(View.VISIBLE);
                Toast.makeText(AyodhyaKandActivity.this, "Zoom Out", Toast.LENGTH_SHORT).show();

            }
        });

        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AyodhyaKandActivity.this,MyFavActivity.class));
                finish();
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AyodhyaKandActivity.this,SearchActivity.class));
                finish();
            }
        });

        imageViewDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ayodhyaKandNavView.setItemIconTintList(null);
                toggle = new ActionBarDrawerToggle(AyodhyaKandActivity.this, drawerLayoutAyodhyaKand, ayodhyaKandToolbar, 0,0);
                drawerLayoutAyodhyaKand.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(true);
                ayodhyaKandNavView.setNavigationItemSelectedListener(AyodhyaKandActivity.this);
                toggle.syncState();
                ayodhyaKandNavView.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case R.id.nav_home:
                Intent h= new Intent(AyodhyaKandActivity.this,ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);
                return true;
            case R.id.nav_path_vidhi:
                Intent i= new Intent(AyodhyaKandActivity.this,PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;
            case R.id.parayan_vidhi:
                Intent g= new Intent(AyodhyaKandActivity.this,ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                return true;


            case R.id.balkand:
                startActivity(new Intent(AyodhyaKandActivity.this,BalkandActivity.class));
                return true;
            case R.id.ayodhya_kand:
                startActivity(new Intent(AyodhyaKandActivity.this,AyodhyaKandActivity.class));

                return true;
            case R.id.aranya_kand:
                startActivity(new Intent(AyodhyaKandActivity.this,AranayaKandActivity.class));
                return true;

            case R.id.kishkindha_kand:
                startActivity(new Intent(AyodhyaKandActivity.this,KishkindhakandActivity.class));
                return true;

            case R.id.sundara_kanda:
                startActivity(new Intent(AyodhyaKandActivity.this,SunderKandActivity.class));
                return true;

            case R.id.lanka_kand:
                startActivity(new Intent(AyodhyaKandActivity.this,LankaKandActivity.class));
                return true;


            case R.id.my_fav_dohe:
                startActivity(new Intent(AyodhyaKandActivity.this,MyFavActivity.class));
                return true;

            case R.id.ramayan_arti:
                startActivity(new Intent(AyodhyaKandActivity.this,RamayanArtiActivity.class));
                return true;
        }
        return false;
    }

}
package com.example.ramayan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.print.PageRange;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.ramayan.R;
import com.google.android.material.navigation.NavigationView;

import yuku.ambilwarna.AmbilWarnaDialog;

import static android.view.View.GONE;

public class KishkindhakandActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {


    private ImageView imageViewDrawer,imageViewSearch,imageViewMyFav,imageViewZoomIn,imageViewZoomOut;

    private DrawerLayout drawerLayoutKishkindhakand;

    private Toolbar kishkindhakandToolbar;

    private NavigationView kishkindhakandNavView;

    private ActionBarDrawerToggle toggle;

    private CoordinatorLayout coordinatorLayoutKishindhakand;

    private Spinner spinnerKishkindhakand;


    private LinearLayout layoutKishkindhakand;

    private String[] kishkindhakandData={"1. गोस्वामी तुलसीदास\n","2. गोस्वामी तुलसीदास\n","3. गोस्वामी तुलसीदास\n","4. गोस्वामी तुलसीदास\n","5. गोस्वामी तुलसीदास\n","6. गोस्वामी तुलसीदास\n","7. गोस्वामी तुलसीदास\n","8. गोस्वामी तुलसीदास\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kishkindhakand);

        kishkindhakandToolbar=findViewById(R.id.kishkindha_kand_toolbar);
        setSupportActionBar(kishkindhakandToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        layoutKishkindhakand=findViewById(R.id.kishkindha_kand_linear_layout);

        spinnerKishkindhakand=findViewById(R.id.kishkindha_kand_spinner);
        ArrayAdapter<String> al=new ArrayAdapter<String>(KishkindhakandActivity.this,android.R.layout.simple_spinner_item,kishkindhakandData);
        al.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKishkindhakand.setAdapter(al);

        coordinatorLayoutKishindhakand=findViewById(R.id.kishkindha_kand_coordinator_layout);
        imageViewZoomIn=findViewById(R.id.kishikindha_kand_activity_zoom_in);
        imageViewZoomOut=findViewById(R.id.kishikindha_kand_activity_zoom_out);

        drawerLayoutKishkindhakand=findViewById(R.id.kishkindha_kand_drawer);
        imageViewDrawer=findViewById(R.id.kishikindha_kand_activity_drawer_btn);
        imageViewSearch=findViewById(R.id.kishkindha_kand_activity_search_dhoe);
        imageViewMyFav=findViewById(R.id.kishkindha_kand_activity_fav_dhoe);
        kishkindhakandNavView=findViewById(R.id.kishkindha_kand_nav_view);
        kishkindhakandNavView.setVisibility(GONE);



        imageViewZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutKishkindhakand.getScaleX();
                float y = layoutKishkindhakand.getScaleY();
                layoutKishkindhakand.setScaleX(x+0.1f);
                layoutKishkindhakand.setScaleY(y+0.1f);
                layoutKishkindhakand.setVisibility(View.VISIBLE);
                Toast.makeText(KishkindhakandActivity.this, "Zoom In", Toast.LENGTH_SHORT).show();

            }
        });

        imageViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutKishkindhakand.getScaleX();
                float y = layoutKishkindhakand.getScaleY();
                layoutKishkindhakand.setScaleX(x-0.1f);
                layoutKishkindhakand.setScaleY(y-0.1f);
                layoutKishkindhakand.setVisibility(View.VISIBLE);
                Toast.makeText(KishkindhakandActivity.this, "Zoom Out", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KishkindhakandActivity.this,MyFavActivity.class));
                finish();
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KishkindhakandActivity.this,SearchActivity.class));
                finish();
            }
        });

        imageViewDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kishkindhakandNavView.setItemIconTintList(null);
                toggle = new ActionBarDrawerToggle(KishkindhakandActivity.this, drawerLayoutKishkindhakand, kishkindhakandToolbar, 0,0);
                drawerLayoutKishkindhakand.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(true);
                kishkindhakandNavView.setNavigationItemSelectedListener(KishkindhakandActivity.this);
                toggle.syncState();
                kishkindhakandNavView.setVisibility(View.VISIBLE);

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        switch (id) {

            case R.id.nav_home:
                Intent h = new Intent(KishkindhakandActivity.this, ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);
                return true;
            case R.id.nav_path_vidhi:
                Intent i = new Intent(KishkindhakandActivity.this, PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;
            case R.id.parayan_vidhi:
                Intent g = new Intent(KishkindhakandActivity.this, ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                return true;


            case R.id.balkand:
                startActivity(new Intent(KishkindhakandActivity.this, BalkandActivity.class));
                return true;
            case R.id.ayodhya_kand:
                startActivity(new Intent(KishkindhakandActivity.this, AyodhyaKandActivity.class));

                return true;
            case R.id.aranya_kand:
                startActivity(new Intent(KishkindhakandActivity.this, AranayaKandActivity.class));
                return true;

            case R.id.kishkindha_kand:
                startActivity(new Intent(KishkindhakandActivity.this, KishkindhakandActivity.class));
                return true;

            case R.id.sundara_kanda:
                startActivity(new Intent(KishkindhakandActivity.this, SunderKandActivity.class));
                return true;

            case R.id.lanka_kand:
                startActivity(new Intent(KishkindhakandActivity.this, LankaKandActivity.class));
                return true;


            case R.id.my_fav_dohe:
                startActivity(new Intent(KishkindhakandActivity.this, MyFavActivity.class));
                return true;

            case R.id.ramayan_arti:
                startActivity(new Intent(KishkindhakandActivity.this, RamayanArtiActivity.class));
                return true;
        }

        return false;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
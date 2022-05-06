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

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.example.ramayan.R;
import com.example.ramayan.zoom.ZoomLayout;
import com.google.android.material.navigation.NavigationView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class LankaKandActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnTouchListener, AdapterView.OnItemSelectedListener {

    private ImageView imageViewSearch,imageViewMyFav,imageViewZoomIn,imageViewZoomOut,imageViewDrawer;

    private RecyclerView lankakandRV;

    private Toolbar lankaKandToolbar;

    private DrawerLayout drawerLayoutLankaKand;

    private NavigationView lankakandNaviView;

    private ActionBarDrawerToggle toggle;

    private CoordinatorLayout coordinatorLayoutLankaKand;

    private Spinner spinnerLankaKand;

    private LinearLayout layoutLankanad;


    private String[] lankaKandData={"1. गोस्वामी तुलसीदास\n","2. गोस्वामी तुलसीदास\n","3. गोस्वामी तुलसीदास\n","4. गोस्वामी तुलसीदास\n","5. गोस्वामी तुलसीदास\n","6. गोस्वामी तुलसीदास\n","7. गोस्वामी तुलसीदास\n","8. गोस्वामी तुलसीदास\n"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanka_kand);

        lankaKandToolbar=findViewById(R.id.lanka_kand_toolbar);

        layoutLankanad=findViewById(R.id.lanka_kand_liner_layout);

        setSupportActionBar(lankaKandToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        spinnerLankaKand=findViewById(R.id.lanka_kand_spinner);



        ArrayAdapter<String> al=new ArrayAdapter<>(LankaKandActivity.this, android.R.layout.simple_spinner_item,lankaKandData);
        al.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLankaKand.setAdapter(al);

        coordinatorLayoutLankaKand=findViewById(R.id.lanka_kand_constraint_layout);

        drawerLayoutLankaKand=findViewById(R.id.lanka_kand_drawer);

        lankakandNaviView=findViewById(R.id.lanka_kand_nav_view);
        lankakandNaviView.setVisibility(View.GONE);

        imageViewSearch=findViewById(R.id.lanka_kand_activity_search_dhoe);

        imageViewMyFav=findViewById(R.id.lanka_kand_activity_fav_dhoe);

        imageViewDrawer=findViewById(R.id.lanka_kand_activity_drawar_menu);

        imageViewZoomIn=findViewById(R.id.lanka_kand_activity_zoom_in);

        imageViewZoomOut=findViewById(R.id.lanka_kand_activity_zoom_out);

        imageViewDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lankakandNaviView.setItemIconTintList(null);
                toggle = new ActionBarDrawerToggle(LankaKandActivity.this, drawerLayoutLankaKand, lankaKandToolbar, 0,0);
                drawerLayoutLankaKand.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(true);
                lankakandNaviView.setNavigationItemSelectedListener(LankaKandActivity.this);
                toggle.syncState();
                lankakandNaviView.setVisibility(View.VISIBLE);
            }
        });

        imageViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutLankanad.getScaleX();
                float y = layoutLankanad.getScaleY();
                layoutLankanad.setScaleX(x-0.1f);
                layoutLankanad.setScaleY(y-0.1f);
                layoutLankanad.setVisibility(View.VISIBLE);
                Toast.makeText(LankaKandActivity.this, "Zoom Out", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutLankanad.getScaleX();
                float y = layoutLankanad.getScaleY();
                layoutLankanad.setScaleX(x+0.1f);
                layoutLankanad.setScaleY(y+0.1f);
                layoutLankanad.setVisibility(View.VISIBLE);
                Toast.makeText(LankaKandActivity.this, "Zoom In", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LankaKandActivity.this,MyFavActivity.class));
                finish();
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LankaKandActivity.this,SearchActivity.class));
                finish();
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            switch (id) {
                case R.id.nav_home:
                    Intent h = new Intent(LankaKandActivity.this, ValmikiActivity.class);
                    h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(h);
                    return true;
                case R.id.nav_path_vidhi:
                    Intent i = new Intent(LankaKandActivity.this, PathVidhiActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    return true;
                case R.id.parayan_vidhi:
                    Intent g = new Intent(LankaKandActivity.this, ParayanVidhiActivity.class);
                    g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(g);
                    return true;


                case R.id.balkand:
                    startActivity(new Intent(LankaKandActivity.this, BalkandActivity.class));
                    return true;
                case R.id.ayodhya_kand:
                    startActivity(new Intent(LankaKandActivity.this, AyodhyaKandActivity.class));

                    return true;
                case R.id.aranya_kand:
                    startActivity(new Intent(LankaKandActivity.this, AranayaKandActivity.class));
                    return true;

                case R.id.kishkindha_kand:
                    startActivity(new Intent(LankaKandActivity.this, KishkindhakandActivity.class));
                    return true;

                case R.id.sundara_kanda:
                    startActivity(new Intent(LankaKandActivity.this, SunderKandActivity.class));
                    return true;

                case R.id.lanka_kand:
                    startActivity(new Intent(LankaKandActivity.this, LankaKandActivity.class));
                    return true;


                case R.id.my_fav_dohe:
                    startActivity(new Intent(LankaKandActivity.this, MyFavActivity.class));
                    return true;

                case R.id.ramayan_arti:
                    startActivity(new Intent(LankaKandActivity.this, RamayanArtiActivity.class));
                    return true;
            }

            return false;
        }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //constraintLayoutLankaKand.init(LankaKandActivity.this);


        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
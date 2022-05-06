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
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomButton;

import com.example.ramayan.R;
import com.example.ramayan.zoom.OnPinchListener;
import com.example.ramayan.zoom.ZoomLayout;
import com.google.android.material.navigation.NavigationView;

import yuku.ambilwarna.AmbilWarnaDialog;

import static android.icu.util.UniversalTimeScale.MAX_SCALE;

public class AranayaKandActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    private ImageView imageViewSearch, imageViewZoomOut, imageViewMyFav, imageViewDrawer;

    private ImageView zoomInButtonAranayaKnad;

    private DrawerLayout drawerLayoutArayanKand;

    private NavigationView aranayaKandNavView;

    private Toolbar aranayaKandToolbar;

    private RecyclerView aranayaKandRV;

    private ActionBarDrawerToggle toggle;

    private Spinner spinnerAranyaKand;

    private int mDefaultColor;

    private final static float move = 200;

    private float ratio = 1.0f;

    private int baseDist;

    private float baseRatio;

    private RelativeLayout relativeLayout;

    private TextView tvFirstAdhyaAranayaKand;
    private String[] aranyakandData = {"1. गोस्वामी तुलसीदास\n", "2. गोस्वामी तुलसीदास\n", "3. गोस्वामी तुलसीदास\n", "4. गोस्वामी तुलसीदास\n", "5. गोस्वामी तुलसीदास\n", "6. गोस्वामी तुलसीदास\n", "7. गोस्वामी तुलसीदास\n", "8. गोस्वामी तुलसीदास\n"};


    private CoordinatorLayout coordinatorLayoutAranayaKand;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aranaya_kand);

        aranayaKandToolbar = findViewById(R.id.aranya_kand_activity_toolbar);
        setSupportActionBar(aranayaKandToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        relativeLayout = findViewById(R.id.relative_layout_zoom_in);
        tvFirstAdhyaAranayaKand = findViewById(R.id.aranya_kand_first_adhya);


        mDefaultColor = ContextCompat.getColor(this, R.color.black);

        spinnerAranyaKand = findViewById(R.id.aranya_kand_spinner);
        spinnerAranyaKand.setOnItemSelectedListener(AranayaKandActivity.this);

        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(this, new OnPinchListener());


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AranayaKandActivity.this, android.R.layout.simple_spinner_item, aranyakandData);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAranyaKand.setAdapter(arrayAdapter);


        coordinatorLayoutAranayaKand = findViewById(R.id.aranaya_kand_constraint_layout);

        drawerLayoutArayanKand = findViewById(R.id.aranya_kand_drawer);

        aranayaKandRV = findViewById(R.id.aranya_kand_recyclerview);
        imageViewSearch = findViewById(R.id.aranya_kand_activity_search_dhoe);
        zoomInButtonAranayaKnad = findViewById(R.id.aranya_kand_activity_zoom_in);
        imageViewZoomOut = findViewById(R.id.aranya_kand_activity_zoom_out);
        imageViewMyFav = findViewById(R.id.aranya_kand_activity_fav_dhoe);

        imageViewDrawer = findViewById(R.id.aranya_kand_activity_drawar_menu);

        aranayaKandNavView = findViewById(R.id.aranya_kand_nav_view);
        aranayaKandNavView.setVisibility(View.GONE);


        zoomInButtonAranayaKnad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = tvFirstAdhyaAranayaKand.getScaleX();
                float y = tvFirstAdhyaAranayaKand.getScaleY();
                tvFirstAdhyaAranayaKand.setScaleX(x + 0.1f);
                tvFirstAdhyaAranayaKand.setScaleY(y + 0.1f);
                tvFirstAdhyaAranayaKand.setVisibility(View.VISIBLE);
                Toast.makeText(AranayaKandActivity.this, "Zoom In", Toast.LENGTH_SHORT).show();

            }
        });


        imageViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = tvFirstAdhyaAranayaKand.getScaleX();
                float y = tvFirstAdhyaAranayaKand.getScaleY();
                tvFirstAdhyaAranayaKand.setScaleX(x - 0.1f);
                tvFirstAdhyaAranayaKand.setScaleY(y - 0.1f);
                Toast.makeText(AranayaKandActivity.this, "Zoom Out", Toast.LENGTH_SHORT).show();
            }
        });
        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AranayaKandActivity.this, MyFavActivity.class));
                finish();
            }
        });
        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AranayaKandActivity.this, SearchActivity.class));
            }
        });
        imageViewDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle = new ActionBarDrawerToggle(AranayaKandActivity.this, drawerLayoutArayanKand, aranayaKandToolbar, 0, 0);
                drawerLayoutArayanKand.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(true);
                aranayaKandNavView.setNavigationItemSelectedListener(AranayaKandActivity.this);
                toggle.syncState();
                aranayaKandNavView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case R.id.nav_home:
                Intent h = new Intent(AranayaKandActivity.this, ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);
                return true;
            case R.id.nav_path_vidhi:
                Intent i = new Intent(AranayaKandActivity.this, PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;
            case R.id.parayan_vidhi:
                Intent g = new Intent(AranayaKandActivity.this, ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                return true;


            case R.id.balkand:
                startActivity(new Intent(AranayaKandActivity.this, BalkandActivity.class));
                return true;
            case R.id.ayodhya_kand:
                startActivity(new Intent(AranayaKandActivity.this, AyodhyaKandActivity.class));

                return true;
            case R.id.aranya_kand:
                startActivity(new Intent(AranayaKandActivity.this, AranayaKandActivity.class));
                return true;

            case R.id.kishkindha_kand:
                startActivity(new Intent(AranayaKandActivity.this, KishkindhakandActivity.class));
                return true;

            case R.id.sundara_kanda:
                startActivity(new Intent(AranayaKandActivity.this, SunderKandActivity.class));
                return true;

            case R.id.lanka_kand:
                startActivity(new Intent(AranayaKandActivity.this, LankaKandActivity.class));
                return true;


            case R.id.my_fav_dohe:
                startActivity(new Intent(AranayaKandActivity.this, MyFavActivity.class));
                return true;

            case R.id.ramayan_arti:
                startActivity(new Intent(AranayaKandActivity.this, RamayanArtiActivity.class));
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
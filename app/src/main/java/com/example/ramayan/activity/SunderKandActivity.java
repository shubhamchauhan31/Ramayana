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
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ramayan.R;
import com.google.android.material.navigation.NavigationView;

import yuku.ambilwarna.AmbilWarnaDialog;

import static android.view.View.GONE;

public class SunderKandActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imageViewSearch,imageViewMyFav,imageViewZoomIn,imageViewZoomOut,imageViewDrawer,imageViewColorPickerSunderKand;

    private RecyclerView sunderkandRV;

    private ActionBarDrawerToggle toggle;

    private NavigationView sunderKandNavView;

    private Toolbar sunderKandToolbar;

    private DrawerLayout drawerLayoutSunderKand;

    private CoordinatorLayout coordinatorLayoutSunderKand;

    private Spinner spinnerSunderKand;

    private int mDefaultColor;

    private LinearLayout layoutSunderKand;

    private String[] sunderKandData={"1. गोस्वामी तुलसीदास\n","2. गोस्वामी तुलसीदास\n","3. गोस्वामी तुलसीदास\n","4. गोस्वामी तुलसीदास\n","5. गोस्वामी तुलसीदास\n","6. गोस्वामी तुलसीदास\n","7. गोस्वामी तुलसीदास\n","8. गोस्वामी तुलसीदास\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunder_kand);

        sunderKandToolbar=findViewById(R.id.sunder_kand_toolbar);
        setSupportActionBar(sunderKandToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        layoutSunderKand=findViewById(R.id.sunder_kand_liner_layout);

        spinnerSunderKand=findViewById(R.id.sunder_kand_spinner);

        ArrayAdapter<String> al=new ArrayAdapter<String>(SunderKandActivity.this, android.R.layout.simple_spinner_item,sunderKandData);
        al.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSunderKand.setAdapter(al);

        imageViewColorPickerSunderKand=findViewById(R.id.sunder_kand_select_color);

        imageViewZoomIn=findViewById(R.id.sunder_kand_activity_zoom_in);

        coordinatorLayoutSunderKand=findViewById(R.id.sunder_kand_coordinator_layout);

        imageViewZoomOut=findViewById(R.id.sunder_kand_activity_zoom_out);

        imageViewDrawer=findViewById(R.id.sunder_kand_activity_drawar_menu);

        sunderKandNavView=findViewById(R.id.sunder_kand_nav_view);

        sunderKandNavView.setVisibility(GONE);

        mDefaultColor = ContextCompat.getColor(this, R.color.black);

        drawerLayoutSunderKand=findViewById(R.id.sunder_kand_drawer);

        sunderkandRV=findViewById(R.id.sunder_kand_activity_rv);

        imageViewSearch=findViewById(R.id.sunder_kand_activity_search_dhoe);

        imageViewMyFav=findViewById(R.id.sunder_kand_activity_fav_dhoe);

        imageViewColorPickerSunderKand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(true);
            }
        });

        imageViewZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutSunderKand.getScaleX();
                float y = layoutSunderKand.getScaleY();
                layoutSunderKand.setScaleX(x+0.1f);
                layoutSunderKand.setScaleY(y+0.1f);
                layoutSunderKand.setVisibility(View.VISIBLE);
                Toast.makeText(SunderKandActivity.this,"Zoom In",Toast.LENGTH_SHORT).show();
            }
        });

        imageViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutSunderKand.getScaleX();
                float y = layoutSunderKand.getScaleY();
                layoutSunderKand.setScaleX(x-0.1f);
                layoutSunderKand.setScaleY(y-0.1f);
                Toast.makeText(SunderKandActivity.this, "Zoom Out", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SunderKandActivity.this,MyFavActivity.class));
                finish();
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SunderKandActivity.this,SearchActivity.class));
                finish();
            }
        });

        imageViewDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sunderKandNavView.setItemIconTintList(null);
                toggle = new ActionBarDrawerToggle(SunderKandActivity.this, drawerLayoutSunderKand, sunderKandToolbar, 0,0);
                drawerLayoutSunderKand.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(true);
                sunderKandNavView.setNavigationItemSelectedListener(SunderKandActivity.this);
                toggle.syncState();
                sunderKandNavView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.nav_home:
                Intent h = new Intent(SunderKandActivity.this, ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);
                return true;
            case R.id.nav_path_vidhi:
                Intent i = new Intent(SunderKandActivity.this, PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;
            case R.id.parayan_vidhi:
                Intent g = new Intent(SunderKandActivity.this, ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                return true;
            case R.id.balkand:
                startActivity(new Intent(SunderKandActivity.this, BalkandActivity.class));
                return true;
            case R.id.ayodhya_kand:
                startActivity(new Intent(SunderKandActivity.this, AyodhyaKandActivity.class));

                return true;
            case R.id.aranya_kand:
                startActivity(new Intent(SunderKandActivity.this, AranayaKandActivity.class));
                return true;

            case R.id.kishkindha_kand:
                startActivity(new Intent(SunderKandActivity.this, KishkindhakandActivity.class));
                return true;

            case R.id.sundara_kanda:
                startActivity(new Intent(SunderKandActivity.this, SunderKandActivity.class));
                return true;

            case R.id.lanka_kand:
                startActivity(new Intent(SunderKandActivity.this, LankaKandActivity.class));
                return true;


            case R.id.my_fav_dohe:
                startActivity(new Intent(SunderKandActivity.this, MyFavActivity.class));
                return true;

            case R.id.ramayan_arti:
                startActivity(new Intent(SunderKandActivity.this, RamayanArtiActivity.class));
                return true;
        }

        return false;
    }

    private void openDialog(boolean supportsAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, mDefaultColor, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                coordinatorLayoutSunderKand.setBackgroundColor(mDefaultColor);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(getApplicationContext(), "Action canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

}
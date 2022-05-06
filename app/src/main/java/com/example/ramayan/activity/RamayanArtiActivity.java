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

public class RamayanArtiActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ImageView imageViewSearch,imageViewMyFav,imageViewZoomIn,imageViewZoomOut,imageViewDrawer;

    private CoordinatorLayout coordinatorLayoutRamayanArti;

    private Toolbar ramayanArtiToolbar;

    private DrawerLayout drawerLayoutRamayanArti;

    private NavigationView ramayanArtiNavView;

    private ActionBarDrawerToggle toggle;

    private Spinner spinnerRamayanArti;

    private int mDefaultColor;

    private LinearLayout layoutRamayanArti;

    private String[] ramayanArtiData={"1. गोस्वामी तुलसीदास\n","2. गोस्वामी तुलसीदास\n","3. गोस्वामी तुलसीदास\n","4. गोस्वामी तुलसीदास\n","5. गोस्वामी तुलसीदास\n","6. गोस्वामी तुलसीदास\n","7. गोस्वामी तुलसीदास\n","8. गोस्वामी तुलसीदास\n"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramayan_arti);

        ramayanArtiToolbar=findViewById(R.id.ramayan_arti_toolbar);
        setSupportActionBar(ramayanArtiToolbar);
        mDefaultColor = ContextCompat.getColor(this, R.color.black);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        layoutRamayanArti=findViewById(R.id.ramayan_arti_linear_layout);

        spinnerRamayanArti=findViewById(R.id.ramayan_arti_spinner);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(RamayanArtiActivity.this, android.R.layout.simple_spinner_item,ramayanArtiData);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerRamayanArti.setAdapter(arrayAdapter);


        imageViewSearch=findViewById(R.id.ramayan_arti_activity_search_dhoe);

        imageViewMyFav=findViewById(R.id.ramayan_arti_activity_fav);

        imageViewZoomIn=findViewById(R.id.ramayan_arti_activity_zoom_in);

        imageViewZoomOut=findViewById(R.id.ramayan_arti_activity_zoom_out);

        imageViewDrawer=findViewById(R.id.ramayan_arti_activity_drawar_menu);

        drawerLayoutRamayanArti=findViewById(R.id.ramayan_arti_drawer);

        ramayanArtiNavView=findViewById(R.id.ramayan_arti_nav_view);

        ramayanArtiNavView.setVisibility(View.GONE);

        coordinatorLayoutRamayanArti=findViewById(R.id.ramayan_arti_coordinator_layout);

        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RamayanArtiActivity.this,MyFavActivity.class));
                finish();
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RamayanArtiActivity.this,SearchActivity.class));
                finish();
            }
        });

        imageViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutRamayanArti.getScaleX();
                float y = layoutRamayanArti.getScaleY();
                layoutRamayanArti.setScaleX(x-0.1f);
                layoutRamayanArti.setScaleY(y-0.1f);
                layoutRamayanArti.setVisibility(View.VISIBLE);
                Toast.makeText(RamayanArtiActivity.this, "Zoom Out", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutRamayanArti.getScaleX();
                float y = layoutRamayanArti.getScaleY();
                layoutRamayanArti.setScaleX(x-0.1f);
                layoutRamayanArti.setScaleY(y-0.1f);
                layoutRamayanArti.setVisibility(View.VISIBLE);
                Toast.makeText(RamayanArtiActivity.this,"Zoom In",Toast.LENGTH_SHORT).show();
            }
        });

        imageViewDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle = new ActionBarDrawerToggle(RamayanArtiActivity.this, drawerLayoutRamayanArti, ramayanArtiToolbar, 0,0);
                drawerLayoutRamayanArti.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(true);
                ramayanArtiNavView.setNavigationItemSelectedListener(RamayanArtiActivity.this);
                toggle.syncState();
                ramayanArtiNavView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.nav_home:
                Intent h = new Intent(RamayanArtiActivity.this, ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);
                return true;
            case R.id.nav_path_vidhi:
                Intent i = new Intent(RamayanArtiActivity.this, PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;
            case R.id.parayan_vidhi:
                Intent g = new Intent(RamayanArtiActivity.this, ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                return true;


            case R.id.balkand:
                startActivity(new Intent(RamayanArtiActivity.this, BalkandActivity.class));
                return true;
            case R.id.ayodhya_kand:
                startActivity(new Intent(RamayanArtiActivity.this, AyodhyaKandActivity.class));

                return true;
            case R.id.aranya_kand:
                startActivity(new Intent(RamayanArtiActivity.this, AranayaKandActivity.class));
                return true;

            case R.id.kishkindha_kand:
                startActivity(new Intent(RamayanArtiActivity.this, KishkindhakandActivity.class));
                return true;

            case R.id.sundara_kanda:
                startActivity(new Intent(RamayanArtiActivity.this, SunderKandActivity.class));
                return true;

            case R.id.lanka_kand:
                startActivity(new Intent(RamayanArtiActivity.this, LankaKandActivity.class));
                return true;


            case R.id.my_fav_dohe:
                startActivity(new Intent(RamayanArtiActivity.this, MyFavActivity.class));
                return true;

            case R.id.ramayan_arti:
                startActivity(new Intent(RamayanArtiActivity.this, RamayanArtiActivity.class));
                return true;
        }

        return false;
    }
    private void openDialog(boolean supportsAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, mDefaultColor, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor=color;
                coordinatorLayoutRamayanArti.setBackgroundColor(mDefaultColor);

            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(getApplicationContext(), "Action canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }


}
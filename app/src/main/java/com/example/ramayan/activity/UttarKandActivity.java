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

public class UttarKandActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ImageView imageViewSearch,imageViewMyFav,imageViewZoomIn,imageViewZoomOut,imageViewDrawer;

    private NavigationView uttarKandNavView;

    private Toolbar uttarKandToolbar;

    private DrawerLayout drawerLayoutUttarKand;

    private ActionBarDrawerToggle toggle;

    private RecyclerView uttarkandRV;

    private CoordinatorLayout coordinatorLayoutUttarKand;

    private Spinner spinnerUttarKand;

    private int mDefaultColor;

    private LinearLayout layoutUttarKand;

    private String[] uttarkandData={"1. गोस्वामी तुलसीदास\n","2. गोस्वामी तुलसीदास\n","3. गोस्वामी तुलसीदास\n","4. गोस्वामी तुलसीदास\n","5. गोस्वामी तुलसीदास\n","6. गोस्वामी तुलसीदास\n","7. गोस्वामी तुलसीदास\n","8. गोस्वामी तुलसीदास\n"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uttar_kand);

        uttarKandToolbar=findViewById(R.id.uttar_kand_toolbar);

        setSupportActionBar(uttarKandToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayoutUttarKand=findViewById(R.id.uttar_kand_drawer);

        uttarKandNavView=findViewById(R.id.uttar_kand_nav_view);

        uttarKandNavView.setVisibility(View.GONE);

        imageViewZoomIn=findViewById(R.id.uttar_kand_activity_zoom_in);

        mDefaultColor = ContextCompat.getColor(this, R.color.black);

        imageViewZoomOut=findViewById(R.id.uttar_kand_activity_zoom_out);

        imageViewDrawer=findViewById(R.id.uttar_kand_activity_back_btn);

        spinnerUttarKand=findViewById(R.id.uttar_kand_spinner);

        ArrayAdapter<String> al=new ArrayAdapter<String>(UttarKandActivity.this, android.R.layout.simple_spinner_item,uttarkandData);

        spinnerUttarKand.setAdapter(al);

        layoutUttarKand=findViewById(R.id.uttar_kand_linear_layout);

        coordinatorLayoutUttarKand=findViewById(R.id.uttar_kand_coordinate_layout);


        imageViewSearch=findViewById(R.id.uttar_kand_activity_search_dhoe);

        imageViewMyFav=findViewById(R.id.uttar_kand_activity_fav_dhoe);

        imageViewDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uttarKandNavView.setItemIconTintList(null);
                toggle = new ActionBarDrawerToggle(UttarKandActivity.this, drawerLayoutUttarKand,uttarKandToolbar, 0,0);
                drawerLayoutUttarKand.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(true);
                uttarKandNavView.setNavigationItemSelectedListener(UttarKandActivity.this);
                toggle.syncState();
                uttarKandNavView.setVisibility(View.VISIBLE);
            }
        });

        imageViewZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutUttarKand.getScaleX();
                float y = layoutUttarKand.getScaleY();
                layoutUttarKand.setScaleX(x+0.1f);
                layoutUttarKand.setScaleY(y+0.1f);
                layoutUttarKand.setVisibility(View.VISIBLE);
                Toast.makeText(UttarKandActivity.this,"Zoom In",Toast.LENGTH_SHORT).show();
            }
        });

        imageViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = layoutUttarKand.getScaleX();
                float y = layoutUttarKand.getScaleY();
                layoutUttarKand.setScaleX(x-0.1f);
                layoutUttarKand.setScaleY(y-0.1f);
                layoutUttarKand.setVisibility(View.VISIBLE);
                Toast.makeText(UttarKandActivity.this, "Zoom Out ", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UttarKandActivity.this,MyFavActivity.class));
                finish();
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UttarKandActivity.this,SearchActivity.class));
                finish();
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.nav_home:
                Intent h = new Intent(UttarKandActivity.this, ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);
                return true;
            case R.id.nav_path_vidhi:
                Intent i = new Intent(UttarKandActivity.this, PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;
            case R.id.parayan_vidhi:
                Intent g = new Intent(UttarKandActivity.this, ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                return true;
            case R.id.balkand:
                startActivity(new Intent(UttarKandActivity.this, BalkandActivity.class));
                return true;
            case R.id.ayodhya_kand:
                startActivity(new Intent(UttarKandActivity.this, AyodhyaKandActivity.class));

                return true;
            case R.id.aranya_kand:
                startActivity(new Intent(UttarKandActivity.this, AranayaKandActivity.class));
                return true;

            case R.id.kishkindha_kand:
                startActivity(new Intent(UttarKandActivity.this, KishkindhakandActivity.class));
                return true;

            case R.id.sundara_kanda:
                startActivity(new Intent(UttarKandActivity.this, SunderKandActivity.class));
                return true;

            case R.id.lanka_kand:
                startActivity(new Intent(UttarKandActivity.this, LankaKandActivity.class));
                return true;


            case R.id.my_fav_dohe:
                startActivity(new Intent(UttarKandActivity.this, MyFavActivity.class));
                return true;

            case R.id.ramayan_arti:
                startActivity(new Intent(UttarKandActivity.this, RamayanArtiActivity.class));
                return true;
        }

        return false;
    }

    private void openDialog(boolean supportsAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, mDefaultColor, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                coordinatorLayoutUttarKand.setBackgroundColor(mDefaultColor);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(getApplicationContext(), "Action canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

}
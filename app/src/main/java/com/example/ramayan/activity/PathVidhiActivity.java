package com.example.ramayan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ramayan.R;
import com.example.ramayan.adapter.ValmikiRamayanaAdapter;
import com.example.ramayan.model.ValimikiRamayanaModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import yuku.ambilwarna.AmbilWarnaDialog;

public class PathVidhiActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout pathVidhiDrawerLayout;

    private NavigationView pathVidhiNavView;

    private ImageView imageViewSearch,imageViewMyFav,pathVidhiZoomIn,pathVidhiZoomOut;

    private ActionBarDrawerToggle toggle;

    private Toolbar toolbar;

    private int mDefaultColor;

    private CoordinatorLayout coordinatorLayoutPathVidhi;

    private LinearLayout layoutPathVidhi;

    private TextView tvPathVidhiFistAdhya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_vidhi);
        toolbar = findViewById(R.id.path_vidhi_activity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("पाठ विधि ");


        pathVidhiDrawerLayout=findViewById(R.id.path_vidhi_drawer);

        layoutPathVidhi=findViewById(R.id.path_vidhi_liner_layout);
        toggle = setupDrawerToggle();
        // Setup toggle to display hamburger icon with nice animation

        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        // Tie DrawerLayout events to the ActionBarToggle
        pathVidhiDrawerLayout.addDrawerListener(toggle);




        pathVidhiNavView=findViewById(R.id.path_vidhi_nav_view);

        setupDrawerContent(pathVidhiNavView);


        pathVidhiZoomIn=findViewById(R.id.path_vidhi_activity_zoom_in);

        pathVidhiZoomOut=findViewById(R.id.path_vidhi_activity_zoom_out);

        imageViewSearch=findViewById(R.id.path_vidhi_activity_search_dhoe);

        imageViewMyFav=findViewById(R.id.path_vidhi_activity_fav_dhoe);

        tvPathVidhiFistAdhya=findViewById(R.id.path_vidhi_first_adhya);


        pathVidhiZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = tvPathVidhiFistAdhya.getScaleX();
                float y = tvPathVidhiFistAdhya.getScaleY();
                tvPathVidhiFistAdhya.setScaleX(x+0.001f);
                tvPathVidhiFistAdhya.setScaleY(y+0.001f);
                Toast.makeText(PathVidhiActivity.this, "Zoom In Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        pathVidhiZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float x = tvPathVidhiFistAdhya.getScaleX();
                float y = tvPathVidhiFistAdhya.getScaleY();


                tvPathVidhiFistAdhya.setScaleX(x-0.001f);
                tvPathVidhiFistAdhya.setScaleY(y-0.001f);



                Toast.makeText(PathVidhiActivity.this, "Zoom Out Successfully", Toast.LENGTH_SHORT).show();


            }
        });


        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PathVidhiActivity.this,MyFavActivity.class));
                finish();
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent balkandSearch=new Intent(PathVidhiActivity.this,SearchActivity.class);
                startActivity(balkandSearch);
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            switch (id) {

                case R.id.nav_home:
                    Intent h = new Intent(PathVidhiActivity.this, ValmikiActivity.class);
                    h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(h);
                    return true;
                case R.id.nav_path_vidhi:
                    Intent i = new Intent(PathVidhiActivity.this, PathVidhiActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    return true;
                case R.id.parayan_vidhi:
                    Intent g = new Intent(PathVidhiActivity.this, ParayanVidhiActivity.class);
                    g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(g);
                    return true;


                case R.id.balkand:
                    startActivity(new Intent(PathVidhiActivity.this, BalkandActivity.class));
                    return true;
                case R.id.ayodhya_kand:
                    startActivity(new Intent(PathVidhiActivity.this, AyodhyaKandActivity.class));

                    return true;
                case R.id.aranya_kand:
                    startActivity(new Intent(PathVidhiActivity.this, AranayaKandActivity.class));
                    return true;

                case R.id.kishkindha_kand:
                    startActivity(new Intent(PathVidhiActivity.this, KishkindhakandActivity.class));
                    return true;

                case R.id.sundara_kanda:
                    startActivity(new Intent(PathVidhiActivity.this, SunderKandActivity.class));
                    return true;

                case R.id.lanka_kand:
                    startActivity(new Intent(PathVidhiActivity.this, LankaKandActivity.class));
                    return true;


                case R.id.my_fav_dohe:
                    startActivity(new Intent(PathVidhiActivity.this, MyFavActivity.class));
                    return true;

                case R.id.ramayan_arti:
                    startActivity(new Intent(PathVidhiActivity.this, RamayanArtiActivity.class));
                    return true;
            }

            return false;
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
                Intent h= new Intent(PathVidhiActivity.this, ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);

                break;
            case R.id.nav_path_vidhi:
                Intent i= new Intent(PathVidhiActivity.this, PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;

            case R.id.parayan_vidhi:
                Intent g= new Intent(PathVidhiActivity.this, ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                break;


            case R.id.balkand:
                startActivity(new Intent(PathVidhiActivity.this, BalkandActivity.class));
                break;

            case R.id.ayodhya_kand:
                startActivity(new Intent(PathVidhiActivity.this, AyodhyaKandActivity.class));
                break;

            case R.id.aranya_kand:
                startActivity(new Intent(PathVidhiActivity.this, AranayaKandActivity.class));
                break;

            case R.id.kishkindha_kand:
                startActivity(new Intent(PathVidhiActivity.this, KishkindhakandActivity.class));
                break;

            case R.id.sundara_kanda:
                startActivity(new Intent(PathVidhiActivity.this, SunderKandActivity.class));
                break;

            case R.id.lanka_kand:
                startActivity(new Intent(PathVidhiActivity.this, LankaKandActivity.class));
                break;

            case R.id.my_fav_dohe:
                startActivity(new Intent(PathVidhiActivity.this, MyFavActivity.class));
                break;

            case R.id.ramayan_arti:
                startActivity(new Intent(PathVidhiActivity.this, RamayanArtiActivity.class));
                break;

            default:
                break;
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        pathVidhiDrawerLayout.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(PathVidhiActivity.this, pathVidhiDrawerLayout, toolbar, R.string.open, R.string.close);
    }

    private void openDialog(boolean supportsAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, mDefaultColor, supportsAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor=color;
                coordinatorLayoutPathVidhi.setBackgroundColor(mDefaultColor);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(getApplicationContext(), "Action canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

}
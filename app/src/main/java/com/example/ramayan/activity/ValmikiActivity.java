package com.example.ramayan.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.airbnb.lottie.animation.content.Content;
import com.example.ramayan.R;
import com.example.ramayan.activity.ui.home.HomeFragment;
import com.example.ramayan.apptheme.Constant;
import com.example.ramayan.apptheme.Method;
import com.example.ramayan.fragments.MyFavouriteDoheFragments;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ValmikiActivity extends AppCompatActivity{

    private ImageView image;

    private ZoomControls simpleZoomControls;

    private ConstraintLayout constraintLayout;

    private TextView tv_first,tv_prev,tv_next,tv_last;

    private HomeFragment homeFragment;

    private AppBarConfiguration mAppBarConfiguration;

    final static float move = 200;

    float ratio = 1.0f;

    int bastDst;

    float baseratio;

    private NavigationView navigationView;

    private Method methods;

    private Constant constant;

    private SharedPreferences.Editor editor;

    private SharedPreferences app_preferences;

    private int deftheme;

    private int themeColor;

    private int color;

    private Toolbar toolbar;

    private DrawerLayout drawer;

    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        app_preferences = PreferenceManager.getDefaultSharedPreferences(ValmikiActivity.this);
        color = app_preferences.getInt("color", 0);
        deftheme = app_preferences.getInt("theme", 0);
        themeColor = color;
        constant.color = color;

        setContentView(R.layout.activity_valmiki);

        toolbar = findViewById(R.id.toolbar);
        //toolbar.setBackgroundColor(Constant.color);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer= findViewById(R.id.drawer_layout);


        drawerToggle = setupDrawerToggle();

        // Setup toggle to display hamburger icon with nice animation
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        // Tie DrawerLayout events to the ActionBarToggle
        drawer.addDrawerListener(drawerToggle);

        navigationView = findViewById(R.id.nav_view);
        setupDrawerContent(navigationView);

        homeFragment=new HomeFragment();
        setFragment(homeFragment);


        //navigationView.setBackgroundColor(Constant.color);

       /* mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
*/
    /*    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.valmiki, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favourite:
                Intent favIntent=new Intent(ValmikiActivity.this,MyFavActivity.class);
                startActivity(favIntent);
                finish();

                break;
            case R.id.search:

                Intent searchIntent=new Intent(ValmikiActivity.this,SearchActivity.class);
                startActivity(searchIntent);
                break;
            case R.id.information:
                Intent informationIntent=new Intent(ValmikiActivity.this,InformationActivity.class);
                startActivity(informationIntent);
                finish();
                break;
            default:
                break;
        }

        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
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
              /*  Intent h= new Intent(ValmikiActivity.this,ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);*/
                homeFragment=new HomeFragment();
                setFragment(homeFragment);
                break;
            case R.id.nav_path_vidhi:
                Intent i= new Intent(ValmikiActivity.this,PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;

            case R.id.parayan_vidhi:
                Intent g= new Intent(ValmikiActivity.this,ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                break;


            case R.id.balkand:
                startActivity(new Intent(ValmikiActivity.this,BalkandActivity.class));
                    break;

            case R.id.ayodhya_kand:
                startActivity(new Intent(ValmikiActivity.this,AyodhyaKandActivity.class));
                break;

                case R.id.aranya_kand:
                startActivity(new Intent(ValmikiActivity.this,AranayaKandActivity.class));
                    break;

            case R.id.kishkindha_kand:
                startActivity(new Intent(ValmikiActivity.this,KishkindhakandActivity.class));
                break;

            case R.id.sundara_kanda:
                startActivity(new Intent(ValmikiActivity.this,SunderKandActivity.class));
                break;

            case R.id.lanka_kand:
                startActivity(new Intent(ValmikiActivity.this,LankaKandActivity.class));
                break;


            case R.id.my_fav_dohe:
                startActivity(new Intent(ValmikiActivity.this,MyFavActivity.class));
                break;

            case R.id.ramayan_arti:
                startActivity(new Intent(ValmikiActivity.this,RamayanArtiActivity.class));
                break;
                default:
                    break;
        }


        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawer.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
    }

    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment,fragment).commit();
    }
}
package com.example.ramayan.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramayan.R;
import com.example.ramayan.activity.AranayaKandActivity;
import com.example.ramayan.activity.AyodhyaKandActivity;
import com.example.ramayan.activity.BalkandActivity;
import com.example.ramayan.activity.KishkindhakandActivity;
import com.example.ramayan.activity.LankaKandActivity;
import com.example.ramayan.activity.MyFavActivity;
import com.example.ramayan.activity.ParayanVidhiActivity;
import com.example.ramayan.activity.PathVidhiActivity;
import com.example.ramayan.activity.RamayanArtiActivity;
import com.example.ramayan.activity.SunderKandActivity;
import com.example.ramayan.activity.ValmikiActivity;
import com.google.android.material.navigation.NavigationView;

public class BalkandSecondAdhyaFragment extends Fragment {

    private Button btnFirst, btnprev, btnNext, btnLast;

    private NavigationView balkandSecondView;

    private Toolbar toolbarBalkandSecond;

    private ImageView balkandSecondZoomIn,balkandSecondZoomOut,balkandSecondFav,balkandSecondSearch;

    private DrawerLayout blakandSecondDrawerLayout;

    private ActionBarDrawerToggle drawerToggle;

    private TextView tvTitle;



    public BalkandSecondAdhyaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_balkand_second_adhya, container, false);

        toolbarBalkandSecond=view.findViewById(R.id.balkand_second_adhya_toolbar);

        blakandSecondDrawerLayout=view.findViewById(R.id.balkand_second_adhya_drawer_layout);

        drawerToggle = setupDrawerToggle();
        // Setup toggle to display hamburger icon with nice animation

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        // Tie DrawerLayout events to the ActionBarToggle
        blakandSecondDrawerLayout.addDrawerListener(drawerToggle);


        balkandSecondView=view.findViewById(R.id.balkand_second_adhya_nav_view);
        setupDrawerContent(balkandSecondView);

        tvTitle=view.findViewById(R.id.balkand_second_adhya_title_one);

        balkandSecondZoomIn=view.findViewById(R.id.balkand_second_adhya_zoom_in);

        balkandSecondZoomOut=view.findViewById(R.id.balkand_second_adhya_zoom_out);

        balkandSecondSearch=view.findViewById(R.id.balkand_second_adhya_search_dhoe);

        balkandSecondFav=view.findViewById(R.id.balkand_second_adhya_fav_dhoe);


        btnFirst=view.findViewById(R.id.balkand_second_adhya_first_btn);

        btnprev=view.findViewById(R.id.balkand_second_adhya_prev_btn);

        btnNext=view.findViewById(R.id.balkand_second_adhya_next_btn);

        btnLast=view.findViewById(R.id.balkand_second_adhya_last_btn);


        balkandSecondZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = tvTitle.getScaleX();
                float y = tvTitle.getScaleY();

                /*float hindiSlokeOneX = tvHindiMeaningOne.getScaleX();
                float hindiSlokeOneY = tvHindiMeaningOne.getScaleY();

                float sanskritSlokeOneX = tvSanskritSlokOne.getScaleX();
                float sanskritSlokeOneY = tvSanskritSlokOne.getScaleY();

                float layoutOneX = linearLayoutBalkandOne.getScaleX();
                float layoutOneY = linearLayoutBalkandOne.getScaleY();
*/

                tvTitle.setScaleX(x + 0.001f);
                tvTitle.setScaleY(y + 0.001f);
/*
                tvHindiMeaningOne.setScaleX(hindiSlokeOneX + 0.001f);
                tvHindiMeaningOne.setScaleY(hindiSlokeOneY + 0.001f);

                tvSanskritSlokOne.setScaleX(sanskritSlokeOneX + 0.001f);
                tvSanskritSlokOne.setScaleY(sanskritSlokeOneY + 0.001f);

                linearLayoutBalkandOne.setScaleX(layoutOneX + 0.0001f);
                linearLayoutBalkandOne.setScaleY(layoutOneY + 0.0001f);*/
            }
        });

        balkandSecondZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = tvTitle.getScaleX();
                float y = tvTitle.getScaleY();

                tvTitle.setScaleX(x + 0.001f);
                tvTitle.setScaleY(y + 0.001f);

            }
        });

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BalkandFirstAdhyaFragment balkandFirstAdhyaFragment=new BalkandFirstAdhyaFragment();
                replaceFragment(balkandFirstAdhyaFragment);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Next Data Not Found",Toast.LENGTH_SHORT).show();
            }
        });

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BalkandFirstAdhyaFragment balkandFirstAdhyaFragment=new BalkandFirstAdhyaFragment();
                replaceFragment(balkandFirstAdhyaFragment);
            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"This is Last Data In Balkand",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.balkand_frame_layout, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
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
                Intent h= new Intent(getContext(), ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);

                break;
            case R.id.nav_path_vidhi:
                Intent i= new Intent(getContext(), PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;

            case R.id.parayan_vidhi:
                Intent g= new Intent(getContext(), ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                break;


            case R.id.balkand:
                startActivity(new Intent(getContext(), BalkandActivity.class));
                break;

            case R.id.ayodhya_kand:
                startActivity(new Intent(getContext(), AyodhyaKandActivity.class));
                break;

            case R.id.aranya_kand:
                startActivity(new Intent(getContext(), AranayaKandActivity.class));
                break;

            case R.id.kishkindha_kand:
                startActivity(new Intent(getContext(), KishkindhakandActivity.class));
                break;

            case R.id.sundara_kanda:
                startActivity(new Intent(getContext(), SunderKandActivity.class));
                break;

            case R.id.lanka_kand:
                startActivity(new Intent(getContext(), LankaKandActivity.class));
                break;

            case R.id.my_fav_dohe:
                startActivity(new Intent(getContext(), MyFavActivity.class));
                break;

            case R.id.ramayan_arti:
                startActivity(new Intent(getContext(), RamayanArtiActivity.class));
                break;

            default:
                break;
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        blakandSecondDrawerLayout.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle((Activity) getContext(), blakandSecondDrawerLayout, toolbarBalkandSecond, R.string.open, R.string.close);
    }
}
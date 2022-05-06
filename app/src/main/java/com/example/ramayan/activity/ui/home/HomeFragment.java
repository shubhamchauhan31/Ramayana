package com.example.ramayan.activity.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;
import com.example.ramayan.R;
import com.example.ramayan.activity.AranayaKandActivity;
import com.example.ramayan.activity.AyodhyaKandActivity;
import com.example.ramayan.activity.BalkandActivity;
import com.example.ramayan.activity.InformationActivity;
import com.example.ramayan.activity.KishkindhakandActivity;
import com.example.ramayan.activity.LankaKandActivity;
import com.example.ramayan.activity.ParayanVidhiActivity;
import com.example.ramayan.activity.PathVidhiActivity;
import com.example.ramayan.activity.RamayanArtiActivity;
import com.example.ramayan.activity.SearchActivity;
import com.example.ramayan.activity.SunderKandActivity;
import com.example.ramayan.activity.UttarKandActivity;
import com.example.ramayan.activity.WallpaperActivity;
import com.example.ramayan.adapter.ValmikiRamayanaAdapter;
import com.example.ramayan.apptheme.Constant;
import com.example.ramayan.apptheme.Method;
import com.example.ramayan.fragments.AranyaKandFragment;
import com.example.ramayan.fragments.AyodhyaKandFragment;
import com.example.ramayan.fragments.BalkandFragment;
import com.example.ramayan.fragments.LankakandFragment;
import com.example.ramayan.fragments.ParayanVidhiFragment;
import com.example.ramayan.fragments.PathVidhiFragment;
import com.example.ramayan.fragments.SundaraKandaFragment;
import com.example.ramayan.fragments.UttarKandFragment;
import com.example.ramayan.fragments.kishkindhakandFragment;
import com.example.ramayan.model.ValimikiRamayanaModel;

import java.util.ArrayList;



public class HomeFragment extends Fragment {
    private FrameLayout frameLayoutHome;
    private TextView btnPathVidhi,btnBalkand,parayanVidhiBtn,ayodhyaKandBtn,aranyakandBtn,kishkindhaKandBtn, sundaraKandBtn,lankaKandBtn,uttarKandBtn,shriRamWallpaper,searchBtn,ramayanArtiBtn;
    private LinearLayout linearLayoutOne,linearLayoutTwo,linearLayoutThree,linearLayoutFour,linearLayoutFive,linearLayoutSix,linearLayoutSeven;
    private TextView companyName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);
        companyName=  root.findViewById(R.id.home_company_name);
        getBounce();

        frameLayoutHome=root.findViewById(R.id.frame_layout_container);

        ayodhyaKandBtn=root.findViewById(R.id.home_ayodhya_kand);

        btnPathVidhi=root.findViewById(R.id.path_vidhi_btn);

        btnBalkand=root.findViewById(R.id.home_balkand_btn);

        ramayanArtiBtn=root.findViewById(R.id.home_ramayan_arti);

        parayanVidhiBtn=root.findViewById(R.id.home_parayan_vidhi_btn);

        aranyakandBtn=root.findViewById(R.id.home_aranya_kand);

        kishkindhaKandBtn=root.findViewById(R.id.home_kishkindha_kand);

        sundaraKandBtn=root.findViewById(R.id.home_sundara_kand);

        lankaKandBtn=root.findViewById(R.id.home_lanka_kand);

        uttarKandBtn=root.findViewById(R.id.home_uttar_kand);

        shriRamWallpaper=root.findViewById(R.id.home_shri_ram_wallpaper);

        searchBtn=root.findViewById(R.id.home_search);

        ramayanArtiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),RamayanArtiActivity.class));
            }
        });

        parayanVidhiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Fragment fragment=new ParayanVidhiFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,fragment).addToBackStack(null).commit();
                frameLayoutHome.setVisibility(View.GONE);*/
                startActivity(new Intent(getContext(), ParayanVidhiActivity.class));
            }
        });

        ayodhyaKandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Fragment fragment=new AyodhyaKandFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,fragment).addToBackStack(null).commit();
                frameLayoutHome.setVisibility(View.GONE);*/

                startActivity(new Intent(getContext(), AyodhyaKandActivity.class));

            }
        });

        aranyakandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Fragment fragment=new AranyaKandFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,fragment).addToBackStack(null).commit();
                frameLayoutHome.setVisibility(View.GONE);*/

                startActivity(new Intent(getContext(), AranayaKandActivity.class));

            }
        });

        kishkindhaKandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Fragment fragment=new kishkindhakandFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,fragment).addToBackStack(null).commit();
                frameLayoutHome.setVisibility(View.GONE);*/

                startActivity(new Intent(getContext(), KishkindhakandActivity.class));

            }
        });

        sundaraKandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Fragment fragment=new SundaraKandaFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,fragment).addToBackStack(null).commit();
                frameLayoutHome.setVisibility(View.GONE);*/
                startActivity(new Intent(getContext(), SunderKandActivity.class));

            }
        });

        lankaKandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Fragment fragment=new LankakandFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,fragment).addToBackStack(null).commit();
                frameLayoutHome.setVisibility(View.GONE);*/
                startActivity(new Intent(getContext(), LankaKandActivity.class));

            }
        });

        uttarKandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Fragment fragment=new UttarKandFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,fragment).addToBackStack(null).commit();
                frameLayoutHome.setVisibility(View.GONE);*/
                startActivity(new Intent(getContext(), UttarKandActivity.class));

            }
        });

        shriRamWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), WallpaperActivity.class));
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });

        btnBalkand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Fragment fragment=new BalkandFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,fragment).addToBackStack(null).commit();
                frameLayoutHome.setVisibility(View.GONE);*/

                Intent balkandIntent=new Intent(getContext(), BalkandActivity.class);
                startActivity(balkandIntent);
            }
        });

        btnPathVidhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //status();
                startActivity(new Intent(getContext(), PathVidhiActivity.class));

            }
        });



        return root;
    }

    private void getBounce(){

        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.bounce);
        companyName.startAnimation(animation);
    }


    public void status(){
       /* Fragment fragment=new PathVidhiFragment();
            FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment, fragment).addToBackStack(null).commit();
            frameLayoutHome.setVisibility(View.GONE);*/
    }



}
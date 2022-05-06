package com.example.ramayan.activity;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import com.example.ramayan.R;
import com.example.ramayan.fragments.BalkandFirstAdhyaFragment;


public class BalkandActivity extends AppCompatActivity {


    private BalkandFirstAdhyaFragment balkandFirstAdhyaFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balkand);
        balkandFirstAdhyaFragment = new BalkandFirstAdhyaFragment();
        setFargement(balkandFirstAdhyaFragment);
    }

    public   void setFargement(Fragment fargement){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.balkand_frame_layout,fargement).addToBackStack(null).commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(BalkandActivity.this,ValmikiActivity.class));
        finish();
    }
}
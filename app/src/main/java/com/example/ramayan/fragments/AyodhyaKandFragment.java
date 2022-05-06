package com.example.ramayan.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ramayan.R;
import com.example.ramayan.adapter.AyodhaKandAdapter;
import com.example.ramayan.model.AyodhaKandModel;

import java.util.ArrayList;


public class AyodhyaKandFragment extends Fragment {

    private RecyclerView ayodhakandRV;
    private ArrayList<AyodhaKandModel> ayodhaKandModels;
    private AyodhaKandAdapter ayodhaKandAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ayodhya_kand, container, false);
        ayodhakandRV=view.findViewById(R.id.ayodhya_kand_recyclerView);
        ayodhakandRV.setHasFixedSize(true);
        ayodhaKandModels=new ArrayList<>();
        ayodhaKandModels.add(new AyodhaKandModel("",""));
        ayodhaKandModels.add(new AyodhaKandModel("",""));
        ayodhaKandModels.add(new AyodhaKandModel("",""));
        ayodhaKandModels.add(new AyodhaKandModel("",""));
        ayodhaKandModels.add(new AyodhaKandModel("",""));
        ayodhaKandModels.add(new AyodhaKandModel("",""));
        ayodhaKandModels.add(new AyodhaKandModel("",""));
        ayodhaKandModels.add(new AyodhaKandModel("",""));
        ayodhaKandAdapter=new AyodhaKandAdapter(ayodhaKandModels,getContext());

        return view;
    }
}
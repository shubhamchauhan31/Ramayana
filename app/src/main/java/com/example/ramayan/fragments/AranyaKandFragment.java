package com.example.ramayan.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ramayan.R;
import com.example.ramayan.adapter.AranyaKandAdapter;
import com.example.ramayan.model.AranyaKandModel;

import java.util.ArrayList;


public class AranyaKandFragment extends Fragment {
    private RecyclerView aranyakandRV;
    private AranyaKandAdapter aranyaKandAdapter;
    private ArrayList<AranyaKandModel> aranyaKandModels;

    public AranyaKandFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view=inflater.inflate(R.layout.fragment_aranya_kand, container, false);
        aranyakandRV=view.findViewById(R.id.aranya_kand_recyclerview);
        aranyakandRV.setHasFixedSize(false);
        aranyaKandModels=new ArrayList<>();
        aranyaKandModels.add(new AranyaKandModel("",""));
        aranyaKandAdapter=new AranyaKandAdapter(aranyaKandModels,getContext());
        aranyakandRV.setAdapter(aranyaKandAdapter);

        return view;
    }
}
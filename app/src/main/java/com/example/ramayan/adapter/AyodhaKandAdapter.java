package com.example.ramayan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramayan.R;
import com.example.ramayan.model.AyodhaKandModel;

import java.util.ArrayList;

public class AyodhaKandAdapter extends RecyclerView.Adapter<AyodhaKandAdapter.ViewHolder> {
    private ArrayList<AyodhaKandModel> ayodhaKandModels;
    private Context context;

    public AyodhaKandAdapter(ArrayList<AyodhaKandModel> ayodhaKandModels, Context context) {
        this.ayodhaKandModels = ayodhaKandModels;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_ayodhakand,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AyodhaKandModel ayodhaKandModel=ayodhaKandModels.get(position);
        holder.tv_ayodhakand_hindi.setText(ayodhaKandModel.getAyodhaKamdHindi());
        holder.tv_ayodhakand_sanskrit.setText(ayodhaKandModel.getAyodhakandSanskrit());

    }

    @Override
    public int getItemCount() {
        return ayodhaKandModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_ayodhakand_sanskrit,tv_ayodhakand_hindi;
        private LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ayodhakand_hindi=itemView.findViewById(R.id.custom_layout_ayodhakand_hindi);
            tv_ayodhakand_sanskrit=itemView.findViewById(R.id.custom_layout_ayodhakand_sanskrit);
            layout=itemView.findViewById(R.id.custom_layout_ayodhakand_liner_layout);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){

                    }
                }
            });
        }
    }
}

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
import com.example.ramayan.activity.LoginActivity;
import com.example.ramayan.model.AranyaKandModel;

import java.util.ArrayList;

public class AranyaKandAdapter  extends RecyclerView.Adapter<AranyaKandAdapter.ViewHolder> {
    private ArrayList<AranyaKandModel> aranyaKandModels;
    private Context context;

    public AranyaKandAdapter(ArrayList<AranyaKandModel> aranyaKandModels, Context context) {
        this.aranyaKandModels = aranyaKandModels;
        this.context = context;
    }


    @NonNull
    @Override
    public AranyaKandAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_aranyakand_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AranyaKandAdapter.ViewHolder holder, int position) {
        AranyaKandModel kandModel=aranyaKandModels.get(position);
        holder.tv_aranyaKandHindi.setText(kandModel.getAranyaKandId());
        holder.tv_aranyaKandSanskrit.setText(kandModel.getAranyaKandSanskrit());
    }

    @Override
    public int getItemCount() {
        return aranyaKandModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_aranyaKandSanskrit,tv_aranyaKandHindi;
        private LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_aranyaKandHindi=itemView.findViewById(R.id.custom_layout_ayodhakand_hindi);
            tv_aranyaKandSanskrit=itemView.findViewById(R.id.custom_layout_ayodhakand_sanskrit);
            layout=itemView.findViewById(R.id.custom_layout_aranyakand_liner_layout);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}

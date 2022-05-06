package com.example.ramayan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramayan.R;
import com.example.ramayan.model.MyFavModel;

import java.util.ArrayList;
import java.util.List;

public class MyFavAdapter extends RecyclerView.Adapter<MyFavAdapter.ViewHolder> {
    private List<MyFavModel> myFavModels;
    private Context context;

    public MyFavAdapter(List<MyFavModel> myFavModels, Context context) {
        this.myFavModels = myFavModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_fav_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyFavModel model=myFavModels.get(position);
        holder.favHindi.setText(model.getfHindi());
        holder.favSanskrit.setText(model.getfSanskrit());
    }

    @Override
    public int getItemCount() {
        return myFavModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView favSanskrit;
        private TextView favHindi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favHindi=itemView.findViewById(R.id.fav_hindi_sholk_meaning);
            favSanskrit=itemView.findViewById(R.id.fav_sholk_with_sanskrit);

        }
    }
}

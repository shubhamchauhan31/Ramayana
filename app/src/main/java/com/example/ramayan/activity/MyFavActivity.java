package com.example.ramayan.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ramayan.R;
import com.example.ramayan.adapter.BalkandFirstAdhyaAdapter;
import com.example.ramayan.adapter.MyFavAdapter;
import com.example.ramayan.adapter.ValmikiRamayanaAdapter;
import com.example.ramayan.db.MyDatabaseHelper;
import com.example.ramayan.model.BalkandFirstAdhyaModel;
import com.example.ramayan.model.MyFavModel;
import com.example.ramayan.model.ValimikiRamayanaModel;

import java.util.ArrayList;
import java.util.List;

public class MyFavActivity extends AppCompatActivity {
    private ImageView imgBackBtn;
    private RecyclerView parayanVidhiRV,balkandRV,pathVidhiRV;
    private MyDatabaseHelper myDatabaseHelper;
    private MyFavAdapter myFavAdapter;

    private List<MyFavModel> models;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fav);
        imgBackBtn=findViewById(R.id.my_fav_back_btn);
        myDatabaseHelper=new MyDatabaseHelper(MyFavActivity.this);

       pathVidhi();

        parayanVidhi();

        balkandList();

        imgBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent=new Intent(MyFavActivity.this,ValmikiActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

    }

    private void pathVidhi(){

        pathVidhiRV=findViewById(R.id.my_fav_recycler_view_path_vidhi);

        pathVidhiRV.setHasFixedSize(false);

        pathVidhiRV.setLayoutManager(new LinearLayoutManager(MyFavActivity.this,LinearLayoutManager.VERTICAL,false));

        models=new ArrayList<>();

        models=myDatabaseHelper.readAllUser();

        myFavAdapter=new MyFavAdapter(models,MyFavActivity.this);

        pathVidhiRV.setAdapter(myFavAdapter);

    }

    public void balkandList(){
        balkandRV=findViewById(R.id.my_fav_balkand);

        balkandRV.setHasFixedSize(false);

        balkandRV.setLayoutManager(new LinearLayoutManager(MyFavActivity.this,LinearLayoutManager.VERTICAL,false));

        models=new ArrayList<>();

        models=myDatabaseHelper.readAllUser();

        myFavAdapter=new MyFavAdapter(models,MyFavActivity.this);

        balkandRV.setAdapter(myFavAdapter);

    }

    public void parayanVidhi(){

        parayanVidhiRV=findViewById(R.id.my_fav_parayanVidhi);

        parayanVidhiRV.setHasFixedSize(false);

        parayanVidhiRV.setLayoutManager(new LinearLayoutManager(MyFavActivity.this,LinearLayoutManager.VERTICAL,false));

        models=new ArrayList<>();

        models=myDatabaseHelper.readAllUser();

        myFavAdapter=new MyFavAdapter(models,MyFavActivity.this);

        parayanVidhiRV.setAdapter(myFavAdapter);

    }


    public void fetch(View view){
        List<MyFavModel> list = myDatabaseHelper.readAllUser();
        StringBuffer buffer = new StringBuffer();
        for(MyFavModel u : list){
            buffer.append(u.toString()+"\n");
        }
        buffer.append("list size : "+list.size());
      //  text.setText(buffer.toString());
        parayanVidhiRV.setAdapter(myFavAdapter);

    }
}
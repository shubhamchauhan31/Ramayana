package com.example.ramayan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.ramayan.R;
import com.example.ramayan.activity.ui.home.HomeFragment;
import com.example.ramayan.adapter.AranyaKandAdapter;
import com.example.ramayan.fragments.AranyaKandFragment;
import com.example.ramayan.model.AranyaKandModel;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private SearchView searchView;
    private ListView listView;
    private ArrayList<String> addContent;
    private ArrayAdapter<String> adapter;
    private ImageView imageViewSerachBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchView=findViewById(R.id.search_view);
        listView=findViewById(R.id.search_list_view);
        addContent=new ArrayList<String>();

        imageViewSerachBackBtn=findViewById(R.id.search_back_btn);

        imageViewSerachBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setVisibility(View.VISIBLE);
                startActivity(new Intent(SearchActivity.this,ValmikiActivity.class));
                finish();
            }
        });

        addContent.add("पाठ विधि ");
        addContent.add("पारायण विधि");
        addContent.add("बालकाण्ड");
        addContent.add("अयोध्याकांड");
        addContent.add("अरण्यकाण्ड");
        addContent.add("किष्किंधाकाण्ड");
        addContent.add("सुंदरकाण्ड");
        addContent.add("लंकाकाण्ड");
        addContent.add("उत्तर कांड");
        addContent.add("भजन जरूर सुने");
        addContent.add("ओरामचन्द्रजो समस्त संसारको शरण देनेवाले हैं। एतत्सं\n" +
                "ओउनके बिना दूसरी कौन-सी गति है। औराम कलियुगके कलौ\n" +
                "समस्त दोर्शको नष्ट कर देते हैं। अतः ओरामचन्द्रजीको\n" +
                "नमस्कार करना चाहिये। श्रीरामसे कालरूपी भयंकर आपने\n" +
                "से भी डरता है। जगत्का सब कुछ भगवान् श्रीरामके जायेंगे\n" +
                "कशाने है। औराममें मेरी अखण्ड भक्ति बनी रहे। हे राम! अधर्मी\n" +
                "आर हो मेरे आधार हैं।");

        listView.setVisibility(View.GONE);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,addContent);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapter.getItem(i);
                Toast.makeText(SearchActivity.this, "You Select "+value, Toast.LENGTH_SHORT).show();
                if (i==0){
                    Intent intent=new Intent(SearchActivity.this,PathVidhiActivity.class);
                    startActivity(intent);
                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();


                }else if (i==1){
                    Intent intent=new Intent(SearchActivity.this,ParayanVidhiActivity.class);
                    startActivity(intent);
                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();

                }else if (i==2){
                    startActivity(new Intent(SearchActivity.this,BalkandActivity.class));
                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();

                }else if (i==3){
                    startActivity(new Intent(SearchActivity.this,AyodhyaKandActivity.class));

                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();

                }else if (i==4){
                    startActivity(new Intent(SearchActivity.this,ParayanVidhiActivity.class));

                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();

                }else if (i==5){
                    startActivity(new Intent(SearchActivity.this,KishkindhakandActivity.class));

                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();

                }else if (i==6){
                    startActivity(new Intent(SearchActivity.this,SunderKandActivity.class));

                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();

                }else  if (i==7){
                    startActivity(new Intent(SearchActivity.this,UttarKandActivity.class));

                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();

                }else if (i==8){
                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();

                }else if (i==9){
                    Toast.makeText(SearchActivity.this, "You Select "+i, Toast.LENGTH_SHORT).show();

                }

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (addContent.contains(s)){
                    adapter.getFilter().filter(s);
                }else{
                    Toast.makeText(SearchActivity.this, "Match No Found....", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

}
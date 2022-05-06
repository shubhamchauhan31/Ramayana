package com.example.ramayan.fragments;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.animation.content.Content;
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
import com.example.ramayan.activity.SearchActivity;
import com.example.ramayan.activity.SunderKandActivity;
import com.example.ramayan.activity.ValmikiActivity;
import com.example.ramayan.activity.ui.home.HomeFragment;
import com.example.ramayan.adapter.BalkandFirstAdhyaAdapter;
import com.example.ramayan.apptheme.Constant;
import com.example.ramayan.apptheme.Method;
import com.example.ramayan.db.MyDatabaseHelper;
import com.example.ramayan.model.BalkandFirstAdhyaModel;
import com.example.ramayan.model.BalkandSecondModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import yuku.ambilwarna.AmbilWarnaDialog;


public class BalkandFirstAdhyaFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Button btnFirst, btnprev, btnNext, btnLast;

    private ImageView imageViewSearch, imageViewMyFav, imageViewColorPicker, imageViewZoomIn, imageViewZoomOut;

    private Spinner balkandDetails;

    private FrameLayout balkandFrameLayout;

    private String[] balkandTitle = {"1. गोस्वामी तुलसीदास\n", "2. गोस्वामी तुलसीदास\n", "3. गोस्वामी तुलसीदास\n", "4. गोस्वामी तुलसीदास\n", "5. गोस्वामी तुलसीदास\n", "6. गोस्वामी तुलसीदास\n", "7. गोस्वामी तुलसीदास\n", "8. गोस्वामी तुलसीदास\n"};

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private ActionBarDrawerToggle toggle;

    private TextView tvTitleOne;

    private Toolbar toolbar;

    private ImageView hindiHide;

    private MyDatabaseHelper myDatabaseHelper;

    private TextView tvSanskritSlokOne;

    private TextView tvHindiMeaningOne;

    private boolean isHide = true;

    private ActionBarDrawerToggle drawerToggle;

    private LinearLayout linearLayoutBalkandOne;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_balkand_first_adhya, container, false);


        toolbar = view.findViewById(R.id.balkand_toolbar);

        linearLayoutBalkandOne = view.findViewById(R.id.balkand_first_adhya_layout_one);

        tvSanskritSlokOne = view.findViewById(R.id.balkand_first_adhya_with_sanskrit_one);

        tvHindiMeaningOne = view.findViewById(R.id.balkand_first_adhya_with_hindi_one);

        hindiHide = view.findViewById(R.id.balkand_first_adhya_hindi_hide);

        btnFirst = view.findViewById(R.id.balkand_activity_first_btn);

        btnprev = view.findViewById(R.id.balkand_activity_prev_btn);

        btnNext = view.findViewById(R.id.balkand_activity_next_btn);

        btnLast = view.findViewById(R.id.balkand_activity_last_btn);

        tvTitleOne = view.findViewById(R.id.balkand_title_one);

        drawerLayout = view.findViewById(R.id.balkand_drawer_layout);

        drawerToggle = setupDrawerToggle();

        // Setup toggle to display hamburger icon with nice animation

        drawerToggle.setDrawerIndicatorEnabled(true);

        drawerToggle.syncState();

        // Tie DrawerLayout events to the ActionBarToggle

        drawerLayout.addDrawerListener(drawerToggle);

        navigationView = view.findViewById(R.id.balkand_first_adhya_nav_view);

        setupDrawerContent(navigationView);

/*
        imageViewColorPicker=view.findViewById(R.id.balkand_activity_color_picker);
*/
        imageViewSearch = view.findViewById(R.id.balkand_search_dhoe);

        imageViewMyFav = view.findViewById(R.id.balkand_activity_fav_dhoe);

        hindiHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Show", Toast.LENGTH_SHORT).show();
                if (isHide) {
                    tvHindiMeaningOne.setVisibility(View.GONE);
                    isHide = false;
                } else {
                    tvHindiMeaningOne.setVisibility(View.VISIBLE);
                    isHide = true;

                }
            }
        });

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "This Is First Dohe", Toast.LENGTH_SHORT).show();
            }
        });

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "This is First Dohe , Please Click On the Next ", Toast.LENGTH_SHORT).show();
                ;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BalkandSecondAdhyaFragment balkandSecondAdhyaFragment = new BalkandSecondAdhyaFragment();
                replaceFragment(balkandSecondAdhyaFragment);
            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "This The Last Dohe", Toast.LENGTH_SHORT).show();
            }
        });

        balkandDetails = view.findViewById(R.id.balkand_first_adhya_spinner);

        balkandFrameLayout = view.findViewById(R.id.balkand_frame_layout);

        imageViewZoomIn = view.findViewById(R.id.balkand_activity_zoom_in);

        imageViewZoomOut = view.findViewById(R.id.balkand_activity_zoom_out);

        imageViewZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = tvTitleOne.getScaleX();
                float y = tvTitleOne.getScaleY();

                float hindiSlokeOneX = tvHindiMeaningOne.getScaleX();
                float hindiSlokeOneY = tvHindiMeaningOne.getScaleY();

                float sanskritSlokeOneX = tvSanskritSlokOne.getScaleX();
                float sanskritSlokeOneY = tvSanskritSlokOne.getScaleY();

                float layoutOneX = linearLayoutBalkandOne.getScaleX();
                float layoutOneY = linearLayoutBalkandOne.getScaleY();


                tvTitleOne.setScaleX(x + 0.01f);
                tvTitleOne.setScaleY(y + 0.01f);

                tvHindiMeaningOne.setScaleX(hindiSlokeOneX + 0.01f);
                tvHindiMeaningOne.setScaleY(hindiSlokeOneY + 0.01f);

                tvSanskritSlokOne.setScaleX(sanskritSlokeOneX + 0.01f);
                tvSanskritSlokOne.setScaleY(sanskritSlokeOneY + 0.01f);

              /*  linearLayoutBalkandOne.setScaleX(layoutOneX + 0.01f);
                linearLayoutBalkandOne.setScaleY(layoutOneY + 0.01f);*/
            }
        });

        imageViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                float x = tvTitleOne.getScaleX();
                float y = tvTitleOne.getScaleY();

                float hindiSlokeOneX = tvHindiMeaningOne.getScaleX();
                float hindiSlokeOneY = tvHindiMeaningOne.getScaleY();

                float sanskritSlokeOneX = tvSanskritSlokOne.getScaleX();
                float sanskritSlokeOneY = tvSanskritSlokOne.getScaleY();

                float layoutOneX = linearLayoutBalkandOne.getScaleX();
                float layoutOneY = linearLayoutBalkandOne.getScaleY();


                tvTitleOne.setScaleX(x - 0.01f);
                tvTitleOne.setScaleY(y - 0.01f);

                tvHindiMeaningOne.setScaleX(hindiSlokeOneX - 0.01f);
                tvHindiMeaningOne.setScaleY(hindiSlokeOneY - 0.01f);

                tvSanskritSlokOne.setScaleX(sanskritSlokeOneX - 0.01f);
                tvSanskritSlokOne.setScaleY(sanskritSlokeOneY - 0.001f);

                /*linearLayoutBalkandOne.setScaleX(layoutOneX - 0.01f);
                linearLayoutBalkandOne.setScaleY(layoutOneY - 0.01f);
*/

            }
        });

        imageViewMyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyFavActivity.class));

            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent balkandSearch = new Intent(getContext(), SearchActivity.class);
                startActivity(balkandSearch);
            }
        });

        ArrayAdapter al = new ArrayAdapter(getContext(), R.layout.page_item, balkandTitle);

        al.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        balkandDetails.setAdapter(al);
        linearLayoutBalkandOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getContext(), linearLayoutBalkandOne);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    popupMenu.setGravity(Gravity.CENTER);
                }

                popupMenu.getMenuInflater().inflate(R.menu.option, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.add_to_fav:
                                String san = tvSanskritSlokOne.getText().toString();
                                String hin = tvHindiMeaningOne.getText().toString();
                                String messsage = san + hin;

                                if (messsage.isEmpty()) {
                                    Toast.makeText(getContext(), "SomeThing Went Wromg", Toast.LENGTH_SHORT).show();
                                } else {
                                    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getContext());
                                    myDatabaseHelper.addFav(san, hin);
                                    ;
//                                    Log.d("Shubham",);
                                    Toast.makeText(getContext(), "Add To Favourite Successfully", Toast.LENGTH_SHORT).show();
                                }

                                break;

                            case R.id.share_this_Data:

                                String sanskrit = tvSanskritSlokOne.getText().toString();
                                String hindi = tvHindiMeaningOne.getText().toString();
                                String message = sanskrit + hindi;
                                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                                sharingIntent.setType("text/plain");
                                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Valmiki Ramayan");
                                sharingIntent.putExtra(Intent.EXTRA_TEXT, message);
                                startActivity(Intent.createChooser(sharingIntent, "Message"));
                                break;

                            case R.id.copy_to_clipbord:
                                String sanskrit_copy = tvSanskritSlokOne.getText().toString();
                                String hindi_copy = tvHindiMeaningOne.getText().toString();
                                String messagecopy = sanskrit_copy + hindi_copy;
                                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clip = ClipData.newPlainText("Copied Text", messagecopy);
                                clipboard.setPrimaryClip(clip);
                                Toast.makeText(getContext(), "Text Copied", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }

                        return true;
                    }
                });
                popupMenu.show();
                return true;
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
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
              Intent h= new Intent(getContext(),ValmikiActivity.class);
                h.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(h);

                break;
            case R.id.nav_path_vidhi:
                Intent i= new Intent(getContext(),PathVidhiActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;

            case R.id.parayan_vidhi:
                Intent g= new Intent(getContext(),ParayanVidhiActivity.class);
                g.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(g);
                break;


            case R.id.balkand:
                startActivity(new Intent(getContext(),BalkandActivity.class));
                break;

            case R.id.ayodhya_kand:
                startActivity(new Intent(getContext(),AyodhyaKandActivity.class));
                break;

            case R.id.aranya_kand:
                startActivity(new Intent(getContext(),AranayaKandActivity.class));
                break;

            case R.id.kishkindha_kand:
                startActivity(new Intent(getContext(),KishkindhakandActivity.class));
                break;

            case R.id.sundara_kanda:
                startActivity(new Intent(getContext(),SunderKandActivity.class));
                break;

            case R.id.lanka_kand:
                startActivity(new Intent(getContext(),LankaKandActivity.class));
                break;

            case R.id.my_fav_dohe:
                startActivity(new Intent(getContext(),MyFavActivity.class));
                break;

            case R.id.ramayan_arti:
                startActivity(new Intent(getContext(),RamayanArtiActivity.class));
                break;

                default:
                   break;
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        drawerLayout.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle((Activity) getContext(), drawerLayout, toolbar, R.string.open, R.string.close);
    }

}
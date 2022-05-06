package com.example.ramayan.adapter;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramayan.R;
import com.example.ramayan.db.MyDatabaseHelper;
import com.example.ramayan.model.ValimikiRamayanaModel;

import java.util.ArrayList;

public class ValmikiRamayanaAdapter extends RecyclerView.Adapter<ValmikiRamayanaAdapter.ViewHolder> {
    private ArrayList<ValimikiRamayanaModel> arrayList;
    private Context context;

    public ValmikiRamayanaAdapter(ArrayList<ValimikiRamayanaModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_valmiki_ramayana_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ValimikiRamayanaModel valimikiRamayanaModel=arrayList.get(position);
        holder.tv_hindi.setText(valimikiRamayanaModel.getHindi());
        holder.tv_sanskrit.setText(valimikiRamayanaModel.getSanskrit());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_sanskrit,tv_hindi;
        private LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sanskrit=itemView.findViewById(R.id.sholk_with_sanskrit);
            tv_hindi=itemView.findViewById(R.id.hindi_sholk_meaning);
            layout=itemView.findViewById(R.id.custom_layout);

            layout.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NewApi")
                @Override
                public void onClick(View view) {


                    PopupMenu popupMenu=new PopupMenu(itemView.getContext(),layout);
                        popupMenu.setGravity(Gravity.CENTER);

                    popupMenu.getMenuInflater().inflate(R.menu.option,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {

                            switch (menuItem.getItemId()){
                               case R.id.add_to_fav:

                                   String sanskritAddFav=tv_sanskrit.getText().toString();
                                   String hindiAddFav=tv_hindi.getText().toString();
                                   MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper(itemView.getContext());
                                   myDatabaseHelper.addFav(sanskritAddFav,hindiAddFav);

                                   Toast.makeText(itemView.getContext(), "Successfully Add To Favourite"+menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                                    break;

                                case R.id.share_this_Data:

                                    String sanskrit=tv_sanskrit.getText().toString();
                                    String hindi=tv_hindi.getText().toString();
                                    String message=sanskrit+hindi;
                                    Intent sharingIntent=new Intent(Intent.ACTION_SEND);
                                    sharingIntent.setType("text/plain");
                                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"Valmiki Ramayan");
                                    sharingIntent.putExtra(Intent.EXTRA_TEXT,message);
                                    itemView.getContext().startActivity(Intent.createChooser(sharingIntent, "Message"));
                                    break;

                                case R.id.copy_to_clipbord:
                                    String sanskrit_copy=tv_sanskrit.getText().toString();
                                    String hindi_copy=tv_hindi.getText().toString();
                                    String messagecopy=sanskrit_copy+hindi_copy;
                                    ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                                    ClipData clip = ClipData.newPlainText("Copied Text", messagecopy);
                                    clipboard.setPrimaryClip(clip);

                                    break;
                                /*case R.id.add_book_mark_here:
                                    Toast.makeText(itemView.getContext(), "Add To Bookmark"+menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                                    break;*/
                                default:
                                    break;
                            }

                            Toast.makeText(itemView.getContext(),"You Select "+menuItem.getTitle(),Toast.LENGTH_SHORT).show();

                            return true;
                        }
                    });
                    popupMenu.show();




                }
            });

        }
    }
}

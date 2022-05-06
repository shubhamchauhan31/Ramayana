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
import com.example.ramayan.model.BalkandFirstAdhyaModel;
import com.example.ramayan.model.BalkandSecondModel;

import java.util.ArrayList;

public class BalkhandSecondAdhyaAdapter  extends RecyclerView.Adapter<BalkhandSecondAdhyaAdapter.ViewHolder> {
    private ArrayList<BalkandSecondModel> secondModels;
    private Context context;

    public BalkhandSecondAdhyaAdapter(ArrayList<BalkandSecondModel> secondModels, Context context) {
        this.secondModels = secondModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_balkhand_second_adhya,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BalkandSecondModel balkandSecondModel=secondModels.get(position);
        holder.tv_hindi.setText(balkandSecondModel.getBalkandSecondAdhyaHindi());
        holder.tv_sanskrit.setText(balkandSecondModel.getBalkandSecondAdhyaSankrit());
    }

    @Override
    public int getItemCount() {
        return secondModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_sanskrit,tv_hindi;
        private LinearLayout layout2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_hindi=itemView.findViewById(R.id.balkand_secont_adhya_hindi_sholk_meaning);
            tv_sanskrit=itemView.findViewById(R.id.balkand_second_adhya_sholk_with_sanskrit);
            layout2=itemView.findViewById(R.id.custom_layout_balkand_adhya_second);
            layout2.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NewApi")
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu=new PopupMenu(itemView.getContext(),layout2);

                        popupMenu.setGravity(Gravity.CENTER);

                    popupMenu.getMenuInflater().inflate(R.menu.option,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {

                            switch (menuItem.getItemId()){
                              /*  case R.id.add_to_fav:
                                    Toast.makeText(itemView.getContext(), "Add To Favourite"+menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                                    break;*/

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
                               /* case R.id.add_book_mark_here:
                                    Toast.makeText(itemView.getContext(), "Add To Bookmark"+menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                                    break;
*/                                default:
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

package com.example.ramayan.adapter;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.utils.Utils;
import com.example.ramayan.R;
import com.example.ramayan.apptheme.Constant;
import com.example.ramayan.apptheme.Method;
import com.example.ramayan.db.MyDatabaseHelper;
import com.example.ramayan.fragments.BalkandFragment;
import com.example.ramayan.model.BalkandFirstAdhyaModel;

import java.util.ArrayList;

public class BalkandFirstAdhyaAdapter extends RecyclerView.Adapter<BalkandFirstAdhyaAdapter.ViewHolder> implements View.OnTouchListener{
    private ArrayList<BalkandFirstAdhyaModel> balkandFirstAdhyaModels;
    private Context context;


    public BalkandFirstAdhyaAdapter(ArrayList<BalkandFirstAdhyaModel> balkandFirstAdhyaModels, Context context) {
        this.balkandFirstAdhyaModels = balkandFirstAdhyaModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_balkand_first_adhya, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BalkandFirstAdhyaModel model = balkandFirstAdhyaModels.get(position);
        holder.tv_hindi.setText(model.getBalkandFirstAdhyaHindi());
        holder.tv_sanskrit.setText(model.getBalkandFirstAdhyaSanskrit());

    }

    @Override
    public int getItemCount() {
        return balkandFirstAdhyaModels.size();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_sanskrit,tv_hindi;

        private LinearLayout layout1;

        private ImageView imageViewBalkandFirstAdhyaZoomIn,imageViewBalkandFirstAdhyaZoomOut;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_sanskrit=itemView.findViewById(R.id.balkand_first_adhya_sholk_with_sanskrit);

            tv_hindi=itemView.findViewById(R.id.balkand_first_adhya_hindi_sholk_meaning);

           /* imageViewBalkandFirstAdhyaZoomIn=itemView.findViewById(R.id.custom_layout_balkand_adhya_first_zoom_in);

            imageViewBalkandFirstAdhyaZoomOut=itemView.findViewById(R.id.custom_layout_balkand_adhya_first_zoom_out);

            imageViewBalkandFirstAdhyaZoomIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    zoomIn();
                }
            });

            imageViewBalkandFirstAdhyaZoomOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    zoomOut();
                }
            });
*/
            layout1=itemView.findViewById(R.id.custom_layout_balkand_adhya_first);
            layout1.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return false;
                }
            });

            layout1.setOnLongClickListener(new  View.OnLongClickListener() {

                @SuppressLint("NewApi")
                @Override
                public boolean onLongClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(itemView.getContext(), layout1);
                    popupMenu.setGravity(Gravity.CENTER);
                    popupMenu.getMenuInflater().inflate(R.menu.option, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {

                            switch (menuItem.getItemId()) {
                                case R.id.add_to_fav:

                                    String san=tv_sanskrit.getText().toString();
                                    String hin=tv_hindi.getText().toString();
                                    String messsage=san+hin;

                                    if (messsage.isEmpty()){
                                        Toast.makeText(itemView.getContext(),"SomeThing Went Wromg",Toast.LENGTH_SHORT).show();
                                    }else{
                                        MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper(itemView.getContext());
                                        myDatabaseHelper.addFav(san,hin);
                                        Toast.makeText(itemView.getContext(), "Add To Favourite Successfully", Toast.LENGTH_SHORT).show();
                                    }

                                break;

                                case R.id.share_this_Data:

                                    String sanskrit = tv_sanskrit.getText().toString();
                                    String hindi = tv_hindi.getText().toString();
                                    String message = sanskrit + hindi;
                                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                                    sharingIntent.setType("text/plain");
                                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Valmiki Ramayan");
                                    sharingIntent.putExtra(Intent.EXTRA_TEXT, message);
                                    itemView.getContext().startActivity(Intent.createChooser(sharingIntent, "Message"));
                                    break;

                                case R.id.copy_to_clipbord:
                                    String sanskrit_copy = tv_sanskrit.getText().toString();
                                    String hindi_copy = tv_hindi.getText().toString();
                                    String messagecopy = sanskrit_copy + hindi_copy;
                                    ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                                    ClipData clip = ClipData.newPlainText("Copied Text", messagecopy);
                                    clipboard.setPrimaryClip(clip);
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

        }

        public  void zoomIn(){
            float sanskritX=tv_sanskrit.getScaleX();
            float sanskritY=tv_sanskrit.getScaleY();


            float hindiX=tv_hindi.getScaleX();
            float hindiY=tv_hindi.getScaleY();

            tv_sanskrit.setScaleX(sanskritX+0.01f);;
            tv_sanskrit.setScaleY(sanskritY+0.01f);

            tv_hindi.setScaleX(hindiX+0.01f);
            tv_hindi.setScaleY(hindiY+0.01f);
        }

        public void zoomOut(){
            float sanskritX=tv_sanskrit.getScaleX();
            float sanskritY=tv_sanskrit.getScaleY();


            float hindiX=tv_hindi.getScaleY();
            float hindiY=tv_hindi.getScaleY();

            tv_sanskrit.setScaleX(sanskritX-0.01f);;
            tv_sanskrit.setScaleY(sanskritY-0.01f);

            tv_hindi.setScaleX(hindiX-0.01f);
            tv_hindi.setScaleY(hindiY-0.01f);
        }
    }

}
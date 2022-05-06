package com.example.ramayan.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ramayan.adapter.ValmikiRamayanaAdapter;
import com.example.ramayan.model.BalkandFirstAdhyaModel;
import com.example.ramayan.model.MyFavModel;
import com.example.ramayan.model.ValimikiRamayanaModel;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=2;
    private static final String DATABASE_NAME="ramayana.db";
    private static final String TABLE_NAME="ramayana_table";
    // keys and value of the table

    private static String COLUMN_ID ="id";
    private static String COLUMN_SANSKRIT="sanskrit";
    private static String COLUMN_HINDI="hindi";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                //+ COLUMN_SANSKRIT + " VARCHAR(2000),"
                + COLUMN_SANSKRIT + " TEXT ,"
                + COLUMN_HINDI + " TEXT " + ")";
      /*  String query1=" CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+
                " INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_SANSKRIT+" TEXT ,"+COLUMN_HINDI+" TEXT "+")";
    */
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
     //   sqLiteDatabase.execSQL("DELETE from "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addFav(String hindi,String sanskrit){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_SANSKRIT,hindi);
        values.put(COLUMN_HINDI,sanskrit);

        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();

    }

    public ArrayList<MyFavModel> getData() throws OutOfMemoryError ,SQLException{

        ArrayList<MyFavModel> myFavModels =new ArrayList<>();
            SQLiteDatabase database=this.getReadableDatabase();
            String query="SELECT * FROM "+TABLE_NAME;
            Cursor cursor=database.rawQuery(query,null);

            if (cursor.moveToFirst()){
                do{
                    MyFavModel model=new MyFavModel();
                    model.setfId(cursor.getInt(0));
                    model.setfSanskrit(cursor.getString(1));
                    model.setfHindi(cursor.getString(2));
                    myFavModels.add(model);
                }while (cursor.moveToLast());
            }
        return myFavModels;
    }


    public List<MyFavModel> readAllUser(){

        List<MyFavModel> userList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                MyFavModel myUser = new MyFavModel();
                myUser.setfId(cursor.getInt(0));
                myUser.setfSanskrit(cursor.getString(1));
                myUser.setfHindi(cursor.getString(2));
                userList.add(myUser);
            }while (cursor.moveToNext());
        }
        return userList;
    }
}

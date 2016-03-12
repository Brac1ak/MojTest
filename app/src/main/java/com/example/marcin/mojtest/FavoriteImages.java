package com.example.marcin.mojtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FavoriteImages extends SQLiteOpenHelper {

    Context context;

    private static final String DATABASE_NAME = "images";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_URL_IMAGE = "urlImage";

    private static final String DATABASE_MOVIE_CREATE = "CREATE TABLE IF NOT EXISTS " +
            DATABASE_NAME + "(" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_URL_IMAGE + " TEXT " + ");";

    public FavoriteImages(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_MOVIE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }

    public void insertImageURL(Result result)
    {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_URL_IMAGE, result.getposter_path().replace("/", ""));

        database.insert(DATABASE_NAME, null, values);
        database.close();
    }

    public List<Result> getAllImages()
    {
        SQLiteDatabase database = getWritableDatabase();
        List<Result> imagesResults = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM " + DATABASE_NAME, null);

        if (cursor.moveToFirst()){
            do{
                imagesResults.add(0, new Result(("/" + cursor.getString(1))));

            }while (cursor.moveToNext());
        }


        return imagesResults;
    }

    public void deleteRow(String imageURL){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(DATABASE_NAME, COLUMN_URL_IMAGE + " = ?" , new String[] {imageURL.replace("/", "")});
    }


    public boolean checkTheMovieIsAdded(String url){


        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DATABASE_NAME + " WHERE " +
                COLUMN_URL_IMAGE + "='" + url.replace("/", "") + "'", null);

        return cursor.moveToFirst();
    }

}

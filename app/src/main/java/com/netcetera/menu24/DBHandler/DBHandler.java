package com.netcetera.menu24.DBHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.netcetera.menu24.Model.MenuModal;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "menudb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mymenus";
    private static final String ID_COL = "id";
    private static final String MENU_COL = "menu";
    private static final String INHALT_COL = "inhalt";
    private static final String PRICE_COL = "price";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MENU_COL + " TEXT,"
                + INHALT_COL + " TEXT,"
                + PRICE_COL + " TEXT)";
        db.execSQL(query);
    }

    public void addNewCourse(String menuName, String menuInhalt, String menuPrice) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(MENU_COL, menuName);
        values.put(INHALT_COL, menuInhalt);
        values.put(PRICE_COL, menuPrice);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<MenuModal> readMenus() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorMenus = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<MenuModal> courseModalArrayList = new ArrayList<>();

        if (cursorMenus.moveToFirst()) {
            do {
                courseModalArrayList.add(new MenuModal(
                        cursorMenus.getString(1),
                        cursorMenus.getString(4),
                        cursorMenus.getString(2)
                ));
            } while (cursorMenus.moveToNext());
        }
        cursorMenus.close();
        return courseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}


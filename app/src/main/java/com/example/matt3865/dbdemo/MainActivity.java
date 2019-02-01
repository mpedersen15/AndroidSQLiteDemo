package com.example.matt3865.dbdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDB = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

//        myDB.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
//
//        myDB.execSQL("INSERT INTO users (name, age) VALUES ('Matt', 29)");
//
//        myDB.execSQL("INSERT INTO users (name, age) VALUES ('Luke', 25)");
//
//        Cursor c = myDB.rawQuery("SELECT * FROM users", null);
//
//        int nameIndex = c.getColumnIndex("name");
//
//        int ageIndex = c.getColumnIndex("age");
//
//        c.moveToFirst();
//
//        while(c != null) {
//            Log.i("name", c.getString(nameIndex));
//            Log.i("age", c.getString(ageIndex));
//            c.moveToNext();
//        }


        myDB.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4))");

        myDB.execSQL("INSERT INTO events (name, year) VALUES ('Berlin wall falls', 1989)");

        myDB.execSQL("INSERT INTO events (name, year) VALUES ('WWII ends', 1945)");

         Cursor c = myDB.rawQuery("SELECT * FROM events", null);

         int nameIndex = c.getColumnIndex("name");

        int yearIndex = c.getColumnIndex("year");

        c.moveToFirst();

        while(c != null) {
            Log.i("name", c.getString(nameIndex));
            Log.i("year", c.getString(yearIndex));
            c.moveToNext();
        }
    }
}

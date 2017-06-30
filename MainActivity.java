package com.example.yuechengshi.day21;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static String a = "Lehigh University, Bethlehem BS in CHE and CS";
    public static String b = "Java, Matlab, Aspen";
    public static String c = "Dance, Music, Running";
    public static String d = "Unit Operation Lab 2015 fall - 2016 Spring";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lView = (ListView) findViewById(R.id.listView1);
        final ArrayList<String> classRoster = new ArrayList<String>();
        classRoster.add("Yuecheng");
        classRoster.add("Ruth");
        classRoster.add("James");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, classRoster);
        lView.setAdapter(adapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Hello", classRoster.get(i));
                if (i ==0) {
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.putExtra("education", a);
                    intent.putExtra("skills", b);
                    intent.putExtra("hobbies", c);
                    intent.putExtra("professional", d);
                    intent.putExtra("image", R.drawable.img1);
                    //intent.putExtra("Message", "Hello World");
                    startActivity(intent);
                }

                if (i ==1) {
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.putExtra("education", a);
                    intent.putExtra("skills", b);
                    intent.putExtra("hobbies", c);
                    intent.putExtra("professional", d);
                    intent.putExtra("image", R.drawable.img2);
                    //intent.putExtra("Message", "Hello World");
                    startActivity(intent);
                }

                if (i ==2) {
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.putExtra("education", a);
                    intent.putExtra("skills", b);
                    intent.putExtra("hobbies", c);
                    intent.putExtra("professional", d);
                    intent.putExtra("image", R.drawable.img2);
                    //intent.putExtra("Message", "Hello World");
                    startActivity(intent);
                }

            }
        });
        //create a db manager instance
        DBHelper dbHelper1 = new DBHelper(getApplicationContext());

        //get the database in write mode
        SQLiteDatabase database = dbHelper1.getWritableDatabase();
        //dbHelper1.onUpgrade(database,1,2);

        //Insert data into our db
        ContentValues values = new ContentValues();
        values.put(DBHelper.DBTable.COLUMN_NAME, "Yuecheng");
        values.put(DBHelper.DBTable.COLUMN_GPA, 3.0);
        values.put(DBHelper.DBTable.COLUMN_EDUCATION, a);
        values.put(DBHelper.DBTable.COLUMN_SKILLS, b);
        values.put(DBHelper.DBTable.COLUMN_HOBBIES, c);
        values.put(DBHelper.DBTable.COLUMN_PROFESSIONAL, d);

        long transac_ID = database.insert(DBHelper.DBTable.TABLE_NAME,null,values);

        if(transac_ID <0) {
            Log.e("SQL ERROR", "No data added");

        }
        else {
            Log.e("SQL succsess ", "Data added ");
        }

        values.put(DBHelper.DBTable.COLUMN_NAME, "Ruth");
        values.put(DBHelper.DBTable.COLUMN_GPA, 3.0);
        values.put(DBHelper.DBTable.COLUMN_EDUCATION, a);
        values.put(DBHelper.DBTable.COLUMN_SKILLS, b);
        values.put(DBHelper.DBTable.COLUMN_HOBBIES, c);
        values.put(DBHelper.DBTable.COLUMN_PROFESSIONAL, d);
        /*
        transac_ID = database.insert(DBHelper.DBTable.TABLE_NAME,null,values);

        if(transac_ID <0) {
            Log.e("SQL ERROR", "No data added");

        }
        else {
            Log.e("SQL succsess ", "Data added ");
        }
        */


        values.put(DBHelper.DBTable.COLUMN_NAME, "James");
        values.put(DBHelper.DBTable.COLUMN_GPA, 3.0);
        values.put(DBHelper.DBTable.COLUMN_EDUCATION, a);
        values.put(DBHelper.DBTable.COLUMN_SKILLS, b);
        values.put(DBHelper.DBTable.COLUMN_HOBBIES, c);
        values.put(DBHelper.DBTable.COLUMN_PROFESSIONAL, d);
/*
        //insert values into the database
        transac_ID = database.insert(DBHelper.DBTable.TABLE_NAME,null,values);

        if(transac_ID <0) {
            Log.e("SQL ERROR", "No data added");

        }
        else {
            Log.e("SQL succsess ", "Data added ");
        }
        */

        //Querying db
        SQLiteDatabase database1 = dbHelper1.getReadableDatabase();
        //dbHelper1.onUpgrade(database1, 1,2);

        //specify the column
        String[] projection = {DBHelper.DBTable._ID,
                DBHelper.DBTable.COLUMN_NAME,
                DBHelper.DBTable.COLUMN_GPA,
                DBHelper.DBTable.COLUMN_EDUCATION,
                DBHelper.DBTable.COLUMN_SKILLS,
                DBHelper.DBTable.COLUMN_HOBBIES,
                DBHelper.DBTable.COLUMN_PROFESSIONAL
        };

        String condition = DBHelper.DBTable.COLUMN_GPA + " = ?";
        String[] conditionArgs = {"3.0"};
        String sortOrder = DBHelper.DBTable.COLUMN_NAME + " ASC";

        //Cursor to run the query and get the results
        Cursor cursor = database.query(
            DBHelper.DBTable.TABLE_NAME,
                projection,//the column to return
                condition,//condition
                conditionArgs,//condition aka where cluse
                null,// we are not grouping results
                null,//no filtrarion
                sortOrder//how we want the  result to  be sorted
        );

        List results = new ArrayList<>();
        while(cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.DBTable.COLUMN_NAME));
            results.add(name);
        }
        cursor.close();

        for (int i = 0; i<results.size(); i++) {
            Log.i("Student" + (i+1), results.get(i).toString());

        }



    }
}

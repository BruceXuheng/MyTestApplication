package com.example.chenxh.myttestapplication.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.chenxh.myttestapplication.R;
import com.example.chenxh.myttestapplication.db.DatabaseHelper;
import com.example.chenxh.myttestapplication.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private Button btninsert,btndelete,btnAllDel;
    private ListView lvShow;
    private DatabaseHelper helper;
    private SQLiteDatabase db;

//  Data
    private List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();


    }

    private void initView() {
        btninsert = (Button) findViewById(R.id.btn_insert);
        btndelete = (Button) findViewById(R.id.btn_delete);
        btnAllDel = (Button) findViewById(R.id.btn_delete_all);
        lvShow = (ListView) findViewById(R.id.lv_show_db);

        helper = new DatabaseHelper(this);


    }


    public void onClickDb(View view) {
        switch (view.getId()){

            case R.id.btn_insert:
                insertDB();
                break;
            case R.id.btn_delete:
                deleteDB();
                break;
            case R.id.btn_delete_all:
                deleteAllDb();
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

//        personList = selectDb();




    }

    private void deleteAllDb() {

        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("insert into person(name) values('chen')");

        db.close();
    }

    private void insertDB(){
        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("insert into person(name) values('chen')");

        db.close();
    }
    private void deleteDB(){
        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("delete into person(id) values(1)");

        db.close();
    }

    private List<Person> selectDb(){

        List<Person> personList = new ArrayList<Person>();

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor mCursor = db.query("person", new String[] { "id", "name" },null, null, null, null,
                null);
        mCursor.moveToFirst();
        do{
            String name = mCursor.getString(mCursor.getColumnIndex("name"));
            int id = mCursor.getInt(mCursor.getColumnIndex("id"));
            Person person = new Person(id,name);//71.4/12 = 5.91  89.7/19.2=4.67 4.27
            person.setId(id);
            person.setName(name);
            personList.add(person);
        }while(mCursor.moveToNext());
        return personList;
    }


}

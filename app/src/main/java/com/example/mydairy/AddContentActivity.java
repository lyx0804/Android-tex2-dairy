package com.example.mydairy;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddContentActivity extends AppCompatActivity {
    private EditText mt;
    private EditText met;
    private DBOpenHelper myDB;
    private SQLiteDatabase mysqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        mt=findViewById(R.id.title);
        met=findViewById(R.id.text);
        myDB=new DBOpenHelper(this);
        mysqldb=myDB.getWritableDatabase();
    }
    public void save(View v) {
        DdAdd();
        finish();
    }
    public void cancle(View v) {
        mt.setText("");
        met.setText("");

        finish();
    }
    public void DdAdd(){
        ContentValues cv = new ContentValues();
        cv.put("title",mt.getText().toString());
        cv.put("content",met.getText().toString());
        cv.put("time",getTime());
        cv.put("_id", LoginActivity.userID);
        mysqldb.insert("note",null,cv);//插入数据
    }
    public static String getTime(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date();
        String str=sdf.format(date);
        return str;
    }


}

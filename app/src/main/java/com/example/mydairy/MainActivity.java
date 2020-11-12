package com.example.mydairy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<User> mList;
    private ListView listView;
    private MyAdapter myAdapter;
    private DBOpenHelper dbOpenHelper;
    private Cursor cursor;
    private SQLiteDatabase dbreader;

    //创建OptionMenu菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载资源菜单
        getMenuInflater ().inflate (R.menu.menu_main,menu);  //第一个传入的参数是你创建的menu的名字
        return true;  //一定要return true 才会显示出来
    }
    //当你选中某个Menu时触发的事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId ()){            //获取Id
            case  R.id.Logout:
                Intent intent=new Intent(this, LoginActivity.class);
                Toast.makeText(this,"退出成功",Toast.LENGTH_LONG).show();
                startActivity(intent);
                break;
            case R.id.addnote:
                Intent intent2 = new Intent(this, AddContentActivity.class);
                startActivity(intent2);
                break;
            case R.id.mine:
                Intent intent3 = new Intent(this, MineActivity.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected (item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        dbOpenHelper= new DBOpenHelper(this);
        dbreader = dbOpenHelper.getReadableDatabase();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, showActivity.class);
                intent.putExtra("ID", mList.get(position).getId());
                intent.putExtra("title", mList.get(position).getTitle());
                intent.putExtra("content", mList.get(position).getContent());
                intent.putExtra("time", mList.get(position).getTime());
                startActivity(intent);
            }
        });


    }
    public void selectDb() {
        mList = new ArrayList<User>();
        cursor = dbreader.rawQuery("SELECT * FROM note WHERE _id = ?", new String[]{LoginActivity.userID + ""});
        while (cursor.moveToNext()) {
            User note = new User();
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String content = cursor.getString(cursor.getColumnIndex("content"));
            note.setTime(time);
            note.setId(id);
            note.setTitle(title);
            note.setContent(content);
            mList.add(note);
        }
        cursor.close();
        myAdapter = new MyAdapter(this, mList);
        listView.setAdapter(myAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        selectDb();
    }
}




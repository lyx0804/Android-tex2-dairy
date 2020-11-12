package com.example.mydairy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<User> mList;
    private LinearLayout mlayout;

    public MyAdapter(Context mContext, List<User> mList){
        this.mContext=mContext;
        this.mList=mList;
    }
    @Override
    public int getCount() {
        return mList.size();
    }
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mlayout=(LinearLayout) inflater.inflate(R.layout.listre,null);

        TextView title=(TextView)mlayout.findViewById(R.id.list_title);
        TextView content=(TextView)mlayout.findViewById(R.id.list_content);
        TextView time=(TextView)mlayout.findViewById(R.id.list_time);

        title.setText(mList.get(position).getTitle());
        content.setText(mList.get(position).getContent());
        time.setText(mList.get(position).getTime());
        return mlayout;
    }
}


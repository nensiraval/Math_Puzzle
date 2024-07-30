package com.example.mathpuzzle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class imageadapter extends BaseAdapter {
    puzzlenumber puzzlenumber;

    public imageadapter(puzzlenumber puzzlenumber) {
        this.puzzlenumber = puzzlenumber;
    }

    @Override
    public int getCount() {
        return 75;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(puzzlenumber).inflate(R.layout.activity_puzzlenumber, parent, false);
        TextView txt4;
        txt4 = convertView.findViewById(R.id.txt4);
        txt4.setBackgroundResource(R.drawable.lock);
        return convertView;
    }
}

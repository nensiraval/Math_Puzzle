package com.example.mathpuzzle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class second extends BaseAdapter {
    puzzlenumber puzzlenumber;
    int[] image;

    public second(puzzlenumber puzzlenumber, int[] image) {
        this.puzzlenumber = puzzlenumber;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return image[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(puzzlenumber).inflate(R.layout.activity_puzzlenumber, parent, false);
        }
        ImageView imageView = view.findViewById(R.id.imageview);
        imageView.setImageResource(image[position]);
        return view;
    }
}
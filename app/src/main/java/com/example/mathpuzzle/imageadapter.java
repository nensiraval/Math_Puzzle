package com.example.mathpuzzle;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
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
    public int getCount()
    {
        return 75;
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = LayoutInflater.from(puzzlenumber).inflate(R.layout.activity_image, parent, false);
        TextView txt4;
        txt4 = convertView.findViewById(R.id.imageView);
        if (MainActivity.sp.getString("key"+position,"").equals(MainActivity.com))
        {
            txt4.setBackgroundResource(R.drawable.tick);
            txt4.setText(""+(position+1));
        }
        else if (MainActivity.sp.getString("key"+position,"").equals(MainActivity.skip))
        {
                txt4.setText(""+(position+1));
        }
        else
        {
            txt4.setBackgroundResource(R.drawable.lock);
        }
        txt4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!MainActivity.sp.getString("key"+position,"").equals(MainActivity.lock))
                {
                    Intent i = new Intent(puzzlenumber, MainActivity2.class);
                    i.putExtra("level", position);
                    puzzlenumber.startActivity(i);
                }
            }
        });
        return convertView;
    }
}

package com.example.mathpuzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class puzzlenumber extends AppCompatActivity {
    GridView grid;
    TextView txt4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_puzzlenumber);

        grid = findViewById(R.id.grid);
        txt4 = findViewById(R.id.txt4);

        String s = getIntent().getStringExtra("level");
        txt4.setText(s);
        Log.e("--", "onCreate: "+s);

        imageadapter ad = new imageadapter(puzzlenumber.this);
        grid.setAdapter(ad);
        txt4.setText("Puzzle "+(MainActivity2.n+1));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.e("+++", "onItemClick: " + position);
            }
        });
    }
}
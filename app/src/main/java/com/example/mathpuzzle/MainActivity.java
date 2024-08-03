package com.example.mathpuzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView contne, puz2;
    int n = 0;
    static SharedPreferences sp; // get
    static SharedPreferences.Editor edit;  // set    //  SharedPreferences  // key = value
    static  String com = "completed";
    static  String lock = "lock";
    static String  skip = "skip";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("Mydata", MODE_PRIVATE);
        edit = sp.edit();

        contne = findViewById(R.id.contne);
        puz2 = findViewById(R.id.puz2);


        //SharedPreferences
        n = sp.getInt("value", 0);
        for (int i = 0; i< 76; i++)
        {
            if (sp.getString("key"+i,"").equals(""))
            {
                edit.putString("key"+i,lock);
                edit.apply();
            }
        }
        contne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("level", n);
                startActivity(i);
            }
        });

        puz2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, puzzlenumber.class));
            }
        });
    }
}
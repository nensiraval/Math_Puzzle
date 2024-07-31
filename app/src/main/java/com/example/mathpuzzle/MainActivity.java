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
    static  int i = 1;
    private static SharedPreferences sp; // get
    private static SharedPreferences.Editor edit;  // set    //  SharedPreferences  // key = value
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        contne = findViewById(R.id.contne);
        puz2 = findViewById(R.id.puz2);

        n = getIntent().getIntExtra("level", 0);

        //SharedPreferences
        sp = getSharedPreferences("Mydata", MODE_PRIVATE);
        edit = sp.edit();
        i = sp.getInt("value", 1);

        contne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("level", n);
                startActivity(i);
                level();
            }
        });

        puz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                level();
                startActivity(new Intent(MainActivity.this, puzzlenumber.class).putExtra("level", n));
            }
        });
    }
    private void level()
    {
        i++;
        edit.putInt("value", i);
        edit.apply();
    }
}
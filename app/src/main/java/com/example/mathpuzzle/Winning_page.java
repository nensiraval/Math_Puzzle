package com.example.mathpuzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Winning_page extends AppCompatActivity
{
    TextView txt3,cnwin,mmenu;
    int n = 0;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        txt3 = findViewById(R.id.txt3);
        cnwin = findViewById(R.id.cnwin);
        mmenu = findViewById(R.id.mmenu);

         n = getIntent().getIntExtra("level",0);
        txt3.setText("PUZZLE "+ n +" COMPLETED");


        cnwin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Winning_page.this, MainActivity2.class).putExtra("level", n));
                finish();
            }
        });
        mmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(Winning_page.this, MainActivity.class));
                    finish();
            }
        });
    }
}


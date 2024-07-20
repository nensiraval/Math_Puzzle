package com.example.mathpuzzle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity
{
    TextView txt3;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

//        txt3 = findViewById(R.id.txt3);
//        String n = getIntent().getStringExtra("second");
//        txt3.setText(n);
//        Log.e("Check", "onCreate: "+n);

    }
}

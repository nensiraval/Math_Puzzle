package com.example.mathpuzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class puzzlenumber extends AppCompatActivity {
    GridView grid;
    TextView textView,puz2;
    int image[] = {R.drawable.lock};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_puzzlenumber);

        grid = findViewById(R.id.grid);
        textView = findViewById(R.id.textview);
        puz2 = findViewById(R.id.puz2);

        String s = getIntent().getStringExtra("level");
        textView.setText(s);
        Log.e("--", "onCreate: "+s);

//        Intent intent = getIntent();
//        String level = intent.getStringExtra("level");  if (level != null) {
//            textView.setText(level);
//            Log.e("--", "onCreate: " + level);
//        } else {
//            Log.e("--", "onCreate: level extra not found");
//        }
        second as = new second(puzzlenumber.this, image);
        grid.setAdapter(as);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.e("+++", "onItemClick: " + position);
            }
        });

        puz2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(puzzlenumber.this,MainActivity.class);
                i.putExtra("level", n);
                startActivity(i);
            }
        });

    }
}
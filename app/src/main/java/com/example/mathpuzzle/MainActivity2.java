package com.example.mathpuzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView txt, typ,sub;
    Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,delete;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.txt);
        typ = findViewById(R.id.typ);
        String s = getIntent().getStringExtra("new");
        txt.setText(s);
        Log.e("Check", "onCreate: "+s);


        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n0 = findViewById(R.id.n0);
        delete = findViewById(R.id.delete);
        sub = findViewById(R.id.sub);

        setbtn(n1,"1");
        setbtn(n2,"2");
        setbtn(n3,"3");
        setbtn(n4,"4");
        setbtn(n5,"5");
        setbtn(n6,"6");
        setbtn(n7,"7");
        setbtn(n8,"8");
        setbtn(n9,"9");
        setbtn(n0,"0");
        setbtn(delete, "");
    }

    void setbtn(Button btn, String n)
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n.equals(""))
                {
                    if (!typ.getText().toString().equals(""))
                    {
                        typ.setText(typ.getText().toString().substring(0, typ.getText().toString().length() - 1));
                    }
                }
                else
                {
                    typ.setText(typ.getText().toString().concat(n));
                }
            }
        });
    }
}

//
//        sub.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        Intent i = new Intent(MainActivity2.this,MainActivity3.class);
//        i.putExtra("second", "data");
//        startActivity(i);
//        }
//        });
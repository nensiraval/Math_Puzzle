package com.example.mathpuzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView txt, typ,sub;
    ImageView solve;
    Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,delete,skip;
    static int n = 0;
    int image[] = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,R.drawable.p20,
            R.drawable.p21,R.drawable.p22,R.drawable.p23,R.drawable.p24,R.drawable.p25,R.drawable.p26,R.drawable.p27,R.drawable.p28,R.drawable.p29,R.drawable.p30,R.drawable.p31,R.drawable.p32,R.drawable.p33,R.drawable.p34,R.drawable.p35,R.drawable.p36,R.drawable.p37,R.drawable.p38,R.drawable.p39,R.drawable.p40,R.drawable.p41,
            R.drawable.p42,R.drawable.p43,R.drawable.p44,R.drawable.p45,R.drawable.p46,R.drawable.p47,R.drawable.p48,R.drawable.p49,R.drawable.p50,R.drawable.p51,R.drawable.p52,R.drawable.p53,R.drawable.p54,R.drawable.p55,R.drawable.p56,R.drawable.p57,R.drawable.p58,R.drawable.p59,R.drawable.p60,R.drawable.p61,R.drawable.p62,
            R.drawable.p63,R.drawable.p64,R.drawable.p65,R.drawable.p66,R.drawable.p67,R.drawable.p68,R.drawable.p69,R.drawable.p70,R.drawable.p71,R.drawable.p72,R.drawable.p73,R.drawable.p74,R.drawable.p75};

    String ans[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40",
            "41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60",
            "61","62","63","64","65","66","67","68","69","70","71","72","73","74","75"};

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.txt);
        typ = findViewById(R.id.typ);
        solve = findViewById(R.id.solve);
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
        solve = findViewById(R.id.solve);
        skip = findViewById(R.id.skip);

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

        n = getIntent().getIntExtra("level", 0);
        txt.setText("Puzzle "+(n+1));
        solve.setBackgroundResource(image[n]);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(typ.getText().toString().equals(ans[n]))
                {
                    MainActivity.edit.putString("key"+n,MainActivity.com);
                    n++;
                    MainActivity.edit.putInt("value", n);
                    MainActivity.edit.apply();
                    startActivity(new Intent(MainActivity2.this,Winning_page.class).putExtra("level",n));
                    finish();
                }
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.edit.putString("key"+n,MainActivity.skip);
                n++;
                MainActivity.edit.putInt("value", n);
                MainActivity.edit.apply();
                txt.setText("Puzzle "+(n+1));
                solve.setBackgroundResource(image[n]);
            }
        });
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
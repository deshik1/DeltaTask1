package com.example.deshiksridharan.deltatask1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RelativeLayout activity_main;
    Button RED;
    Button BLUE;
    Button GREEN;
    Button Reset;
    TextView Red;
    TextView Blue;
    TextView Green;

int r,g,b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=getred();
        g=getgreen();
        b=getblue();

        activity_main =(RelativeLayout) findViewById(R.id.activity_main);
        activity_main.setBackgroundColor(Color.rgb(r,g,b));
        RED = (Button) findViewById(R.id.RED);
        Red = (TextView) findViewById(R.id.Red);
        RED.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view)
                                   {
                                       r=r+25;
                                       if(r>255)
                                       {
                                           r=0;
                                       }
                                       activity_main.setBackgroundColor(Color.rgb(r,g,b));
                                       Red.setText(String.valueOf(r));
                                    savedata(r,g,b);
                                   }
                               }

        );
        BLUE = (Button) findViewById(R.id.BLUE);
        Blue=(TextView) findViewById(R.id.Blue);
        BLUE.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view)
                                    {
                                        b=b+25;
                                        if(b>255)
                                        {
                                            b=0;
                                        }
                                        activity_main.setBackgroundColor(Color.rgb(r,g,b));
                                        Blue.setText(String.valueOf(b));
                                        savedata(r,g,b);
                                    }
                                }

        );
        GREEN = (Button) findViewById(R.id.GREEN);
        Green=(TextView) findViewById(R.id.Green);
        GREEN.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view)
                                     {
                                         g=g+25;
                                         if(g>255)
                                         {
                                             g=0;
                                         }

                                         activity_main.setBackgroundColor(Color.rgb(r,g,b));
                                         Green.setText(String.valueOf(g));
                                         savedata(r,g,b);
                                     }
                                 }

        );
        Reset = (Button) findViewById(R.id.Reset);
        Reset.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view)
                                     {
                                         r=g=b=0;
                                         Red.setText(String.valueOf(r));
                                         Blue.setText(String.valueOf(b));
                                         Green.setText(String.valueOf(g));
                                         activity_main.setBackgroundColor(Color.rgb(r,g,b));
                                         savedata(r,g,b);
                                     }
                                 }

        );


    }

    public void savedata(int r1, int g1, int b1)
    {
        SharedPreferences sharedPref = getSharedPreferences("preffile",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("red", r1);
        editor.putInt("green", g1);
        editor.putInt("blue", b1);
        editor.commit();
    }
    public int  getred()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("preffile",Context.MODE_PRIVATE);
        int r2 = sharedPreferences.getInt("red",0);
        return r2;
    }
    public  int getgreen()
    {
        SharedPreferences sharedpref = getSharedPreferences("color", Context.MODE_PRIVATE);
        Integer g2 = sharedpref.getInt("green",0);
        return g2;

    }

    public  int getblue()
    {
        SharedPreferences sharedpref = getSharedPreferences("color", Context.MODE_PRIVATE);
        Integer b2 = sharedpref.getInt("blue",0);
        return b2;

    }
}
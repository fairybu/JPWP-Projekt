package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class run extends AppCompatActivity {


    public Button po_run_main;

    //przejście do menu głownego
    public void przycisk(){
        po_run_main=(Button)findViewById(R.id.po_run);
        po_run_main.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent powrot_menu=new Intent(run.this, MainActivity.class);

                startActivity(powrot_menu);
            }
        }));
    }

    private static final int[] idArray ={R.id.Button_1,R.id.Button_2,R.id.Button_3,
            R.id.Button_4,R.id.Button_5,R.id.Button_6,
            R.id.Button_7,R.id.Button_8,R.id.Button_9,
            R.id.Button_10,R.id.Button_11,R.id.Button_12};


    private Button[] button = new  Button[idArray.length];

    int i;
    String buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        przycisk();

        for(i=0; i<idArray.length;i++){

        button [i]=(Button)findViewById(idArray[i]);

        Random r= new Random();

        int value=r.nextInt(100)+1;

        button[i].setText(Integer.toString(value));




        button[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Random r= new Random();
                Toast.makeText(getApplicationContext(),Integer.toString(r.nextInt(100)+1),Toast.LENGTH_SHORT).show();
            }
        });





        }

    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}

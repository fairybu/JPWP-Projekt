package com.example.firstapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;

public class run extends AppCompatActivity {


    public Button po_run_main;

    //przejście do menu głownego
    public void przycisk(){
        po_run_main=(Button)findViewById(R.id.po_run);
        po_run_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countDownTimer.cancel();
                Intent powrot_menu=new Intent(run.this, MainActivity.class);
                startActivity(powrot_menu);
            }
        });
    }
    //TABLIca z przyciskami
    private static final int[] idArray ={R.id.Button_1,R.id.Button_2,R.id.Button_3,
            R.id.Button_4,R.id.Button_5,R.id.Button_6,
            R.id.Button_7,R.id.Button_8,R.id.Button_9,
            R.id.Button_10,R.id.Button_11,R.id.Button_12};


    private Button[] button = new  Button[idArray.length];


    int i;
    String buttonText;



    //zmienne do licznnika
    private TextView licznik;
    public CountDownTimer countDownTimer;
    public long timeLeftinMilliseconds=11000;
    public  boolean TimeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        String tryb = getIntent().getStringExtra("tryb"); //pobieram info jaki tryb gry wybrano


        int wys = Integer.parseInt(tryb); //zamiana stringa trybu na intigera bo inaczej nie chciało dziłać

        licznik = findViewById(R.id.licznik);

        StartStop();// wywołanie funkcji licznika

        przycisk();//wywołanie funkci powrotu

        //przypisanie wartości buttom
        for (i = 0; i < idArray.length; i++) {

            button[i] = (Button) findViewById(idArray[i]);

            Random rand = new Random();
            int value;


            if (wys == 1) {

                for (int counte = 0; counte < idArray.length; counte++) {
                    value = (int) (Math.random() * 20) + 1;
                    button[i].setText(Integer.toString(value));
                }
            } else if (wys == 2) {

                value = 1 + rand.nextInt(20);
                button[i].setText(Integer.toHexString(value));
            } else {
                for (int counte = 0; counte < idArray.length; counte++) {
                    value = 1 + rand.nextInt(20);
                    button[i].setText(Integer.toHexString(value));
                }

            }

        }

    }

    //funkcja licznika
    public void StartStop(){

        if(TimeRunning){
            StopTimer();
        }else{

            StartTime();
        }

    }

    public void StartTime(){

        countDownTimer=new CountDownTimer(timeLeftinMilliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftinMilliseconds=millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        TimeRunning=true;
    }

    public void StopTimer(){
        countDownTimer.cancel();
        TimeRunning=false;
    }

    //wyświetlenie czasu w polu tekstowym
    public void updateTimer(){
        int minuty=(int)timeLeftinMilliseconds/ 60000;
        int sekundy=(int) timeLeftinMilliseconds % 60000/1000;

        String czas;
        czas= "" + minuty;
        czas +=":";

        if(sekundy<10) czas+="0";
        czas+=sekundy;

        licznik.setText(czas);

        //jak skończy się czas to przeskskuje do koljnego okna
        if(minuty==0&&sekundy==0)
        {

            Intent info=new Intent(run.this, info.class);
            info.putExtra("info","Skończył się czas");
            startActivity(info);

        }
    }

    //chowanie się panelu
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

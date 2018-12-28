package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button ara;
    public Button hex;
    public Button bin;

    // przejście do wybranego systemu ze zmiennymi
    public void przejscie(){
        ara = (Button)findViewById(R.id.ara);
        ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ot_ar = new Intent (MainActivity.this,reg.class);
                ot_ar.putExtra("mode","1");
                ot_ar.putExtra("level","1");
                startActivity(ot_ar);
            }

        });

        hex =(Button)findViewById(R.id.hex);
        hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ot_hex= new Intent(MainActivity.this, reg.class);
                ot_hex.putExtra("mode","2");
                ot_hex.putExtra("level","1");
                startActivity(ot_hex);
            }

            });

        bin =(Button)findViewById(R.id.bin);
        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ot_bin= new Intent(MainActivity.this,reg.class);
                ot_bin.putExtra("mode","3");
                ot_bin.putExtra("level","1");

                startActivity(ot_bin);
            }

    });

  }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //przejścia do poszczególnych okien
        przejscie();

    }


    // ukrywanie przycisków
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }


    // ukrywanie przycisków u dołu
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

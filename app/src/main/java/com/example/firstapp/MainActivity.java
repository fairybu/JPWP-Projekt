package com.example.firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button sys_arabski;
    public Button sys_rzymski;
    public Button sys_binarny;


    public void sys_ara(){
        sys_arabski= (Button)findViewById(R.id.sys_arabski);
        sys_arabski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ot_ar = new Intent (MainActivity.this,system_arabski_reg1.class);

                startActivity(ot_ar);
            }
        });
    }

    public void sys_rzy(){
        sys_rzymski=(Button)findViewById(R.id.sys_rzymski);
        sys_rzymski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ot_rzy= new Intent(MainActivity.this, system_rzymski_reg1.class);

                startActivity(ot_rzy);
            }
        });

    }

    public void sys_bin(){
        sys_binarny=(Button)findViewById(R.id.sys_binarny);
        sys_binarny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ot_bin= new Intent(MainActivity.this,system_binarny_reg1.class);

                startActivity(ot_bin);
            }
        });
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sys_ara();
        sys_rzy();
        sys_bin();
    }
}
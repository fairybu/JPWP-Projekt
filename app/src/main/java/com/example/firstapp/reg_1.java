package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class reg_1 extends AppCompatActivity {

    public Button powrot;
    public Button dalej;

    //przycisk powrotu do menu głownego
    public void przycisk(){
        powrot=(Button)findViewById(R.id.powrot);
        powrot.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent powrot_menu=new Intent(reg_1.this, MainActivity.class);

                startActivity(powrot_menu);
            }
        }));

        dalej=(Button)findViewById(R.id.dalej);
        dalej.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tryb_m = getIntent().getStringExtra("tryb_m");
                TextView textView = findViewById(R.id.regula1);
                textView.setText(tryb_m);



                Intent dalej_gra=new Intent(reg_1.this, run_1.class);
                dalej_gra.putExtra("tryb",tryb_m);

                startActivity(dalej_gra);
            }
        }));
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
        setContentView(R.layout.activity_reg_1);



        przycisk();
    }
}

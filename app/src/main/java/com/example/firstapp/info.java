package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class info extends AppCompatActivity {

    private TextView komunikat;
    private Button powrot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String tryb_m = getIntent().getStringExtra("tryb");
        String runda_m = getIntent().getStringExtra("runda");
        String info = getIntent().getStringExtra("info");

        int wys = parseInt(info);

        komunikat=(TextView) findViewById(R.id.kom_1);

        if(wys==1){

            komunikat.setText("GRATULACJE UKOŃCZYŁEŚ GRĘ!");

        }else if(wys==2) {

            komunikat.setText("PRZYKRO MI, NASTĘPNYM RAZEM SIĘ UDA!");
        }else {

            komunikat.setText("USTAW LICZBY MALEJĄCO");
        }

    }

    public void powrot(View view){

        powrot=(Button)findViewById(R.id.powrot);
        Intent pow= new Intent(info.this, MainActivity.class);
        startActivity(pow);
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

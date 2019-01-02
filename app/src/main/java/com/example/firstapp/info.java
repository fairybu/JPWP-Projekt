package com.example.firstapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class info extends AppCompatActivity {

    private TextView com;
    private Button back;
    private ImageView smile;
    private ImageView sad;

    MediaPlayer sound_happy;
    MediaPlayer sound_sad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        sound_happy=MediaPlayer.create(info.this,R.raw.happy);
        sound_sad=MediaPlayer.create(info.this,R.raw.sad);


        //pobieranie wartości o przebiegu gry
        String info = getIntent().getStringExtra("info");
        int i = parseInt(info);

        com =(TextView) findViewById(R.id.info);
        smile=(ImageView)findViewById(R.id.smile);
        sad=(ImageView)findViewById(R.id.sad);

        //wyświetlanie tekstu, adekwatnego do przebiegu gry
        if(i==1){

            com.setText("GRATULACJE UKOŃCZYŁEŚ GRĘ!");
            smile.setVisibility(View.VISIBLE);
            sound_happy.start();



        }else{

            com.setText("PRZYKRO MI, NASTĘPNYM RAZEM SIĘ UDA!");
            sad.setVisibility(View.VISIBLE);
            sound_sad.start();
        }

    }

    /*@Override
    protected void onPause() {

        super.onPause();
        sound_happy.release();
        sound_sad.release();

    }*/

    //powrót do manu
    public void powrot(View view){

        back =(Button)findViewById(R.id.back_2);
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

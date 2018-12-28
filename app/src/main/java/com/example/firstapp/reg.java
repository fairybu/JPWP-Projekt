package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class reg extends AppCompatActivity {


    public Button back;
    public Button next;
    public TextView com;

    //go_menu powrotu do menu głownego
    public void back(View view) {
        back = (Button) findViewById(R.id.back_1);

                Intent back_menu = new Intent(reg.this, MainActivity.class); //powrót do menu
                startActivity(back_menu);
    }
    public void next(View view) {

        next =(Button)findViewById(R.id.next);

                // otwieranie kolejnego okna przy przenoszeniu zmiennej dotyczącej trybu gry i pobieranie zmiennych dotyczących poziomu
                Intent next_game=new Intent(reg.this, run.class);

                String mode = getIntent().getStringExtra("mode"); //pobieranie
                String level = getIntent().getStringExtra("level");

                next_game.putExtra("mode",mode); //przekazanie
                next_game.putExtra("level",level);

                startActivity(next_game);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        com =(TextView)  findViewById(R.id.reg);

        //pobieranie wartości dotyczących rundy do sprawdzenia czy przesyłają się poprawnie
        String level = getIntent().getStringExtra("level");

        int r = parseInt(level);

        Log.i("runda0","="+level);


        //ustawienie reguły, w zalezności od poziomu gry
        if(r==1){
            com.setText("USTAW LICZBY ROSNĄCO");
        }else
            com.setText("USTAW LICZBY MALEJĄCO");


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

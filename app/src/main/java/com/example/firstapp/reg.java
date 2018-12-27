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

    public Button powrot;
    public Button dalej;
    public TextView kom;

    //przycisk powrotu do menu głownego
    public void pow(View view) {
        powrot = (Button) findViewById(R.id.powrot);

                Intent powrot_menu = new Intent(reg.this, MainActivity.class);
                startActivity(powrot_menu);
    }
    public void dalej(View view) {

        dalej=(Button)findViewById(R.id.dalej);

                // otwieranie kolejnego okna przy przenoszeniu zmiennej dotyczącej trybu gry
                Intent dalej_gra=new Intent(reg.this, run.class);
                String tryb = getIntent().getStringExtra("tryb");
                String runda = getIntent().getStringExtra("runda");
                dalej_gra.putExtra("tryb",tryb);
                dalej_gra.putExtra("runda",runda);
                startActivity(dalej_gra);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        kom=(TextView)  findViewById(R.id.tresc1);

        String runda = getIntent().getStringExtra("runda");
        String tryb = getIntent().getStringExtra("tryb");
        int run=parseInt(runda);

        Log.i("runda0","="+runda);
        Log.i("tryb0","="+tryb);

        if(run==1){
            kom.setText("USTAW LICZBY ROSNĄCO");
        }else
            kom.setText("USTAW LICZBY MALEJĄCO");


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

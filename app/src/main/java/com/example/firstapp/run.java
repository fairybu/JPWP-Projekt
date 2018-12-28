package com.example.firstapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;


import static java.lang.Integer.parseInt;

public class run extends AppCompatActivity {


    public Button back;

    //przejście do menu głownego
    public void go_menu(View view){
        back =(Button)findViewById(R.id.back_3);

        countDownTimer.cancel(); //wyłączenie zliczania zegara
        Intent back_menu=new Intent(run.this, MainActivity.class);
        startActivity(back_menu);

    }
    //Tablica z przyciskami
    private static final int[] idArray ={R.id.Button_1,R.id.Button_2,R.id.Button_3,
            R.id.Button_4,R.id.Button_5,R.id.Button_6,
            R.id.Button_7,R.id.Button_8,R.id.Button_9,
            R.id.Button_10,R.id.Button_11,R.id.Button_12};


    public Button[] button = new  Button[idArray.length]; //tablica buttonów
    ArrayList list = new ArrayList(); // list dotyczaca uporzadkowanych wartości
    int[] tab =new int[idArray.length]; //tablica wartoci
    int level; //zmienna przechowująca poziom gry
    int mode;  //zmienna przechowująca tryb gry

    int i;   //zmienna pomocnicza
    int count_but =0; //zmienna dotycząca ilości kliknięć


    //zmienne do licznnika
    private TextView timer; // pole tekstowe do czasu
    public CountDownTimer countDownTimer;
    public long timeLeftinMilliseconds=181000; //zmienna dotycząca czasu trwania rozgrywki
    public  boolean TimeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        String mo = getIntent().getStringExtra("mode");//pobieram info jaki tryb gry wybrano
        String lev = getIntent().getStringExtra("level");

        int m = parseInt(mo); //zamiana stringa mo na intigera bo inaczej nie chciało dziłać

        mode = m;

        int l = parseInt(lev);

        level = l;

        timer = findViewById(R.id.timer); 

        StartStop();// wywołanie funkcji licznika

        int range; //zmienna przechowująca warość zakresu licz jakie mają się losować

        if(mode ==1 || mode ==2) range=20;
        else range=15;

        //pętla przyppisująca wartość dla każdego z buttonów
        for (i = 0; i < idArray.length; i++) {

            button[i] = (Button) findViewById(idArray[i]);

            //przypisanie liczb do tablicy (bez powtórzeń)
            tab[i]= (int)Math.floor(Math.random()*range);
            for (int j=0;j<i;j++){
                if(tab[i]==tab[j]){
                    tab[i]=(int)Math.floor(Math.random()*range);
                    j=0;
                }
            }

            list.add(tab[i]); //przyisanie wartości do listy

            //przypisanie wartości z tablicy do buttonów w odpowiedni sposoób(w zależności od trybu gry)
            if (mode == 1) button[i].setText(Integer.toString(tab[i]));
            else if (mode == 2) {
                String results= Integer.toHexString(tab[i]);
                if(results.length()==2) button[i].setText("000000"+results);
                else button[i].setText("0000000"+results);

            }
            else {
                String results=Integer.toBinaryString(tab[i]);
                if(results.length()==1) button[i].setText("000"+results);
                else if(results.length()==2) button[i].setText("00"+results);
                else if(results.length()==3) button[i].setText("0"+results);
                else button[i].setText(results);

            }


        }




    }

    public void action(View view){

        String mode = getIntent().getStringExtra("mode");//pobieram info jaki tryb gry wybrano

        back =(Button)findViewById(R.id.back_3);
        int k = 0; //zmienna pomocnicza 

        //pętla sprawdzająca, który go_menu został wciśnięty
        for(i=0;i<idArray.length;i++){

            button[i]=(Button) findViewById(idArray[i]);

            if(view.getId()== button[i].getId()){
                
                k=i; //pobieranie indeksu 
            }
        }

        Collections.sort(list); // sortowanie listy od min do max

        //warunki w zależności od poziomu gry
        if(level ==1) {
            
            //jeśli wartość wciśniętego buttona odpowiada kolejnemu elementowi z listy to w zależnośći od ilości kliknięć
            if (list.get(count_but).equals(tab[k])) {
                
                //przensi nas do kolejnego levelu
                if (count_but == 11) {
                    
                    count_but = 0;
                    countDownTimer.cancel();
                    Intent info = new Intent(run.this, reg.class);
                    info.putExtra("level", "2"); //przenoszzenie zmiennych do kolejnego okna
                    info.putExtra("mode",mode);
                    startActivity(info);

                //zwiększany zostaje licznik
                } else {
                    count_but = count_but + 1;
                    button[k].setBackgroundColor(Color.GRAY); //zmiana koloru buttony gdy poprawnie został wciśnięty 
                    button[k].setText(":)");
                }
            } else { //jeśli źle wcisnęliśmy button to przechodzimy do okna z informacją 

                button[k].setBackgroundColor(Color.RED); 
                button[k].setText(":(");
                countDownTimer.cancel();
                Intent info = new Intent(run.this, info.class);
                info.putExtra("info", "2");
                startActivity(info);
            }



        }else{ //reguła dla poziomu 2 
            
            Collections.sort(list,Collections.reverseOrder()); //posortowanie listy od max do min
            //Log.i("list","="+ list);
            //Log.i("LICZNIK_BUTT", "=" + count_but); //sprawdzenie czy poprawnie się wykonuje 

            if (list.get(count_but).equals(tab[k])) { //sprawdzenie poprawności 

                if (count_but == 11) { //jeśli poprawnie wykonaliśmy zadanie to przenosi nas do okna z informacją 
                        
                    Intent info = new Intent(run.this, info.class);
                    info.putExtra("info", "1");
                    startActivity(info);


                } else {
                    //zwiększanie licznika 
                    count_but = count_but + 1;
                    button[k].setBackgroundColor(Color.GRAY);
                    button[k].setText(":)");
                }
            } else {

                button[k].setBackgroundColor(Color.RED);
                button[k].setText(":(");
                countDownTimer.cancel();
                Intent info = new Intent(run.this, info.class);
                info.putExtra("info", "2");
                startActivity(info);
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

        timer.setText(czas);

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

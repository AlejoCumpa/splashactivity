package com.android.espanol.actividadsplash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SplashActivity extends Activity {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_splash);
	        Thread splashThread = new Thread() { //creamos un hilo que permita cerrar la actividad
		         @Override
		         public void run() {
		            try {
		               int waited = 0;
		               while (waited < 3000) {  //creamos un temporizador para que la splash activity permanezca un tiempo (3s en este ejemplo)
		                  sleep(100);
		                  waited += 100;
		               }
		            } catch (InterruptedException e) {
		               // do nothings
		            } finally {
		               finish(); //cerramos esta actividad de splash
		               Intent i = new Intent(getApplicationContext(),MainActivity.class); //creamos el intent de la actividad principal
		               startActivity(i); //iniciamos la actividad principal
		            }
		         }
		      };

	//una vez que creamos el hilo...
		      splashThread.start();	 //hacemos que inicie su actividad
    }
}

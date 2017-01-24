package com.tcu.esteban.cuestionarios;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityPregunta extends AppCompatActivity {
    private static int numeroPregunta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView textView = (TextView) findViewById(R.id.toolbar_title);
        textView.setText("Pregunta");

        //Se cargan la materia, el tema y la dificultad, para asi saber cuales preguntas se deben importar
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int materia = extras.getInt("MATERIA");
        int tema = extras.getInt("TEMA");
        int dificultad = extras.getInt("DIFICULTAD");

        TextView nombreMateria = (TextView) findViewById(R.id.textView2);

        String m = "",d = "",t="";

        //Cada tema es representado por un numero, el cual se guardo en el intent, en las pantalla trasanterior
        switch(tema) {
            case 0:
                t = "Tema 1";
                break;
            case 1:
                t = "Tema 2";
                break;
            case 2:
                t = "Tema 3";
                break;
        }

        //Cada materia es representada por un numero, el cual se guardo en el intent, en la pantalla anterior
        switch(materia) {
            case 0:
                m = "Física";
                break;
            case 1:
                m = "Química";
                break;
            case 2:
                m = "Biología";
                break;
        }

        //La dificultad es representada por un numero, el cual se guardo en el intent, en la pantalla anterior
        switch(dificultad) {
            case 0:
                d = "Básico";
                break;
            case 1:
                d = "Intermedio";
                break;
            case 2:
                d = "Avanzado";
                break;
        }

        //Esto es temporal, para saber cual pregunta se debe cargar, segun materia, tema y dificultad
        nombreMateria.setText("Pregunta " + t + " " + m + " " + d);

        Button mResp1 = (Button) findViewById(R.id.button);
        Button mResp2 = (Button) findViewById(R.id.button2);
        Button mResp3 = (Button) findViewById(R.id.button3);
        Button mResp4 = (Button) findViewById(R.id.button4);

        mResp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Implementar

            }
        });

        mResp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Implementar

            }
        });

        mResp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Implementar

            }
        });

        mResp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Implementar

            }
        });
    }

    public void goToVAS(View view) {
        goToURL("http://accionsocial.ucr.ac.cr");

    }

    public void goToUCR(View view) {
        goToURL("https://www.ucr.ac.cr");

    }

    //Lleva a la pagina web correspondiente, al hacer click en la imagen ya sea del VAS o de la UCR. Se invoca desde el xml
    private void goToURL(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}

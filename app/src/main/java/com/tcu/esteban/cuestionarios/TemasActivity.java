package com.tcu.esteban.cuestionarios;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TemasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int materia = extras.getInt("MATERIA");

        ImageButton mTema1 = (ImageButton) findViewById(R.id.imageButton);
        ImageButton mTema2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton mTema3 = (ImageButton) findViewById(R.id.imageButton3);

        //Dependiendo de la materia seleccionada, carga las imagenes correspondientes
        switch(materia) {
            case 0:
                mTema1.setBackgroundResource(R.drawable.tf1);
                mTema2.setBackgroundResource(R.drawable.tf2);
                mTema3.setBackgroundResource(R.drawable.tf3);
                break;
            case 1:
                mTema1.setBackgroundResource(R.drawable.tq1);
                mTema2.setBackgroundResource(R.drawable.tq2);
                mTema3.setBackgroundResource(R.drawable.tq3);
                break;
            case 2:
                mTema1.setBackgroundResource(R.drawable.tb1);
                mTema2.setBackgroundResource(R.drawable.tb2);
                mTema3.setBackgroundResource(R.drawable.tb3);
                break;
        }

        final int[] tema = new int[1];

        //Guarda el tema seleccionado, representado por un entero
        mTema1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tema[0] = 0;
                createDialog(tema);

            }
        });

        mTema2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tema[0] = 1;
                createDialog(tema);

            }
        });

        mTema3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tema[0] = 2;
                createDialog(tema);
            }

        });
    }

    /*
    Crea un pop-up para seleccionar la dificultad del cuestionario.
    Devuelve 0 si es Básico, 1 si es Intermedio o 2 si es Avanzado
     */
    public void createDialog(final int[] tema) {

        //final int[] seleccion = new int[1];
        final String[] items = {"Básico", "Intermedio", "Avanzado"};

        AlertDialog.Builder builder =
                new AlertDialog.Builder(TemasActivity.this);

        builder.setTitle("Dificultad")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Log.i("Dialogos", "Opción elegida: " + items[item]);
                        iniciarCuestionario(tema[0], item);
                    }
                });

        builder.create();
        builder.show();
    }

    public void iniciarCuestionario(int tema, int dificultad) {
        Intent intent = new Intent(TemasActivity.this, ActivityPregunta.class);
        intent.putExtra("TEMA", tema);
        intent.putExtra("DIFICULTAD", dificultad);
        TemasActivity.this.startActivity(intent);
    }

    public void goToVAS(View view) {
        goToURL("http://accionsocial.ucr.ac.cr");

    }

    public void goToUCR(View view) {
        goToURL("https://www.ucr.ac.cr");

    }

    private void goToURL(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}

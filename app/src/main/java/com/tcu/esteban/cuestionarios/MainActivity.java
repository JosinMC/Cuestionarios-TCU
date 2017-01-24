package com.tcu.esteban.cuestionarios;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton mFisica = (ImageButton) findViewById(R.id.imageButtonFisica);
        ImageButton mQuimica = (ImageButton) findViewById(R.id.imageButtonQuimica);
        ImageButton mBiologia = (ImageButton) findViewById(R.id.imageButtonBiologia);

        final int seleccion[] = new int[1];
        final int[] materia = new int[1];

        //Cuando se selecciona fisica, se indica con 0 en la materia
        mFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materia[0] = 0;
                Intent intent = new Intent(MainActivity.this, TemasActivity.class);
                intent.putExtra("MATERIA", materia[0]);
                MainActivity.this.startActivity(intent);

                //createDialog(materia);

            }
        });

        //Cuando se selecciona quimica, se indica con 1 en la materia
        mQuimica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materia[0] = 1;
                Intent intent = new Intent(MainActivity.this, TemasActivity.class);
                intent.putExtra("MATERIA", materia[0]);
                MainActivity.this.startActivity(intent);

                //createDialog(materia);

            }
        });

        //Cuando se selecciona biologia, se indica con 2 en la materia
        mBiologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materia[0] = 2;
                Intent intent = new Intent(MainActivity.this, TemasActivity.class);
                intent.putExtra("MATERIA", materia[0]);
                MainActivity.this.startActivity(intent);

                //createDialog(materia);
            }

        });

    }

    /*
    Crea un pop-up para seleccionar la dificultad del cuestionario.
    Devueve o si es Básico, 1 si es Intermedio o 2 si es Avanzado
     */

    public void createDialog(final int[] materia) {

        //final int[] seleccion = new int[1];
        final String[] items = {"Básico", "Intermedio", "Avanzado"};

        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Dificultad")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Log.i("Dialogos", "Opción elegida: " + items[item]);
                        iniciarCuestionario(materia[0], item);
                    }
                });

        builder.create();
        builder.show();
    }

    public void iniciarCuestionario(int materia, int dificultad) {
        Intent intent = new Intent(MainActivity.this, ActivityPregunta.class);
        intent.putExtra("MATERIA", materia);
        intent.putExtra("DIFICULTAD", dificultad);
        MainActivity.this.startActivity(intent);
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

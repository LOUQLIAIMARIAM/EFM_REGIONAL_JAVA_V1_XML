package com.example.efm_regional_java_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText poidsEditText;
    private EditText tailleEditText;
    private Button calculerButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poidsEditText = findViewById(R.id.poidsEditText);
        tailleEditText = findViewById(R.id.tailleEditText);
        calculerButton = findViewById(R.id.calculerButton);

        calculerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer le poids et la taille entrés par l'utilisateur
                double poids = Double.parseDouble(poidsEditText.getText().toString());
                double taille = Double.parseDouble(tailleEditText.getText().toString());

                // Calculer l'IMC
                double imc = poids / (taille * taille);

                // Déterminer l'état de la personne en fonction de l'IMC
                String etat;
                if (imc < 18.5) {
                    etat = "Maigreur";
                } else if (imc < 25) {
                    etat = "Normale";
                } else if (imc < 40) {
                    etat = "Surpoids";
                } else {
                    etat = "Obésité";
                }

                // Afficher l'IMC et l'état dans un Toast
                String message = "Votre IMC est " + String.format("%.2f", imc) + " (" + etat + ")";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
    }

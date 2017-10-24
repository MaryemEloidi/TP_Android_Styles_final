package com.example.tp_styles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textView = (TextView) findViewById(R.id.textView);
        String dataNom = getIntent().getExtras().getString("Nom");
        String dataPrenom = getIntent().getExtras().getString("Prenom");

        textView.setText("Welcome "+dataPrenom+" "+dataNom+ " :) ");

    }
}

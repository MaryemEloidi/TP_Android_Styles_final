package com.example.tp_styles;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtPrenom;
    EditText edtNom;
    Button btnValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPrenom = (EditText) findViewById(R.id.edtprenom);
        edtNom = (EditText) findViewById(R.id.edtnom);
        btnValider = (Button) findViewById(R.id.btn1);

       edtPrenom.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edtPrenom.getWindowToken(), 0);
                }
                return false;
            }
        });
        edtNom.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edtNom.getWindowToken(), 0);
                }
                return false;
            }
        });
        btnValider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    public void login(){
            btnValider.setEnabled(false);

       final ProgressDialog p = new ProgressDialog(MainActivity.this, R.style.Theme_Custom_dialog);
        //final ProgressDialog p = new ProgressDialog(MainActivity.this, R.style.Theme_AppCompat);
        p.setIndeterminate(true);
            p.setMessage("Chargement ...");
            p.show();
            String nom = edtNom.getText().toString();
            String prenom = edtPrenom.getText().toString();
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {

                            chargementReussi();

                            p.dismiss();
                        }
                    }, 6000);

    }
    public void chargementReussi(){
        Intent it = new Intent(MainActivity.this, WelcomeActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        it.putExtra("Nom",edtNom.getText().toString());
        it.putExtra("Prenom",edtPrenom.getText().toString());

        startActivity(it);
    }
    public String getNom(){
        return edtNom.getText().toString();
    }
}

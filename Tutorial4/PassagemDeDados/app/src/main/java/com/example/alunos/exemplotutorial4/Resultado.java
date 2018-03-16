package com.example.alunos.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();

        String nome = pacote.getString("nome");
        TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
        txtResultado.setText(String.format("Olá, %S!", nome));s
    }
}
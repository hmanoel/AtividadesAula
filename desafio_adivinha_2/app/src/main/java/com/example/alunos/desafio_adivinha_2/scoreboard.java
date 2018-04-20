package com.example.alunos.desafio_adivinha_2;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

public class scoreboard extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();

        String number_5 = pacote.getString("number_1");
        String number_4 = pacote.getString("number_2");
        String number_3 = pacote.getString("number_3");
        String number_2 = pacote.getString("number_4");
        String number_1 = pacote.getString("number_5");
        TextView result_1 = (TextView) findViewById(R.id.number_5);
        TextView result_2 = (TextView) findViewById(R.id.number_4);
        TextView result_3 = (TextView) findViewById(R.id.number_3);
        TextView result_4 = (TextView) findViewById(R.id.number_2);
        TextView result_5 = (TextView) findViewById(R.id.number_1);
        result_1.setText(number_5);
        result_2.setText(number_4);
        result_3.setText(number_3);
        result_4.setText(number_2);
        result_5.setText(number_1);

    }
    
}

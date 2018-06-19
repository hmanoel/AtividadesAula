package com.example.alunos.scrollview;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.LayoutInflater;

import android.widget.LinearLayout;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {

        super.onCreate(icicle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_main);

        LinearLayout desing = findViewById(R.id.layout1);

        for (int aux = 0; aux < 100; aux++){

            LayoutInflater inflater = LayoutInflater.from(this);

            TextView text = (TextView) inflater.inflate(R.layout.inflate_textview, desing, false);

            text.setText("Texto: " + aux);

            desing.addView(text);

        }
        TextView text = new TextView();

        text.setText("Texto do rótulo");

        text.setTextColor(getResources().getColor(R.color.textoDestacado));

        text.setTextAppearance(this,R.style.estiloExemplo);
    }
}

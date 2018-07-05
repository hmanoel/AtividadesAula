package com.example.alunos.linearlayout;

import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;

import android.text.Layout;

import android.view.Gravity;

import android.widget.Button;

import android.widget.EditText;

import android.widget.LinearLayout;

import android.widget.LinearLayout.LayoutParams;

import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {

        super.onCreate(icicle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout design = new LinearLayout(this);

        design.setPadding(10,10,10,10);

        design.setOrientation(LinearLayout.VERTICAL);

        design.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        design.setPadding(10,10,10,10);

        TextView name = new TextView(this);

        name.setText("Nome:");

        name.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        design.addView(name);

        EditText aux_name = new EditText(this);

        aux_name.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        design.addView(aux_name);

        aux_name.requestFocus();

        TextView password = new TextView(this);

        password.setText("Senha:");

        password.setLayoutParams( new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        design.addView(password);

        EditText aux_password = new EditText(this);

        aux_password.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        design.addView(aux_password);

        Button top = new Button(this);

        top.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        top.setGravity(Gravity.CENTER);

        top.setText("TOP TOP");

        design.addView(top);

        setContentView(design);
    }
}

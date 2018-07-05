package com.example.alunos.tablelayout;

import android.widget.EditText;

import android.widget.TableLayout;

import android.widget.TableLayout.LayoutParams;

import android.widget.TableRow;

import android.widget.TextView;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.text.method.PasswordTransformationMethod;

import android.view.Gravity;

import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {

        super.onCreate(icicle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TableLayout table = new TableLayout(this);

        table.setPadding(10, 10, 10, 10);

        table.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

        table.setColumnStretchable(1, true);

        TableRow line_1 = new TableRow(this);

        TextView name = new TextView(this);

        name.setText("Nome:");

        line_1.addView(name);

        EditText aux_name = new EditText(this);

        aux_name.requestFocus();

        line_1.addView(aux_name);

        TableRow line_2 = new TableRow(this);

        TextView password = new TextView(this);

        password.setText("Senha:");

        line_2.addView(password);

        EditText aux_password = new EditText(this);

        aux_password.setTransformationMethod(
                new PasswordTransformationMethod());

        line_2.addView(aux_password);

        TableRow line_3 = new TableRow(this);

        line_3.setGravity(Gravity.RIGHT);

        Button ok = new Button(this);

        ok.setText("Login");

        line_3.addView(ok);

        table.addView(line_1);

        table.addView(line_2);

        table.addView(line_3);

        setContentView(table);

    }

}



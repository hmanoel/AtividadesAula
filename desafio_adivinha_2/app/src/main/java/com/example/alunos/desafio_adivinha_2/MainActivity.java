package com.example.alunos.desafio_adivinha_2;

import android.content.Context;

import android.content.Intent;

import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;

import android.util.Log;

import android.view.View;

import android.widget.TextView;

import android.widget.EditText;

import java.util.Random;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    Random rand = new Random();
    private int x = rand.nextInt(999) + 1;
    private int attempt = 0;
    private String number_5 = "";
    private String number_4 = "";
    private String number_3 = "";
    private String number_2 = "";
    private String number_1 = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView visu_2 = (TextView) findViewById(R.id.rtl_1);
        String number_user = Integer.toString(attempt);
        visu_2.setText(number_user);
        TextView visu = (TextView) findViewById(R.id.textView);
        visu.setText(getResources().getString(R.string.play));
        SharedPreferences aux_2 = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor publisher = aux_2.edit();
        publisher.putString("number_1", number_1);
        publisher.putString("number_2", number_2);
        publisher.putString("number_3", number_3);
        publisher.putString("number_4", number_4);
        publisher.putString("number_5", number_5);
        publisher.commit();
        
    }
    
    public void restart(View v)
    {
    
        x = rand.nextInt(999) + 1;
        attempt = 0;
        TextView visu_2 = (TextView) findViewById(R.id.rtl_1);
        String number_user = Integer.toString(attempt);
        visu_2.setText(number_user);
        TextView visu = (TextView) findViewById(R.id.rtl_2);
        visu.setText(getResources().getString(R.string.play));
        EditText text = findViewById(R.id.editText);
        text.setText("");
        Button button = (Button) findViewById(R.id.btn);
        button.setEnabled(true);
        
    }
    
    public void scoreboard(View v)
    {
    
        SharedPreferences aux_2 = getPreferences(Context.MODE_PRIVATE);
        String number_5 = aux_2.getString("number_5", "nothing...");
        String number_4 = aux_2.getString("number_4", "Nothing...");
        String number_3 = aux_2.getString("number_3", "Nothing...");
        String number_2 = aux_2.getString("number_2", "Nothing...");
        String number_1 = aux_2.getString("number_1", "Nothing...");
        Log.i("number_5: ", number_5);
        Log.i("number_4: ", number_4);
        Log.i("number_3: ", number_3);
        Log.i("number_2: ", number_2);
        Log.i("number_1: ", number_1);
        Intent aux_1 = new Intent(MainActivity.this, scoreboard.class);
        Bundle bundle = new Bundle();
        bundle.putString("number_5", number_5);
        bundle.putString("number_4", number_4);
        bundle.putString("number_3", number_3);
        bundle.putString("number_2", number_2);
        bundle.putString("number_1", number_1);
        aux_1.putExtras(bundle);
        startActivity(aux_1);
        
    }
    
    public void play(View v)
    {
    
        EditText text = findViewById(R.id.editText);
        String value = text.getText().toString();
        int number = Integer.parseInt(value);
        
        if (!(number == x))
        {
        
            attempt++;
            TextView view3 = (TextView) findViewById(R.id.rtl_2);
            
            if(!(number > x))
            {
            
                view3.setText(getResources().getString(R.string.larger));
                
            }
            else if(!(number < x))
            {
            
                view3.setText(getResources().getString(R.string.less));
                
            }
            
            String number_user = Integer.toString(attempt);
            TextView view2 = (TextView) findViewById(R.id.rtl_1);
            view2.setText(number_user);
            
        }
        else
        {
        
            TextView view = (TextView) findViewById(R.id.rtl_2);
            view.setText(getResources().getString(R.string.won));
            Button button = (Button) findViewById(R.id.btn);
            button.setEnabled(false);
            x = 0;
            SharedPreferences aux_2 = getPreferences(Context.MODE_PRIVATE);
            String attempt_1 = Integer.toString(attempt);

            if (attempt_1.matches(""))
            {
            
                Toast toast = Toast.makeText(MainActivity.this,
                        "Insira um número...", Toast.LENGTH_SHORT);
                toast.show();
                return;
                
            }
            
            number_1 = aux_2.getString("number_1", "Nothing...");
            number_2 = aux_2.getString("number_2", "Nothing...");
            number_3 = aux_2.getString("number_3", "Nothing...");
            number_4 = aux_2.getString("number_4", "Nothing...");
            number_5 = aux_2.getString("number_5", "Nothing...");
            number_1 = number_2;
            number_2 = number_3;
            number_3 = number_4;
            number_4 = number_5;
            number_5 = attempt_1;
            attempt = 0;
            SharedPreferences.Editor publisher = aux_2.edit();
            publisher.putString("number_1", number_1);
            publisher.putString("number_2", number_2);
            publisher.putString("number_3", number_3);
            publisher.putString("number_4", number_4);
            publisher.putString("number_5", number_5);
            publisher.commit();
            
        }
        
    }
    
}

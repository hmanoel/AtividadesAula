package com.example.alunos.desafio_adivinha_1;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;

import java.util.Random;

import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    Random generate = new Random();
    int number_generated = generate.nextInt(11), aux = 3;


    public void play(View v)
    {

        TextView msg = (TextView) findViewById(R.id.rtl_text);
        EditText number = findViewById(R.id.number);
        String gamer = number.getText().toString();
        int aux_number;
        aux_number = Integer.parseInt(gamer);
        String message;

        if(!(aux > 0))
        {

            message = "Você perdeu!";
            msg.setText(message);

        }
        else
        {

            if(!(aux_number == number_generated))
            {

                --aux;
                if(!(aux == 0))
                {

                    message = "Você errou! " + aux + " chance(s)";
                    msg.setText(message);

                }
                else
                {

                    message = "Você perdeu ! A resposta certa era " + number_generated;
                    msg.setText(message);

                }

            }
            else
            {

                message = "Finalmente !";
                msg.setText(message);
                aux = 0;

            }

        }

    }

    public void new_game(View v)
    {

        aux = 3;
        number_generated = generate.nextInt(11);
        TextView msg = (TextView) findViewById(R.id.rtl_text);
        String message;
        message = "Informe um número entre 0 e 10:";
        msg.setText(message);

    }
}

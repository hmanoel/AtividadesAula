package com.example.alunos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Random gerador = new Random();
    int num_aleatorio = gerador.nextInt(11), c = 3;


    public void joga(View v){
        TextView mensagem = (TextView) findViewById(R.id.id);
        EditText cxeNum = findViewById(R.id.cxeNum);
        String usuario = cxeNum.getText().toString();
        int num;
        num = Integer.parseInt(usuario);
        String msg;
        if(c>0){
            if(num == num_aleatorio){
                msg = "Parabéns! Você acertou! ";
                mensagem.setText(msg);
                c = 0;
            } else {
                --c;
                if(c == 0){
                    msg = "Você perdeu! O número era " + num_aleatorio + " ";
                    mensagem.setText(msg);
                } else {
                    msg = "Você errou! Ainda tem " + c + " chance(s)";
                    mensagem.setText(msg);
                }

            }
        } else {
            msg = "Suas chances acabaram!";
            mensagem.setText(msg);
        }

    }

    public void deNovo(View v){
        c = 3;
        num_aleatorio = gerador.nextInt(11);
        TextView mensagem = (TextView) findViewById(R.id.id);
        String msg;
        msg = "Informe um número entre 0 e 10:";
        mensagem.setText(msg);
    }
}

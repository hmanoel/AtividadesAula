package com.example.alunos.listadinamica;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;

import android.widget.EditText;

import android.widget.Toast;

import com.example.alunos.listadinamica.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

   private ArrayList<Pessoa> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void show_list(View v)
    {

        Intent it = new Intent(this, Show_list.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos", list);
        it.putExtras(bundle);
        startActivity(it);

    }

    public void addiction(View v)
    {

        EditText name = findViewById(R.id.cxe_name);
        EditText fone = findViewById(R.id.cxe_fone);
        String user_name = name.getText().toString();
        String user_fone = fone.getText().toString();

        if(user_name.matches(""))
        {

            Toast toast = Toast.makeText(getApplicationContext(), "Digite o nome...", Toast.LENGTH_SHORT);
            toast.show();
            return;

        }

        if(user_fone.matches(""))
        {

            Toast toast = Toast.makeText(getApplicationContext(), "Digite o telefone...", Toast.LENGTH_SHORT);
            toast.show();
            return;

        }

        list.add(new Pessoa(user_name, user_fone, R.mipmap.ic_launcher_foreground));
        this.clear(v);

    }
    public void clear(View v)
    {

        EditText name = findViewById(R.id.cxe_name);
        EditText fone = findViewById(R.id.cxe_fone);
        name.setText("");
        fone.setText("");

    }
}

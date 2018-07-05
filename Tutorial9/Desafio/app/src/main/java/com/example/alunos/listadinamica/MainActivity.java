package com.example.alunos.listadinamica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.alunos.listadinamica.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarLista(View v){
        Intent it = new Intent(this, mostraListaDinamica.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos", lista);
        it.putExtras(bundle);
        startActivity(it);
    }

    public void salvar(View v){
        EditText nome = findViewById(R.id.nome);
        EditText telefone = findViewById(R.id.telefone);
        String contatoNome = nome.getText().toString();
        String contatoTelefone = telefone.getText().toString();
        lista.add(new Pessoa (contatoNome, contatoTelefone, R.mipmap.ic_launcher_round));
    }
}

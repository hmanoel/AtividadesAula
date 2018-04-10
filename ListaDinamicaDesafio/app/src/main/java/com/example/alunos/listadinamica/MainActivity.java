package com.example.alunos.listadinamica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alunos.listadinamica.model.Pessoa;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   private ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void mostrarLista(View v){
        Intent it = new Intent(this, mostrarListaDinamica.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos", lista);
        it.putExtras(bundle);
        startActivity(it);
    }

    public void addContatos(View v){
        EditText nome = findViewById(R.id.cxe_nome);
        EditText telefone = findViewById(R.id.cxe_telefone);

        String oNome = nome.getText().toString();
        String oTelefone = telefone.getText().toString();

        if(oNome.matches("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Digite um nome...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if(oTelefone.matches("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Digite um telefone...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        lista.add(new Pessoa(oNome, oTelefone, R.mipmap.ic_launcher_foreground));
        this.limpa(v);

    }
    public void limpa(View v){
        EditText nome = findViewById(R.id.cxe_nome);
        EditText telefone = findViewById(R.id.cxe_telefone);
        nome.setText("");
        telefone.setText("");
    }
}

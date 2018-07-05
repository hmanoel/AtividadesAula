package com.example.alunos.desafio10;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView nome;
    private TextView sobrenome;
    private TextView email;
    private TextView endereco;
    private TextView cidade;
    private TextView estado;
    private TextView username;
    private TextView senha;
    private TextView nascimento;
    private TextView telefone;
    private ImageView foto;
    private ProgressBar load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetJson download = new GetJson();
        load = (ProgressBar) findViewById(R.id.progressBar);
        nome = (TextView) findViewById(R.id.txtNome);
        sobrenome = (TextView) findViewById(R.id.txtSobrenome);
        email = (TextView) findViewById(R.id.txtEmail);
        endereco = (TextView) findViewById(R.id.txtEndereco);
        cidade = (TextView) findViewById(R.id.txtCidade);
        estado = (TextView) findViewById(R.id.txtEstado);
        username = (TextView) findViewById(R.id.txtUsername);
        senha = (TextView) findViewById(R.id.txtSenha);
        nascimento = (TextView) findViewById(R.id.txtNasc);
        telefone = (TextView) findViewById(R.id.txtTel);
        foto = (ImageView)findViewById(R.id.imageView);
        download.execute();
    }

    protected void atualizar(){
        GetJson download = new GetJson();
        download.execute();
    }

    private class GetJson extends AsyncTask<Void, Void, FakeUser> {
        @Override
        protected void onPreExecute(){
            load.setVisibility(View.VISIBLE);
        }
        @Override
        protected FakeUser doInBackground(Void... params){
            Utils util = new Utils();
            return util.getInformacao("https://randmuser.me/api/0.7");
        }
        @Override
        protected void onPostExecute(FakeUser pessoa){
            String strNome = pessoa.getNome().substring(0, 1).toUpperCase() + pessoa.getNome().substring(1);
            nome.setText(strNome);
            String strSobrenome = pessoa.getSobrenome().substring(0, 1) + pessoa.getSobrenome().substring(1);
            sobrenome.setText(strSobrenome);
            email.setText(pessoa.getEmail());
            endereco.setText(pessoa.getEndereco());
            String strCidade = pessoa.getCidade().substring(0, 1) + pessoa.getCidade().substring(1);
            cidade.setText(strCidade);
            estado.setText(pessoa.getEstado());
            username.setText(pessoa.getUsername());
            senha.setText(pessoa.getSenha());
            nascimento.setText(pessoa.getNascimento());
            telefone.setText(pessoa.getTelefone());
            foto.setImageBitmap(pessoa.getFoto());
            load.setVisibility(View.GONE);
        }
    }
}


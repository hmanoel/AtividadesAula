package com.example.alunos.listadinamica.adapter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.alunos.listadinamica.R;
import com.example.alunos.listadinamica.model.Pessoa;

import java.util.List;

public class PessoaAdapter extends BaseAdapter{
    private Activity atividade;
    private List<Pessoa> lista;

    public PessoaAdapter(Activity atividade, List<Pessoa> lista){
        this.atividade = atividade;
        this.lista = lista;
    }

    @Override
    public int getCount(){
        return lista.size();
    }

    @Override
    public Object getItem(int position){
        return lista.get(position);
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Pessoa obj = lista.get(position);
        View v = atividade.getLayoutInflater().inflate(R.layout.row_layout, parent, false);
        TextView textNome = v.findViewById(R.id.lbl_nome);
        textNome.setText(obj.getNome());
        TextView textTelefone = v.findViewById(R.id.lbl_telefone);
        textTelefone.setText(obj.getTelefone());
        ImageView imgImagem = v.findViewById(R.id.imageView);
        imgImagem.setImageResource(obj.getImagem());

        return v;
    }
}

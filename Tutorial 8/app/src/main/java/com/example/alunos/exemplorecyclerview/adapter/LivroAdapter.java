package com.example.alunos.exemplorecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alunos.exemplorecyclerview.R;
import com.example.alunos.exemplorecyclerview.model.Livro;

import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter{
    private List<Livro> list;
    private Context text;

    public LivroAdapter(List<Livro> l, Context c){
        this.list = l;
        this.text = c;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(text)
                .inflate(R.layout.view_list, parent, false);
        return new LivroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder, int position){
        LivroViewHolder theHolder = (LivroViewHolder) holder;
        Livro book = list.get(position);
        theHolder.title.setText(book.getTitulo());
        theHolder.actor.setText(book.getAutor());
        theHolder.description.setText(book.getDescricao());
    }

    @Override
    public int getItemCount(){
        return list.size();
    }
}


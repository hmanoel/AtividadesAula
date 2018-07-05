package com.example.alunos.exemplorecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alunos.exemplorecyclerview.R;


public class LivroViewHolder extends RecyclerView.ViewHolder {
    final TextView title;
    final TextView actor;
    final TextView description;

    public LivroViewHolder(View itemView){
        super(itemView);
        title = itemView.findViewById(R.id.txtTitle);
        actor = itemView.findViewById(R.id.txtActor);
        description = itemView.findViewById(R.id.txtDescription);
    }
}



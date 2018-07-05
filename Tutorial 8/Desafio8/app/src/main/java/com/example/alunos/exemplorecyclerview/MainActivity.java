package com.example.alunos.exemplorecyclerview;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;

import com.example.alunos.exemplorecyclerview.adapter.LivroAdapter;

import com.example.alunos.exemplorecyclerview.model.Livro;

import java.util.ArrayList;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ArrayList<Livro> list_book;

    RecyclerView view;

    @Override

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        view = findViewById(R.id.recyclerView);

        list_book = new ArrayList<>();

        list_book.add(new Livro ("The 48 Laws of Power", "Robert Greene",
                "The 48 Laws of Power vendereu mais de 1,2 milhão de cópias nos Estados Unidos e foram traduzidas para 24 idiomas. "));

        view.setAdapter(new LivroAdapter(list_book, this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        view.setLayoutManager(layout);

    }

}

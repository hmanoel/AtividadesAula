package com.example.alunos.androidtoolbar;

import android.os.Bundle;

import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

public class AddItemsFragment extends Fragment {

    @Nullable

    @Override

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup contrainer, Bundle savedInstanceState){

        View aux = inflater.inflate(R.layout.fragment_adicionar,
                contrainer, false);

        return aux;

    }

}

package com.example.joffr.eajpraver;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joffr on 18/10/2017.
 */

public class PontoInteresse extends Fragment{

    private List<Setor> listaSetor = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ponto_interesse, container, false);
        //logica do fragment

        final RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.RecViewPontos);
        CarregaSetores();

        LocaisAdapter locaisAdapter = new LocaisAdapter(getContext(), listaSetor);
        recyclerView.setAdapter(locaisAdapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        return view;
    }

    private void CarregaSetores() {
        Setor s1 = new Setor();
        s1.setNome("Informatica");
        s1.setId(1);
        s1.setFoto(R.drawable.informatica);
        listaSetor.add(s1);
        Setor s2 = new Setor();
        s2.setNome("Ensino Medio");
        s2.setId(2);
        s2.setFoto(R.drawable.medio);
        listaSetor.add(s2);
        Setor s3 = new Setor();
        s3.setNome("CVT");
        s3.setId(3);
        s3.setFoto(R.drawable.cvt);
        listaSetor.add(s3);
        Setor s4 = new Setor();
        s4.setNome("Biblioteca");
        s4.setId(4);
        s4.setFoto(R.drawable.biblioteca);
        listaSetor.add(s4);
        Setor s5 = new Setor();
        s5.setNome("Aquicultuta");
        s5.setId(5);
        s5.setFoto(R.drawable.aquicultura);
        listaSetor.add(s5);

    }
}

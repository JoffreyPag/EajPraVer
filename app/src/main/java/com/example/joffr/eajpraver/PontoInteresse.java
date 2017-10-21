package com.example.joffr.eajpraver;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joffr on 18/10/2017.
 */

public class PontoInteresse extends Fragment {

    private List<Setor> listaSetor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ponto_interesse, container, false);
        //logica do fragment

        listaSetor = new ArrayList<>();

        final RecyclerView recyclerView = view.findViewById(R.id.RecViewPontos);

        CarregaSetores();

        LocaisAdapter locaisAdapter = new LocaisAdapter(getContext(), listaSetor);
        recyclerView.setAdapter(locaisAdapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        recyclerView.addOnItemTouchListener(new RecyclePontoInteresseClickListener(getContext(), recyclerView, new RecyclePontoInteresseClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                //TODO: provavelmente um bundle pra passar de um fragment para outro

                //Log.i("click", "clicou: "+position);

                TabLayout tabLayout = getActivity().findViewById(R.id.tab);
                //ACHEI NO STACKOVERFLOW
                //https://stackoverflow.com/questions/32306136/switch-tabs-from-fragment
                tabLayout.getTabAt(1).select();

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Snackbar.make((View)view.getParent(), "Tente so clicar", Snackbar.LENGTH_SHORT).show();
            }
        }));

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

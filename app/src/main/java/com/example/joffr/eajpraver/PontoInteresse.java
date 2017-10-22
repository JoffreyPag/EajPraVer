package com.example.joffr.eajpraver;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
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
                //Log.i("click", "clicou: "+listaSetor.get(position).getNome());

                TextView nome, desc, lati, longi;
                Button button;
                ImageView imageView;

                TabLayout tabLayout = getActivity().findViewById(R.id.tab);
                nome = getActivity().findViewById(R.id.nome);
                desc = getActivity().findViewById(R.id.desc);
                lati = getActivity().findViewById(R.id.lati);
                longi = getActivity().findViewById(R.id.logi);
                imageView = getView().findViewById(R.id.im);
                button = getActivity().findViewById(R.id.butao);

                nome.setText(listaSetor.get(position).getNome());
                desc.setText(listaSetor.get(position).getDescricao());
                lati.setText("Latidude: "+listaSetor.get(position).getLatitude());
                longi.setText("Longitude: "+listaSetor.get(position).getLongitude());
                //imageView.setImageResource(R.drawable.cvt);
//                imageView.setImageResource(listaSetor.get(position).getFoto());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make((View)view.getParent(), "Ainda vai implementar", Snackbar.LENGTH_SHORT).show();
                    }
                });
                button.setVisibility(View.VISIBLE);
                //ACHEI NO STACKOVERFLOW
                //https://stackoverflow.com/questions/32306136/switch-tabs-from-fragment
                tabLayout.getTabAt(1).select();

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Snackbar.make((View) view.getParent(), "Tente so clicar", Snackbar.LENGTH_SHORT).show();
            }
        }));

        return view;
    }

    private void CarregaSetores() {
        Setor s1 = new Setor(1, R.drawable.informatica, 0, 0, "Informatica", "Setor de tecnologia plicada a ciencias agrarias");
        listaSetor.add(s1);
        Setor s2 = new Setor(2, R.drawable.medio, 0, 0, "Ensino Médio", "Setor de Ensino Médio");
        listaSetor.add(s2);
        Setor s3 = new Setor(3, R.drawable.cvt, 0, 0, "CVT", "Centro Vocacional Tecnologico");
        listaSetor.add(s3);
        Setor s4 = new Setor(4, R.drawable.biblioteca, 0, 0, "Biblioteca", "Biclioteca da ufrn para os alunos alocados da EAJ");
        listaSetor.add(s4);
        Setor s5 = new Setor(5, R.drawable.aquicultura, 0, 0, "Aquicultura", "Setor de Aquicultura");
        listaSetor.add(s5);

    }

}

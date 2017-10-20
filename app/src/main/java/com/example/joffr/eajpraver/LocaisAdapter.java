package com.example.joffr.eajpraver;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by joffr on 19/10/2017.
 */

public class LocaisAdapter extends RecyclerView.Adapter {

    Context context;
    List<Setor> setores;

    public LocaisAdapter(Context context, List<Setor> setores) {
        this.context = context;
        this.setores = setores;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.inflate_locais, parent, false);
        SetorViewHolder holder = new SetorViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        SetorViewHolder setorViewHolder = (SetorViewHolder) holder;
        Setor setorselecionado = setores.get(position);
        setorViewHolder.nome.setText(setorselecionado.getNome());
        setorViewHolder.img.setImageResource(setorselecionado.getFoto());
    }

    @Override
    public int getItemCount() {
        return setores == null ? 0:setores.size();
    }

    public class SetorViewHolder extends RecyclerView.ViewHolder{

        final TextView nome;
        final ImageView img;

        public SetorViewHolder(View v) {
            super(v);
            nome = v.findViewById(R.id.nomeLocal);
            img = v.findViewById(R.id.imagem);
        }
    }
}

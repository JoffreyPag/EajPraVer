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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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
            public void onItemClick(View view, final int position) {
                //Log.i("click", "clicou: "+listaSetor.get(position).getNome());

                TextView nome, desc, resp, email, tele, hor, lati, longi;
                Button button;
                ImageView imageView;

                Activity activity = getActivity();
                Setor s = listaSetor.get(position);

                final TabLayout tabLayout = activity.findViewById(R.id.tab);

                nome = activity.findViewById(R.id.nome);
                desc = activity.findViewById(R.id.desc);
                resp = activity.findViewById(R.id.responsable);
                email = activity.findViewById(R.id.email);
                tele = activity.findViewById(R.id.telefone);
                hor = activity.findViewById(R.id.horario);
                lati = activity.findViewById(R.id.lati);
                longi = activity.findViewById(R.id.logi);
                imageView = activity.findViewById(R.id.im);
                button = activity.findViewById(R.id.butao);

                nome.setText(s.getNome());
                desc.setText(s.getDescricao());
                resp.setText("Responsavel: " + s.getResponsavel());
                email.setText("E-mail: " + s.getEmail());
                tele.setText("Telefone: " + s.getTelefone());
                hor.setText("Horário: " + s.getHorario());
                lati.setText("Latidude: " + s.getLatitude());
                longi.setText("Longitude: " + s.getLongitude());
                imageView.setImageResource(s.getFoto());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //setando o marcador no mapa
                        MainActivity.mGoogleMap.addMarker(new MarkerOptions().position(
                                new LatLng(listaSetor.get(position).getLatitude(), listaSetor.get(position).getLongitude()))
                                .title(listaSetor.get(position).getNome()));
                        //visao do mapa
                        CameraPosition liberty = CameraPosition.builder().target(
                                new LatLng(listaSetor.get(position).getLatitude(), listaSetor.get(position).getLongitude()))
                                .zoom(16).bearing(0).build();
                        //visao no mapa
                        MainActivity.mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty));

                        tabLayout.getTabAt(2).select();
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
        Setor s1 = new Setor(1, R.drawable.informatica, -5.885786, -35.365748, "Informatica",
                "O setor de Informatica é onde o curso de mesmo nome é ministrado por professores exepcionais " +
                        "e um curso recente na escola comparado com os outros cursos", "Leonardo Teixeira",
                "eajInformatica@eaj.urfn.br", "11 1111-1111", "7h-17h");
        listaSetor.add(s1);
        Setor s2 = new Setor(2, R.drawable.medio, -5.885205, -35.364782, "Ensino Médio",
                "Setor de Ensino Médio para alunos integrados com algum curso técnico possam estudar as materias de " +
                        "Ensino Médio, antigamente conhecido como Ginásio", "Ligia Pereira",
                "eajMedio@eaj.ufrn.br", "22 2222-2222", "7h-17h");
        listaSetor.add(s2);
        Setor s3 = new Setor(3, R.drawable.cvt, -5.884567, -35.364924, "CVT", "Centro Vocacional Tecnologico, o setor com laboratorios " +
                "preparados para o ensino de graduação e Ensino Médio, Quimica, fisica, biologia e Agroidustria sã oalguns dos laboratorios " +
                "encontrados nele", "André Stuwart", "eajCVT@eaj.ufrn.br", "33 3333-3333", "7h-17h");
        listaSetor.add(s3);
        Setor s4 = new Setor(4, R.drawable.biblioteca, -5.885911, -35.366131, "Biblioteca",
                "Biclioteca da ufrn para que os alunos alocados da EAJ possam cunsultar a literatura para aprender " +
                        "novos conhecimentos, ou passar o tempo no ar-condicionado e wi-fi ja que é o vicio " +
                        "da nova geração", "Petunia Dolores Silva", "eajBiblioteca@eaj.ufrn.br", "44 4444-4444", "7h-17h");
        listaSetor.add(s4);
        Setor s5 = new Setor(5, R.drawable.aquicultura, -5.887602, -35.361685, "Aquicultura", "O Setor de Aquicultura é onde o curso de " +
                "mesmo nome é ministrado por professores exepcionais",
                "Paulo Faria", "eajAquicultura@eaj.ufrn.br", "55 5555-5555", "7h-17h");
        listaSetor.add(s5);
        Setor s6 = new Setor(6, R.drawable.agroindustria, -5.885453, -35.366123, "Agroindustria", "O setor de Agroindustria é onde o curso de mesmo nome é " +
                "ministrado por professores exepcionais, e fabrica do melhor doce de leite da escola", "Agroindustriana de Leite",
                "eajAgroindustria@eaj.ufrn.br", "66 6666-6666", "7h-17h");
        listaSetor.add(s6);
        Setor s7 = new Setor(7, R.drawable.agropecuaria, -5.885657, -35.366227, "Agropecuaria", "O setor de Agropecuara é onde o curso de " +
                "mesmo nome é ministrado por professores exepcionais e um dos polos mais fortes desse ensino depois de Aquicultura",
                "Agropecuariano Firmino", "eajAgropecuaria@eaj.ufrn.br", "77 7777-7777", "7h-17h");
        listaSetor.add(s7);
        Setor s8 = new Setor(8, R.drawable.apicultura, 5.885880, -35.362644, "Apicultura", "O setor de Apicultura é onde o curso de " +
                "mesmo nome é ministrado por professores exepcionais e uma das melhores fabricas de mel caseiro da escola",
                "Apicultorino Peixoto", "eajApicultura@eaj.ufrn.br", "88 8888-8888", "7h-17h");
        listaSetor.add(s8);
        Setor s9 = new Setor(9, R.drawable.avicultura, -5.886712, -35.363297, "Avicultura", "O setor de Avicultura é onde o curso de " +
                "mesmo nome é ministrado por professores exepcionais e uma das mais produtora de aves de corte em Macaíba",
                "Avicultano Armenico", "eajAvicultura@eaj.ufrn.br", "99 9999-9999", "7h-17h");
        listaSetor.add(s9);
        Setor s10 = new Setor(10, R.drawable.capela, -5.885117, -35.366293, "Capela", "A capela da EAJ é para aqueles que buscam iluminação " +
                "espiritual e acalmar os abalos da vida de um estudante, tambem serve para pedir força à divindade suprema para " +
                "as dificeis provas de recuperação", "Padre Fábio de Melo", "eajCapela@eaj.ufrn.br", "10 1010-1010", "24h/dia");
        listaSetor.add(s10);
        Setor s11 = new Setor(11, R.drawable.diretoria, -5.886449, -35.362213, "Diretoria", "A diretoria da escola onde todo o processo burocratico " +
                "academico passa, reunioes constantemente acontencem o que não é raro de não ver carros estacionados na frente ",
                "Julio César", "eajDirecao@eaj.ufrn.br", "11 1011-1011", "7h-17h");
        listaSetor.add(s11);
        Setor s12 = new Setor(12, R.drawable.etec, -5.885260, -35.366496, "E-Tec", "A direção do E-tec onde é realizado toda a parte burocratica e " +
                "administrativa desse projeto social, localiza-se no antigo prédio da direção e antigo casarão do dono da EAJ que " +
                "um dia foi-se um fazenda de engenho", "Max Lacerda", "eajEtec@eaj.ufrn.br", "12 1212-1212", "7h-17h");
        listaSetor.add(s12);
        Setor s13 = new Setor(13, R.drawable.ru, -5.885471, -35.362908, "RU", "Com fome? Passe no Restaurante Universitário(RU), onde os alunos da graduação," +
                " Ensino Médio, funcionários terceirizados, Professores e etc vão almoçar, porem se vc nao tiver  auxilio esteja sabendo" +
                " que a entrada é 7R$",
                "Agropecuariano Firmino", "eajAgropecuaria@eaj.ufrn.br", "77 7777-7777", "7h-17h");
        listaSetor.add(s13);
    }

}

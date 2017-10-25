package com.example.joffr.eajpraver;

/**
 * Created by joffr on 19/10/2017.
 */

public class Setor {
    private int id, foto;
    private double longitude, latitude;
    private String nome, descricao;

    public Setor(int id, int foto, double latitude, double longitude, String nome, String descricao) {
        this.id = id;
        this.foto = foto;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Setor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

package com.example.be_java_esamefinale.models;

public class TariffaCorriere {
    private int id;
    private String nome_corriere;
    private String nome_tariffa;
    private double peso_max;
    private double costo;

    public TariffaCorriere(int id, String nome_corriere, String nome_tariffa, double peso_max, double costo) {
        this.id = id;
        this.nome_corriere = nome_corriere;
        this.nome_tariffa = nome_tariffa;
        this.peso_max = peso_max;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_corriere() {
        return nome_corriere;
    }

    public void setNome_corriere(String nome_corriere) {
        this.nome_corriere = nome_corriere;
    }

    public String getNome_tariffa() {
        return nome_tariffa;
    }

    public void setNome_tariffa(String nome_tariffa) {
        this.nome_tariffa = nome_tariffa;
    }

    public double getPeso_max() {
        return peso_max;
    }

    public void setPeso_max(double peso_max) {
        this.peso_max = peso_max;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}

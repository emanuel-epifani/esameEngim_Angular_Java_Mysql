package com.example.be_java_esamefinale.models.payloads;

import com.example.be_java_esamefinale.models.TariffaCorriere;

public class OrdineConPreventivo {
    private int id;
    private int numero;
    private String data;
    private TariffaCorriere preventivo_migliore;

    public OrdineConPreventivo(int id, int numero, String data, TariffaCorriere preventivo_migliore) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.preventivo_migliore = preventivo_migliore;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TariffaCorriere getPreventivo_migliore() {
        return preventivo_migliore;
    }

    public void setPreventivo_migliore(TariffaCorriere preventivo_migliore) {
        this.preventivo_migliore = preventivo_migliore;
    }
}

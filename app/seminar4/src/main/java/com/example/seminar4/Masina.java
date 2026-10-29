package com.example.seminar4;

import java.io.Serializable;

public class Masina implements Serializable {
    private String marca;
    private int anFabricatie;
    private float pret;
    private boolean esteElectrica;
    private String tipCaroserie;
    private String tractiune;
    private float rating;

    public Masina() {
    }

    public Masina(String marca, int anFabricatie, float pret, boolean esteElectrica, String tipCaroserie, String tractiune, float rating) {
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.pret = pret;
        this.esteElectrica = esteElectrica;
        this.tipCaroserie = tipCaroserie;
        this.tractiune = tractiune;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "marca='" + marca + '\'' +
                ", anFabricatie=" + anFabricatie +
                ", pret=" + pret +
                ", esteElectrica=" + esteElectrica +
                ", tipCaroserie='" + tipCaroserie + '\'' +
                ", tractiune='" + tractiune + '\'' +
                ", rating=" + rating +
                '}';
    }
}

package com.example.aprofundare;

import java.io.Serializable;

public class Laptop implements Serializable {
     private String marca;
     private int memorieRAM;
     boolean deGaming;
     private String procesor;
     private String stare;
     private float review;

    public Laptop() {
    }

    public Laptop(String marca, int memorieRAM, boolean deGaming, String procesor, String stare, float review) {
        this.marca = marca;
        this.memorieRAM = memorieRAM;
        this.deGaming = deGaming;
        this.procesor = procesor;
        this.stare = stare;
        this.review = review;
    }

}

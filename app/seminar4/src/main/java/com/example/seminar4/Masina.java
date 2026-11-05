package com.example.seminar4;

import android.os.Parcel;
import android.os.Parcelable;

public class Masina implements Parcelable {
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

    protected Masina(Parcel in) {
        marca = in.readString();
        anFabricatie = in.readInt();
        pret = in.readFloat();
        esteElectrica = in.readByte() != 0;
        tipCaroserie = in.readString();
        tractiune = in.readString();
        rating = in.readFloat();
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(marca);
        dest.writeInt(anFabricatie);
        dest.writeFloat(pret);
        dest.writeByte((byte) (esteElectrica ? 1 : 0));
        dest.writeString(tipCaroserie);
        dest.writeString(tractiune);
        dest.writeFloat(rating);
    }

    public static final Creator<Masina> CREATOR = new Creator<Masina>() {
        @Override
        public Masina createFromParcel(Parcel in) {
            return new Masina(in);
        }

        @Override
        public Masina[] newArray(int size) {
            return new Masina[size];
        }
    };

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public boolean isEsteElectrica() {
        return esteElectrica;
    }

    public void setEsteElectrica(boolean esteElectrica) {
        this.esteElectrica = esteElectrica;
    }

    public String getTipCaroserie() {
        return tipCaroserie;
    }

    public void setTipCaroserie(String tipCaroserie) {
        this.tipCaroserie = tipCaroserie;
    }

    public String getTractiune() {
        return tractiune;
    }

    public void setTractiune(String tractiune) {
        this.tractiune = tractiune;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
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

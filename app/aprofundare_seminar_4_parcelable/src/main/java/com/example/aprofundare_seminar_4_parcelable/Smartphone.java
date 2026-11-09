package com.example.aprofundare_seminar_4_parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class Smartphone implements Parcelable {

    private String model;
    private float pret;
    private int anLansare;
    private String sistemDeOperare;
    private float rating;
    private boolean areGarantieExtinsa;
    private String memorie;

    public Smartphone() {
    }

    public Smartphone(String model, float pret, int anLansare, String sistemDeOperare, float rating, boolean areGarantieExtinsa, String memorie) {
        this.model = model;
        this.pret = pret;
        this.anLansare = anLansare;
        this.sistemDeOperare = sistemDeOperare;
        this.rating = rating;
        this.areGarantieExtinsa = areGarantieExtinsa;
        this.memorie = memorie;
    }

    protected Smartphone(Parcel in) {
        model = in.readString();
        pret = in.readFloat();
        anLansare = in.readInt();
        sistemDeOperare = in.readString();
        rating = in.readFloat();
        areGarantieExtinsa = in.readByte() != 0;
        memorie = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(model);
        dest.writeFloat(pret);
        dest.writeInt(anLansare);
        dest.writeString(sistemDeOperare);
        dest.writeFloat(rating);
        dest.writeByte((byte) (areGarantieExtinsa ? 1 : 0));
        dest.writeString(memorie);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Smartphone> CREATOR = new Creator<Smartphone>() {
        @Override
        public Smartphone createFromParcel(Parcel in) {
            return new Smartphone(in);
        }

        @Override
        public Smartphone[] newArray(int size) {
            return new Smartphone[size];
        }
    };

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getAnLansare() {
        return anLansare;
    }

    public void setAnLansare(int anLansare) {
        this.anLansare = anLansare;
    }

    public String getSistemDeOperare() {
        return sistemDeOperare;
    }

    public void setSistemDeOperare(String sistemDeOperare) {
        this.sistemDeOperare = sistemDeOperare;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isAreGarantieExtinsa() {
        return areGarantieExtinsa;
    }

    public void setAreGarantieExtinsa(boolean areGarantieExtinsa) {
        this.areGarantieExtinsa = areGarantieExtinsa;
    }

    public String getMemorie() {
        return memorie;
    }

    public void setMemorie(String memorie) {
        this.memorie = memorie;
    }

    @NonNull
    @Override
    public String toString() {
        return  "model='" + model + '\'' +
                ", pret=" + pret +
                ", anLansare=" + anLansare +
                ", sistemDeOperare='" + sistemDeOperare + '\'' +
                ", rating=" + rating +
                ", areGarantieExtinsa=" + areGarantieExtinsa +
                ", memorie='" + memorie + '\'';
    }
}

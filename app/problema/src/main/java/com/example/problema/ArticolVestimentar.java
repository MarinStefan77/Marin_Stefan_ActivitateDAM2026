package com.example.problema;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ArticolVestimentar  implements Parcelable {
    private String brand;
    private String culoare;
    private float pret;
    private String marime;
    private float rating;
    private boolean favorit;

    public ArticolVestimentar() {
    }

    public ArticolVestimentar(String brand, String culoare, float pret, String marime, float rating, boolean favorit) {
        this.brand = brand;
        this.culoare = culoare;
        this.pret = pret;
        this.marime = marime;
        this.rating = rating;
        this.favorit = favorit;
    }

    protected ArticolVestimentar(Parcel in) {
        brand = in.readString();
        culoare = in.readString();
        pret = in.readFloat();
        marime = in.readString();
        rating = in.readFloat();
        favorit = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brand);
        dest.writeString(culoare);
        dest.writeFloat(pret);
        dest.writeString(marime);
        dest.writeFloat(rating);
        dest.writeByte((byte) (favorit ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArticolVestimentar> CREATOR = new Creator<ArticolVestimentar>() {
        @Override
        public ArticolVestimentar createFromParcel(Parcel in) {
            return new ArticolVestimentar(in);
        }

        @Override
        public ArticolVestimentar[] newArray(int size) {
            return new ArticolVestimentar[size];
        }
    };

    public String getMarca() {
        return brand;
    }

    public void setMarca(String brand) {
        this.brand = brand;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getMarime() {
        return marime;
    }

    public void setMarime(String marime) {
        this.marime = marime;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isFavorit() {
        return favorit;
    }

    public void setFavorit(boolean favorit) {
        this.favorit = favorit;
    }

    @NonNull
    @Override
    public String toString() {
        return  "marca='" + brand + '\'' +
                ", culoare='" + culoare + '\'' +
                ", pret=" + pret +
                ", marime='" + marime + '\'' +
                ", rating=" + rating +
                ", favorit=" + favorit;
    }
}

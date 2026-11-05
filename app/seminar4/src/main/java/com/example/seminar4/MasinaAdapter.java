package com.example.seminar4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MasinaAdapter extends BaseAdapter {

    private final List<Masina> masini;
    private final Context context;
    private final int layout;
    private final LayoutInflater inflater;

    public MasinaAdapter(@NonNull List<Masina> masini,
                         @NonNull Context context,
                         int layout) {
        this.masini = masini;
        this.context = context;
        this.layout = layout;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return masini.size();
    }

    @Override
    public Masina getItem(int position) {
        return masini.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(layout, parent, false);


        Masina masina = getItem(position);

        TextView tvMarca = view.findViewById(R.id.tvItemMarca);
        TextView tvPret = view.findViewById(R.id.tvItemPret);
        TextView tvTip = view.findViewById(R.id.tvItemTip);
        TextView tvElectrica = view.findViewById(R.id.tvItemElectrica);
        RatingBar rbRating = view.findViewById(R.id.rbItemRating);

        tvMarca.setText(context.getString(
                R.string.item_marca_an,
                masina.getMarca(),
                masina.getAnFabricatie()));
        tvPret.setText(context.getString(R.string.item_pret, masina.getPret()));
        tvTip.setText(context.getString(
                R.string.item_tip,
                masina.getTipCaroserie(),
                masina.getTractiune()));
        tvElectrica.setText(
                masina.isEsteElectrica()
                        ? R.string.item_electrica
                        : R.string.item_nu_electrica);
        rbRating.setRating(masina.getRating());
        return view;
    }
}
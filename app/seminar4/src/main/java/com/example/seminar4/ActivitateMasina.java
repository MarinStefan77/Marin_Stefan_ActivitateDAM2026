package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateMasina extends AppCompatActivity {

    private EditText etMarca, etAn, etPret;
    private Switch swElectrica;
    private Spinner spCaroserie;
    private RadioButton rbFata, rbSpate, rb4x4;
    private RatingBar rbRating;
    private CheckBox cbConfirm;
    private Button btnSalveaza;
    private int pozitie = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_masina);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etMarca = findViewById(R.id.etMarca);
        etAn = findViewById(R.id.etAn);
        etPret = findViewById(R.id.etPret);
        swElectrica = findViewById(R.id.swElectrica);
        spCaroserie = findViewById(R.id.spCaroserie);
        rbFata = findViewById(R.id.rbFata);
        rbSpate = findViewById(R.id.rbSpate);
        rb4x4 = findViewById(R.id.rb4x4);
        rbRating = findViewById(R.id.rbRating);
        cbConfirm = findViewById(R.id.cbConfirm);
        btnSalveaza = findViewById(R.id.btnSalveaza);
        btnSalveaza.setOnClickListener(v -> trimiteDatele(v));

        Bundle primit = getIntent().getExtras();
        if (primit != null) {
            Masina selectata = BundleCompat.getParcelable(primit, "masina_selectata", Masina.class);
            if (selectata != null) {
                pozitie = primit.getInt("pozitie", -1);
                completeazaCampurile(selectata);
            }
        }
    }

    private void completeazaCampurile(Masina masina) {
        etMarca.setText(masina.getMarca());
        etAn.setText(String.valueOf(masina.getAnFabricatie()));
        etPret.setText(String.valueOf(masina.getPret()));
        swElectrica.setChecked(masina.isEsteElectrica());

        String[] caroserii = getResources().getStringArray(R.array.tipuri_caroserie);
        for (int i = 0; i < caroserii.length; i++) {
            if (caroserii[i].equals(masina.getTipCaroserie())) {
                spCaroserie.setSelection(i);
                break;
            }
        }

        if ("Spate".equals(masina.getTractiune())) {
            rbSpate.setChecked(true);
        } else if ("4x4".equals(masina.getTractiune())) {
            rb4x4.setChecked(true);
        } else {
            rbFata.setChecked(true);
        }

        rbRating.setRating(masina.getRating());
    }


    public void trimiteDatele(View view) {
        if (!cbConfirm.isChecked()) {
            Toast.makeText(this, "Bifeaza casuța de confirmare pentru a salva!", Toast.LENGTH_SHORT).show();
            return;
        }

        String marca = etMarca.getText().toString();

        int an = 0;
        if (!etAn.getText().toString().isEmpty()) {
            an = Integer.parseInt(etAn.getText().toString());
        }

        float pret = 0.0f;
        if (!etPret.getText().toString().isEmpty()) {
            pret = Float.parseFloat(etPret.getText().toString());
        }

        boolean electrica = swElectrica.isChecked();
        String caroserie = spCaroserie.getSelectedItem() != null ? spCaroserie.getSelectedItem().toString() : "Necunoscut";

        String tractiune = "Fata";
        if (rbSpate.isChecked()) {
            tractiune = "Spate";
        } else if (rb4x4.isChecked()) {
            tractiune = "4x4";
        }

        float rating = rbRating.getRating();

        Masina masinaCreata = new Masina(marca, an, pret, electrica, caroserie, tractiune, rating);

        Bundle bundle = new Bundle();
        bundle.putParcelable("cheie_masina", masinaCreata);
        bundle.putInt("pozitie", pozitie);

        Intent intentReturn = new Intent();
        intentReturn.putExtras(bundle);

        setResult(RESULT_OK, intentReturn);
        finish();
    }
}
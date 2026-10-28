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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateMasinaAI extends AppCompatActivity {

    private EditText etMarca, etAn, etPret;
    private Switch swElectrica;
    private Spinner spCaroserie;
    private RadioButton rbFata, rbSpate, rb4x4;
    private RatingBar rbRating;
    private CheckBox cbConfirm;
    private Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_masina_ai);
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
        btnSalveaza = findViewById(R.id.btnSalveazaAI);
        btnSalveaza.setOnClickListener(v -> trimiteDatele(v));
    }

    public void trimiteDatele(View view) {
        if (!cbConfirm.isChecked()) {
            android.widget.Toast.makeText(this, "Bifeaza casuța de confirmare pentru a salva!", android.widget.Toast.LENGTH_SHORT).show();
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
        bundle.putSerializable("cheie_masina", masinaCreata);

        Intent intentReturn = new Intent();
        intentReturn.putExtras(bundle);

        setResult(RESULT_OK, intentReturn);
        finish();
    }
}

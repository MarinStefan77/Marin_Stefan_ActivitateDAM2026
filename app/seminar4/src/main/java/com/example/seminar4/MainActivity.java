package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int COD_LISTA = 3;

    private ArrayList<Masina> listaMasini = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAdauga = findViewById(R.id.btnAdauga);
        Button btnLista = findViewById(R.id.btnLista);
        btnAdauga.setOnClickListener(v -> deschideAdaugare(v));
        btnLista.setOnClickListener(v -> deschideLista(v));
    }

    public void deschideAdaugare(View view) {
        Intent it = new Intent(this, ActivitateMasina.class);
        startActivityForResult(it, 1);
    }

    public void deschideLista(View view) {
        Intent it = new Intent(this, ActivitateLista.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista_masini", listaMasini);
        it.putExtras(bundle);
        startActivityForResult(it, COD_LISTA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                Masina masinaPrimita = (Masina) bundle.getSerializable("cheie_masina");
                if (masinaPrimita != null) {
                    listaMasini.add(masinaPrimita);
                    Toast.makeText(this, masinaPrimita.toString(), Toast.LENGTH_LONG).show();
                }
            }
        }

        if (requestCode == COD_LISTA && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                ArrayList<Masina> listaActualizata = (ArrayList<Masina>) bundle.getSerializable("lista_masini");
                if (listaActualizata != null) {
                    listaMasini = listaActualizata;
                }
            }
        }
    }
}
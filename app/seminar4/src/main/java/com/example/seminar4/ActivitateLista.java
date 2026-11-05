package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivitateLista extends AppCompatActivity {

    private static final int COD_MODIFICARE = 4;

    private ArrayList<Masina> listaMasini = new ArrayList<>();
    private MasinaAdapter adapter;
    private int idModificat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_lista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ArrayList<Masina> primita = BundleCompat.getParcelableArrayList(bundle, "lista_masini", Masina.class);
            if (primita != null) {
                listaMasini = primita;
            }
        }

        ListView lvMasini = findViewById(R.id.lvMasini);
        adapter = new MasinaAdapter(listaMasini, this, R.layout.item_masina);
        lvMasini.setAdapter(adapter);


        lvMasini.setOnItemClickListener((parent, view, position, id) -> {
            Intent intentModifica = new Intent(this, ActivitateMasina.class);
            intentModifica.putExtra("masina_selectata", listaMasini.get(position));
            idModificat = position;
            startActivityForResult(intentModifica, COD_MODIFICARE);
        });

        lvMasini.setOnItemLongClickListener((parent, view, position, id) -> {
            listaMasini.remove(position);
            adapter.notifyDataSetChanged();
            trimiteListaInapoi();
            return true;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == COD_MODIFICARE && resultCode == RESULT_OK
                && data != null && data.getExtras() != null) {
            Masina modificata = BundleCompat.getParcelable(data.getExtras(), "cheie_masina", Masina.class);
            if (modificata != null) {
                listaMasini.set(idModificat, modificata);
                adapter.notifyDataSetChanged();
                trimiteListaInapoi();
            }
        }
    }

    private void trimiteListaInapoi() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("lista_masini", listaMasini);
        Intent it = new Intent();
        it.putExtras(bundle);
        setResult(RESULT_OK, it);
    }
}

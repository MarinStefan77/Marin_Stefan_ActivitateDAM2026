package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivitateLista extends AppCompatActivity {

    private ArrayList<Masina> listaMasini = new ArrayList<>();
    private ArrayAdapter<Masina> adapter;

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
            ArrayList<Masina> primita = (ArrayList<Masina>) bundle.getSerializable("lista_masini");
            if (primita != null) {
                listaMasini = primita;
            }
        }

        ListView lvMasini = findViewById(R.id.lvMasini);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaMasini);
        lvMasini.setAdapter(adapter);


        lvMasini.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, listaMasini.get(position).toString(), Toast.LENGTH_LONG).show();
        });

        lvMasini.setOnItemLongClickListener((parent, view, position, id) -> {
            listaMasini.remove(position);
            adapter.notifyDataSetChanged();
            trimiteListaInapoi();
            return true;
        });
    }

    private void trimiteListaInapoi() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista_masini", listaMasini);
        Intent it = new Intent();
        it.putExtras(bundle);
        setResult(RESULT_OK, it);
    }
}

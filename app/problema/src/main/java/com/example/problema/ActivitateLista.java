package com.example.problema;

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
import java.util.List;

public class ActivitateLista extends AppCompatActivity {

    private ListView lvLista;

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

        lvLista=findViewById(R.id.lvLista);
        Intent itPrimit=getIntent();
        Bundle bundlePrimit=itPrimit.getExtras();
        ArrayList<ArticolVestimentar> hainePrimite =bundlePrimit.getParcelableArrayList("lista_haine");
        ArrayAdapter<ArticolVestimentar> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,hainePrimite);
        lvLista.setAdapter(adapter);

        lvLista.setOnItemClickListener((parent, view, position, id) -> {
            ArticolVestimentar hainaSelectata=hainePrimite.get(position);
            Toast.makeText(this, hainaSelectata.toString(), Toast.LENGTH_SHORT).show();
        });
        lvLista.setOnItemLongClickListener((parent, view, position, id) -> {
            hainePrimite.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(ActivitateLista.this, R.string.articolul_vestimentar_a_fost_sters_cu_succes, Toast.LENGTH_SHORT).show();
            return true;
        });




    }
}
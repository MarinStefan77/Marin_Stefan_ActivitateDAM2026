package com.example.aprofundare_seminar_4_parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
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
    private ListView lvTelefoane;

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
        lvTelefoane=findViewById(R.id.lvTelefoane);
        Intent intentPrimit=getIntent();
        ArrayList<Smartphone> telefoanePrimite=intentPrimit.getParcelableArrayListExtra("lista_telefoane");

        if(telefoanePrimite==null || telefoanePrimite.isEmpty())
        {
            Toast.makeText(ActivitateLista.this,"Lista este goala",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ArrayAdapter<Smartphone>adapter=new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1,
                    telefoanePrimite
            );
            lvTelefoane.setAdapter(adapter);

            lvTelefoane.setOnItemClickListener((parent,view,position,id)-> {
                Smartphone telefonselectat = telefoanePrimite.get(position);
                Toast.makeText(this, telefonselectat.toString(), Toast.LENGTH_SHORT).show();
            });
            lvTelefoane.setOnItemLongClickListener((parent, view, position, id) -> {
                telefoanePrimite.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(this,"Telefonul a fost sters cu succes",Toast.LENGTH_SHORT).show();
                return true;
            });
        }


    }
}
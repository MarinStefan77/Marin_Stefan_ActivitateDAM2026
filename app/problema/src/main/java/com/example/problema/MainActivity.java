package com.example.problema;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnDeschidereAdaugare;
    private Button btnDeschidereLista;
    private TextView tvRezultat;
    private ArrayList<ArticolVestimentar> haine=new ArrayList<>();

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

        btnDeschidereAdaugare=findViewById(R.id.btnDeschidereAdaugare);
        btnDeschidereLista=findViewById(R.id.btnDeschidereLista);
        tvRezultat=findViewById(R.id.tvRezultat);
        btnDeschidereAdaugare.setOnClickListener(v->{
            Intent it=new Intent(this,ActivitateArticolVestimentar.class);
            startActivityForResult(it,1);
        });
        btnDeschidereLista.setOnClickListener(v -> {
            Intent intent=new Intent(this,ActivitateLista.class);
            Bundle bundle=new Bundle();
            bundle.putParcelableArrayList("lista_haine",haine);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            Bundle bundlePrimit=data.getExtras();
            if(bundlePrimit!=null)
            {
                ArticolVestimentar hainaPrimita=bundlePrimit.getParcelable("haina_noua");
                if(hainaPrimita!=null) {
                    tvRezultat.setText(hainaPrimita.toString());
                    haine.add(hainaPrimita);
                    Toast.makeText(this,"Articol vestimentar adaugat cu succes!",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
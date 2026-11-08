package com.example.aprofundare_seminar_4_parcelable;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnDeschidereAdaugare;
    private TextView tvRezultat;

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
        tvRezultat=findViewById(R.id.tvRezultat);
        btnDeschidereAdaugare.setOnClickListener(v -> {
            Intent it=new Intent(this,ActivitateSmartphone.class);
            startActivityForResult(it,1);
        }) ;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            Bundle bundlePrimit=data.getExtras();
            if(bundlePrimit!=null){
                Smartphone telefonPrimit=bundlePrimit.getParcelable("telefon");

                 if(telefonPrimit!=null) {
                    tvRezultat.setText(telefonPrimit.toString());
                 }
            }
        }
    }
}
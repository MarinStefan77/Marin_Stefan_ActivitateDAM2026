package com.example.aprofundare_seminar_4_parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.TuplesKt;

public class ActivitateSmartphone extends AppCompatActivity {

    private EditText etModel;
    private EditText etPret;
    private EditText etAnLansare;
    private RadioButton rbAndroid;
    private RadioButton rbIOS;
    private RatingBar rbRating;
    private CheckBox cbAreGarantieExtinsa;
    private Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_smartphone);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etModel=findViewById(R.id.etModel);
        etPret=findViewById(R.id.etPret);
        etAnLansare=findViewById(R.id.etAnLansare);
        rbAndroid=findViewById(R.id.rbAndroid);
        rbIOS=findViewById(R.id.rbIOS);
        rbRating=findViewById(R.id.rbRating);
        cbAreGarantieExtinsa=findViewById(R.id.cbAreGarantie);
        btnSalveaza=findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(v->{
            String model=etModel.getText().toString();
            float pret=Float.parseFloat(etPret.getText().toString());
            int anLansare=Integer.parseInt(etAnLansare.getText().toString());

            String sistem="";
            if(rbAndroid.isChecked())
            {
                sistem="Android";
            }
            else if(rbIOS.isChecked())
            {
                sistem="IOS";
            }
            else {
                Toast.makeText(ActivitateSmartphone.this,"Selectati unul dintre sistemele de operare!",Toast.LENGTH_SHORT).show();
                return;
            }

            float rating=rbRating.getRating();
            boolean areGarantie=cbAreGarantieExtinsa.isChecked();

            Smartphone telefon=new Smartphone(model,pret,anLansare,sistem,rating,areGarantie);

            Bundle bundle=new Bundle();
            bundle.putParcelable("telefon",telefon);
            Intent intent=new Intent();
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);

            finish();

        });
    }
}
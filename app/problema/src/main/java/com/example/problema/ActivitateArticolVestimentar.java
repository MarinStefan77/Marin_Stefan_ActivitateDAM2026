package com.example.problema;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateArticolVestimentar extends AppCompatActivity {

    private EditText etBrand;
    private Spinner spCuloare;
    private EditText etPret;
    private RadioButton rbMarimeS;
    private RadioButton rbMarimeM;
    private RadioButton rbMarimeL;
    private RadioButton rbMarimeXXL;
    private RatingBar rbRating;
    private CheckBox cbFavorit;
    private Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_articol_vestimentar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBrand=findViewById(R.id.etBrand);
        spCuloare=findViewById(R.id.spCuloare);
        etPret=findViewById(R.id.etPret);
        rbMarimeS=findViewById(R.id.rbS);
        rbMarimeM=findViewById(R.id.rbM);
        rbMarimeL=findViewById(R.id.rbL);
        rbMarimeXXL=findViewById(R.id.rbXXL);
        rbRating=findViewById(R.id.rbRating);
        cbFavorit=findViewById(R.id.cbEFavorit);
        btnSalveaza=findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(v -> {
            String brand=etBrand.getText().toString();
            String culoare=spCuloare.getSelectedItem().toString();
            float pret=Float.parseFloat(etPret.getText().toString());
            String marime="";
            if(rbMarimeS.isChecked())
            {
                marime="S";
            }
            else if (rbMarimeM.isChecked())
            {
                marime = "M";
            }
            else if (rbMarimeL.isChecked())
            {
                marime = "L";
            }
            else if (rbMarimeXXL.isChecked()) {
                marime = "XXL";
            }

            float rating=rbRating.getRating();
            boolean eFavorit=cbFavorit.isChecked();

            ArticolVestimentar haina=new ArticolVestimentar(brand,culoare,pret,marime,rating,eFavorit);
            Bundle bundle=new Bundle();
            bundle.putParcelable("haina_noua",haina);
            Intent it=new Intent();
            it.putExtras(bundle);
            setResult(RESULT_OK,it);
            finish();

        });


    }
}
package com.example.laborator2;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Seminar","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Seminar","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Seminar","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Seminar","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Seminar","onDestroy");
    }

}
//   1. Creați o aplicație în Android Studio cu o activitate Empty, în java, cu API 24.
//
//        2. Implementați metodele pentru prezentarea ciclului de viață al unei activități: onStart(), onResume(), onPause(), onStop().
//
//        3. In cadrul fiecărei metode salvați un log de tipul error, warning, debug, info: Log.e(), Log.w(), Log.d(), Log.i(), Log.v().
//
//        4. Filtrați si căutați logurile salvate în tab-ul Logat.
//
//        5. Adăugați o nouă activitate în cadrul proiectului.
//        Setați din AndroidManifest ca noua activitate să fie lansată la deschiderea aplicației.
//
//        6. Adăugați o a treia activitate în cadrul proiectului.
//
//        7. În cea de a doua activitate adăugați un Button. La apăsarea butonului respectiv deschideți cea de a treia activitate printr-un Intent.
//
//        8. La deschiderea activității trimiteți un mesaj și două valori de tip întreg către activitatea deschisă printr-un Bundle.
//
//        9. În activitatea nou deschisă preluați informațiile trimise din activitatea precedentă și le afișați într-un Toast.
//
//        10. În activitatea nou deschisa trebuie sa aveți un buton care să trimită către activitatea precedentă un alt mesaj si suma celor două valori primite.
//
//        11. În activitatea inițială vor fi afișate printr-un Toast mesajul primit și valoarea calculată.

package com.example.marisaagustina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    ImageButton btnAyam,btnIkan, btnSapi;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
    }

    public void Pindahbiodata (View v) {
        Intent intent = new Intent(MainActivity.this, Profile.class);
        intent.putExtra("MAHASISWA", "Marisa");
        startActivity(intent);
    }
    private void inisialisasiView() {
        btnAyam = findViewById(R.id.btn_buka_ayam);
        btnIkan = findViewById(R.id.btn_buka_ikan);
        btnSapi = findViewById(R.id.btn_buka_sapi);
        btnAyam.setOnClickListener(view -> bukaGaleri("Ayam"));
        btnIkan.setOnClickListener(view -> bukaGaleri("Ikan"));
        btnSapi.setOnClickListener(view -> bukaGaleri("Sapi"));
    }

    private void bukaGaleri(String menuMakanan) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, DaftarMakananActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, menuMakanan);
        startActivity(intent);
    }
}
package com.example.marisaagustina;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marisaagustina.menu.Makanan;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    Makanan makanan;
    TextView txJudul,txMenu,txNama,txDeskripsi;
    ImageView ivPosterMakanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galerimakanan);
        Intent intent = getIntent();
        makanan = (Makanan) intent.getSerializableExtra(DaftarMakananActivity.MAKANAN_TERPILIH);
        inisialisasiView();
        tampilkanProfil(makanan);
    }

    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txMenu = findViewById(R.id.txmenu);
        txNama = findViewById(R.id.txNama);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivPosterMakanan = findViewById(R.id.gambarMakanan);
    }


    private void tampilkanProfil(Makanan makanan) {
        Log.d("Profil","Menampilkan "+makanan.getJenis());
        txJudul.setText(makanan.getJenis());
        txMenu.setText(makanan.getMenu());
        txNama.setText(makanan.getNama());
        txDeskripsi.setText(makanan.getDeskripsi());
        ivPosterMakanan.setImageDrawable(this.getDrawable(makanan.getDrawableRes()));
    }

}

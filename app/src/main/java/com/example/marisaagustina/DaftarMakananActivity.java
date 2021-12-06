package com.example.marisaagustina;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.marisaagustina.menu.Makanan;

import java.util.List;

public class DaftarMakananActivity extends AppCompatActivity{
    public final static String MAKANAN_TERPILIH ="makanan_object_key";
    List<Makanan> makanans;
    ListView listView;
    String menuMakanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarmakanan);
        Intent intent = getIntent();
        menuMakanan = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        TextView txJudul = findViewById(R.id.text_title_daftar_makanan);
        txJudul.setText("DAFTAR MENU MAKANAN "+menuMakanan.toUpperCase());
        makanans = DataProvider.getMakanansByTipe(this,menuMakanan);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_makanan);
        DaftarMakananAdapter adapter = new DaftarMakananAdapter(this,makanans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Makanan terpilih = makanans.get(position);
            bukaProfileMakanan(terpilih);
        }
    };

    private void bukaProfileMakanan(Makanan makananM) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(MAKANAN_TERPILIH, makananM);
        startActivity(intent);
    }

}

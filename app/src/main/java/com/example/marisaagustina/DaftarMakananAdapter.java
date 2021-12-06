package com.example.marisaagustina;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;
import com.example.marisaagustina.menu.Makanan;

public class DaftarMakananAdapter extends ArrayAdapter<Makanan>{
    Context context;

    public DaftarMakananAdapter(Context context, List<Makanan> makanans) {
        super(context, R.layout.row_daftar_makanan, makanans);
        this.context = context;
    }

    private static class ViewHolder  {
        TextView textMenu;
        TextView textNama;
        ImageView gambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Makanan makanan = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_makanan, parent, false);
            viewHolder.textMenu =  convertView.findViewById(R.id.row_text_menu);
            viewHolder.textNama = (TextView) convertView.findViewById(R.id.row_text_nama_makanan);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_makanan);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textMenu.setText(makanan.getMenu());
        viewHolder.textNama.setText(makanan.getNama());
        viewHolder.gambar.setImageDrawable(context.getDrawable(makanan.getDrawableRes()));
        return convertView;
    }

}

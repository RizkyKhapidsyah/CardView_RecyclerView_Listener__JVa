package com.rizkykhapidsyah.cardview_recyclerview_listener__jva;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    String nama[] = {"Masjid Al-Azhom", "Museum Herigate", "Kelenteng ", "Wisata Kuliner", "Pantai Tanjung Pasir"};
    int gambar[] = {R.drawable.al_azhom,
            R.drawable.heritage,
            R.drawable.kelenteng,
            R.drawable.kuliner2,
            R.drawable.pantaitanjungpasir};
    String detail[] = {"Masjid Al-Azhom terletak di depan Pusat Pemerintahan Kota Tangerang",
            "Museum Herigate terletak di kawasan Pasar Anyar",
            "Kelenteng terletak di kawasan Pasar Lama",
            "Wisata Kuliner hanya buka pada malam hari dan terletak di Pasar Lama",
            "Pantai Tanjung Pasir terletak di kecamatan Teluk Naga"};
    Context context;
    LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        layoutInflater = layoutInflater.from(context);

    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyHolder holder, final int position) {
        // ini berfungsi untuk mengirim data ke DetailActivity
        holder.txt.setText(nama[position]);
        holder.img.setImageResource(gambar[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirimData = new Intent(context, DetailActivity.class);
                kirimData.putExtra("Nama", nama[position]);
                kirimData.putExtra("IMG", gambar[position]);
                kirimData.putExtra("DET", detail[position]);
                context.startActivity(kirimData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nama.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        // ID ini diambil dari file list_item.xml
        ImageView img;
        TextView txt;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imglist);
            txt = (TextView) itemView.findViewById(R.id.txtlist);
        }
    }
}

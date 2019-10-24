package com.rizkykhapidsyah.cardview_recyclerview_listener__jva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisiasi ID dan pemanggilan dari layout
        list = (RecyclerView) findViewById(R.id.recyclerview);

        // mengatur jenis layoutnya, bisa vertical kebawah atau horizontal kesamping
        list.setLayoutManager(new LinearLayoutManager(this));

        // kita membuat variabel baru untuk memanggil dari file RecyclerViewAdapter agar bisa mengambil konten darinya
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this);
        list.setAdapter(adapter);
    }
}

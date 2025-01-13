package com.fachrulziyyan.reverie;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TshirtActivity extends AppCompatActivity {
    private RecyclerView rvProdukList;
    private TextView tvJmlProduk;
    private ArrayList<Product> produkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshirt);

        rvProdukList = findViewById(R.id.rvProdukList);
        tvJmlProduk = findViewById(R.id.tvJmlProduk);
        ImageView btnBack = findViewById(R.id.btnBack);

        // Terima data dari intent
        Intent intent = getIntent();
        produkList = intent.getParcelableArrayListExtra("produkList");

        // Tampilkan jumlah produk
        if (produkList != null) {
            tvJmlProduk.setText(produkList.size() + " Produk Ditampilkan");

            // Set RecyclerView
            rvProdukList.setLayoutManager(new LinearLayoutManager(this));
            rvProdukList.setAdapter(new FlashSaleAdapter(this, produkList));
        }

        // Tombol kembali
        btnBack.setOnClickListener(v -> finish());
    }
}

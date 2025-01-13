package com.fachrulziyyan.reverie;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail); // Menggunakan XML yang sudah diubah

        // Inisialisasi view dari layout
        ImageView ivCover = findViewById(R.id.ivCover);
        TextView tvJudul = findViewById(R.id.tvJudul);
        TextView tvPrice = findViewById(R.id.tvPrice);
        TextView tvDescription = findViewById(R.id.tvDescription);
        ImageView btnBack = findViewById(R.id.btnBack);
        Button btnBeliSekarang = findViewById(R.id.btnBeliSekarang);

        // Ambil data dari Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("description");
        int imageResource = intent.getIntExtra("imageResource", 0);

        // Set data ke UI
        tvJudul.setText(title);
        tvPrice.setText(price);
        tvDescription.setText(description);
        ivCover.setImageResource(imageResource);

        // Tombol kembali
        btnBack.setOnClickListener(v -> finish());

        // Tombol "Beli Sekarang"
        btnBeliSekarang.setOnClickListener(v -> {
            // Tambahkan logika pembelian, misalnya membuka halaman checkout
            Toast.makeText(ProductDetail.this,
                    "Beli produk: " + title, Toast.LENGTH_SHORT).show();
        });
    }
}

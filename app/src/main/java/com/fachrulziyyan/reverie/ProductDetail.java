package com.fachrulziyyan.reverie;

import android.content.Intent;
import android.net.Uri; // Tambahkan impor ini
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
        Intent receivedIntent = getIntent();
        String title = receivedIntent.getStringExtra("title");
        String price = receivedIntent.getStringExtra("price");
        String description = receivedIntent.getStringExtra("description");
        int imageResource = receivedIntent.getIntExtra("imageResource", 0);

        // Set data ke UI
        tvJudul.setText(title);
        tvPrice.setText(price);
        tvDescription.setText(description);
        ivCover.setImageResource(imageResource);

        // Tombol kembali
        btnBack.setOnClickListener(v -> finish());

        // Tombol "Beli Sekarang"
        btnBeliSekarang.setOnClickListener(v -> {
            // Format URL dengan pesan template
            String phoneNumber = "6289628518304"; // Ganti dengan nomor tujuan
            String message = "Halo reverie Store! saya ingin memesan :%0ANama :%0AAlamat Lengkap :%0AKode Pos :%0ANama Item :%0AUkuran :%0AJumlah :%0ATerima kasih";
            String url = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + message;

            // Buat Intent untuk membuka URL
            Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
            whatsappIntent.setData(Uri.parse(url));
            startActivity(whatsappIntent);
        });
    }
}

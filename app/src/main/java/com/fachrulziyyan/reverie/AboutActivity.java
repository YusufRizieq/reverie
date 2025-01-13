package com.fachrulziyyan.reverie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Navigasi ke TabActivity saat ic_back ditekan
        ImageView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(AboutActivity.this, TabActivity.class);
            startActivity(intent);
            finish();
        });

        // Intent ke WhatsApp
        ImageView btnWhatsapp = findViewById(R.id.whatsapp);
        btnWhatsapp.setOnClickListener(view -> {
            String whatsappUrl = "https://wa.me/089628518304";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(whatsappUrl));
            startActivity(intent);
        });

        // Intent ke Gmail
        ImageView btnEmail = findViewById(R.id.email);
        btnEmail.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:yusuf.rizieq@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Halo!");
            startActivity(intent);
        });

        // Intent ke Instagram
        ImageView btnInstagram = findViewById(R.id.instagram);
        btnInstagram.setOnClickListener(view -> {
            String instagramUrl = "https://www.instagram.com/ysfryzn";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
            startActivity(intent);
        });
    }
}

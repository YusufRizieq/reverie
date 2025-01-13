package com.fachrulziyyan.reverie;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeFragment extends Fragment {

    private TextView countdownTimer;
    private RecyclerView flashSaleRecyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout untuk fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inisialisasi elemen UI
        countdownTimer = view.findViewById(R.id.countdownTimer);
        flashSaleRecyclerView = view.findViewById(R.id.flashSaleRecyclerView);

        // Set up RecyclerView untuk Flash Sale
        flashSaleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        flashSaleRecyclerView.setAdapter(new FlashSaleAdapter(requireContext(), getFlashSaleProducts()));

        // Set up RecyclerView untuk Rekomendasi Produk
        RecyclerView recommendationRecyclerView = view.findViewById(R.id.recommendationRecyclerView);
        recommendationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recommendationRecyclerView.setAdapter(new RecommendationAdapter(requireContext(), getRecommendationProducts()));
        // Handle Klik Layout Hoodie
        View layoutHoodie = view.findViewById(R.id.layoutHoodie);
        layoutHoodie.setOnClickListener(v -> {
            // Ambil 5 produk dari indeks 1-5
            List<Product> produkHoodie = getAllProducts().subList(0, 5);

            // Kirim data melalui Intent
            Intent intent = new Intent(getContext(), HoodieActivity.class);
            intent.putParcelableArrayListExtra("produkList", new ArrayList<>(produkHoodie));
            startActivity(intent);
        });

        // Tambahkan klik pada kategori Tshirt
        View layoutTshirt = view.findViewById(R.id.layoutTshirt);
        layoutTshirt.setOnClickListener(v -> {
            // Ambil 5 produk terakhir
            List<Product> produkTshirt = getAllProducts().subList(10, 15);

            // Kirim data melalui Intent
            Intent intent = new Intent(getContext(), TshirtActivity.class);
            intent.putParcelableArrayListExtra("produkList", new ArrayList<>(produkTshirt));
            startActivity(intent);
        });
        // Handle Klik Layout Jersey
        View layoutJersey = view.findViewById(R.id.layoutJersey);
        layoutJersey.setOnClickListener(v -> {
            // Ambil 5 produk dari indeks 5-10
            List<Product> produkJersey = getAllProducts().subList(5, 10);

            // Kirim data melalui Intent
            Intent intent = new Intent(getContext(), JerseyActivity.class);
            intent.putParcelableArrayListExtra("produkList", new ArrayList<>(produkJersey));
            startActivity(intent);
        });


        // Mulai countdown selama 6 hari
        startCountdown();

        return view;
    }


    private void startCountdown() {
        long sixDaysInMillis = 6 * 24 * 60 * 60 * 1000; // 6 hari dalam milidetik
        new CountDownTimer(sixDaysInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished) % 24;
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60;
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60;

                // Format waktu yang tersisa
                countdownTimer.setText(String.format("%02d:%02d:%02d:%02d", days, hours, minutes, seconds));
            }

            @Override
            public void onFinish() {
                countdownTimer.setText("Flash Sale Berakhir!");
            }
        }.start();
    }

    private List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(
                "Urban Cozy",
                "Rp. 125.000",
                "Hoodie modern berwarna solid dengan potongan kasual yang memberikan kesan simpel dan elegan. Didesain dengan bahan katun premium yang lembut, hoodie ini tidak hanya menawarkan kenyamanan tetapi juga daya tahan tinggi. Dengan kantong depan praktis dan tudung yang dapat disesuaikan, hoodie ini sempurna untuk cuaca dingin maupun gaya harian yang santai.",
                R.drawable.hoodie1));
        products.add(new Product(
                "Dynamic Edge",
                "Rp. 125.000",
                "Tampilkan gaya sporty dengan hoodie ini, yang dilengkapi aksen garis yang memberikan sentuhan dinamis. Terbuat dari bahan fleece yang hangat, produk ini cocok untuk aktivitas luar ruangan maupun sekadar bersantai di rumah. Warna kontras pada desainnya menambah daya tarik visual dan memastikan Anda tetap tampil keren di segala suasana.",
                R.drawable.hoodie2));
        products.add(new Product(
                "Essential Minimalist",
                "Rp. 125.000",
                "Hoodie dengan desain minimalis ini memadukan kenyamanan dan gaya yang timeless. Warna netralnya menjadikannya pilihan serbaguna yang cocok dipadukan dengan berbagai outfit. Material berkualitas tinggi memastikan ketahanan terhadap cuaca dingin, sementara potongannya memberikan kesan trendi tanpa berlebihan.",
                R.drawable.hoodie3));
        products.add(new Product(
                "Urban Trail",
                "Rp. 125.000",
                "Dengan desain urban yang edgy, hoodie ini dirancang untuk Anda yang ingin tampil beda. Aksen pada tudung dan kantong memberikan daya tarik visual yang unik. Cocok untuk digunakan sehari-hari maupun acara santai, hoodie ini menghadirkan keseimbangan sempurna antara fungsi dan gaya.",
                R.drawable.hoodie4));
        products.add(new Product(
                "Prestige Active",
                "Rp. 125.000",
                "Produk premium dengan tampilan yang mewah. Dilengkapi dengan detail seperti ritsleting tersembunyi dan bahan anti air, hoodie ini tidak hanya stylish tetapi juga sangat fungsional. Pilihan ideal untuk Anda yang mengutamakan kenyamanan tanpa mengorbankan estetika.",
                R.drawable.hoodie5));
        products.add(new Product(
                "Pro Motion Jersey",
                "Rp. 245.000",
                "Jersey olahraga berdesain modern dengan pola garis aerodinamis yang memberikan kesan dinamis dan sporty. Dibuat dengan bahan quick-dry yang cepat menyerap keringat, produk ini memastikan kenyamanan maksimal selama aktivitas fisik. Pilihan terbaik untuk pemain yang ingin tampil gaya di lapangan.",
                R.drawable.jrsy1));
        products.add(new Product(
                "Bold Strike Jersey",
                "Rp. 245.000",
                "Jersey dengan desain bold yang menarik perhatian, cocok untuk tim olahraga yang ingin tampil beda. Dengan teknologi breathable fabric, jersey ini tetap nyaman meskipun digunakan dalam pertandingan intens. Pola geometris memberikan sentuhan futuristik pada tampilan Anda.",
                R.drawable.jrsy2));
        products.add(new Product(
                "Classic Fit Jersey",
                "Rp. 245.000",
                "Klasik namun tetap stylish, jersey ini menawarkan kenyamanan sepanjang hari. Warna solidnya memberikan kesan profesional, menjadikannya pilihan sempurna untuk pertandingan formal maupun sesi latihan santai. Material elastis mendukung pergerakan bebas dan fleksibel.",
                R.drawable.jrsy3));
        products.add(new Product(
                "Custom Power Jersey",
                "Rp. 245.000",
                "Desain unik dan customizable pada jersey ini memungkinkan Anda menambahkan nama atau nomor favorit. Cocok untuk tim olahraga atau koleksi pribadi, bahan berkualitas tinggi memastikan ketahanan jangka panjang, bahkan setelah dicuci berkali-kali.",
                R.drawable.jrsy4));
        products.add(new Product(
                "Elite Performance Jersey",
                "Rp. 245.000",
                "Jersey premium dengan teknologi anti-lembab yang membuat Anda tetap segar sepanjang hari. Desainnya menggabungkan elemen tradisional dengan sentuhan modern, menjadikannya pilihan yang pas untuk pemain maupun penggemar olahraga.",
                R.drawable.jrsy5));
        products.add(new Product(
                "Daily Comfort Tee",
                "Rp. 95.000",
                "Kaos berbahan katun combed berkualitas tinggi, memberikan kenyamanan ekstra dengan tekstur lembut yang ramah kulit. Desainnya yang clean dan simpel membuatnya ideal untuk tampilan sehari-hari, baik di dalam maupun luar ruangan.",
                R.drawable.tshirt1));
        products.add(new Product(
                "Energetic Fit Tee",
                "Rp. 95.000",
                "T-shirt slim-fit yang memancarkan aura energik dan modern. Cocok untuk acara semi-formal atau sekadar hangout bersama teman. Bahan elastisnya memungkinkan pergerakan bebas tanpa mengorbankan gaya.",
                R.drawable.tshirt2));
        products.add(new Product(
                "Timeless Basic Tee",
                "Rp. 95.000",
                "Pilihan sempurna untuk gaya santai. Kaos basic ini memiliki desain timeless yang tidak pernah ketinggalan zaman. Tersedia dalam berbagai warna netral yang mudah dipadukan dengan celana jeans atau jaket favorit Anda.",
                R.drawable.tshirt3));
        products.add(new Product(
                "Statement Graphic Tee",
                "Rp. 95.000",
                "T-shirt ini hadir dengan detail grafis unik yang mencuri perhatian. Ideal untuk Anda yang ingin tampil beda dan menonjolkan kepribadian melalui pakaian. Bahan breathable-nya memberikan kenyamanan sepanjang hari.",
                R.drawable.tshirt4));
        products.add(new Product(
                "Vibrant Fresh Tee",
                "Rp. 95.000",
                "Kaos berkualitas dengan warna-warna vibrant yang awet meskipun sering dicuci. Pilihan ideal untuk Anda yang ingin tampil fresh dan standout dalam berbagai kesempatan.",
                R.drawable.tshirt5));
        return products;
    }

    private List<Product> getFlashSaleProducts() {
        List<Product> allProducts = getAllProducts();
        List<Product> flashSaleProducts = new ArrayList<>();

        // Pilih produk untuk Flash Sale
        flashSaleProducts.add(allProducts.get(1));
        flashSaleProducts.add(allProducts.get(4));
        flashSaleProducts.add(allProducts.get(6));
        flashSaleProducts.add(allProducts.get(10));
        flashSaleProducts.add(allProducts.get(14));
        flashSaleProducts.add(allProducts.get(3));
        flashSaleProducts.add(allProducts.get(0));

        return flashSaleProducts;
    }

    private List<Product> getRecommendationProducts() {
        List<Product> allProducts = getAllProducts();

        // Acak daftar produk
        Collections.shuffle(allProducts);

        // Batasi jumlah rekomendasi
        int recommendationCount = 6;
        return allProducts.subList(0, Math.min(recommendationCount, allProducts.size()));
    }
}

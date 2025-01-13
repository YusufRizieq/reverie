package com.fachrulziyyan.reverie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FlashSaleAdapter extends RecyclerView.Adapter<FlashSaleAdapter.FlashSaleViewHolder> {

    private List<Product> products;

    public FlashSaleAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public FlashSaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_flash_sale, parent, false);
        return new FlashSaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlashSaleViewHolder holder, int position) {
        Product product = products.get(position);
        holder.productImage.setImageResource(product.getImageResource());
        holder.productTitle.setText(product.getTitle());
        holder.productPrice.setText(product.getPrice());
        // Sembunyikan deskripsi
        holder.productDescription.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class FlashSaleViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productTitle, productPrice, productDescription;

        FlashSaleViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productTitle = itemView.findViewById(R.id.productTitle);
            productPrice = itemView.findViewById(R.id.productPrice);
            productDescription = itemView.findViewById(R.id.productDescription);
        }
    }
}

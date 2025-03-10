package com.fachrulziyyan.reverie;

import android.content.Context;
import android.content.Intent; // Tambahkan impor ini
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecommendationAdapter extends RecyclerView.Adapter<RecommendationAdapter.ViewHolder> {

    private final Context context;
    private final List<Product> recommendationList;

    public RecommendationAdapter(Context context, List<Product> recommendationList) {
        this.context = context;
        this.recommendationList = recommendationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommendation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = recommendationList.get(position);

        holder.title.setText(product.getTitle());
        holder.price.setText(product.getPrice());
        holder.description.setText(product.getDescription());
        holder.image.setImageResource(product.getImageResource());
        holder.description.setVisibility(View.GONE);

        // Tambahkan OnClickListener pada item MaterialCardView
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetail.class);
            intent.putExtra("title", product.getTitle());
            intent.putExtra("price", product.getPrice());
            intent.putExtra("description", product.getDescription());
            intent.putExtra("imageResource", product.getImageResource());

            // Pastikan context adalah instance Activity
            if (context instanceof android.app.Activity) {
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recommendationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, price, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.recommendationImage);
            title = itemView.findViewById(R.id.recommendationTitle);
            price = itemView.findViewById(R.id.recommendationPrice);
            description = itemView.findViewById(R.id.recommendationDescription);
        }
    }
}

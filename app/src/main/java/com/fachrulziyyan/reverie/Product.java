package com.fachrulziyyan.reverie;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private String title;
    private String price;
    private String description;
    private int imageResource;

    public Product(String title, String price, String description, int imageResource) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.imageResource = imageResource;
    }

    protected Product(Parcel in) {
        title = in.readString();
        price = in.readString();
        description = in.readString();
        imageResource = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(price);
        dest.writeString(description);
        dest.writeInt(imageResource);
    }

    public String getTitle() { return title; }
    public String getPrice() { return price; }
    public String getDescription() { return description; }
    public int getImageResource() { return imageResource; }
}

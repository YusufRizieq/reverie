package com.fachrulziyyan.reverie;

public class Product {
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

    public String getTitle() { return title; }
    public String getPrice() { return price; }
    public String getDescription() { return description; }
    public int getImageResource() { return imageResource; }
}


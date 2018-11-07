package com.codecool.servlet;

public class Item {

    private static int id = 0;
    private String name;
    private double price;

    public Item(String name, float price) {
        setId(id++);
        setName(name);
        setPrice(price);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Item.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }



}

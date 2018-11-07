package com.codecool.servlet;

public class Item {

    private static int id = 0;
    private int uid;
    private String name;
    private double price;

    public Item(String name, float price) {
        setId(id++);
        setName(name);
        setPrice(price);
    }

    public int getId() {
        return uid;
    }

    public void setId(int id) {
        this.uid = id;
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

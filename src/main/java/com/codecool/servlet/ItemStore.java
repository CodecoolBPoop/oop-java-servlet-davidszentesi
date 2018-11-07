package com.codecool.servlet;

import java.util.LinkedList;
import java.util.List;

public class ItemStore {

    static List<Item> items = new LinkedList<>();

    static void add(Item item) {
        items.add(item);
    }

    static void remove(Item item) {
        items.remove(item);
    }
}

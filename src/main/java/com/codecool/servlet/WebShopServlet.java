package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "WebShopServlet", urlPatterns = {"/webshop"}, loadOnStartup = 3)
public class WebShopServlet extends HttpServlet {

    private List<Item> availableItems = new LinkedList<>();

    @Override
    public void init() {
        availableItems.add(new Item("Jetski", 123));
        availableItems.add(new Item("Yacht", 1234));
        availableItems.add(new Item("Titanic", 12345));
        availableItems.add(new Item("Titanic 2", 123456));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String title = "Webshop";

        out.println(
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n");

        for (Item item : availableItems) {
            out.println(
                "<li><b>" + item.getId() + " - " + item.getName() + " - " + item.getPrice() +"</b>" + " - " +
                "<a href=/webshop?itemid-add=" + item.getId() + ">Add</a>" + " - " +
                "<a href=/webshop?itemid-remove=" + item.getId() + ">Remove</a>" +
                "\n");
        }

        out.println(
                "</ul>\n" +
                "<div><a href=\"/shopping-cart\">Check Shopping Cart</a></div>" +
                "</body></html>"
                );


        String itemToShoppingCart = request.getParameter("itemid-add");
        String removeItemFromShoppingCart = request.getParameter("itemid-remove");

        if (itemToShoppingCart != null) {
            int itemToShoppingCartId = Integer.parseInt(itemToShoppingCart);
            ItemStore.add(availableItems.get(itemToShoppingCartId));
        }

        if (removeItemFromShoppingCart != null) {
            int removeItemFromShoppingCartId = Integer.parseInt(removeItemFromShoppingCart);
            ItemStore.remove(availableItems.get(removeItemFromShoppingCartId));
        }

    }

}

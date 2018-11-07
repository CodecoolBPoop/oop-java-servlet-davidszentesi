package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/shopping-cart"}, loadOnStartup = 4)
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        double sumPrice = 0;

        PrintWriter out = response.getWriter();
        String title = "Shopping Cart";

        out.println(
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n");

        for (Item item : ItemStore.items) {
            sumPrice += item.getPrice();
            out.println(
                "<li><b>" + item.getId() + " - " + item.getName() + " - " + item.getPrice() +"</b>\n");
        }

        out.println(
                "</ul>\n" +
                "<div>Sum of Price:" + sumPrice + "</div>" +
                "<div><a href=/webshop>Back to the Shop</a></div>" +
                "</body></html>"
        );

    }

}

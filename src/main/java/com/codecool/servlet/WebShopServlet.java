package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WebShopServlet", urlPatterns = {"/webshop"}, loadOnStartup = 3)
public class WebShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        initItems();

        PrintWriter out = response.getWriter();
        String title = "Webshop";

        out.println(
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n");

        for (int i = 0; i < ItemStore.items.size(); i++) {
            out.println(
                    "<li><b>" + ItemStore.items.get(i).getName() + "</b>\n");
        }

        out.println(
                "</ul>\n" +
                "<div>Visit another servlet: <a href=\"/another\">Visit the other servlet</a></div>" +
                "</body></html>"
                );

    }

    public void initItems() {
        ItemStore.add(new Item("Jetski", 123));
        ItemStore.add(new Item("Yacht", 1234567));
        ItemStore.add(new Item("Titanic", 1234567890));
    }


}

package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/Lesson1")
public class Lesson1 extends HttpServlet {

    private List<Product> productsList;

    public void fillProductsList (List<Product> list) {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productsList.add(new Product(i+1, "Product" + (i+1), Math.random() * 20000));
        }

    }

    @Override
    public void init() throws ServletException {
         productsList = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        fillProductsList(productsList);

        resp.getWriter().println("<h3>Products list</h3>");

        for (Product s : productsList) {
            if (s != null) {
                resp.getWriter().println("<p>" + s + "</p>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}


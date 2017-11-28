package com.shop.controller.products;

import com.shop.DAO.ProductDAO;
import com.shop.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetAllProduct")
public class GetAllProducts extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Product> products = new ProductDAO().getAll();
        resp.getWriter().println("<html><title>AllProduct</title><body>");
        for (Product p : products) {
            resp.getWriter().println("<h2>" + p.getName() + "</h2><br>");
            resp.getWriter().println("<a href=\"/updateProduct?model_id="+p.getId() +"\">Update</a>");
            resp.getWriter().println("<a href=\"/deleteProduct?model_id="+p.getId() +"\">Delete</a><br>");
        }
        resp.getWriter().println("<br><a href=\"\\jsp\\AddProduct.jsp\">Add</a>");
        resp.getWriter().println("<br><a href=\"\\index.jsp\">choice</a>");
        resp.getWriter().println("</body> </html>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

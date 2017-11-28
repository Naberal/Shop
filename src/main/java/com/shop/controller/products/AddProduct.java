package com.shop.controller.products;

import com.shop.DAO.ManufacturerDAO;
import com.shop.DAO.ProductDAO;
import com.shop.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("\\jsp\\AddProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new ProductDAO().save(new Product(req.getParameter("name"), new BigDecimal(req.getParameter("prise")),
                new ManufacturerDAO().findByName(req.getParameter("manufacturer"))));
        new GetAllProducts().doGet(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

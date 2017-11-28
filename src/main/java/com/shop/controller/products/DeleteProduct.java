package com.shop.controller.products;

import com.shop.DAO.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new ProductDAO().delete(UUID.fromString(req.getParameter("model_id")));
        new GetAllProducts().doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

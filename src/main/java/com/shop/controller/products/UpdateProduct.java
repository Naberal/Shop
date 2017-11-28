package com.shop.controller.products;

import com.shop.DAO.ManufacturerDAO;
import com.shop.DAO.ProductDAO;
import com.shop.model.Manufacturer;
import com.shop.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
    ProductDAO dao = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("model_id"));
        String name = dao.findByID(id).getName();
        BigDecimal decimal = dao.findByID(id).getPrise();
        Manufacturer manufacturer = dao.findByID(id).getManufacturer();
        req.setAttribute("name", name);
        req.setAttribute("prise", decimal);
        req.setAttribute("manufacture", manufacturer);
        req.setAttribute("model_id", id);
        req.getRequestDispatcher("\\jsp\\UpdateProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = dao.findByID(UUID.fromString(req.getParameter("UUID")));
        product.setName(req.getParameter("name"));
        product.setPrise(new BigDecimal(req.getParameter("prise")));
        product.setManufacturer(new ManufacturerDAO().findByName(req.getParameter("manufacturer")));
        dao.update(product);
        new GetAllProducts().doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

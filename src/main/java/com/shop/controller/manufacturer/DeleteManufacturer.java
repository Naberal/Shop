package com.shop.controller.manufacturer;

import com.shop.DAO.ManufacturerDAO;
import com.shop.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/deleteManufacturer")
public class DeleteManufacturer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new ManufacturerDAO().delete(UUID.fromString(req.getParameter("model_id")));
        new GetAllManufacturer().doGet(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

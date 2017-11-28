package com.shop.controller.manufacturer;

import com.shop.DAO.ManufacturerDAO;
import com.shop.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/updateManufacturer")
public class UpdateManufacturer extends HttpServlet {
    ManufacturerDAO dao = new ManufacturerDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("model_id"));
        String name = dao.findByID(id).getName();
        req.setAttribute("name", name);
        req.setAttribute("id", id);
        req.getRequestDispatcher("\\jsp\\UpdateManufacturer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Manufacturer manufacturer=dao.findByID(UUID.fromString(req.getParameter("UUID")));
        manufacturer.setName(req.getParameter("name"));
        dao.update(manufacturer);
        new GetAllManufacturer().doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

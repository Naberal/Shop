package com.shop.controller.manufacturer;

import com.shop.DAO.ManufacturerDAO;
import com.shop.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddManufacturer")
public class AddManufacturer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("\\jsp\\AddManufacturer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       ManufacturerDAO dao= new ManufacturerDAO();
       if (dao.findByName(req.getParameter("name")).getName().equals(req.getParameter("name"))){
          resp.getWriter().println( "<script type=\"text/javascript\">alert(\"this manufacturer exist\");</script>");
       }
       else dao.save(new Manufacturer(req.getParameter("name")));
        new GetAllManufacturer().doGet(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

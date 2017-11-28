package com.shop.controller.manufacturer;

import com.shop.DAO.ManufacturerDAO;
import com.shop.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetAllManufacturer")
public class GetAllManufacturer extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Manufacturer> manufacturers = new ManufacturerDAO().getAll();
        resp.getWriter().println("<html><title>AllManufacturer</title><body>");
        for (Manufacturer m : manufacturers) {
            resp.getWriter().println("<h2>" + m.getName() + "</h2><br>");
            resp.getWriter().println("<a href=\"/updateManufacturer?model_id="+m.getId() +"\">Update</a>");
            resp.getWriter().println("<a href=\"/deleteManufacturer?model_id="+m.getId() +"\">Delete</a><br>");
        }
        resp.getWriter().println("<br><a href=\"\\jsp\\AddManufacturer.jsp\">Add</a>");
        resp.getWriter().println("<br><a href=\"\\index.jsp\">choice</a>");
        resp.getWriter().println("</body> </html>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

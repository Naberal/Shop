<%@ page import="com.shop.DAO.ManufacturerDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shop.model.Manufacturer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update Product</title>
</head>
<body>
<form action="/updateProduct" method="POST">
    <p> new Product name</p>
    <input required type="text" name="name" value="<%=request.getAttribute("name")%>"/><br>
    <p> new Product prise</p>
    <input requiredtype="number" name="prise" value="<%=request.getAttribute("prise")%>"/><br>
    <p>new Manufacturer</p>
    <select required name="manufacturer">
        <%
            List<Manufacturer> list = new ManufacturerDAO().getAll();
            for (Manufacturer manufacturer : list) {
                if (manufacturer.getName().equals(request.getAttribute("manufacture"))) {
                    out.println("<option selected value=\"" + manufacturer.getName() + "\">"
                            + manufacturer.getName() + "</option>");
                } else {
                    out.println("<option value=\"" + manufacturer.getName() + "\">"
                            + manufacturer.getName() + "</option>");
                }
            }
        %>
    </select><br>
    <input hidden name="UUID" value="<%=request.getAttribute("model_id")%>" \>
    <br>
    <input type="submit" value="update"/>
</form>
</body>
</html>
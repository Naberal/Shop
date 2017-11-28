<%@ page import="com.shop.DAO.ManufacturerDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shop.model.Manufacturer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<form action="/AddProduct" method="POST">
    <p>Product name</p>
    <input required type="text" name="name"/><br>
    <p>Product prise</p>
    <input required type="number" name="prise"/><br>
    <p>Manufacturer</p>
    <select required name="manufacturer">
        <%
            List<Manufacturer> list = new ManufacturerDAO().getAll();
            for (Manufacturer manufacturer : list) {
                out.println("<option value=\"" + manufacturer.getName() + "\">"
                        + manufacturer.getName() + "</option>");
            }
        %>
    </select><br>
    <br>
    <input hidden name="choice" value="products"/>
    <input type="submit" value="Add"/>
</form>
</body>
</html>
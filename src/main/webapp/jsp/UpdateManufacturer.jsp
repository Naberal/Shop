
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Manufacturer</title>
</head>
<body>
<form action="/updateManufacturer" method="POST">
    <p> new Manufacturer name</p>
    <input required type="text" name="name"value="<%=request.getAttribute("name")%>"/><br>
    <input hidden name="UUID" value="<%=request.getAttribute("id")%>">
    <input type="submit" value="update"/>
</form>
</body>
</html>

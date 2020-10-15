<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 13.10.2020
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить новый магазин</title>
</head>
<body>
<form action = "MyServlet" method="post">
    <input required type="text" name="nameOfShop2" placeholder="Название">
    <input required type="text" name="typeOfShop2" placeholder="Тип магазина">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>

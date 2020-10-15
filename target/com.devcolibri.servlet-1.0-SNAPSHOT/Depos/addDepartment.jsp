<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 13.10.2020
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Добавить отделение магазина</title>
</head>
<body>
<form action = "MyServlet" method="post">
    <input required type="text" name="typeDepo1" placeholder="Название">
    <input required type="text" name="typeDepo1" placeholder="Тип отдела">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>

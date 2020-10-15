<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 13.10.2020
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить продавца</title>
</head>
<body>
<form action = "MyServlet" method="post">
    <input required type="text" name="nameSeller3" placeholder="Имя">
    <input required type="text" name="surnameSeller3" placeholder="Фамилия">
    <input required type="date" name="dateSeller3" placeholder="Дата рождения">
    <input required type="number" name="salarySeller3" placeholder="Зарплата">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>

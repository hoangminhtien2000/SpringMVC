<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 09/01/2023
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDIT</title>
</head>
<body>
<form  method="post" action="/edit">
    <input placeholder="id" name="id" value="${e.id}" readonly><br>
    <input placeholder="name" name="name" value="${e.name}"><br>
    <input placeholder="price" name="price" value="${e.price}"><br>
    <button type="submit">Edit</button>
</form>
</body>
</html>

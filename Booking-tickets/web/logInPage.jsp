<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 05.11.2021
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
    <form action = "http://localhost:8080/Booking_tickets_war_exploded/logInH", method="get">
        Email: <input type="email", name="email"> <br><br>
        Password: <input type="password", name="password"> <br><br>
        <input type="submit" value="log in">
    </form>
</body>
</html>

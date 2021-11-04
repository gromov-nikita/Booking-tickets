<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 05.11.2021
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form action="http://localhost:8080/Booking_tickets_war_exploded/signUpH" method="post">
    First name: <input type="text" name="firstName"> <br><br>
    Last name: <input type="text" name="lastName"> <br><br>
    Passport ID: <input type="text" name="passportID"> <br><br>
    Email: <input type="email" name="email"> <br><br>
    Password: <input type="password" name="password"> <br><br>
    <input type="submit" name="sign up">
</form>
</body>
</html>

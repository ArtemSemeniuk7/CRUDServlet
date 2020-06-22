<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 15.06.20
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<style>
    a{
        position: fixed;
        top: 5%;
        left: 75%;
        background-color: lightgreen;
    }
    form {
        position: fixed;
        top: 30%;
        left: 40%;
        width: 900px;
    }
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 50%;
        float: right;
    }

    input[type=button], input[type=submit], input[type=reset] {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 12px 28px;
        text-decoration: none;
        margin: 4px 2px;
        cursor: pointer;
    }
    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
    body {background-color: #E6E6FA;}
    tr:nth-child(even) {
        background-color: #dddddd;
    }
</style>

<form method="post" action="<c:url value='/'/>">
    <p> Sign in database2</p>
    <label><input type="text" name="login"></label>    Login <br> <br>
    <label><input type="text" name="password"></label>    Password <br> <br>
    <input type="submit" value="Enter" name="Insert">
</form>

<a href="<c:url value='/createAccount' />"> Dont have account? -> Create account</a>


</body>
</html>
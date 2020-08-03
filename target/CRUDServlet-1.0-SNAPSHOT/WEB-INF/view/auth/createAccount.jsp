<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 18.06.20
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<style>
    form {
        position: fixed;
        top: 30%;
        left: 40%;
        width: 450px;
    }
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 50%;
        float: right;
    }

    p {text-align: left;}
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

<form method="post" action="<c:url value='/createAccount'/>">
    <p>Create Account</p>
    <label><input type="text" name="login"></label>    Login <br> <br>
    <label><input type="text" name="password"></label>    Password <br> <br>
    <input type="submit" value="Create account" name="Insert">
</form>
</body>
</html>

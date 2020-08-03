<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 08.06.20
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries Update</title>
</head>
<body>
<style>
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

<form method="post" action="<c:url value='/countriesUpdate'/>">
    <label><input type="number" name="COUNTRY_ID"></label>   COUNTRY ID<br>
    <label><input type="text" name="COUNTRY_NAME"></label>   COUNTRY NAME<br>
    <label><input type="number" name="REGION_ID"></label>   REGION ID<br>
    <input type="submit" value="Update Data" name="Insert">
</form>
</body>
</html>


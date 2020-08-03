<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees Update</title>
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

<form method="post" action="<c:url value='/employeesUpdate'/>">
    <label><input type="number" name="EMPLOYEE_ID"></label>   EMPLOYEE ID<br>
    <label><input type="text" name="FIRST_NAME"></label>   FIRST NAME<br>
    <label><input type="text" name="LAST_NAME"></label>   LAST NAME<br>
    <label><input type="text" name="EMAIL"></label>    EMAIL<br>
    <label><input type="text" name="HIRE_DATE"></label>   HIRE_DATE<br>
    <label><input type="number" name="PHONE"></label>   PHONE<br>
    <label><input type="number" name="SALARY"></label>   SALARY<br>
    <label><input type="number" name="DEPARTMENT_ID"></label>   DEPARTMENT_ID<br>
    <input type="submit" value="Update Data" name="Insert">
</form>
</body>
</html>

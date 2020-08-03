<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: a
  Date: 29.05.20
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EmployeesDataBase</title>
</head>
<body>
<div style="display: flex;">
    <form method="get" action="<c:url value='/countries'/>">
        <input type="submit" name="COUNTRIES " value="COUNTRIES"/>
    </form>

    <form method="get" action="<c:url value='/jobs'/>">
        <input type="submit" name="JOBS " value="JOBS"/>
    </form>

    <form method="get" action="<c:url value='/departments'/>">
        <input type="submit" name="DEPARTMENTS " value="DEPARTMENTS"/>
    </form>

    <form method="get" action="<c:url value='/employees'/>">
        <input type="submit" name="EMPLOYEES " value="EMPLOYEES"/>
    </form>

    <form method="get" action="<c:url value='/region'/>">
        <input type="submit" name="REGION " value="REGION"/>
    </form>
    <a href="<c:url value='/servletLogout' />">Log Out</a>
</div>

<form method="post" action="/employees">
    <label><input type="number" name="EMPLOYEE_ID"></label>   EMPLOYEE ID<br>
    <label><input type="text" name="FIRST_NAME"></label>   FIRST NAME<br>
    <label><input type="text" name="LAST_NAME"></label>   LAST NAME<br>
    <label><input type="text" name="EMAIL"></label>    EMAIL<br>
    <label><input type="text" name="HIRE_DATE"></label>   HIRE_DATE<br>
    <label><input type="number" name="PHONE"></label>   PHONE<br>
    <label><input type="number" name="SALARY"></label>   SALARY<br>
    <label><input type="number" name="DEPARTMENT_ID"></label>   DEPARTMENT_ID<br>
    <div style="float:left;">
        <input type="submit" value="Insert Data" name="Insert">
    </div>
</form>
<br>
<center><h2>EMPLOYEES TABLE</h2></center>
<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 50%;
        float: right;
    }

    p {text-align: right;}
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


<table style="width:100%">
    <tr>
        <th>EMPLOYEE ID</th>
        <th>FIRST NAME</th>
        <th>LAST NAME</th>
        <th>EMAIL</th>
        <th>HIRE_DATE</th>
        <th>PHONE</th>
        <th>SALARY</th>
        <th>DEPARTMENT_ID</th>
    </tr>
    <c:forEach var="EMPLOYEE" items="${requestScope.EMPLOYEES}">
        <tr>
            <td><c:out value="${EMPLOYEE.EMPLOYEE_ID}"/></td>
            <td><c:out value="${EMPLOYEE.FIRST_NAME}"/></td>
            <td><c:out value="${EMPLOYEE.LAST_NAME}"/></td>
            <td><c:out value="${EMPLOYEE.EMAIL}"/></td>
            <td><c:out value="${EMPLOYEE.HIRE_DATE}"/></td>
            <td><c:out value="${EMPLOYEE.PHONE}"/></td>
            <td><c:out value="${EMPLOYEE.SALARY}"/></td>
            <td><c:out value="${EMPLOYEE.DEPARTMENT_ID}"/></td>
            <td><form method="get" action="<c:url value='/employeesUpdate'/>">
                <input type="submit" name="edit" value="EDIT"/>
            </form></td>
            <td> <form method="post" action="<c:url value='/employeesDelete'/>">
                <input type="number" hidden name="EMPLOYEE_ID" value="${EMPLOYEE.EMPLOYEE_ID}" />
                <input type="submit" name="delete" value="DELETE"/>
            </form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
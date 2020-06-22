<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 15.06.20
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JobsDataBase</title>
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

    <form method="get" action="<c:url value='/jobsDelete'/>">
        <input type="submit" name="EMPLOYEES " value="EMPLOYEES"/>
    </form>

    <form method="get" action="<c:url value='/jobsDelete'/>">
        <input type="submit" name="JOB_HISTORY " value="JOB_HISTORY"/>
    </form>
    <form method="get" action="<c:url value='/jobsDelete'/>">
        <input type="submit" name="LOCATIONS " value="LOCATIONS"/>
    </form>
    <form method="get" action="<c:url value='/region'/>">
        <input type="submit" name="REGION " value="REGION"/>
    </form>
    <a href="<c:url value='/servletLogout' />">Log Out</a>
</div>

<form method="post" action="/departments">
    <label><input type="number" name="DEPARTMENT_ID"></label>   DEPARTMENT ID<br>
    <label><input type="text" name="DEPARTMENT_NAME"></label>   DEPARTMENT NAME<br>
    <label><input type="number" name="MANAGER_ID"></label>   MANAGER ID<br>
    <label><input type="number" name="LOCATION_ID"></label>   LOCATION ID<br>
    <div style="float:left;">
        <input type="submit" value="Insert Data" name="Insert">
    </div>
</form>
<br>
<center><h2>DEPARTMENTS TABLE</h2></center>
<style>
    a{
        position: fixed;
        top: 5%;
        left: 75%;
        background-color: lightgreen;
    }
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 50%;
        float: right;
    }

    p {text-align: center;}
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
        <th>DEPARTMENT ID</th>
        <th>DEPARTMENT NAME</th>
        <th>MANAGER ID</th>
        <th>LOCATION ID</th>
    </tr>
    <c:forEach var="DEPARTMENT" items="${requestScope.DEPARTMENTS}">
        <tr>
            <td><c:out value="${DEPARTMENT.DEPARTMENT_ID}"/></td>
            <td><c:out value="${DEPARTMENT.DEPARTMENT_NAME}"/></td>
            <td><c:out value="${DEPARTMENT.MANAGER_ID}"/></td>
            <td><c:out value="${DEPARTMENT.LOCATION_ID}"/></td>
            <td><form method="get" action="<c:url value='/departmentsUpdate'/>">
                <input type="submit" name="edit" value="EDIT"/>
            </form></td>
            <td> <form method="delete" action="<c:url value='/departmentsDelete'/>">
                <input type="number" hidden name="DEPARTMENT_ID" value="${DEPARTMENT.DEPARTMENT_ID}" />
                <input type="submit" name="delete" value="DELETE"/>
            </form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
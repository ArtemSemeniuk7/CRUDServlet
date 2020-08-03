<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 08.06.20
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CountriesDataBase</title>
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
<form method="post" action="/countries">
    <label><input type="number" name="COUNTRY_ID"></label>   COUNTRY ID<br>
    <label><input type="text" name="COUNTRY_NAME"></label>   COUNTRY NAME<br>
    <label><input type="number" name="REGION_ID"></label>   REGION ID<br>
    <div style="float:left;">
        <input type="submit" value="Insert Data" name="Insert">
    </div>
</form>
<br>
<center><h2>COUNTRIES TABLE</h2></center>
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
        <th>COUNTRY ID</th>
        <th>COUNTRY NAME</th>
        <th>REGION ID</th>
    </tr>
    <c:forEach var="COUNTRY" items="${requestScope.COUNTRIES}">
        <tr>
            <td><c:out value="${COUNTRY.COUNTRY_ID}"/></td>
            <td><c:out value="${COUNTRY.COUNTRY_NAME}"/></td>
            <td><c:out value="${COUNTRY.REGION_ID}"/></td>
            <td><form method="get" action="<c:url value='/countriesUpdate'/>">
                <input type="submit" name="edit" value="EDIT"/>
            </form></td>
            <td> <form method="post" action="<c:url value='/countriesDelete'/>">
                <input type="number" hidden name="COUNTRY_ID" value="${COUNTRY.COUNTRY_ID}" />
                <input type="submit" name="delete" value="DELETE"/>
            </form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

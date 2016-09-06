<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="msid" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="cars" scope="request" type="java.util.List"/>

<c:set var="urlEdit" value="/caredition"/>
<c:set var="urlDelete" value="/deletecar"/>
<c:set var="urlCarEdition" value="/caredition"/>
<c:set var="urlMotorShows" value="/motorshows"/>
<c:set var="urlCars" value="/cars"/>
<c:set var="urlMain" value="/"/>

<c:url value="${urlCarEdition}" var="carEdition">
    <c:param name="MS" value="${msid}"/>
</c:url>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="js/bootstrap.js"></script>
    <title>Available cars</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%--<a class="navbar-brand" href="#">Logo</a>--%>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">
                <li><a href="${urlMain}">Return to main</a></li>
                <li><a href="${carEdition}">Create Car</a></li>
                <li><a href="${urlMotorShows}">Return to Motor Shows</a></li>
                <li><a href="${urlCars}">Return to Cars</a></li>
            </ul>
        </div>
    </div>
</div>


<div align="center">
    <table class="table_price" cellpadding="4" cellspacing="1">
        <caption><h1>Cars</h1></caption>
        <tr>
            <th>Model</th>
            <th>Production date</th>
            <th>Manufacturer</th>
            <th>Manufacturer E-mail</th>
            <th>Price</th>
            <th>Engine volume</th>
            <th>VIN code</th>
        </tr>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td><c:out value="${car.model}"/></td>
                <td><c:out value="${car.productionDate}"/></td>
                <td><c:out value="${car.manufacturer}"/></td>
                <td><c:out value="${car.manufacturerEmail}"/></td>
                <td><c:out value="${car.price}"/></td>
                <td><c:out value="${car.engineVolume}"/></td>
                <td><c:out value="${car.vinCode}"/></td>
                <td>
                    <div>
                        <c:url value="${urlEdit}" var="edit">
                            <c:param name="car" value="${car.id}"/>
                        </c:url>
                        <a href="${edit}">Edit</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="${urlDelete}" var="delete">
                            <c:param name="car" value="${car.id}"/>
                        </c:url>
                        <a href="${delete}">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

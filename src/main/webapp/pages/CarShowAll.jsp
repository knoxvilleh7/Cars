<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:url value="/caredition" var="edit">--%>
    <%--<c:param name="car" value="${car.id}"/>--%>
<%--</c:url>--%>
<c:url value="/deletecar" var="delete">
    <c:param name="car" value="${car.id}"/>
</c:url>
<c:url value="/mscars" var="mshow">
    <c:param name="motorShowId" value="${car.motorShowId}"/>
</c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <title>All cars</title>

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
                <li><a href="${pageContext.request.contextPath}/">Return to main</a></li>
                <li><a href="/caredition">Create car</a></li>
                <%--<li><a href="">Punkt 3</a></li>--%>
                <%--<li><a href="">Punkt 4</a></li>--%>
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
                        <a href="caredition?car=${car.id}" id="editlink">Edit</a>
                    </div>
                </td>
                <td>
                    <div>

                        <a href="${delete}" id="deletelink">Delete</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="${mshow}" id="mslink">To Motor Show</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--<a href="/" class="c">Return to main</a>--%>
    <%--<a href="/caredition" class="c">Create car</a>--%>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>

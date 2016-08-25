<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="js/local/html5shiv.min.js"></script>
    <script src="js/local/respond.min.js"></script>
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
            <form class="form-inline" method="get" action="cars">
                <ul class="nav navbar-nav col-lg">
                    <li><a href="${pageContext.request.contextPath}/">Return to main</a></li>
                    <li><a href="caredition">Create car</a></li>

                    <li class="menu-bar-page">
                        <button type="submit" class="btn" name="pageNumber" value="${(page.getPageNumber())-1}">
                            Previous
                        </button>
                    </li>
                    <li class="menu-bar-count">
                        <label>
                            <input type="text" class="pageCount" disabled="disabled"
                                   value="${page.getPageNumber()}/${page.getPageCount()}">
                        </label>
                    </li>
                    <li class="menu-bar">
                        <button type="submit" class="btn" name="pageNumber" value="${(page.getPageNumber())+1}">Next
                        </button>
                    </li>
                    <li class="menu-bar-beg">
                        <div>

                            <label>
                                <select class="form-control" name="pageSize" size="1">
                                    <option <c:if test="${page.pageSize eq 5}"> selected= </c:if> value="5">5</option>
                                    <option <c:if test="${page.pageSize eq 10}"> selected="selected" </c:if> value="10">10</option>
                                    <option <c:if test="${page.pageSize eq 25}"> selected="selected" </c:if>  value="25">25</option>
                                    <option <c:if test="${page.pageSize eq 35}"> selected="selected" </c:if> value="35">35</option>
                                </select>
                            </label>
                            <button type="submit" class="btn">Apply</button>

                        </div>
                        <%--<input type="hidden" name="numberOfCarsFromHidden" value="${}">--%>
                    </li>

                    <%--<li><a href="">Punkt 4</a></li>--%>
                </ul>
            </form>
        </div>
    </div>
</div>

<div class="zlp1" align="center">
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
                        <a href="caredition?car=${car.id}">Edit</a>
                    </div>
                </td>
                <td>
                    <div>

                        <a href="deletecar?car=${car.id}">Delete</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="mscars?motorShowId=${car.motorShowId}">To Motor Show</a>
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

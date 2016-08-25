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
            <form class="form-inline" method="get" action="mscars?motorShowId=${motorShowId}">
                <div>
                    <input type="hidden" name="motorShowId" value="${motorShowId}">
                </div>
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/" >Return to main</a></li>
                <li><a href="caredition?motorShowId=${motorShowId}" >Create Car</a></li>
                <li><a href="motorshows" >Return to Motor Shows</a></li>
                <li><a href="cars">Return to Cars</a></li>
                <li class="menu-bar-page">
                    <button type="submit" <c:if test="${page.toPrev == false}"> disabled="disabled"</c:if> class="btn" name="pageNumber" value="${(page.getPageNumber())-1}">
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
                    <button type="submit" <c:if test="${page.toNext == false}"> disabled="disabled"</c:if> class="btn" name="pageNumber" value="${(page.getPageNumber())+1}">Next
                    </button>
                </li>
                <li class="menu-bar-beg">
                    <div>

                        <label>
                            <select class="form-control" name="pageSize" size="1">
                                <option <c:if test="${page.pageSize eq 5}"> selected= </c:if> value="5">5</option>
                                <option <c:if test="${page.pageSize eq 10}"> selected="selected" </c:if> value="10">
                                    10
                                </option>
                                <option <c:if test="${page.pageSize eq 25}"> selected="selected" </c:if> value="25">
                                    25
                                </option>
                                <option <c:if test="${page.pageSize eq 35}"> selected="selected" </c:if> value="35">
                                    35
                                </option>
                            </select>
                        </label>
                        <button type="submit" class="btn">Apply</button>
                    </div>
                </li>

                <%--<li><a href="">Punkt 4</a></li>--%>
            </ul>
            </form>
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
                        <c:url value="caredition" var="edit">
                            <c:param name="car" value="${car.id}"/>
                            <c:param name="motorShowId" value="${car.motorShowId}"/>
                        </c:url>
                        <a href=" <c:out value="${edit}"/>" id="editlink">Edit</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="deletecar" var="delete">
                            <c:param name="car" value="${car.id}"/>
                            <c:param name="motorShowId" value="${car.motorShowId}"/>
                        </c:url>
                        <a href=" <c:out value="${delete}"/>" id="deletelink">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>

    <%--<a href="/caredition?MS=${msid}" class="c">Create Car</a>--%>
    <%--<a href="/motorshows" class="c">Return to Motor Shows</a>--%>
    <%--<a href="/" class="c">Return to main</a><br>--%>
    <%--<a href="/cars" class="c">Return to Cars</a><br>--%>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>

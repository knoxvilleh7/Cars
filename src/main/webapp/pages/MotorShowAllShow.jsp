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

    <title>Motor Shows.</title>
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
            <form class="form-inline" method="get" action="motorshows">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/">Return to main</a></li>
                    <li><a href="caredition">Create car</a></li>
                    <li><a href="motorshowedition">Create Motor Show</a></li>
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

        <caption><h1>Motor shows</h1></caption>
        <tr>
            <th>Name</th>
            <th>Address</th>
        </tr>
        <c:forEach var="MS" items="${motorShow}">
            <tr>
                <td><c:out value="${MS.name}"/></td>
                <td><c:out value="${MS.address}"/></td>
                <td>
                    <div>
                        <a href="motorshowedition?motorShowId=${MS.id}">Edit</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="deleteshow?motorShowId=${MS.id}">Delete</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="mscars?motorShowId=${MS.id}">Show cars</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--<a href="/" class="c">Return to main</a>--%>
    <%--<a href="/motorshowedition" class="c">Create Motor Show</a>--%>
    <%--<a href="/caredition" class="c">Create Car</a>--%>
    <%--<a href="/cars" class="c">Return to Cars</a><br>--%>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>

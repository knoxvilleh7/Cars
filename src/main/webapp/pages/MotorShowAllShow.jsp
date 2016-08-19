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
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

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
            <ul class="nav navbar-nav">
                <li><a href="/" >Return to main</a></li>
                <li><a href="/caredition" >Create car</a></li>
                <li><a href="/motorshowedition">Create Motor Show</a></li>
                <li><a href="/cars">Return to Cars</a></li>
            </ul>
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
        <c:forEach var="MS" items="${show}">
            <tr>
                <td><c:out value="${MS.name}"/></td>
                <td><c:out value="${MS.address}"/></td>
                <td>
                    <div>
                        <c:url value="/motorshowedition" var="edit">
                            <c:param name="MSID" value="${MS.id}"/>
                        </c:url>
                        <a href=" <c:out value="${edit}"/>" id="editlink">Edit</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="/deleteshow" var="delete">
                            <c:param name="MSID" value="${MS.id}"/>
                        </c:url>
                        <a href=" <c:out value="${delete}"/>" id="deletelink">Delete</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="/mscars" var="mscars">
                            <c:param name="MSID" value="${MS.id}"/>
                        </c:url>
                        <a href=" <c:out value="${mscars}"/>" id="mscarslink">Show cars</a>
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

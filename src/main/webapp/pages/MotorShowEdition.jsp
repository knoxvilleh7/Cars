<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="errs" scope="request" type="java.util.List"/>
<jsp:useBean id="motorShow" scope="request" type="java.util.List"/>
<c:set var="urlMotorShowList" value="motorshows"/>
<c:set var="urlCarList" value="cars"/>
<c:set var="urlMotorShowSave" value="mssave"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create or edit motor show</title>
</head>
<body class="motorShowEdit">
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/">Main page</a></li>
                <li><a href="${urlMotorShowList}">All motor shows</a></li>
                <li><a href="${urlCarList}">All cars</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="motorShowEdition  col-lg-8">
    <form class="form" method="post" action="${urlMotorShowSave}">
        <div class="form-group">
            <label for="name" class="text-right col-sm-3">Motor show name:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="name" id="name" value="${motorShow.name}">
            </div>
        </div>
        <div class="col-sm-offset-4">
            ${errs.name}
        </div>
        <div class="form-group">
            <label for="address" class="text-right col-sm-3">Motor show address:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="address" id="address" value="${motorShow.address}">
            </div>
        </div>
        <div class="col-sm-offset-4">
            ${errs.address}
        </div>
        <div class="col-sm-offset-6">
            <button type="submit" class="btn">Submit</button>
        </div>
        <div>
            <input type="hidden" name="id" value="${motorShow.id}">
        </div>
    </form>
</div>
</body>
</html>

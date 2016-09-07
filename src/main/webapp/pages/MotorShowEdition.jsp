<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all"/>

    <title>Create or edit motor show</title>
</head>
<body class="motorShowEdit">
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
                <li><a href="/main">Main page</a></li>
                <li><a href="/car/list">All cars</a></li>
                <li><a href="/motor_show/list">All motor shows</a></li>

                <%--<li><a href="">Punkt 4</a></li>--%>

            </ul>
        </div>
    </div>
</div>

<div class="motorShowEdition  col-lg-8">
    <form class="form" method="post" action="/motor_show/save">
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

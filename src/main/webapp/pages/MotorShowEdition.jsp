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

    <title>Edit Show</title>
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
                <li><a href="/">Return to main</a></li>
                <li><a href="/motorshows">Return to MotorShows</a></li>
                <li><a href="/cars">Return to Cars</a></li>
                <%--<li><a href="">Punkt 4</a></li>--%>

            </ul>
        </div>
    </div>
</div>

<div  class="col-lg-8">
    <form class="form" method="post" action="/mssave">
        <div class="form-group">
            <label for="name" class="text-right col-sm-3">Motor show name:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="name" id="name" value="${show.name}">
            </div>
            <div>
                ${errs.name}
            </div>
        </div>

        <div class="form-group">
            <label for="address" class="text-right col-sm-3">Motor show address:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="address" id="address" value="${show.address}">
            </div>
            <div>
                ${errs.address}
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
        <div>
            <input type="hidden" name="id" value="${show.id}">
        </div>
        <%--<div>--%>
        <%--<a href="/" class="c">Return to main</a><br>--%>
        <%--<a href="/motorshows"class="c">Return to MotorShows</a><br>--%>
        <%--<a href="/cars" class="c">Return to Cars</a><br>--%>
        <%--</div>--%>

    </form>
</div>
</body>
</html>

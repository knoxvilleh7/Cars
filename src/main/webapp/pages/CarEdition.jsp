<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <style type="text/css">
        body {
            background-image: url("/img/bmv.jpg");
        }

    </style>
    <title>Create car</title>
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


<div align="center" class="col-lg-8">
    <form class="form" method="post" action="/carsave">
        <div class="form-group">

            <label for="model" class="text-right col-sm-3" control-label>Car model:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="model" id="model" placeholder="Model"
                       value="${car.model}">
            </div>

            <div>
                ${errs.model}
            </div>

        </div>

        <div class="form-group">
            <label for="productionDate" class="text-right col-sm-3" control-label>Production date:</label>
            <div class="col-sm-9">
                <input type="date" class="form-control" name="productionDate" id="productionDate"
                       placeholder="YYYY-MM-DD" value="${car.productionDate}">
            </div>
            <div>
                ${errs.productionDate}
            </div>
        </div>

        <div class="form-group">
            <label for="manufacturer" class="text-right col-sm-3" control-label>Manufacturer:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="manufacturer" id="manufacturer"
                       placeholder="Enter company name" value="${car.manufacturer}">
            </div>
            <div>
                ${errs.manufacturer}
            </div>
        </div>

        <div class="form-group">
            <label for="manufacturerEmail" class="text-right col-sm-3">Manufacturer E-mail:</label>
            <div class="col-sm-9">
                <input type="email" class="form-control" name="manufacturerEmail" id="manufacturerEmail"
                       placeholder="Enter E-mail" value="${car.manufacturerEmail}">
            </div>
            <div>
                ${errs.manufacturerEmail}
            </div>
        </div>

        <div class="form-group">
            <label for="price" class="text-right col-sm-3">Price:</label>
            <div class="col-sm-9">
                <input type="number" class="form-control" name="price" id="price" placeholder="Enter price"
                       value="${car.price}">
            </div>
            <div>
                ${errs.price}
            </div>
        </div>

        <div class="form-group">
            <label for="engineVolume" class="text-right col-sm-3">Engine volume:</label>
            <div class="col-sm-9">
                <input type="number" step="any" class="form-control" name="engineVolume" id="engineVolume"
                       placeholder="Enter volume of engine" value="${car.engineVolume}">
            </div>
            <div>
                ${errs.engineVolume}
            </div>
        </div>

        <div class="form-group">
            <label for="vinCode" class="text-right col-sm-3">VIN code:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="vinCode" id="vinCode"
                       placeholder="Enter VIN code" value="${car.vinCode}">
            </div>
            <div>
                ${errs.vinCode}
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-8">
                <select name="motorShowIdFromSelect" size="1" <c:if test="${motorShowId > 0 || id >0 }">hidden</c:if>>
                    <option selected="selected">Choose Motor Show</option>
                    <c:forEach var="MS" items="${mShows}">
                        <option value="${MS.id}">${MS.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>



        <div class="form-group">
            <input type="hidden" name="id" value="${id}">
        </div>

        <div class="form-group">
            <input type="hidden" name="motorShowIdFromHidden" value="${motorShowId}">
        </div>

        <button type="submit" class="btn">Submit</button>

    </form>
</div>
</body>
</html>

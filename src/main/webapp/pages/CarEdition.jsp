<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="car" scope="request" type="java.util.List"/>
<jsp:useBean id="errs" scope="request" type="java.util.List"/>
<jsp:useBean id="mShows" scope="request" type="java.util.List"/>
<jsp:useBean id="motorShow" scope="request" type="java.util.List"/>
<jsp:useBean id="motorShowId" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
<c:set var="urlMotorShowList" value="motorshows"/>
<c:set var="urlCarList" value="cars"/>
<c:set var="urlCarSave" value="carsave"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <title>Create or edit car</title>
</head>
<body class="carEdit">
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


<div align="center" class="carEdition col-lg-8">
    <form class="form" method="post" action="${urlCarSave}">
        <div class="form-group">
            <label for="model" class="text-right col-sm-3" control-label>Car model:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="model" id="model" placeholder="Model"
                       value="${car.model}">
            </div>
        </div>
        <div class="errs">
            ${errs.model}
        </div>

        <div class="form-group">
            <label for="productionDate" class="text-right col-sm-3" control-label>Production date:</label>
            <div class="col-sm-9">
                <input type="date" class="form-control" name="productionDate" id="productionDate"
                       placeholder="YYYY-MM-DD" value="${car.productionDate}">
            </div>
        </div>
        <div>
            ${errs.productionDate}
        </div>

        <div class="form-group">
            <label for="manufacturer" class="text-right col-sm-3" control-label>Manufacturer:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="manufacturer" id="manufacturer"
                       placeholder="Enter company name" value="${car.manufacturer}">
            </div>
        </div>
        <div>
            ${errs.manufacturer}
        </div>

        <div class="form-group">
            <label for="manufacturerEmail" class="text-right col-sm-3">Manufacturer E-mail:</label>
            <div class="col-sm-9">
                <input type="email" class="form-control" name="manufacturerEmail" id="manufacturerEmail"
                       placeholder="Enter E-mail" value="${car.manufacturerEmail}">
            </div>
        </div>
        <div>
            ${errs.manufacturerEmail}
        </div>

        <div class="form-group">
            <label for="price" class="text-right col-sm-3">Price:</label>
            <div class="col-sm-9">
                <input type="number" step="any" class="form-control" name="price" id="price" placeholder="Enter price"
                       value="${car.price}">
            </div>
        </div>
        <div>
            ${errs.price}
        </div>

        <div class="form-group">
            <label for="engineVolume" class="text-right col-sm-3">Engine volume:</label>
            <div class="col-sm-9">
                <input type="number" step="any" class="form-control" name="engineVolume" id="engineVolume"
                       placeholder="Enter volume of engine" value="${car.engineVolume}">
            </div>
        </div>
        <div>
            ${errs.engineVolume}
        </div>

        <div class="form-group">
            <label for="vinCode" class="text-right col-sm-3">VIN code:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="vinCode" id="vinCode"
                       placeholder="Enter VIN code" value="${car.vinCode}">
            </div>
        </div>
        <div>
            ${errs.vinCode}
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-8">
                <label>
                    <select name="motorShowIdFromSelect" size="1" <c:if
                        test="${motorShowId > 0 || id >0 }">hidden</c:if>>
                    <option selected="selected">Choose Motor Show</option>
                    <c:forEach var="MS" items="${mShows}">
                        <option value="${MS.id}">${MS.name}</option>
                    </c:forEach>
                    </select>
                </label>
            </div>
        </div>

        <div>
            <input type="hidden" name="id" value="${id}">
        </div>

        <div>
            <input type="hidden" name="motorShowIdFromHidden" value="${motorShowId}">
        </div>

        <div>
            <input type="hidden" name="motorShow" value="${motorShow}">
        </div>

        <button type="submit" class="btn">Submit</button>

    </form>
</div>
</body>
</html>

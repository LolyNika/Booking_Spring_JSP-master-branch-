<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Guests</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<style>
    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        background-color: #000000;
        color: white;
        text-align: center;
    }

    .test_btn {
        margin: 20px;
    }
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand">Booking Zone</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/bookings/listrooms">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/bookings/list">Booking</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/guests/list">Guests</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/rooms/list">Rooms</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">0.0.2</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<center><h1>Wellcum to rooms</h1></center>
<center>
    <h1><a href="/rooms/createroom">
        <button type="submit" class="btn btn-primary">Add New Room</button>
    </a></h1>
</center>

<%--<a href="/rooms/createbook">New book</a>--%>
<table id="myRooms" class="table table-hover test_btn">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">NameStatus</th>
        <th scope="col">Price</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="rooms" items="${rooms}">
        <tr>
            <td>${rooms.idRoom}</td>
            <td>${rooms.nameRoom}</td>
            <td>${rooms.roomstatus.nameStatus}</td>
            <td>${rooms.rate.price}</td>
            <td>
                <a href="/rooms/${rooms.idRoom}/editrooms">
                    <button type="submit" class="btn btn-primary">Edit Room</button>
                </a>
                <a href="/rooms/${rooms.idRoom}/delete">
                    <button type="submit" class="btn btn-primary">Delete Room</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="footer">
    <p>&copy;LolyNIka 2021</p>
</div>
</body>
</html>

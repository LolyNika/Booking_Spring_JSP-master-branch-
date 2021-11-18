<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>List of Bookings</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
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
<body>
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
                    <a class="nav-link active" href="/bookings/list">Booking</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/guests/list">Guests</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/rooms/list">Rooms</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">0.0.2</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<center>
    <h1>Wellcum to bookings</h1>
    <br/>
    <p><input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search..."></p>
    <script>
        function myFunction() {
            var input, filter, table, tr, td, i, a, txtValue;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");

            /**
             * if you need make search only for one cologne - delete for (a) and "break;",
             * and instead [a] -> [number cologne]
             */
            for (i = 0; i < tr.length; i++) {
                for (a = 0; a < 17; a++) {
                    td = tr[i].getElementsByTagName("td")[a];
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                            break;
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        }
    </script>
    <table id="myTable" class="table table-hover test_btn">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">checkindate</th>
            <th scope="col">checkoutdate</th>
            <th scope="col">adultscount</th>
            <th scope="col">childrencount</th>
            <th scope="col">roomtype</th>
            <th scope="col">comment</th>
            <th scope="col">bookingstatus</th>

            <th scope="col">CardHolderName</th>
            <th scope="col">PayID</th>
            <th scope="col">Address</th>
            <th scope="col">NameRoom</th>
            <th scope="col">Price</th>
            <th scope="col">RoomStatus</th>
            <th scope="col">Action</th>

            <%--            <th scope="col">#</th>--%>
            <%--            <th scope="col">Name Guest</th>--%>
            <%--            <th scope="col">Mobile</th>--%>
            <%--            <th scope="col">Email</th>--%>
            <%--            <th scope="col">Address</th>--%>

            <%--            <th scope="col">#</th>--%>
            <%--            <th scope="col">Name Room</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="bookings" items="${bookings}">
            <tr>
                <td>${bookings.idBooking}</td>
                <td>${bookings.checkInDate}</td>
                <td>${bookings.checkOutDate}</td>
                <td>${bookings.adultsCount}</td>
                <td>${bookings.childrenCount}</td>
                <td>${bookings.roomType}</td>
                <td>${bookings.comment}</td>
                <td>${bookings.bookingStatus}</td>

                <td>${bookings.paymethod.cardholderName}</td>

                <td>${bookings.paymethod.paymethodId}</td>

                <td>${bookings.guest.address}</td>

                <td>${bookings.room.nameRoom}</td>

                <td>${bookings.rate.price}$</td>

                <td>${bookings.roomstatus.nameStatus}</td>
                <td>
                        <%--                    <a href="/rooms/${rooms.idRoom}/editrooms">--%>
                        <%--                        <button type="submit" class="btn btn-primary">Edit Room</button>--%>
                        <%--                    </a>--%>
                    <form action='/bookings/delete' method='get'>
                        <input type="hidden" value="${bookings.idBooking}" name="idBooking"/>
                        <input type="hidden" value="${bookings.room.nameRoom}" name="nameRoom"/>
                        <input type="hidden" value="${bookings.rate.rateId}" name="rateId"/>
                        <input type="hidden" value="${bookings.room.idRoom}" name="idRoom"/>
                        <button type="submit" class="btn btn-primary">Delete Book</button>
                    </form>
<%--                    <a href="/bookings/${bookings.idBooking}/delete">--%>
<%--                        <button type="submit" class="btn btn-primary">Delete Book</button>--%>
<%--                    </a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</center>
<div class="footer">
    <p>&copy;LolyNIka 2021</p>
</div>
</body>
</html>
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
<style>
    .test_btn {
        margin: 0 30px 0 30px; /*top right bottom left*/
    }
</style>
<div class="test_btn">
    Book Registration
</div>
<form action='/bookings/create' method="post">
    <input type="hidden" value="${rateId}" name="rateId"/>
    <input type="hidden" value="${idroomm}" name="idroom"/>
    <input type="hidden" value="${nameroomm}" name="nameroom"/>
    <input type="hidden" value="${users.userId}" name="userId"/>
    <input type="hidden" value="${users.nameUser}" name="nameUser"/>
    <input type="hidden" value="${users.userRole.roleId}" name="roleId"/>
    <div class="col-md-4 test_btn">
        <label for="validationCustom50" class="form-label">Name</label>
        <input type="text" name="nameGuest" class="form-control" id="validationCustom50">
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputEmail51" class="form-label">Mobile</label>
        <input type="text" name="mobile" class="form-control" id="exampleInputEmail51" aria-describedby="emailHelp">
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputPassword52" class="form-label">Email</label>
        <input type="email" name="email" class="form-control" id="exampleInputPassword52">
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputPassword53" class="form-label">Address</label>
        <input type="text" name="address" class="form-control" id="exampleInputPassword53">
    </div>
<%--    <div class="col-md-4 test_btn">--%>
<%--        <label for="validationCustom01" class="form-label">idbook</label>--%>
<%--        <input type="text" name="idbooking" class="form-control" id="validationCustom01">--%>
<%--    </div>--%>
    <div class="col-md-4 test_btn">
        <label for="validationCustom02" class="form-label">adultscount</label>
        <input type="text" name="adultscount" class="form-control" id="validationCustom02">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom03" class="form-label">childrencount</label>
        <input type="text" name="childrencount" class="form-control" id="validationCustom03">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom04" class="form-label">roomtype</label>
        <input type="text" name="roomtype" class="form-control" id="validationCustom04">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom05" class="form-label">bookingstatus</label>
        <input type="text" name="bookingstatus" class="form-control" id="validationCustom05">
    </div>
    <div class="mb-3 test_btn">
        <label for="subject" class="form-label">Comments</label>
        <textarea id="subject" name="comment" class="form-control" style="height:200px"></textarea>
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputPassword22" class="form-label">checkindate</label>
        <input type="date" id="exampleInputPassword22" name="checkindate" max="2050-04-20" min="2020-04-10" value="2021-08-15"/>
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInput" class="form-label">checkoutdate</label>
        <input type="date" id="exampleInput" name="checkoutdate" max="2050-04-20" min="2020-04-10" value="2021-08-15"/>
    </div>
<%--    <input type="hidden" value="${rooms.idRoom}" name="idroom"/>--%>
<%--    <input type="hidden" value="${rooms.nameRoom}" name="nameroom"/>--%>
<%--    <input type="hidden" value="${rooms.roomstatus.idroomStatus}" name="idroomStatus"/>--%>
<%--    <input type="hidden" value="${rooms.rate.}" name="nameroom"/>--%>
    <div class="col-md-4 test_btn">
        <label for="validationCustom60" class="form-label">name</label>
        <input type="text" name="name" class="form-control" id="validationCustom60">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom61" class="form-label">cardholderName</label>
        <input type="text" name="cardholderName" class="form-control" id="validationCustom61">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom62" class="form-label">expirationDate</label>
        <input type="text" name="expirationDate" class="form-control" id="validationCustom62">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom63" class="form-label">cardNumber</label>
        <input type="text" name="cardNumber" class="form-control" id="validationCustom63">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom64" class="form-label">cvsCode</label>
        <input type="text" name="cvsCode" class="form-control" id="validationCustom64">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom65" class="form-label">transactionDate</label>
        <input type="text" name="transactionDate" class="form-control" id="validationCustom65">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom66" class="form-label">transactionStatus</label>
        <input type="text" name="transactionStatus" class="form-control" id="validationCustom66">
    </div>
    <div class="col-md-4 test_btn">
        <label for="validationCustom67" class="form-label">sum</label>
        <input type="text" name="sum" class="form-control" id="validationCustom67">
    </div>
<%--    <div class="mb-3 test_btn">--%>
<%--        <label for="exampleInputPassword3" class="form-label">Id</label>--%>
<%--        <input type="hidden" name="idguest" class="form-control" id="exampleInputPassword3">--%>
<%--    </div>--%>
    <button type="submit" class="btn btn-primary test_btn">Submit</button>
</form>
</body>
</html>
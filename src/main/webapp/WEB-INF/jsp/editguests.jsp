<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Edit Guest</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<style>
    .test_btn {
        margin: 20px;
    }
</style>
<div class="test_btn">
    Updating Guest Information
</div>
<%--<h3> class="col-md-4 test_btn" Guest Registration</h3>--%>
<form action='/guests/update' method='post'>
    <div class="col-md-4 test_btn">
        <span for="validationCustom01" class="form-label">Name</span>
        <input type="text" name="nameGuest" value="${guests.nameGuest}" class="form-control" id="validationCustom01">
    </div>
    <div class="col-md-4 test_btn">
        <span for="validationCustom02" class="form-label">Name</span>
        <input type="text" name="mobile" value="${guests.mobile}" class="form-control" id="validationCustom02">
    </div>
    <div class="col-md-4 test_btn">
        <span for="validationCustom03" class="form-label">Name</span>
        <input type="text" name="email" value="${guests.email}" class="form-control" id="validationCustom03">
    </div>
    <div class="col-md-4 test_btn">
        <span for="validationCustom04" class="form-label">Name</span>
        <input type="text" name="address" value="${guests.address}" class="form-control" id="validationCustom04">
    </div>
    <input type="hidden" value="${guests.idGuest}" name="idGuest"/>
    <button type="submit" class="btn btn-primary test_btn">Submit</button>


    <%--        <table class='table table-hover table-responsive table-bordered'>--%>

    <%--            <tr>--%>
    <%--                <td><b>Name</b></td>--%>
    <%--                <td><input type='text' name='nameGuest' class='form-control' value="${guests.nameGuest}" /></td>--%>
    <%--            </tr>--%>

    <%--            <tr>--%>
    <%--                <td><b>Mobile</b></td>--%>
    <%--                <td><input type='text' name='mobile' class='form-control' value="${guests.mobile}" /></td>--%>
    <%--            </tr>--%>

    <%--            <tr>--%>
    <%--                <td><b>Email</b></td>--%>
    <%--                <td><input type='text' name='email' class='form-control' size="20" value="${guests.email}" /></td>--%>
    <%--            </tr>--%>

    <%--            <tr>--%>
    <%--                <td><b>Address</b></td>--%>
    <%--                <td><input type='text' name='address' class='form-control' size="20" value="${guests.address}" /></td>--%>
    <%--            </tr>--%>

    <%--            <input type='hidden' id='idGuest' rows='5' class='form-control' name='idGuest' value="${guests.idGuest}"/>--%>
    <%--            <tr>--%>
    <%--                <td></td>--%>
    <%--                <td>--%>
    <%--                    <button type="submit" class="btn btn-primary">Update Guest Information</button>--%>
    <%--                </td>--%>
    <%--            </tr>--%>

    <%--        </table>--%>
</form>
</body>
</html>
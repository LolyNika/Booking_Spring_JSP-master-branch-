<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Edit Room</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<style>
    .test_btn {
        margin: 20px;
    }
</style>
<div class="test_btn">
    Updating Room Information
</div>
<form action='/rooms/update'  method="post">
    <input type="hidden" value="${rooms.idRoom}" name="idroom" />
    <div class="col-md-4 test_btn">
        <span for="validationCustom02" class="form-label">Name</span>
        <input type="text" name="nameRoom" value="${rooms.nameRoom}"  class="form-control" id="validationCustom02">
    </div>
    <button type="submit" class="btn btn-primary test_btn">Submit</button>
</form>
</body>
</html>
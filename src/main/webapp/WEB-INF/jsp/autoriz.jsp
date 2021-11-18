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
        margin:0 30px 0 30px; /*top right bottom left*/
    }
</style>
<form action='/users/enter' method='get'>
    <div class="col-md-4 test_btn">
        <label for="validationCustom01" class="form-label">Name</label>
        <input type="text" name="nameUser" class="form-control" id="validationCustom01">
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputPassword3" class="form-label">Password</label>
        <input type="text" name="password" class="form-control" id="exampleInputPassword3">
    </div>
<%--    <a href="/users/enter">--%>
<%--        <button type="submit" class="btn btn-primary test_btn">Enter</button>--%>
<%--    </a>--%>
    <button type="submit" class="btn btn-primary test_btn">Enter</button>
</form>
</html>
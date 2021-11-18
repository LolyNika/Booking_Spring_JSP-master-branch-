<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>New Room</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<style>
    .test_btn {
        margin:0 30px 0 30px; /*top right bottom left*/
    }
</style>
<div class="test_btn">
    Room Registration
</div>
<form action='/rooms/create' method='post'>
    <div class="col-md-4 test_btn">
        <label for="validationCustom01" class="form-label">Name</label>
        <input type="text" name="nameRoom" class="form-control" id="validationCustom01">
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputPassword4" class="form-label">Date</label>
        <input type="text" name="date" class="form-control" id="exampleInputPassword4">
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputPassword5" class="form-label">Price</label>
        <input type="text" name="price" class="form-control" id="exampleInputPassword5">
    </div>
    <button type="submit" class="btn btn-primary test_btn">submit</button>
</form>
</body>
</html>
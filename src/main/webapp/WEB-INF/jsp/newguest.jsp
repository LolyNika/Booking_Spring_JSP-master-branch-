<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
<div class="test_btn">
    Guest Registration
</div>
<form action='/guests/create' method='post'>
    <input type="hidden" value="${users.userId}" name="userId"/>
    <input type="hidden" value="${users.nameUser}" name="nameUser"/>
    <input type="hidden" value="${users.userRole.roleId}" name="roleId"/>
    <div class="col-md-4 test_btn">
        <label for="validationCustom01" class="form-label">Name</label>
        <input type="text" name="nameGuest" class="form-control" id="validationCustom01">
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputEmail1" class="form-label">Mobile</label>
        <input type="text" name="mobile" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputPassword1" class="form-label">Email</label>
        <input type="email" name="email" class="form-control" id="exampleInputPassword1">
    </div>
    <div class="mb-3 test_btn">
        <label for="exampleInputPassword2" class="form-label">Address</label>
        <input type="text" name="address" class="form-control" id="exampleInputPassword2">
    </div>
    <button type="submit" class="btn btn-primary test_btn">submit</button>
</form>
</body>
</html>
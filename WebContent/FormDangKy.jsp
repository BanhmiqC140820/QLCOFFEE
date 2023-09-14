<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="icon" href="Logo.png" type="image/png">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="javascript:void(0)"><img  src="Logo.png"style=" width:50%; display: block; margin: 0 auto;"></a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="mynavbar">
	      <ul class="navbar-nav me-auto">
	        <li class="nav-item">
	          <a class="nav-link" href="CoffeeController">Trang chủ</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">Giỏ hàng
	          <span class="badge bg-white text-primary"></span>
	          </a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">Giới Thiệu</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">Sản Phẩm</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">Tin Tức</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">Liên Hệ</a>
	        </li>        
	      </ul>
	      <form action="CoffeeController" method="post" class="d-flex ms-auto me-auto">
	        <input class="form-control me-2" type="text" placeholder="Search">
	        <button class="btn btn-primary" type="button">Search</button>
	      </form>
	      <ul class="navbar-nav ms-auto">
	      <c:choose>
	      <c:when test="${sessionScope.customer==null}">
	      	<li class="nav-item btn"><a class="nav-link" href="DangkyController">Đăng ký</a></li>
		    <li class="nav-item btn  btn-primary"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#ModalLogin">Đăng nhập</a></li>
		  </c:when>
		  <c:otherwise>
		  	<div class="dropdown">
			    <a class="btn dropdown-toggle" href="#" role="button" id="user-dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			        <img src="images/user.png" alt="user profile" style=" width:50%;margin: 0 auto;">
			    </a>
			    <ul class="dropdown-menu bg-white" aria-labelledby="user-dropdown-toggle">
			        <li><a class="dropdown-item" href="#">Đổi Mật Khẩu</a></li>
			        <li><hr class="dropdown-divider"></li>
			        <li><a class="dropdown-item" href="DangXuatController">Đăng Xuất</a></li>
			    </ul>
			</div>
		  	
		  </c:otherwise>
		  </c:choose>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="modal fade" id="ModalLogin" role="dialog">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h2 class="modal-title">Đăng nhập</h2>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <form action="DangNhapController" method="post">
			  <div class="mb-3 mt-3">
			    <label for="username" class="form-label" >usename:</label>
			    <input type="text" class="form-control" placeholder="username" name="username" required>
			  </div>
			  <div class="mb-3">
			    <label class="form-label" >Password:</label>
			    <input type="password" class="form-control" id="pwd" placeholder="password" name="pswd" required>
			  </div>
			  <div class="mb-3">
			    <img src="simpleCaptcha.jpg" class="form-control" >
			    <input type="text" name="answer" class="form-control">
			  </div>
			  <button type="submit" class="btn btn-primary">Đăng nhập</button>
			</form>
	      </div>
	     </div>
	    </div>
	   </div>
	   <div class="modal fade" id="Nofication">
		  <div class="modal-dialog modal-sm">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h6 class="modal-title">Tên Đăng Nhập đã tồn tại</h6>
		        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		      </div>

		    </div>
		  </div>
		</div>
	<div class="container mt-5">
    <h1 class="mb-4">Đăng Ký</h1>
	    <form action="DangkyController" method="post">
	        <div class="mb-3">
	            <label for="fullName" class="form-label">Họ và Tên</label>
	            <input type="text" class="form-control" id="fullName" name="fullName" required>
	        </div>
	        <div class="mb-3">
	            <label for="address" class="form-label">Địa Chỉ</label>
	            <input type="text" class="form-control" id="address" name="address" required>
	        </div>
	        <div class="mb-3">
	            <label for="phone" class="form-label">Số Điện Thoại</label>
	            <input type="tel" class="form-control" id="phone" name="phone" required>
	        </div>
	        <div class="mb-3">
	            <label for="email" class="form-label">Email</label>
	            <input type="email" class="form-control" id="email" name="email" required>
	        </div>
	        <div class="mb-3">
	            <label for="username" class="form-label">Tên đăng nhập</label>
	            <input type="text" class="form-control" id="username" name="username" required>
	        </div>
	        <div class="mb-3">
	            <label for="password" class="form-label">Mật Khẩu</label>
	            <input type="password" class="form-control" id="password" name="password" required>
	        </div>
	        <div class="mb-3">
	            <label for="confirmPassword" class="form-label">Xác Nhận Mật Khẩu</label>
	            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
	        </div>
	        <div id="passwordMismatchAlert" class="alert alert-danger" style="display: none;">
    			Mật khẩu và xác nhận mật khẩu không khớp.
			</div>
	        <div class="mb-3 form-check">
	            <input type="checkbox" class="form-check-input" id="agreeTerms" required>
	            <label class="form-check-label" for="agreeTerms">Tôi đồng ý với các điều khoản và điều kiện</label>
	        </div>
	        <button type="submit" class="btn btn-primary">Đăng Ký</button>
	    </form>
    </div>
	<script>
	    const passwordField = document.getElementById('password');
	    const confirmPasswordField = document.getElementById('confirmPassword');
	    const mismatchAlert = document.getElementById('passwordMismatchAlert');
	
	    function checkPasswordMatch() {
	        if (passwordField.value !== confirmPasswordField.value) {
	            mismatchAlert.style.display = 'block';
	            return false;
	        } else {
	            mismatchAlert.style.display = 'none';
	            return true;
	        }
	    }
	
	    // Thêm sự kiện cho việc kiểm tra khi nhập liệu
	    confirmPasswordField.addEventListener('input', checkPasswordMatch);
	</script>
	<c:if test="${DkCheck!=null}">
		<script>
		  window.onload = function() {
		    var modal = new bootstrap.Modal(document.getElementById("Nofication"));
		    modal.show();
		  };
		</script> 
	</c:if>

</body>

	  <div class="container">
		<footer class="bg-dark text-white py-0">
		    <div class="row justify-content-center">
		      <div class="col-auto">
		        <ul class="nav">
		          <li class="nav-item"><a href="#" class="nav-link text-white">Home</a></li>
		          <li class="nav-item"><a href="#" class="nav-link text-white">Features</a></li>
		          <li class="nav-item"><a href="#" class="nav-link text-white">Pricing</a></li>
		          <li class="nav-item"><a href="#" class="nav-link text-white">FAQs</a></li>
		          <li class="nav-item"><a href="#" class="nav-link text-white">About</a></li>
		        </ul>
		      </div>
		    </div>
		    <div class="row justify-content-center mt-3">
		      <div class="col-auto">
		        <p class="mb-0">© 2023 Your Company, Inc</p>
		      </div>
		    </div>
		</footer>
	</div>

</html>
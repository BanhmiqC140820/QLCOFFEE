<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Reset Password</title>
  <!-- Add Bootstrap CSS link here -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
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
		  	<li class="dropdown">
			    <a class="btn dropdown-toggle" href="#" role="button" id="user-dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			        <img src="images/user.png" alt="user profile" style=" width:50%;margin: 0 auto;">
			    </a>
			    <ul class="dropdown-menu bg-white" aria-labelledby="user-dropdown-toggle">
			        <li><a class="dropdown-item" href="#">Đổi Mật Khẩu</a></li>
			        <li><hr class="dropdown-divider"></li>
			        <li><a class="dropdown-item" href="DangXuatController">Đăng Xuất</a></li>
			    </ul>
			</li>
		  	
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
	 <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-body">
            <h2 class="card-title">Reset Password</h2>
            <form action="ResetPassController" method="post">
              <div class="mb-3">
                <label class="form-label">Mật khẩu hiện tại:</label>
                <input type="password" class="form-control" name="mk" required>
              </div>
              <div class="mb-3">
                <label class="form-label">Mật khẩu mới:</label>
                <input type="password" class="form-control" name="mknew" id="password" required>
              </div>
               <div class="mb-3">
                <label class="form-label">Xác nhận mật khẩu:</label>
                <input type="password" class="form-control" name="mknew1" id="confirmPassword" required>
              </div>
             <div id="passwordMismatchAlert" class="alert alert-danger" style="display: none;">
    			Mật khẩu và xác nhận mật khẩu không khớp.
			</div>
              <div class="mb-3">
                <button type="submit" class="btn btn-primary">Send Reset Link</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
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
</body>
</html>
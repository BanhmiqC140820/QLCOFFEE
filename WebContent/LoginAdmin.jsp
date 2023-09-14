<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="icon" href="Logo.png" type="image/png">
    <link rel="stylesheet" href="styles.css">
    <title>Đăng Nhập</title>
</head>
<body class="bg-gradient">
	<div class="modal fade" id="Nofication">
		  <div class="modal-dialog modal-sm">
		    <div class="modal-content">
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">Đăng nhập thất bại</h4>
		        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		     </div>
		   </div>
		</div>
	</div>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card login-card">
            <div class="card-body">
                <h4 class="card-title text-center mb-4">Đăng Nhập</h4>
                <form action="LoginADcontroller" method="post">
                    <div class="mb-3">
                        <input type="text" class="form-control" name="username" placeholder="Tên đăng nhập" required>
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required>
                    </div>
                     <div class="mb-3">
			   			 <img src="simpleCaptcha.jpg" class="form-control" >
			    		<input type="text" name="answer" class="form-control" placeholder="Nhập captcha" required>
			  </div>
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-primary btn-block">Đăng Nhập</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <c:if test="${checklogin!=null}">
		<script>
		  window.onload = function() {
		    var modal = new bootstrap.Modal(document.getElementById("Nofication"));
		    modal.show();
		  };
		</script> 
	</c:if>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
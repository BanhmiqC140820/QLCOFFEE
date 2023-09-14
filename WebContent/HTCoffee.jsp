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
<title>Trang Khách Hàng</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="javascript:void(0)"><img  src="Logo.png"style=" width:50%; height:auto display: block; margin: 0 auto;"></a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="mynavbar">
	      <ul class="navbar-nav me-auto">
	        <li class="nav-item">
	          <a class="nav-link" href="CoffeeController">Trang chủ</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="HtGioHang">Giỏ hàng
	          <span class="badge bg-white text-primary">${SoLuongMH}</span>
	          </a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="GioiThieu.jsp">Giới Thiệu</a>
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
	        <input class="form-control me-2" type="text" placeholder="Search" name="Search"> 
	        <button class="btn btn-primary" type="button">Search</button>
	      </form>
	      <ul class="navbar-nav ms-auto">
	      <c:choose>
	      <c:when test="${sessionScope.customer==null}">
	      	<li class="nav-item btn"><a class="nav-link" href="DangkyController">Đăng ký</a></li>
		    <li class="nav-item btn  btn-primary"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#ModalLogin">Đăng nhập</a></li>
		  </c:when>
		  <c:otherwise>
		  	<li class="dropdown">
			    <a class="btn dropdown-toggle" href="#" role="button" id="user-dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			        <img src="images/user.png" alt="user profile" style=" width:50%;margin: 0 auto;">
			    </a>
			    <ul class="dropdown-menu bg-white" aria-labelledby="user-dropdown-toggle">
			    	<li><a class="dropdown-item" href="LSController">Lịch sử mua hàng</a></li>
			        <li><a class="dropdown-item" href="ResetPassController">Đổi Mật Khẩu</a></li>
			        <li><hr class="dropdown-divider"></li>
			        <li><a class="dropdown-item" href="DangXuatController">Đăng Xuất</a></li>
			    </ul>
			</li>
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
			    <input type="text" name="answer" class="form-control" required>
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
		        <h4 class="modal-title">Đăng ký Thành công</h4>
		        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		      </div>
		    </div>
		  </div>
		</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<ul class="list-group list-group-flush">
				  <li class="list-group-item">
					  <a class="list-group-item border border-0" href="CoffeeController">
					  All
					  </a>
				  </li>
				<c:forEach var="loai" items="${dsloai}">
				  <li class="list-group-item">
					  <a class="list-group-item border border-0" href="CoffeeController?ml=${loai.getMaLoai()}">
					  ${loai.getTenLoai()}
					  </a>
				  </li>
				</c:forEach>
				</ul>
			</div>
			<div class="d-flex flex-wrap col-sm-9 mt-2" >
			<c:forEach var="xn" items="${ds}">
				<div class="card col-12 col-sm-6 col-lg-4 mb-2">
					<div class="card-body d-flex flex-column justify-content-center" >
						<img class="card-img-top" src="${xn.getLinkAnh()}" alt="Card image" style=" display: block; margin: 0 auto;">
						<div class="card-body text-center">
							<h6 class="card-title"><a href="CTSPController?msp=${xn.getMaSanPham()}" class="btn">${xn.getTenSanPHam()}</a></h6>
							<h4 class="card-text">${xn.getGia()} VNĐ</h4>
							<a href="GioHangController?msp=${xn.getMaSanPham()}&tsp=${xn.getTenSanPHam() }&gia=${xn.getGia()}&Img=${xn.getLinkAnh()}" class="btn"><img src="mua.png"></a>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
		<ul class="pagination justify-content-center">
			<c:forEach var="i" begin="1" end="${soTrang}">
		    <li class="page-item"><a class="page-link" href="CoffeeController?page=${i}&ml=${ml}">${i}</a></li>
		    <!-- Thêm các nút trang khác ở đây -->
			</c:forEach>
		</ul>
	</div>
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
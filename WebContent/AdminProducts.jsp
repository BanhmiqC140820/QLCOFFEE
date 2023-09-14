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
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Trang Quản Trị</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">Admin Panel</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="AdminDashboard.jsp">Dashboard</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="QlloaiController">Type of Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminPRDController">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminOrderController">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Customers</a>
                    </li>
                </ul>    
            <ul class=" navbar-nav ms-auto">
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

    <div class="container mt-4">
	    <div class="row">
	        <div class="col-md-6">
	            <form action="AdminPRDController" method="post" class="p-4 border rounded">
	                <h4 class="mb-4">PRODUCTS</h4>
	                <div class="mb-3">
	                    <label class="form-label">Mã Sản phẩm:</label>
	                    <input type="text" class="form-control" name="MaSP" value="${coffee.getMaSanPham()}" required>
	                </div>
	                <div class="mb-3">
	                    <label class="form-label">Tên Sản phẩm:</label>
	                    <input type="text" class="form-control" name="TenSP" value="${coffee.getTenSanPHam()}" required>
	                </div>
	                <div class="mb-3">
	                    <label class="form-label">Số lượng:</label>
	                    <input type="number" class="form-control" name="SoLuong" value="${coffee.getSoLuong()}" required>
	                </div>

	                <div class="mb-3">
	                    <label class="form-label">Giá:</label>
	                    <input type="number" class="form-control" name="Gia" value="${coffee.getGia()}" required>
	                </div>
	                <div class="mb-3">
	                    <label class="form-label">Xuất xứ:</label>
	                    <input type="text" class="form-control" name="Xuatxu" value="${coffee.getXuatXu()}" required>
	                </div>
	                <div class="mb-3">
	                    <label class="form-label">Mã Loại:</label>
	                        <select class="form-select" id="sel1" name="MaLoai">
	                        <c:forEach var="loai" items="${dsloai}">
	                        	<c:if test="${loai.getMaLoai().equals(coffee.getMaLoai())}">
	                        	 	<option value="${loai.getMaLoai()}" selected>${loai.getTenLoai()}</option>
	                        	</c:if>
						      <option value="${loai.getMaLoai()}">${loai.getTenLoai()}</option>
						      </c:forEach>
						    </select>
	                    <%-- <input type="text" class="form-control" name="MaLoai" value="${coffee.getMaLoai()}" required> --%>
	                </div>
	                <div class="d-flex justify-content-between">
	                    <input type="submit" class="btn btn-primary" name="Add" value="Add">
	                    <input type="submit" class="btn btn-primary" name="update" value="Update">
	                </div>
	            </form>
	        </div>
	        <div class="col-md-6">
	            <form action="AdminPRDController" method="post" enctype="multipart/form-data" class="p-4 border rounded">
	                <h4 class="mb-4">UPDATE IMAGE FOR PRODUCT</h4>
	                <div class="mb-3">
	                    <label class="form-label">Mã sản phẩm:</label>
	                    <input type="text" class="form-control" name="maSPanh" value="${coffee.getMaSanPham()}" required>
	                </div>
	                <!-- Các trường khác của biểu mẫu 2 -->
	                <div class="mb-3">
	                    <label class="form-label">Ảnh:</label>
	                    <input type="file" class="form-control mt-2" name="anh" accept="image/*" required>
	                </div>
	                <div class="d-flex justify-content-between">
	                    <input type="submit" class="btn btn-primary" name="submitAnh" value="submit">
	                </div>
	            </form>
	        </div>
	    </div>
        <table class="table">
        	<c:forEach var="xn" items="${ds}">
        		<tbody>
        		 <tr>
        			<td>${xn.getMaSanPham()}</td>
        			<td>${xn.getTenSanPHam()}</td>
        			<td>${xn.getGia()}</td>
        			<td>${xn.getSoLuong()}</td>
        			<td>${xn.getXuatXu()}</td>
        			<td>${xn.getMaLoai()}</td>
        			<td><img class="mx-auto d-block" src="${xn.getLinkAnh()}" style=" width:25%;height:auto; margin:0 auto;"> </td>
        			<td><a class="btn" href="AdminPRDController?mSPSelect=${xn.getMaSanPham()}&tab=select">SELECT</a></td>
			    	<td><a class="btn" href="AdminPRDController?mSPDelete=${xn.getMaSanPham()}&tab=delete">DELETE</a></td>
        		 </tr>
        		</tbody>
        	</c:forEach>
        </table>
    </div>
		<ul class="pagination justify-content-center">
			<c:forEach var="i" begin="1" end="${soTrang}">
		    <li class="page-item"><a class="page-link" href="AdminPRDController?page=${i}&ml=${ml}">${i}</a></li>
			</c:forEach>
		</ul>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
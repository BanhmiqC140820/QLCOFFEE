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
        <h1>Dashboard</h1>
        <p>Welcome to the admin dashboard. Manage your products, orders, and customers here.</p>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
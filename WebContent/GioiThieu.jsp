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
		  	<div class="dropdown">
			    <a class="btn dropdown-toggle" href="#" role="button" id="user-dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			        <img src="images/user.png" alt="user profile" style=" width:50%;margin: 0 auto;">
			    </a>
			    <ul class="dropdown-menu bg-white" aria-labelledby="user-dropdown-toggle">
			    	<li><a class="dropdown-item" href="LSController">Lịch sử mua hàng</a></li>
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
	<div class="container mt-5">
	    <div class="row">
	        <div class="col-lg-8 offset-lg-2">
	            <div class="card">
	                <img src="GioiThieuCofffe.jpg" class="card-img-top" alt="Hình ảnh minh họa">
	                <div class="card-body">
	                    <h1 class="card-title">Chào mừng đến với CoffeeMall - Nơi Hương Vị Cà Phê Thăng Hoa</h1>
	                    <p class="card-text">Chào các tín đồ cà phê yêu thích! Hãy cùng chào đón một trải nghiệm mua sắm cà phê tuyệt vời tại CoffeeMall - nơi hội tụ những hương vị đậm đà và tinh tế nhất từ khắp nơi trên thế giới. Chúng tôi tự hào là địa điểm mua sắm trực tuyến dành riêng cho những người đam mê cà phê, nơi bạn có thể tìm thấy những sản phẩm tốt nhất để tạo ra những ly cà phê hoàn hảo.                
	                    </p>
	                    <p><strong> <strong>Vô vàn lựa chọn cà phê đa dạng</strong></strong></p>
	                    <p>Tại CoffeeMall, chúng tôi cung cấp một loạt các loại cà phê đa dạng từ các khu vực sản xuất nổi tiếng trên thế giới. Bạn có thể khám phá những hạt cà phê Arabica mềm mịn từ đồng bằng Ethiopia, hoặc trải nghiệm sự đậm đà của Robusta từ xứ sở Brazil. Từ cà phê hạt đến cà phê bột, chúng tôi cam kết mang đến cho bạn sự lựa chọn đa dạng để thỏa mãn mọi khẩu vị.</p>
	                    <p><strong> <strong>Dụng cụ và phụ kiện chất lượng</strong></strong></p>
	                    <p>Chúng tôi không chỉ cung cấp cà phê nguyên chất mà còn có sẵn các dụng cụ và phụ kiện cần thiết để bạn có thể tận hưởng cả quy trình pha chế cà phê tại nhà. Từ máy xay cà phê chuyên nghiệp cho đến bộ lọc thảo dược thơm ngon, chúng tôi cam kết cung cấp những sản phẩm chất lượng nhất để bạn trở thành một chuyên gia pha chế cà phê tại gia.</p>
	                    <p><strong> <strong>Cam kết chất lượng và nguồn gốc</strong></strong></p>
	                    <p>Chất lượng là tâm huyết của chúng tôi. Chúng tôi tận tâm đảm bảo mỗi hạt cà phê đều được chọn lựa cẩn thận từ những vùng đất đẹp nhất, và qua mỗi quy trình chế biến và đóng gói nghiêm ngặt. Với CoffeeMall, bạn không chỉ mua cà phê, mà còn mua cả niềm đam mê và trải nghiệm cà phê thú vị.</p>
	                    <p><strong> <strong>Chia sẻ đam mê - Học pha chế cùng chúng tôi</strong></strong></p>
	                    <p>Nếu bạn là người mới bắt đầu, đừng lo lắng! Chúng tôi cung cấp những tài liệu hướng dẫn pha chế cà phê từng bước, giúp bạn nắm vững từng kỹ thuật và tạo ra những tách cà phê thơm ngon ngay tại nhà.</p>
	                    <p>Hãy tham gia cùng chúng tôi để khám phá và trải nghiệm sự hòa quyện của hương vị cà phê tại CoffeeMall. Chúng tôi luôn sẵn sàng phục vụ và mang đến cho bạn những trải nghiệm mua sắm tuyệt vời nhất.</p>
	                   	<p><strong>Chúng tôi ở đây để phục vụ bạn</strong> </p>
	                   	<p>CoffeeMall không chỉ là một trang web mua sắm cà phê, mà còn là một cộng đồng đam mê cà phê. Chúng tôi luôn sẵn sàng lắng nghe ý kiến của bạn và giải đáp mọi thắc mắc. Nếu bạn cần tư vấn về cách lựa chọn cà phê phù hợp cho mình, hay cần hỗ trợ về việc pha chế, đừng ngần ngại liên hệ với đội ngũ chăm sóc khách hàng của chúng tôi.</p>
	                   	<p><strong>Ưu đãi và khuyến mãi thường xuyên</strong></p>
	                   	<p>Chúng tôi hiểu rằng việc tạo ra những trải nghiệm thú vị không chỉ dừng lại ở chất lượng sản phẩm. Vì vậy, CoffeeMall thường xuyên cập nhật các chương trình khuyến mãi, ưu đãi đặc biệt và quà tặng hấp dẫn để bạn có thể thưởng thức cà phê yêu thích mà không lo về giá cả.</p>
	                   	<p><strong>Đặt hàng dễ dàng - Giao hàng tận nơi</strong></p>
	                   	<p>Việc đặt hàng tại CoffeeMall rất đơn giản. Bạn chỉ cần lựa chọn các sản phẩm bạn muốn, thêm vào giỏ hàng và tiến hành thanh toán. Chúng tôi cam kết cung cấp dịch vụ giao hàng tận nơi nhanh chóng và đáng tin cậy, giúp bạn nhận được các sản phẩm cà phê ưng ý một cách dễ dàng.</p>
	                   
	                    <p class="card-text">Ngày Đăng: <span class="news-date">16 Tháng 8, 2023</span></p>
	                    <p class="card-text">Người viết: <span class="author-name">John Doe</span></p>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>

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
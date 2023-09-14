package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.CustomerBo;

/**
 * Servlet implementation class DangkyController
 */
@WebServlet("/DangkyController")
public class DangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangkyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setCharacterEncoding("utf-8");
	  		request.setCharacterEncoding("utf-8");
	  		String hovaten=request.getParameter("fullName");
	  		String diachi=request.getParameter("address");
	  		String sdt=request.getParameter("phone");
	  		String email=request.getParameter("email");
	  		String tendn=request.getParameter("username");
	  		String matkhau=request.getParameter("password");
	  		CustomerBo cusbo=new CustomerBo();
			if(matkhau!=null)
				matkhau=cusbo.getMD5Hash(matkhau);
	  		if(hovaten!=null)
	  		if(cusbo.register(hovaten, diachi, sdt, email, tendn, matkhau)==0) {
	  			request.setAttribute("DkCheck",2);
		  		RequestDispatcher rd=request.getRequestDispatcher("FormDangKy.jsp");
				rd.forward(request, response);
	  		}
	  		else {
	  			request.setAttribute("DkCheck", 1);
		  		RequestDispatcher rd=request.getRequestDispatcher("CoffeeController");
				rd.forward(request, response);
	  		}
	  		RequestDispatcher rd=request.getRequestDispatcher("FormDangKy.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

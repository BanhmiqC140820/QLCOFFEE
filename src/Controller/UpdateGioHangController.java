package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.GioHangBo;

/**
 * Servlet implementation class UpdateGioHangController
 */
@WebServlet("/UpdateGioHangController")
public class UpdateGioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		GioHangBo g=(GioHangBo)session.getAttribute("cart");
		String txtsua=request.getParameter("txtsua");
		if(request.getParameter("SuaSL")!=null) {
			long sl=Long.parseLong(txtsua);
			g.UpdateSL(request.getParameter("SuaSL"), sl);
			session.setAttribute("cart", g);
		}
		if(request.getParameter("Xoa1SP")!=null) {
			g.XoaSP(request.getParameter("Xoa1SP"));
		}
		if(request.getParameter("xoahet")!=null) {
			g.XoaHet();
		}
  		RequestDispatcher rd=request.getRequestDispatcher("HtGioHang");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

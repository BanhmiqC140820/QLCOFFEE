package Controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import BO.GioHangBo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String MaSP=request.getParameter("msp");
		String TenSP=request.getParameter("tsp");
		String GiaString=request.getParameter("gia");
		String linkanh=request.getParameter("Img");
		String slthem=request.getParameter("txtSLThem");
		HttpSession session=request.getSession();
		if(MaSP!=null && TenSP!=null && GiaString!=null && slthem!=null) {
			long gia=Long.parseLong(GiaString);
			long sl=Long.parseLong(slthem);
			if(session.getAttribute("cart")==null) {
				GioHangBo g=new GioHangBo();
				g.ThemSP(MaSP, TenSP, gia, 1, linkanh);
				session.setAttribute("cart", g);
			}
			else {
				GioHangBo g=(GioHangBo)session.getAttribute("cart");
				g.ThemSP(MaSP, TenSP, gia, sl, linkanh);
				session.setAttribute("cart", g);
			}

			response.sendRedirect("HtGioHang");
		}
		else 
		if(MaSP!=null && TenSP!=null && GiaString!=null) {
			long gia=Long.parseLong(GiaString);
			if(session.getAttribute("cart")==null) {
				GioHangBo g=new GioHangBo();
				g.ThemSP(MaSP, TenSP, gia, 1, linkanh);
				session.setAttribute("cart", g);
			}
			GioHangBo g=(GioHangBo)session.getAttribute("cart");
			g.ThemSP(MaSP, TenSP, gia, 1, linkanh);
			
			session.setAttribute("cart", g);
			response.sendRedirect("HtGioHang");
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

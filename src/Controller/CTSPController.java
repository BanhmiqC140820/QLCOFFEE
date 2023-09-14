package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.CoffeeBean;
import BEAN.LoaiBean;
import BO.CoffeeBo;
import BO.GioHangBo;
import BO.LoaiBo;

/**
 * Servlet implementation class CTSPController
 */
@WebServlet("/CTSPController")
public class CTSPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTSPController() {
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
	  		CoffeeBo Cofbo=new CoffeeBo();
	  		String Masp=request.getParameter("msp");
	  		LoaiBo lbo=new LoaiBo();
	  		ArrayList<LoaiBean> dsloai;
	  		dsloai=lbo.getLoai();
	  		CoffeeBean cof=Cofbo.getChiTietSP(Masp);
			HttpSession session=request.getSession();
			GioHangBo g=(GioHangBo)session.getAttribute("cart");
			if(session.getAttribute("cart")!=null)
				request.setAttribute("SoLuongMH", g.ds.size());
	  		request.setAttribute("dsloai", dsloai);
	  		request.setAttribute("cof", cof);
	  		RequestDispatcher rd=request.getRequestDispatcher("HtChiTietSanPham.jsp");
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

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
 * Servlet implementation class CoffeeController
 */
@WebServlet("/CoffeeController")
public class CoffeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeController() {
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
	  		LoaiBo lbo=new LoaiBo();
	  		ArrayList<LoaiBean> dsloai;
	  		String maloai=request.getParameter("ml");
	  		ArrayList<CoffeeBean> ds=null;
	  		String seach=request.getParameter("Search");
	  		int n=Cofbo.CountRow(null)/9+1;
  			request.setAttribute("soTrang", n);
	  		int page=1;
	  		if(seach!=null){
	  			ds=Cofbo.seach(seach);
	  		}
	  		if(request.getParameter("page")!=null) {
	  			page=Integer.parseInt(request.getParameter("page"));
	  			}
	  		dsloai=lbo.getLoai();
	  		request.setAttribute("dsloai", dsloai);
	  		if(maloai!=null && maloai!="")
	  		{	
	  			if(Cofbo.TimMa(maloai)) {
		  			int pageMl=Cofbo.CountRow(maloai)/9+1;
		  			request.setAttribute("ml", maloai);
		  			request.setAttribute("soTrang", pageMl);
		  			request.setAttribute("maloai", maloai);
		  			ds=Cofbo.getcofffeLoai(page, maloai);
	  			}
	  		}
	  		else {
	  			n=Cofbo.CountRow(null)/9+1;
	  			request.setAttribute("soTrang", n);
		  		ds=Cofbo.getCoffe(page);
	  		}
	  		request.setAttribute("ds", ds);
			HttpSession session=request.getSession();
			GioHangBo g=(GioHangBo)session.getAttribute("cart");
			if(session.getAttribute("cart")!=null)
				request.setAttribute("SoLuongMH", g.ds.size());
	  		RequestDispatcher rd=request.getRequestDispatcher("HTCoffee.jsp");
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

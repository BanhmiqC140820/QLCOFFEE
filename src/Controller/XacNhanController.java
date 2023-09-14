package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.CustomerBean;
import BEAN.GioHangBean;
import BO.CTHDbo;
import BO.GioHangBo;
import BO.HoaDonBo;



/**
 * Servlet implementation class XacNhanController
 */
@WebServlet("/XacNhanController")
public class XacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session=request.getSession();
			CustomerBean Cus=(CustomerBean)session.getAttribute("customer");
			if(session.getAttribute("customer")==null) {
				RequestDispatcher rd=request.getRequestDispatcher("HtGioHang?checkCus=1");
				rd.forward(request, response);
			}else {
				GioHangBo cart=(GioHangBo)session.getAttribute("cart");
				if(cart!=null) {
					HoaDonBo HDbo=new HoaDonBo();
					HDbo.AddhoaDon(Cus.getMaKH());
					long MaHD=HDbo.getMaxHD();
					CTHDbo CT=new CTHDbo();
					for(GioHangBean g:cart.ds)
						CT.ThemCTHD(g.getMaSanPham(), g.getSoluongmua(), MaHD);
					session.removeAttribute("cart");
					RequestDispatcher rd=request.getRequestDispatcher("CoffeeController");
					rd.forward(request, response);
				}
			}
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

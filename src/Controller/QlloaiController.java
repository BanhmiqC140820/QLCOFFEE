package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.LoaiBean;
import BO.LoaiBo;

/**
 * Servlet implementation class QlloaiController
 */
@WebServlet("/QlloaiController")
public class QlloaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QlloaiController() {
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
		  		LoaiBo lbo=new LoaiBo();
		  		String tab=request.getParameter("tab");
		  		String ml=request.getParameter("txtmaloai");
				String tenloai=request.getParameter("txttenloai");
				ArrayList<LoaiBean> dsloai=lbo.getLoai();
				request.setAttribute("dsloai", dsloai);
				if(request.getParameter("Add")!=null) 
					lbo.them(ml, tenloai);
				else {
					if(request.getParameter("update")!=null)
						lbo.sua(ml, tenloai);
					else {
						String ml1=request.getParameter("ml");
						String tenloai1=request.getParameter("tenloai");
						if(tab!=null && tab.equals("xoa"))
							lbo.deleteloai(ml1);
						else {
							if(tab!=null && tab.equals("chon")) {
								request.setAttribute("ml", ml1);
								request.setAttribute("tenloai", tenloai1);
							}
						}
					}
				}	
				request.setAttribute("dsloai", lbo.getLoai());
				RequestDispatcher rd=request.getRequestDispatcher("AdminTOP.jsp");
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

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
import BO.CustomerBo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			CustomerBo cus=new CustomerBo();
			String username=request.getParameter("username");
			String password=request.getParameter("pswd");
			String answer = request.getParameter("answer");
			HttpSession session=request.getSession();
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			if(password!=null)
				password=cus.getMD5Hash(password);	
			if(username!=null && password!=null) {
				if(captcha.isCorrect(answer)) {
					CustomerBean customer=null;
					customer=cus.CheckLogin(username, password);
					if(customer!=null) {
						session.setAttribute("customer", customer);
						RequestDispatcher rd=request.getRequestDispatcher("CoffeeController");
						rd.forward(request, response);
					}
					else {
						RequestDispatcher rd=request.getRequestDispatcher("CoffeeController");
						rd.forward(request, response);
					}
				}
			else {
					
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("CoffeeController");
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

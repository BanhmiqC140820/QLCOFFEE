package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.AdminBean;
import BO.AdminBo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class LoginADcontroller
 */
@WebServlet("/LoginADcontroller")
public class LoginADcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginADcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			AdminBo Adbo=new AdminBo();
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String answer = request.getParameter("answer");
			HttpSession session=request.getSession();
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			if(username!=null && password!=null) {
				if(captcha.isCorrect(answer)) {
					AdminBean admin=null;
					admin=Adbo.checklogin(username, password);
					if(admin!=null) {
						session.setAttribute("admin", admin);
						RequestDispatcher rd=request.getRequestDispatcher("AdminDashboard.jsp");
						rd.forward(request, response);
					}else {
						request.setAttribute("checklogin", 1);
						RequestDispatcher rd=request.getRequestDispatcher("LoginAdmin.jsp?checklogin=false");
						rd.forward(request, response);
					}
				}
				else {
				}
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("LoginAdmin.jsp");
				rd.forward(request, response);
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

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

/**
 * Servlet implementation class ResetPassController
 */
@WebServlet("/ResetPassController")
public class ResetPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassController() {
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
			String pass=request.getParameter("mk");
			String passNew=request.getParameter("mknew");
			HttpSession session=request.getSession();
			CustomerBean customer=(CustomerBean)session.getAttribute("customer");
			if(pass!=null) {
				pass=cus.getMD5Hash(pass);
				passNew=cus.getMD5Hash(passNew);
			}
			if(customer!=null) {
				if(customer.getPass().equals(pass)) {
					cus.resetPass(customer.getMaKH(), passNew);
					RequestDispatcher rd=request.getRequestDispatcher("CoffeeController");
					rd.forward(request, response);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("ResetPass.jsp");
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

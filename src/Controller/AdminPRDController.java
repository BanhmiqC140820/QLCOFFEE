package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BEAN.CoffeeBean;
import BEAN.LoaiBean;
import BO.CoffeeBo;
import BO.LoaiBo;

/**
 * Servlet implementation class AdminPRDController
 */
@WebServlet("/AdminPRDController")
public class AdminPRDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPRDController() {
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
	  		ArrayList<LoaiBean> dsloai=lbo.getLoai();
	  		ArrayList<CoffeeBean> ds=null;
	  		String MaSP=request.getParameter("MaSP");
	  		String TenSP=request.getParameter("TenSP");
	  		String Xuatxu=request.getParameter("Xuatxu");
	  		String MaLoai=request.getParameter("MaLoai");
	  		String tab=request.getParameter("tab");
	  		String soluong=request.getParameter("SoLuong");
	  		String gia=request.getParameter("Gia");
	  		String MaSPanh=null;
	  		String Anh="image_product";
	  		String submitAnh=null;
			long Sl=1;
  			long Gia=0;
	  		if(soluong!=null) {
	  			Sl=Long.parseLong(soluong);
	  			Gia=Long.parseLong(gia);
	  			}
	  		if(request.getParameter("Add")!=null) 
	  			Cofbo.them(MaSP, TenSP, Gia, Sl, Xuatxu, MaLoai);
	  		else {
				if(request.getParameter("update")!=null)
					Cofbo.sua(MaSP, TenSP, Gia, Sl,Xuatxu, MaLoai);
				else {
					if(tab!=null && tab.equals("select")) {
						String mSPSelect=request.getParameter("mSPSelect");
						CoffeeBean coffee=Cofbo.TimMaSP(mSPSelect);
						request.setAttribute("coffee", coffee);
					}else if(tab!=null && tab.equals("delete")) {
						String mSPDelete=request.getParameter("mSPDelete");
						Cofbo.DeleteCoffee(mSPDelete);
					}
				}
			}
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "image_product";
			System.out.println(dirUrl1);
			try {
				List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
				//duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
	 			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
				           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "image_product";
						File dir = new File(dirUrl);
						if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
					           String fileImg = dirUrl + File.separator + "Up.jpg";
					           File file = new File(fileImg);//tạo file
					            try {
					               fileItem.write(file);//lưu file
					              System.out.println("UPLOAD THÀNH CÔNG...!");
					              System.out.println("Đường dẫn lưu file là: "+dirUrl);
					              System.out.println(dirUrl); 
					            } catch (Exception e) {
					            	e.printStackTrace();
					}
				}
			 }
				else//Neu la control
				{
					String tentk=fileItem.getFieldName();
					if(tentk.equals("maSPanh"))
						MaSPanh=fileItem.getString();
					if(tentk.equals("submitAnh"))
						submitAnh=fileItem.getString();
						
				}
			}
				File oldfile=new File(dirUrl1, "Up.jpg");
				if(MaSPanh!=null) {
					File newFile = new File(dirUrl1, MaSPanh+".jpg");
			        // Thực hiện việc đổi tên tệp
			        boolean renamed = oldfile.renameTo(newFile);
			        if (renamed) {
			        	Anh="image_product/"+MaSPanh+".jpg";
			            System.out.println("Đổi tên tệp thành công.");
			        } else {
			            System.out.println("Đổi tên tệp thất bại.");
			        }
		        }
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			System.out.println(submitAnh);
			if(submitAnh!=null) {
				System.out.println(Anh);
				Cofbo.Upanh(MaSPanh,Anh);
			}
	  		int n=Cofbo.CountRow(null)/9+1;
  			request.setAttribute("soTrang", n);
	  		int page=1;
	  		if(request.getParameter("page")!=null) {
	  			page=Integer.parseInt(request.getParameter("page"));
	  			}
  			n=Cofbo.CountRow(null)/9+1;
  			request.setAttribute("soTrang", n);
	  		ds=Cofbo.getCoffe(page);
	  		request.setAttribute("ds", ds);
	  		request.setAttribute("dsloai", dsloai);
	  		RequestDispatcher rd=request.getRequestDispatcher("AdminProducts.jsp");
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

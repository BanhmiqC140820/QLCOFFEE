package BO;

import BEAN.AdminBean;
import DAO.AdminDao;

public class AdminBo {
	AdminDao addao=new AdminDao();
	public AdminBean checklogin(String tendn, String pass)throws Exception {
		return addao.checklogin(tendn, pass);
	}
}	

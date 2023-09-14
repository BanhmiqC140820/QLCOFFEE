package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BEAN.AdminBean;

public class AdminDao {
	public AdminBean checklogin(String tendn,String pass) throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="select * from UserAdmin where tendn=? and pass=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		ResultSet rs=cmd.executeQuery();
		AdminBean admin=null;
		if(rs.next()){
			boolean quyen=rs.getBoolean("Quyen");
			admin=new AdminBean(tendn, pass,quyen);
		}
		rs.close();cmd.close();
		return admin;
	}
}

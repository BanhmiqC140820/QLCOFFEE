package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BEAN.CustomerBean;


public class CustomerDao {
	public CustomerBean CheckLogin(String TenDN, String pass) throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="select * from Customer where tendn=? and pass=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, TenDN);
		cmd.setString(2, pass);
		ResultSet rs=cmd.executeQuery();
		CustomerBean customer=null;
		if(rs.next()) {
			long MaKH=rs.getLong("MaKH");
			String Hovaten=rs.getString("Hovaten");
			String DiaChi=rs.getString("DiaChi");
			String SDT=rs.getString("SDT");
			String Email=rs.getString("Email");
			customer =new CustomerBean(MaKH, Hovaten, DiaChi, SDT, Email, TenDN, pass);
			return customer;
		}
		cmd.close(); kn.cn.close();
		return customer;
	}
	public int register(String hovaTen, String diaChi, String sDT, String email, String tenDN, String pass)throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="INSERT INTO Customer(Hovaten, DiaChi, Email, TenDN, Pass) SELECT ?, ?, ?, ?, ? WHERE NOT EXISTS (SELECT 1 FROM Customer WHERE tendn =? )";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		int kq=0;
		cmd.setString(1, hovaTen);
		cmd.setString(2, diaChi);
		cmd.setString(3, email);
		cmd.setString(4, tenDN);
		cmd.setString(5, pass);
		cmd.setString(6, tenDN);
		kq = cmd.executeUpdate();
		cmd.close(); kn.cn.close();
		return kq;
	}
	public int resetPass(long Makh, String pass)throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql="UPDATE Customer SET Pass=? WHERE Makh=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		int kq=0;
		cmd.setString(1, pass);
		cmd.setLong(2, Makh);
		kq=cmd.executeUpdate();
		cmd.close(); kn.cn.close();
		return kq;
	}
}

package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.LoaiBean;


public class LoaiDao {
	public ArrayList<LoaiBean> getLoai() throws Exception {
		ArrayList<LoaiBean> ds=new ArrayList<LoaiBean>();
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql="select*from Loai";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String MaLoai=rs.getString("MaLoai");
			String TenLoai=rs.getString("TenLoai");
			ds.add(new LoaiBean(MaLoai, TenLoai));
		}
		cmd.close();kn.cn.close();
		return ds;
	}
	public int them(String maloai, String tenloai) throws Exception  {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql="INSERT INTO loai(maloai, tenloai) VALUES (?,?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
	public int sua(String maloai, String tenloai) throws Exception  {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql="UPDATE loai SET TenLoai=? WHERE MaLoai=?;";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, tenloai);
		cmd.setString(2, maloai);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
	public int deleteloai(String maloai) throws Exception  {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql="DELETE FROM Loai WHERE MaLoai=?;";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
}

package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import BEAN.XacNhanHDBean;

public class CTHDdao {
	public int ThemCTHD(String MaSP,long SoluongMua, long MaHD) throws Exception{
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="insert into ChiTietHD (MaSanPham,SoLuongMua,MaHD,DaMua) values(?,?,?,?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		int kq=0;	
		cmd.setString(1, MaSP);
		cmd.setLong(2, SoluongMua);
		cmd.setLong(3, MaHD);
		cmd.setBoolean(4, false);
		kq=cmd.executeUpdate();
	
	cmd.close();kn.cn.close();
	return kq;
	}
	public int Update(long MaCTHD) throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="update ChiTietHD set damua=1 where MaChiTietHD=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		int kq=0;
		cmd.setLong(1, MaCTHD);
		kq=cmd.executeUpdate();
		cmd.close(); kn.cn.close();
		return kq;
	}
	public ArrayList<XacNhanHDBean> getHDchuaXacNhan() throws Exception {
		ArrayList<XacNhanHDBean> ds=new ArrayList<>();
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql="select * from VXacNhan";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			long makh=rs.getLong("makh"); 
			String hoten=rs.getString("Hovaten"); 
			String tenSP=rs.getString("TenSanPham"); 
			long gia=rs.getLong("Gia"); 
			Date ngayMua=rs.getDate("NgayMua"); 
			long soLuongMua=rs.getLong("SoLuongMua"); 
			boolean damua=rs.getBoolean("DaMua");
			long thanhtien=rs.getLong("thanhtien");
			long maChiTietHD=rs.getLong("MaChiTietHD");
			ds.add(new XacNhanHDBean(makh, hoten, tenSP, gia, ngayMua, soLuongMua, damua, thanhtien, maChiTietHD));
		}
		cmd.close(); kn.cn.close();
		return ds;
	}
}

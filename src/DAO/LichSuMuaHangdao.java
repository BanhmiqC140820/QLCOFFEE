package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import BEAN.LichSuMuaHangBean;



public class LichSuMuaHangdao {
	public ArrayList<LichSuMuaHangBean> getLS(long makh) throws Exception{
		ArrayList<LichSuMuaHangBean> dsls=new ArrayList<>();
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="select * from LichSuMuaHang where MaKH=? order by NgayMua desc";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String MaSanPham=rs.getString("MaSanPham"); 
			String TenSanPham=rs.getString("TenSanPham"); 
			long gia=rs.getLong("Gia"); 
			long SoLuongMua=rs.getLong("SoLuongMua"); 
			Date ngaySql=rs.getDate("NgayMua");
			java.util.Date NgayJava=new java.util.Date(ngaySql.getTime());
			SimpleDateFormat dateformat= new SimpleDateFormat("dd/MM/yyyy");
			String formatdate= dateformat.format(NgayJava);
			NgayJava=dateformat.parse(formatdate);
			boolean damua=rs.getBoolean("DaMua");
			long thanhtien=rs.getLong("thanhtien");
			String linkanh=rs.getString("LinkAnh");
			dsls.add(new LichSuMuaHangBean(MaSanPham,TenSanPham,gia,SoLuongMua,NgayJava,damua,thanhtien,linkanh));
		}
		rs.close();kn.cn.close();
		return dsls;
		
	}
}

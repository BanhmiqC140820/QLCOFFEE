package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.CoffeeBean;





public class CoffeeDao {
	public ArrayList<CoffeeBean> getCoffe(int pagenumber) throws Exception {
		ArrayList<CoffeeBean> ds=new ArrayList<>();
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="SELECT *\r\n"
				+ "FROM Coffe\r\n"
				+ "ORDER BY MaSanPham\r\n"
				+ "OFFSET (? - 1) * 9 ROWS\r\n"
				+ "FETCH NEXT 9 ROWS ONLY;";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setInt(1, pagenumber);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String maSanPham=rs.getString("MaSanPham"); 
			String TenSanPham=rs.getString("TenSanPham"); 
			Long gia=rs.getLong("Gia"); 
			Long SoLuong=rs.getLong("SoLuong"); String XuatXu=rs.getString("XuatXu");
			String maLoai=rs.getString("MaLoai");
			String LinkAnh=rs.getString("LinkAnh");
			ds.add(new CoffeeBean(maSanPham, TenSanPham, gia, SoLuong, XuatXu, maLoai, LinkAnh));
		}
		cmd.close();kn.cn.close();
		return ds;
	}
	public ArrayList<CoffeeBean> getcofffeLoai(int pagenumber, String MaLoai) throws Exception {
		ArrayList<CoffeeBean> ds=new ArrayList<>();
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="SELECT * FROM Coffe\r\n"
				+ "where MaLoai=?\r\n"
				+ " ORDER BY MaSanPham OFFSET (? - 1) * 9 ROWS FETCH NEXT 9 ROWS ONLY;";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1,MaLoai);
		cmd.setInt(2, pagenumber);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String maSanPham=rs.getString("MaSanPham"); 
			String TenSanPham=rs.getString("TenSanPham"); 
			Long gia=rs.getLong("Gia"); 
			Long SoLuong=rs.getLong("SoLuong"); String XuatXu=rs.getString("XuatXu");
			String maLoai=rs.getString("MaLoai");
			String LinkAnh=rs.getString("LinkAnh");
			ds.add(new CoffeeBean(maSanPham, TenSanPham, gia, SoLuong, XuatXu, maLoai, LinkAnh));
		}
		cmd.close();kn.cn.close();
		return ds;
	}
	public ArrayList<CoffeeBean> getCoffe() throws Exception {
		ArrayList<CoffeeBean> ds=new ArrayList<>();
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="SELECT * FROM Coffe";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);

		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String maSanPham=rs.getString("MaSanPham"); 
			String TenSanPham=rs.getString("TenSanPham"); 
			Long gia=rs.getLong("Gia"); 
			Long SoLuong=rs.getLong("SoLuong"); String XuatXu=rs.getString("XuatXu");
			String maLoai=rs.getString("MaLoai");
			String LinkAnh=rs.getString("LinkAnh");
			ds.add(new CoffeeBean(maSanPham, TenSanPham, gia, SoLuong, XuatXu, maLoai, LinkAnh));
		}
		cmd.close();kn.cn.close();
		return ds;
	}
	public CoffeeBean getChiTietSP(String MaSP) throws Exception {
		CoffeeBean cof=null;
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="SELECT * FROM Coffe WHERE MaSanPham=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, MaSP);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String maSanPham=rs.getString("MaSanPham"); 
			String TenSanPham=rs.getString("TenSanPham");
			String MoTa=rs.getString("MoTa");
			Long gia=rs.getLong("Gia"); 
			Long SoLuong=rs.getLong("SoLuong"); String XuatXu=rs.getString("XuatXu");
			String maLoai=rs.getString("MaLoai");
			String LinkAnh=rs.getString("LinkAnh");
			cof=new CoffeeBean(maSanPham, TenSanPham, gia, SoLuong, XuatXu, maLoai, LinkAnh, MoTa);
		}
		cmd.close();kn.cn.close();
		return cof;
	}
	public int CountRow(String Maloai) throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql=null;
		int kq=0;
		if(Maloai==null)
		{
			 sql="SELECT COUNT(*) AS TotalRows FROM Coffe";
			 PreparedStatement cmd=kn.cn.prepareStatement(sql);
			 ResultSet rs=cmd.executeQuery();
				if(rs.next())
					kq=rs.getInt(1);
				cmd.close();kn.cn.close();
		 }
		else 
		{
			sql="SELECT COUNT(*) AS TotalRows FROM Coffe where MaLoai=?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, Maloai);
			ResultSet rs=cmd.executeQuery();
			if(rs.next())
				kq=rs.getInt(1);
			cmd.close();kn.cn.close();
		}
		return kq;
	}
	public int them(String maSanPham, String tenSanPHam, Long gia, Long soLuong, String xuatXu, String maLoai)throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="INSERT INTO [dbo].[Coffe] ([MaSanPham],[TenSanPHam],[Gia],[SoLuong],[XuatXu],[MaLoai])VALUES(?,?,?,?,?,?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, maSanPham);
		cmd.setString(2, tenSanPHam);
		cmd.setLong(3, gia);
		cmd.setLong(4, soLuong);
		cmd.setString(5, xuatXu);
		cmd.setString(6, maLoai);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
	public int Sua(String maSanPham, String tenSanPHam, Long gia, Long soLuong, String xuatXu, String maLoai)throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="UPDATE [dbo].[Coffe] SET  [TenSanPHam]=?,[Gia]=?,[SoLuong]=?,[XuatXu]=?,[MaLoai]=? where [MaSanPham]=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, tenSanPHam);
		cmd.setLong(2, gia);
		cmd.setLong(3, soLuong);
		cmd.setString(4, xuatXu);
		cmd.setString(5, maLoai);
		cmd.setString(6, maSanPham);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
	public int DeleteCoffee(String MaSP)throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="DELETE FROM Coffe WHERE [MaSanPham]=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, MaSP);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
	public int Upanh(String maSanPham, String LinkAnh)throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="UPDATE [dbo].[Coffe] SET  [LinkAnh]=? where [MaSanPham]=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, LinkAnh);
		cmd.setString(2, maSanPham);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
}

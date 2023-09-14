package BO;

import java.util.ArrayList;

import BEAN.CoffeeBean;
import DAO.CoffeeDao;

public class CoffeeBo {
	CoffeeDao Cofdao=new CoffeeDao();
	public ArrayList<CoffeeBean> ds;
	public ArrayList<CoffeeBean> getCoffe(int pagenumber)throws Exception {
		return Cofdao.getCoffe(pagenumber);
	}
	public ArrayList<CoffeeBean> getCoffe()throws Exception {
		ds=Cofdao.getCoffe();
		return ds;
	}
	public ArrayList<CoffeeBean> getcofffeLoai(int pagenumber, String MaLoai) throws Exception {
		return Cofdao.getcofffeLoai(pagenumber, MaLoai);
	}
	public ArrayList<CoffeeBean> seach(String seach) throws Exception {
		getCoffe();
		ArrayList<CoffeeBean> temp=new ArrayList<>();
		for(CoffeeBean cof:ds) {
			if(cof.getTenSanPHam().contains(seach)) {
				temp.add(cof);
			}
		}
		return temp;
	}
	public CoffeeBean getChiTietSP(String MaSP) throws Exception{
		return Cofdao.getChiTietSP(MaSP);
	}
	public int CountRow(String MaLoai)  throws Exception{
		return Cofdao.CountRow(MaLoai);
	}
	public int them(String maSanPham, String tenSanPHam, Long gia, Long soLuong, String xuatXu, String maLoai)throws Exception {
		return Cofdao.them(maSanPham, tenSanPHam, gia, soLuong, xuatXu, maLoai);
	}
	public int sua(String maSanPham, String tenSanPHam, Long gia, Long soLuong, String xuatXu, String maLoai)throws Exception {
		return Cofdao.Sua(maSanPham, tenSanPHam, gia, soLuong, xuatXu, maLoai);
	}
	public int DeleteCoffee(String MaSP)throws Exception{
		return Cofdao.DeleteCoffee(MaSP);
	}
	public int Upanh(String maSanPham, String LinkAnh)throws Exception {
		return Cofdao.Upanh(maSanPham, LinkAnh);
	}
	public boolean TimMa(String Maloai) throws Exception{
		getCoffe();
		for(CoffeeBean cof:ds){
			if(cof.getMaLoai().equals(Maloai))
				return true;
		}
		return false;
	}
	public CoffeeBean TimMaSP(String MaSP) throws Exception{
		getCoffe();
		for(CoffeeBean cof:ds) {
			if(cof.getMaSanPham().equals(MaSP))
				return cof;
		}
		return null;
	}
}

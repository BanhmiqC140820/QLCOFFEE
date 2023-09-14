package BO;

import java.util.ArrayList;

import BEAN.LoaiBean;
import DAO.LoaiDao;

public class LoaiBo {
	LoaiDao ldao=new LoaiDao();
	public ArrayList<LoaiBean> getLoai() throws Exception{
		return ldao.getLoai();
	}
	public int them(String maloai, String tenloai) throws Exception  {
		return ldao.them(maloai, tenloai);
	}
	public int sua(String maloai, String tenloai) throws Exception  {
		return ldao.sua(maloai, tenloai);
	}
	public int deleteloai(String maloai) throws Exception  {
		return ldao.deleteloai(maloai);
	}
}

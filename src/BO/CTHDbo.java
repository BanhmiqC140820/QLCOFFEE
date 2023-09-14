package BO;

import java.util.ArrayList;

import BEAN.XacNhanHDBean;
import DAO.CTHDdao;

public class CTHDbo {
	CTHDdao ctdao=new CTHDdao();
	public int ThemCTHD(String MaSP,long SoluongMua, long MaHD) throws Exception{
		return ctdao.ThemCTHD(MaSP, SoluongMua, MaHD);
	}
	public int Update(long MaCTHD) throws Exception{
		return ctdao.Update(MaCTHD);
	}
	public ArrayList<XacNhanHDBean> getHDchuaXacNhan() throws Exception{
		return ctdao.getHDchuaXacNhan();
	}
}

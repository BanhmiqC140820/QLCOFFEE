package BO;

import DAO.HoaDonDao;

public class HoaDonBo {
	HoaDonDao Hddao=new HoaDonDao();
	public int AddhoaDon(long makh) throws Exception{
		return Hddao.AddhoaDon(makh);
	}
	public long getMaxHD() throws Exception{
		return Hddao.getMaxHD();
	}
}

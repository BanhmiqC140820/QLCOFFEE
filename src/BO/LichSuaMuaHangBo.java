package BO;

import java.util.ArrayList;

import BEAN.LichSuMuaHangBean;
import DAO.LichSuMuaHangdao;

public class LichSuaMuaHangBo {
	LichSuMuaHangdao lsdao=new LichSuMuaHangdao();
	public ArrayList<LichSuMuaHangBean> getLS(long makh) throws Exception{
		return lsdao.getLS(makh);
	}
}

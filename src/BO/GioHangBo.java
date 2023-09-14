package BO;

import java.util.ArrayList;

import BEAN.GioHangBean;

public class GioHangBo {
	public ArrayList<GioHangBean> ds=new ArrayList<>();
	public void ThemSP(String MaSanPham,String TenSP, long gia, long soluongmua,String linkAnh) {
		for(GioHangBean h:ds) {
			if(h.getMaSanPham().equals(MaSanPham)) {
				h.setSoluongmua(h.getSoluongmua()+soluongmua);
				return;
			}	
		}
		GioHangBean h=new GioHangBean(MaSanPham, TenSP, gia, soluongmua, soluongmua,linkAnh);
		ds.add(h);
	}
	public void XoaSP(String MaSanPHam) {
		for(GioHangBean h:ds) {
			if(h.getMaSanPham().equals(MaSanPHam)) {
				ds.remove(h);
				return;
			}
		}
	}
	public void UpdateSL(String MaSanPham, long sl) {
		int n=ds.size();
		for(int i=0;i<n;i++) {
			GioHangBean h=ds.get(i);
			if(h.getMaSanPham().equals(MaSanPham)) {
				h.setSoluongmua(sl);
				ds.set(i, h);
				return;
			}
		}
	}
	public void XoaHet() {
		ds.removeAll(ds);
	}
	public long TongTien() {
		long tong=0;
		for(GioHangBean h:ds) 
			tong =tong+h.getThanhtien();
		return tong;
	}
}

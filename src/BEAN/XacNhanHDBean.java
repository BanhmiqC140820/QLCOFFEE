package BEAN;

import java.util.Date;

public class XacNhanHDBean {
	private long makh;
	private String hoten;
	private String tenSP;
	private long gia;
	private Date NgayMua;
	private long SoLuongMua;
	private boolean damua;
	private long thanhtien;
	private long MaChiTietHD;
	public XacNhanHDBean(long makh, String hoten, String tenSP, long gia, Date ngayMua, long soLuongMua, boolean damua,
			long thanhtien, long maChiTietHD) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.tenSP = tenSP;
		this.gia = gia;
		NgayMua = ngayMua;
		SoLuongMua = soLuongMua;
		this.damua = damua;
		this.thanhtien = thanhtien;
		MaChiTietHD = maChiTietHD;
	}
	public XacNhanHDBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public long getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	
}

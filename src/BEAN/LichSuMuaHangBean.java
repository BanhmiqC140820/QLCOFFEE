package BEAN;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LichSuMuaHangBean {
	private String MaSP;
	private String TenSP;
	private long gia;
	private long SoluongMua;
	private Date NgayMua;
	private boolean damua;
	private long thanhtien;
	private String linkanh;
	public LichSuMuaHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LichSuMuaHangBean(String maSP, String tenSP, long gia, long soluongMua, Date ngayMua, boolean damua,
			long thanhtien) {
		super();
		MaSP = maSP;
		TenSP = tenSP;
		this.gia = gia;
		SoluongMua = soluongMua;
		NgayMua = ngayMua;
		this.damua = damua;
		this.thanhtien = thanhtien;
	}
	
	public LichSuMuaHangBean(String maSP, String tenSP, long gia, long soluongMua, Date ngayMua, boolean damua,
			long thanhtien, String linkanh) {
		super();
		MaSP = maSP;
		TenSP = tenSP;
		this.gia = gia;
		SoluongMua = soluongMua;
		NgayMua = ngayMua;
		this.damua = damua;
		this.thanhtien = thanhtien;
		this.linkanh = linkanh;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluongMua() {
		return SoluongMua;
	}
	public void setSoluongMua(long soluongMua) {
		SoluongMua = soluongMua;
	}
	public String getNgayMua() {
		SimpleDateFormat dateformat= new SimpleDateFormat("dd/MM/yyyy");
		String formatdate= dateformat.format(NgayMua);
		return formatdate;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
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
	public String getLinkanh() {
		return linkanh;
	}
	public void setLinkanh(String linkanh) {
		this.linkanh = linkanh;
	}
	
}

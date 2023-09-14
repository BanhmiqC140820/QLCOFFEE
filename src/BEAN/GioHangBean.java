package BEAN;

public class GioHangBean {
	private String MaSanPham;
	private String TenSanPham;
	private long gia;
	private long soluongmua;
	private long thanhtien;
	private String linkAnh;
	public GioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GioHangBean(String maSanPham, String tenSanPham, long gia, long soluongmua, long thanhtien) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = soluongmua*gia;
	}
	
	public GioHangBean(String maSanPham, String tenSanPham, long gia, long soluongmua, long thanhtien, String linkAnh) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = soluongmua*gia;
		this.linkAnh = linkAnh;
	}

	public String getMaSanPham() {
		return MaSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return TenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getSoluongmua() {
		return soluongmua;
	}

	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}

	public long getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien() {
		this.thanhtien = soluongmua*gia;
	}

	public String getLinkAnh() {
		return linkAnh;
	}

	public void setLinkAnh(String linkAnh) {
		this.linkAnh = linkAnh;
	}
	
}

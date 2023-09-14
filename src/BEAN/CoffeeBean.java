package BEAN;

public class CoffeeBean {
	private String MaSanPham;
	private String TenSanPHam;
	private Long Gia;
	private Long SoLuong;
	private String XuatXu;
	private String MaLoai;
	private String LinkAnh;
	private String Mota;
	public CoffeeBean(String maSanPham, String tenSanPHam, Long gia, Long soLuong, String xuatXu, String maLoai,
			String linkAnh) {
		super();
		MaSanPham = maSanPham;
		TenSanPHam = tenSanPHam;
		Gia = gia;
		SoLuong = soLuong;
		XuatXu = xuatXu;
		MaLoai = maLoai;
		LinkAnh = linkAnh;
	}
	
	public CoffeeBean(String maSanPham, String tenSanPHam, Long gia, Long soLuong, String xuatXu, String maLoai) {
		super();
		MaSanPham = maSanPham;
		TenSanPHam = tenSanPHam;
		Gia = gia;
		SoLuong = soLuong;
		XuatXu = xuatXu;
		MaLoai = maLoai;
	}

	public CoffeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPHam() {
		return TenSanPHam;
	}
	public void setTenSanPHam(String tenSanPHam) {
		TenSanPHam = tenSanPHam;
	}
	public Long getGia() {
		return Gia;
	}
	public void setGia(Long gia) {
		Gia = gia;
	}
	public Long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}
	public String getXuatXu() {
		return XuatXu;
	}
	public void setXuatXu(String xuatXu) {
		XuatXu = xuatXu;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getLinkAnh() {
		return LinkAnh;
	}
	public void setLinkAnh(String linkAnh) {
		LinkAnh = linkAnh;
	}
	public String getMota() {
		return Mota;
	}
	public void setMota(String mota) {
		Mota = mota;
	}
	public CoffeeBean(String maSanPham, String tenSanPHam, Long gia, Long soLuong, String xuatXu, String maLoai,
			String linkAnh, String mota) {
		super();
		MaSanPham = maSanPham;
		TenSanPHam = tenSanPHam;
		Gia = gia;
		SoLuong = soLuong;
		XuatXu = xuatXu;
		MaLoai = maLoai;
		LinkAnh = linkAnh;
		Mota = mota;
	}
	
}

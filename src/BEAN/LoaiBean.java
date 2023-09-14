package BEAN;

public class LoaiBean {
	private String MaLoai;
	private String TenLoai;
	public LoaiBean(String maLoai, String tenLoi) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoi;
	}
	public LoaiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoi) {
		TenLoai = tenLoi;
	}
	
}

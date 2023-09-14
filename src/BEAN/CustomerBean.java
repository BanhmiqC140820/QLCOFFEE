package BEAN;

public class CustomerBean {
	private long MaKH;
	private String HovaTen;
	private String DiaChi;
	private String SDT;
	private String Email;
	private String TenDN;
	private String pass;
	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerBean(long maKH, String hovaTen, String diaChi, String sDT, String email, String tenDN, String pass) {
		super();
		MaKH = maKH;
		HovaTen = hovaTen;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		TenDN = tenDN;
		this.pass = pass;
	}
	
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public long getMaKH() {
		return MaKH;
	}
	public void setMaKH(long maKH) {
		MaKH = maKH;
	}
	public String getHovaTen() {
		return HovaTen;
	}
	public void setHovaTen(String hovaTen) {
		HovaTen = hovaTen;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTenDN() {
		return TenDN;
	}
	public void setTenDN(String tenDN) {
		TenDN = tenDN;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}

package BEAN;

public class AdminBean {
	private String TenDN;
	private String pass;
	private boolean quyen;
	public AdminBean(String tenDN, String pass) {
		super();
		TenDN = tenDN;
		this.pass = pass;
	}
	
	public AdminBean(String tenDN, String pass, boolean quyen) {
		super();
		TenDN = tenDN;
		this.pass = pass;
		this.quyen = quyen;
	}

	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
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
	public boolean isQuyen() {
		return quyen;
	}
	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}
	
}

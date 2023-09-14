package BO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import BEAN.CustomerBean;
import DAO.CustomerDao;

public class CustomerBo {
	CustomerDao cusDao=new CustomerDao();
	public CustomerBean CheckLogin(String TenDn,String Pass)throws Exception {
		return cusDao.CheckLogin(TenDn, Pass);
	}
	public int register(String hovaTen, String diaChi, String sDT, String email, String tenDN, String pass)throws Exception {
		return cusDao.register(hovaTen, diaChi, sDT, email, tenDN, pass);
	}
	public int resetPass(long Makh, String pass)throws Exception {
		return cusDao.resetPass(Makh, pass);
	}
    public String getMD5Hash(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(pass.getBytes());
            
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

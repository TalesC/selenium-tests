package br.edu.cruzeirodosul.util;

public class UserLogin {
	
	private String rgm;
	private String password;
		
	public UserLogin(String rgm, String password) {
		this.rgm = rgm;
		this.password = password;
	}
	
	public String getRgm() {
		return rgm;
	}
	public void setRgm(String rgm) {
		this.rgm = rgm;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

package br.com.jsn.dto;



public class LoginRequest {

	private String loginRequestEmail ;
	private String loginRequestSenha ;
	
	public LoginRequest() {}
	
	public LoginRequest(String loginRequestEmail , String loginRequestSenha) {
		this.loginRequestEmail = loginRequestEmail ;
		this.loginRequestSenha = loginRequestSenha;
	}


	public String getLoginRequestEmail() {
		return loginRequestEmail;
	}


	public void setLoginRequestEmail(String loginRequestEmail) {
		this.loginRequestEmail = loginRequestEmail;
	}


	public String getLoginRequestSenha() {
		return loginRequestSenha;
	}


	public void setLoginRequestSenha(String loginRequestSenha) {
		this.loginRequestSenha = loginRequestSenha;
	}
	
	
	

}
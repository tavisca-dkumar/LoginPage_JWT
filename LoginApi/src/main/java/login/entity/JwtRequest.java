package login.entity;

public class JwtRequest {
	
	private String username;
	
	private String password;

	
	public JwtRequest() {
		super();
	}


	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return this.username;
	}


	public String getPassword() {
		return this.password;
	}
	
	
	

}

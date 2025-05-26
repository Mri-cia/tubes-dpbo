package app.modules;

public class User {
	private String username;
	private String role;
	private String password;
	
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
}

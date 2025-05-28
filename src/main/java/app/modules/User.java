package app.modules;

import java.util.ArrayList;

public class User {
	private String username;
	private String role;
	private String password;
	
	protected ArrayList<Barang> barang = new ArrayList<>();
	
	public User(String username, String password, String role) {
		this.username = username.toUpperCase();
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}
	
	public ArrayList<Barang> getBarang() {
		return barang;
	}

}

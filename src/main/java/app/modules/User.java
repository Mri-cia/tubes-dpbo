package app.modules;

import java.util.ArrayList;
import java.util.Objects;

public class User {
	private String username;
	private String role;
	private String password;

	protected ArrayList<Barang> barang = new ArrayList<>();

	public User(String username, String password, String role) {
		this.username = username.toUpperCase();
		this.password = password;
		this.role = role.toUpperCase();
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

	// Override equals to compare username and role
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User) o;
		return username.equalsIgnoreCase(user.username) && role.equalsIgnoreCase(user.role);
	}

	// Override hashCode to match equals (username + role)
	@Override
	public int hashCode() {
		return Objects.hash(username.toLowerCase(), role.toLowerCase());
	}
}

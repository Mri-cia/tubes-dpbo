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
	
    //Override equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
        		Objects.equals(role, user.role);
    }

    // 🔹 Override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

}

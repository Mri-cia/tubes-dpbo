package app.modules;

import java.util.ArrayList;

public class Donator extends User {

	public Donator(String username, String password) {
		super(username, password, "Donator");
		this.barang = new ArrayList<>();
	}

}

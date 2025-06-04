package app.modules;

import java.util.ArrayList;

public class Seller extends User {
	
	public Seller(String username, String password) {
		super(username, password, "Penjual");
		barang = new ArrayList<Barang>();
	}
	

}

package app.modules;

import java.util.ArrayList;

public class Seller extends User {
	
	public Seller(String username, String password) {
		super(username, password, "Penjual");
		barang = new ArrayList<Barang>();
	}
	
	public void tambahBarang(Barang barang) {
		this.barang.add(barang);
		System.out.println(barang);
	}
	
	public void editBarang(Barang barang) {
		for(int i = 0; i < this.barang.size(); i++){
			
		}
	}
	
	public void deleteBarang(Barang barang) {
		
	}
}

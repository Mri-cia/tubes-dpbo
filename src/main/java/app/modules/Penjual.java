package app.modules;

import java.util.ArrayList;

public class Penjual extends User {
	ArrayList<Barang> barang;
	
	public Penjual(String username, String password) {
		super(username, password, "Penjual");
		barang = new ArrayList<Barang>();
	}
	
	public void tambahBarang(Barang barang) {
		this.barang.add(barang);
	}
	
	public void editBarang(Barang barang) {
		for(int i = 0; i < this.barang.size(); i++){
			
		}
	}
	
	public void deleteBarang(Barang barang) {
		
	}
}

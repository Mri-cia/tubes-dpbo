package app.modules;

import java.util.ArrayList;

public class Donator extends User implements Contributor {
	private ArrayList<Barang>barang;

	public Donator(String username, String password) {
		super(username, password, "Donator");
		this.barang = new ArrayList<>();
	}
	public void addBarang(Barang barang) {
        this.barang.add(barang);
    }


	public Barang getBarang() {
		 if (!barang.isEmpty()) {
	            return barang.get(0);
		 }
		return null;
	}

	@Override
	public int getBarangNumber() {
		return barang.size();
	}
	 public ArrayList<Barang> getAllGoods() {
	        return new ArrayList<>(barang);
	 }

}

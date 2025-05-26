package app.modules;

import java.util.ArrayList;
import java.util.Date;

public class DataBarang {
	public static ArrayList<Barang> listBarang = new ArrayList<>();
	
	public static void initializeData() {
		listBarang.add(new Barang("Pai Coklat", "Makanan", new Date("01-01-2025"), 50000));
		listBarang.add(new Barang("Pai Coklat", "Makanan", new Date("01-01-2025"), 50000));
		listBarang.add(new Barang("Pai Coklat", "Makanan", new Date("01-01-2025"), 50000));
		listBarang.add(new Barang("Pai Coklat", "Makanan", new Date("01-01-2025"), 50000));
		listBarang.add(new Barang("Pai Coklat", "Makanan", new Date("01-01-2025"), 50000));
		listBarang.add(new Barang("Pai Coklat", "Makanan", new Date("01-01-2025"), 50000));
		listBarang.add(new Barang("Pai Coklat", "Makanan", new Date("01-01-2025"), 50000));
	}
}

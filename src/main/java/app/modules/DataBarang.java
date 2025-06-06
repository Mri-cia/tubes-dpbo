package app.modules;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import app.utils.*;

public class DataBarang {
	private static User currentUser;
	
	public static HashMap<User, ArrayList<Barang>> data = new HashMap<>();
	private static ArrayList<Barang> listBarang;
	
	public static ArrayList<Barang> barangUser;
	
	public static void initializeData() {
		//Penjual
		listBarang = new ArrayList<>();
		listBarang.add(new Barang("Pai Coklat", "Makanan", DateUtils.parseDateStr("2025-05-23"), 50000));
		listBarang.add(new Barang("Es Teh Manis", "Minuman", DateUtils.parseDateStr("2025-06-01"), 15000));
		listBarang.add(new Barang("Roti Tawar", "Makanan", DateUtils.parseDateStr("2025-05-30"), 20000));
		listBarang.add(new Barang("Jus Mangga", "Minuman", DateUtils.parseDateStr("2025-06-05"), 25000));
		listBarang.add(new Barang("Keripik Kentang", "Makanan", DateUtils.parseDateStr("2025-06-10"), 30000));
		listBarang.add(new Barang("Air Mineral", "Minuman", DateUtils.parseDateStr("2025-05-26"), 10000));
		listBarang.add(new Barang("Coklat Batangan", "Makanan", DateUtils.parseDateStr("2025-06-03"), 18000));
		listBarang.add(new Barang("Kopi Hitam", "Minuman", DateUtils.parseDateStr("2025-06-08"), 22000));
		listBarang.add(new Barang("Biskuit Keju", "Makanan", DateUtils.parseDateStr("2025-06-12"), 27000));
		listBarang.add(new Barang("Susu UHT", "Minuman", DateUtils.parseDateStr("2025-06-15"), 19000));
		listBarang.add(new Barang("Nasi Bungkus", "Makanan", DateUtils.parseDateStr("2025-05-27"), 30000));
		listBarang.add(new Barang("Teh Botol", "Minuman", DateUtils.parseDateStr("2025-05-28"), 14000));
		listBarang.add(new Barang("Mie Instan", "Makanan", DateUtils.parseDateStr("2025-06-07"), 12000));
		listBarang.add(new Barang("Soda Lemon", "Minuman", DateUtils.parseDateStr("2025-06-11"), 26000));
		listBarang.add(new Barang("Donat Gula", "Makanan", DateUtils.parseDateStr("2025-06-04"), 16000));
		User ursula = DataUser.getDataUser(0);
		data.put(ursula, listBarang);

		//Donatur
		listBarang = new ArrayList<>();
		listBarang.add(new Barang("Bakso Sapi", "Makanan", DateUtils.parseDateStr("2025-06-13"), 35000));
		listBarang.add(new Barang("Lemon Tea", "Minuman", DateUtils.parseDateStr("2025-06-06"), 17000));
		listBarang.add(new Barang("Ayam Goreng", "Makanan", DateUtils.parseDateStr("2025-06-17"), 45000));
		listBarang.add(new Barang("Smoothie Alpukat", "Minuman", DateUtils.parseDateStr("2025-06-09"), 28000));
		listBarang.add(new Barang("Kentang Goreng", "Makanan", DateUtils.parseDateStr("2025-06-18"), 24000));
		listBarang.add(new Barang("Susu Kedelai", "Minuman", DateUtils.parseDateStr("2025-06-02"), 13000));
		listBarang.add(new Barang("Pizza Mini", "Makanan", DateUtils.parseDateStr("2025-06-19"), 38000));
		listBarang.add(new Barang("Sari Kelapa", "Minuman", DateUtils.parseDateStr("2025-06-20"), 21000));
		listBarang.add(new Barang("Martabak Telur", "Makanan", DateUtils.parseDateStr("2025-06-21"), 42000));
		listBarang.add(new Barang("Teh Hijau", "Minuman", DateUtils.parseDateStr("2025-06-22"), 15000));
		listBarang.add(new Barang("Spaghetti", "Makanan", DateUtils.parseDateStr("2025-06-23"), 34000));
		listBarang.add(new Barang("Air Kelapa", "Minuman", DateUtils.parseDateStr("2025-06-24"), 20000));
		listBarang.add(new Barang("Onigiri", "Makanan", DateUtils.parseDateStr("2025-06-25"), 23000));
		listBarang.add(new Barang("Milkshake Coklat", "Minuman", DateUtils.parseDateStr("2025-06-26"), 27000));
		listBarang.add(new Barang("Pempek", "Makanan", DateUtils.parseDateStr("2025-06-27"), 33000));
		listBarang.add(new Barang("Jamu Kunyit", "Minuman", DateUtils.parseDateStr("2025-06-28"), 12000));
		listBarang.add(new Barang("Pisang Goreng", "Makanan", DateUtils.parseDateStr("2025-06-29"), 15000));
		listBarang.add(new Barang("Susu Stroberi", "Minuman", DateUtils.parseDateStr("2025-06-30"), 18000));
		listBarang.add(new Barang("Tempe Mendoan", "Makanan", DateUtils.parseDateStr("2025-07-01"), 16000));
		listBarang.add(new Barang("Kopi Susu", "Minuman", DateUtils.parseDateStr("2025-07-02"), 19000));
		listBarang.add(new Barang("Tahu Isi", "Makanan", DateUtils.parseDateStr("2025-07-03"), 14000));
		listBarang.add(new Barang("Es Jeruk", "Minuman", DateUtils.parseDateStr("2025-07-04"), 13000));
		listBarang.add(new Barang("Sate Ayam", "Makanan", DateUtils.parseDateStr("2025-07-05"), 39000));
		listBarang.add(new Barang("Cappuccino", "Minuman", DateUtils.parseDateStr("2025-07-06"), 25000));
		listBarang.add(new Barang("Kue Lapis", "Makanan", DateUtils.parseDateStr("2025-07-07"), 21000));
		listBarang.add(new Barang("Sirup Melon", "Minuman", DateUtils.parseDateStr("2025-07-08"), 11000));
		listBarang.add(new Barang("Kue Cubit", "Makanan", DateUtils.parseDateStr("2025-07-09"), 16000));
		User ralsna = DataUser.getDataUser(1);
		data.put(ralsna, listBarang);
		
		//Pembeli
		listBarang = new ArrayList<>();
		listBarang.add(new Barang("Pai Coklat", "Makanan", DateUtils.parseDateStr("2025-05-23"), 50000));
		listBarang.add(new Barang("Teh Botol", "Minuman", DateUtils.parseDateStr("2025-06-15"), 8000));
		listBarang.add(new Barang("Laptop Asus", "Elektronik", DateUtils.parseDateStr("2026-01-01"), 12000000));
		listBarang.add(new Barang("Sabun Mandi", "Kebutuhan", DateUtils.parseDateStr("2025-07-01"), 12000));
		listBarang.add(new Barang("Kemeja Batik", "Pakaian", DateUtils.parseDateStr("2025-08-10"), 150000));
		listBarang.add(new Barang("Coklat SilverQueen", "Makanan", DateUtils.parseDateStr("2025-06-05"), 25000));
		listBarang.add(new Barang("Air Mineral", "Minuman", DateUtils.parseDateStr("2025-07-20"), 5000));
		listBarang.add(new Barang("Mouse Logitech", "Elektronik", DateUtils.parseDateStr("2026-02-01"), 350000));
		listBarang.add(new Barang("Handuk", "Kebutuhan", DateUtils.parseDateStr("2025-09-30"), 40000));
		listBarang.add(new Barang("Celana Jeans", "Pakaian", DateUtils.parseDateStr("2025-10-15"), 200000));
		User ilya = DataUser.getDataUser(2);
		data.put(ilya, listBarang);
		
		//Penerima
		listBarang = new ArrayList<>();
		listBarang.add(new Barang("Biskuit Roma", "Makanan", DateUtils.parseDateStr("2025-06-25"), 18000));
		listBarang.add(new Barang("Jus Mangga", "Minuman", DateUtils.parseDateStr("2025-07-18"), 12000));
		listBarang.add(new Barang("Kipas Angin", "Elektronik", DateUtils.parseDateStr("2026-03-12"), 450000));
		listBarang.add(new Barang("Pasta Gigi", "Kebutuhan", DateUtils.parseDateStr("2025-08-03"), 15000));
		listBarang.add(new Barang("Jaket Hoodie", "Pakaian", DateUtils.parseDateStr("2025-11-22"), 250000));
		User usha = DataUser.getDataUser(3);
		data.put(usha, listBarang);


	}
	
	public static int getIndexUser(String username) {
		int index = 0;
		for (User u : data.keySet()) {
			if(u.getUsername().equals(username)) {
				return index;
			}
			index++;
		}
		return 0;
	}
	
	public static void getUser(User user) {
		if (currentUser != null) {
			currentUser = null;
		}
		
		currentUser = user;
		
		if (barangUser != null) {
			barangUser.clear();		
//			System.out.println("ini kosong");
		}
		barangUser = new ArrayList<>();
			for (User u : data.keySet()) {
				if (u.getUsername().equals(user.getUsername()) && u.getRole().equals(user.getRole())) {
					barangUser = new ArrayList<>(data.get(u));
//					System.out.println("ini diambild ari barang");
					break;
				}
				else if (!user.getBarang().isEmpty()) {
						barangUser = user.getBarang();
//						System.out.println("ini ambil dari user");
				} else if (!barangUser.isEmpty()){
					barangUser = new ArrayList<>();
				}
				
			}
			
//		System.out.println("Data for user " + user.getUsername() + " | " + user.getRole() + ":");
//		for (Barang b : barangUser) {
//			System.out.println("- " + b.getName());
//		}
	}
	
	public static void addBarang(Barang barang) {
			for (User u : data.keySet()) {
				if (u.getUsername().equals(currentUser.getUsername()) && u.getRole().equals(currentUser.getRole())) {
					System.out.println("barang udah masuk");
					data.get(u).add(barang);
					barangUser.add(barang);
				}
			}
	}
	
	public static void buyBarang(Barang barang, int selectedRow) {
		for (User u : data.keySet()) {
			if (u.getUsername().equals(currentUser.getUsername()) && u.getRole().equals(currentUser.getRole())) {
				data.get(u).add(barang);
			}
		}
	}
	
	public static void editBarang(int row, int column, String editedValue) {
		for (User u : data.keySet()) {
			if (u.getUsername().equals(currentUser.getUsername()) && u.getRole().equals(currentUser.getRole())) {
				switch(column) {
				case 0:
					data.get(u).get(row).setName(editedValue);
					break;
				case 1:
					data.get(u).get(row).setType(editedValue);
					break;
				case 2:
					data.get(u).get(row).setKadaluarsa(editedValue);
					break;
				case 3:
					data.get(u).get(row).setHarga(Integer.parseInt(editedValue));
					break;
				}
//				System.out.println("ini diambild ari barang");
//				break;
			}
			
		}
	}
	
	
	public static ArrayList<String> listSellerUser(String type) {
		ArrayList<String> listUser = new ArrayList<>();
		if(type.equalsIgnoreCase("trade")) {
			for (User u : data.keySet()) {
				if(u instanceof Seller) {
					for (int i = 0; i < data.get(u).size(); i++) {
						listUser.add(u.getUsername());
					}
				}
			}
		} else if(type.equalsIgnoreCase("donate")) {
			for (User u : data.keySet()) {
				if(u instanceof Donator) {
					for (int i = 0; i < data.get(u).size(); i++) {
						listUser.add(u.getUsername());
					}
				}
			}
		}
		return listUser;
	}
	
}

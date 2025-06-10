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
        listBarang.add(new Barang("Teh Botol", "Minuman", DateUtils.parseDateStr("2025-06-01"), 8000));
        listBarang.add(new Barang("Keripik Kentang", "Makanan", DateUtils.parseDateStr("2025-07-15"), 15000));
        listBarang.add(new Barang("Jus Mangga", "Minuman", DateUtils.parseDateStr("2025-06-20"), 12000));
        listBarang.add(new Barang("Roti Tawar", "Makanan", DateUtils.parseDateStr("2025-05-25"), 17000));
        listBarang.add(new Barang("Air Mineral", "Minuman", DateUtils.parseDateStr("2025-08-01"), 5000));
        listBarang.add(new Barang("Donat Coklat", "Makanan", DateUtils.parseDateStr("2025-05-30"), 10000));
        listBarang.add(new Barang("Kopi Hitam", "Minuman", DateUtils.parseDateStr("2025-06-15"), 15000));
        listBarang.add(new Barang("Nasi Goreng", "Makanan", DateUtils.parseDateStr("2025-06-05"), 25000));
        listBarang.add(new Barang("Susu Kedelai", "Minuman", DateUtils.parseDateStr("2025-06-10"), 9000));
        listBarang.add(new Barang("Coklat Batangan", "Makanan", DateUtils.parseDateStr("2025-06-22"), 13000));
        listBarang.add(new Barang("Es Jeruk", "Minuman", DateUtils.parseDateStr("2025-06-18"), 7000));
		User ursula = DataUser.getDataUser(0);
		data.put(ursula, listBarang);
		
		listBarang = new ArrayList<>();
        listBarang.add(new Barang("Martabak Manis", "Makanan", DateUtils.parseDateStr("2025-06-07"), 30000));
        listBarang.add(new Barang("Soda Gembira", "Minuman", DateUtils.parseDateStr("2025-07-01"), 11000));
        listBarang.add(new Barang("Burger Sapi", "Makanan", DateUtils.parseDateStr("2025-07-10"), 27000));
        listBarang.add(new Barang("Smoothie Pisang", "Minuman", DateUtils.parseDateStr("2025-06-25"), 16000));
        listBarang.add(new Barang("Ayam Goreng", "Makanan", DateUtils.parseDateStr("2025-05-28"), 30000));
        listBarang.add(new Barang("Milkshake Coklat", "Minuman", DateUtils.parseDateStr("2025-06-11"), 14000));
        listBarang.add(new Barang("Pizza Mini", "Makanan", DateUtils.parseDateStr("2025-07-03"), 22000));
		User yalna = DataUser.getDataUser(1);
		data.put(yalna, listBarang);


		listBarang = new ArrayList<>();
        listBarang.add(new Barang("Kue Pancong", "Makanan", DateUtils.parseDateStr("2025-08-01"), 9000));
        listBarang.add(new Barang("Susu Jahe", "Minuman", DateUtils.parseDateStr("2025-08-05"), 12000));
        listBarang.add(new Barang("Seblak Bandung", "Makanan", DateUtils.parseDateStr("2025-08-10"), 22000));
        listBarang.add(new Barang("Cendol Durian", "Minuman", DateUtils.parseDateStr("2025-08-12"), 15000));
        listBarang.add(new Barang("Kroket Ayam", "Makanan", DateUtils.parseDateStr("2025-08-15"), 13000));
        listBarang.add(new Barang("Kopi Tubruk", "Minuman", DateUtils.parseDateStr("2025-08-18"), 14000));
        listBarang.add(new Barang("Tahu Isi", "Makanan", DateUtils.parseDateStr("2025-08-20"), 8000));
        listBarang.add(new Barang("Jus Nanas", "Minuman", DateUtils.parseDateStr("2025-08-22"), 11000));
        listBarang.add(new Barang("Bakwan Jagung", "Makanan", DateUtils.parseDateStr("2025-08-24"), 9000));
        listBarang.add(new Barang("Teh Lemon", "Minuman", DateUtils.parseDateStr("2025-08-25"), 9500));
        listBarang.add(new Barang("Tempe Mendoan", "Makanan", DateUtils.parseDateStr("2025-08-27"), 7000));
		User marui = DataUser.getDataUser(2);
		data.put(marui, listBarang);


		
		
		//Donatur
		listBarang = new ArrayList<>();
        listBarang.add(new Barang("Nasi Padang", "Makanan", DateUtils.parseDateStr("2025-06-19"), 32000));
        listBarang.add(new Barang("Kopi Susu", "Minuman", DateUtils.parseDateStr("2025-06-27"), 12000));
        listBarang.add(new Barang("Kue Nastar", "Makanan", DateUtils.parseDateStr("2025-06-14"), 19000));
        listBarang.add(new Barang("Minuman Energi", "Minuman", DateUtils.parseDateStr("2025-06-12"), 10000));
        listBarang.add(new Barang("Pisang Goreng", "Makanan", DateUtils.parseDateStr("2025-05-31"), 11000));
        listBarang.add(new Barang("Teh Tarik", "Minuman", DateUtils.parseDateStr("2025-06-23"), 9000));
        listBarang.add(new Barang("Sosis Bakar", "Makanan", DateUtils.parseDateStr("2025-07-09"), 20000));
        listBarang.add(new Barang("Cappuccino", "Minuman", DateUtils.parseDateStr("2025-06-29"), 16000));
        listBarang.add(new Barang("Kue Bolu", "Makanan", DateUtils.parseDateStr("2025-06-26"), 17000));
        listBarang.add(new Barang("Jus Stroberi", "Minuman", DateUtils.parseDateStr("2025-06-16"), 14000));
        listBarang.add(new Barang("Pempek Palembang", "Makanan", DateUtils.parseDateStr("2025-07-06"), 26000));
        listBarang.add(new Barang("Lemon Tea", "Minuman", DateUtils.parseDateStr("2025-06-03"), 10000));
        listBarang.add(new Barang("Kentang Goreng", "Makanan", DateUtils.parseDateStr("2025-05-26"), 15000));
        listBarang.add(new Barang("Air Kelapa", "Minuman", DateUtils.parseDateStr("2025-06-21"), 11000));
		User ralsna = DataUser.getDataUser(3);
		data.put(ralsna, listBarang);
		
		listBarang = new ArrayList<>();
        listBarang.add(new Barang("Sate Padang", "Makanan", DateUtils.parseDateStr("2025-10-12"), 32000));
        listBarang.add(new Barang("Matcha Latte", "Minuman", DateUtils.parseDateStr("2025-10-14"), 16000));
        listBarang.add(new Barang("Kue Sagu", "Makanan", DateUtils.parseDateStr("2025-10-16"), 10000));
        listBarang.add(new Barang("Teh Susu", "Minuman", DateUtils.parseDateStr("2025-10-18"), 11000));
        listBarang.add(new Barang("Kue Kering", "Makanan", DateUtils.parseDateStr("2025-10-20"), 18000));
        listBarang.add(new Barang("Es Teler", "Minuman", DateUtils.parseDateStr("2025-10-22"), 14000));
        listBarang.add(new Barang("Ayam Geprek", "Makanan", DateUtils.parseDateStr("2025-10-24"), 26000));
        listBarang.add(new Barang("Susu Almond", "Minuman", DateUtils.parseDateStr("2025-10-25"), 14000));
        listBarang.add(new Barang("Sayur Asem", "Makanan", DateUtils.parseDateStr("2025-10-27"), 19000));
        listBarang.add(new Barang("Wedang Ronde", "Minuman", DateUtils.parseDateStr("2025-10-29"), 12000));
        listBarang.add(new Barang("Tumpeng Mini", "Makanan", DateUtils.parseDateStr("2025-10-30"), 35000));
        listBarang.add(new Barang("Es Lemonade", "Minuman", DateUtils.parseDateStr("2025-11-01"), 13000));
		User plina = DataUser.getDataUser(1);
		data.put(plina, listBarang);
		
		
		//Pembeli
		listBarang = new ArrayList<>();
        listBarang.add(new Barang("Kopi Latte", "Minuman", DateUtils.parseDateStr("2025-06-17"), 17000));
        listBarang.add(new Barang("Kue Lapis", "Makanan", DateUtils.parseDateStr("2025-06-02"), 18000));
        listBarang.add(new Barang("Teh Hijau", "Minuman", DateUtils.parseDateStr("2025-06-30"), 9000));
        listBarang.add(new Barang("Sate Ayam", "Makanan", DateUtils.parseDateStr("2025-06-08"), 35000));
        listBarang.add(new Barang("Sirup Jeruk", "Minuman", DateUtils.parseDateStr("2025-07-20"), 10000));
        listBarang.add(new Barang("Kue Cubit", "Makanan", DateUtils.parseDateStr("2025-05-29"), 12000));
        listBarang.add(new Barang("Es Campur", "Minuman", DateUtils.parseDateStr("2025-06-13"), 13000));
        listBarang.add(new Barang("Bakso Sapi", "Makanan", DateUtils.parseDateStr("2025-07-07"), 28000));
        listBarang.add(new Barang("Jus Alpukat", "Minuman", DateUtils.parseDateStr("2025-07-04"), 15000));
		User ilya = DataUser.getDataUser(5);
		data.put(ilya, listBarang);
		
		listBarang = new ArrayList<>();
        listBarang.add(new Barang("Cilok Bandung", "Makanan", DateUtils.parseDateStr("2025-09-25"), 7000));
        listBarang.add(new Barang("Teh Talua", "Minuman", DateUtils.parseDateStr("2025-09-26"), 11000));
        listBarang.add(new Barang("Bakmi Jawa", "Makanan", DateUtils.parseDateStr("2025-09-28"), 24000));
        listBarang.add(new Barang("Air Jahe Hangat", "Minuman", DateUtils.parseDateStr("2025-09-30"), 10000));
        listBarang.add(new Barang("Perkedel Kentang", "Makanan", DateUtils.parseDateStr("2025-10-01"), 9500));
        listBarang.add(new Barang("Coklat Panas", "Minuman", DateUtils.parseDateStr("2025-10-02"), 12000));
        listBarang.add(new Barang("Opor Ayam", "Makanan", DateUtils.parseDateStr("2025-10-04"), 29000));
        listBarang.add(new Barang("Es Kopi Susu", "Minuman", DateUtils.parseDateStr("2025-10-06"), 17000));
        listBarang.add(new Barang("Gado-Gado", "Makanan", DateUtils.parseDateStr("2025-10-08"), 21000));
        listBarang.add(new Barang("Jus Semangka", "Minuman", DateUtils.parseDateStr("2025-10-10"), 10000));
		User bosha = DataUser.getDataUser(5);
		data.put(bosha, listBarang);
		
		
		//Penerima
		listBarang = new ArrayList<>();
        listBarang.add(new Barang("Brownies Kukus", "Makanan", DateUtils.parseDateStr("2025-06-06"), 20000));
        listBarang.add(new Barang("Kopi Vietnam", "Minuman", DateUtils.parseDateStr("2025-06-24"), 18000));
        listBarang.add(new Barang("Lemper Ayam", "Makanan", DateUtils.parseDateStr("2025-06-28"), 9000));
        listBarang.add(new Barang("Jus Jambu", "Minuman", DateUtils.parseDateStr("2025-06-09"), 13000));
        listBarang.add(new Barang("Kue Putu", "Makanan", DateUtils.parseDateStr("2025-06-04"), 8000));
        listBarang.add(new Barang("Es Cincau", "Minuman", DateUtils.parseDateStr("2025-07-02"), 9500));
        listBarang.add(new Barang("Lontong Sayur", "Makanan", DateUtils.parseDateStr("2025-07-08"), 23000));
        listBarang.add(new Barang("Jus Apel", "Minuman", DateUtils.parseDateStr("2025-07-05"), 13500));
		User usha = DataUser.getDataUser(7);
		data.put(usha, listBarang);
		
		listBarang = new ArrayList<>();
        listBarang.add(new Barang("Sari Kacang Hijau", "Minuman", DateUtils.parseDateStr("2025-08-30"), 8500));
        listBarang.add(new Barang("Kue Lumpur", "Makanan", DateUtils.parseDateStr("2025-09-01"), 10000));
        listBarang.add(new Barang("Jus Pepaya", "Minuman", DateUtils.parseDateStr("2025-09-02"), 9000));
        listBarang.add(new Barang("Kacang Goreng", "Makanan", DateUtils.parseDateStr("2025-09-04"), 7500));
        listBarang.add(new Barang("Bandrek", "Minuman", DateUtils.parseDateStr("2025-09-06"), 9500));
        listBarang.add(new Barang("Serabi Solo", "Makanan", DateUtils.parseDateStr("2025-09-08"), 11000));
        listBarang.add(new Barang("Teh Manis Dingin", "Minuman", DateUtils.parseDateStr("2025-09-09"), 7000));
        listBarang.add(new Barang("Puding Coklat", "Makanan", DateUtils.parseDateStr("2025-09-11"), 12500));
        listBarang.add(new Barang("Susu Kurma", "Minuman", DateUtils.parseDateStr("2025-09-13"), 13500));
        listBarang.add(new Barang("Risol Mayo", "Makanan", DateUtils.parseDateStr("2025-09-14"), 12000));
        listBarang.add(new Barang("Kopi Arabika", "Minuman", DateUtils.parseDateStr("2025-09-16"), 16000));
        listBarang.add(new Barang("Ayam Penyet", "Makanan", DateUtils.parseDateStr("2025-09-18"), 27000));
        listBarang.add(new Barang("Lassi Mangga", "Minuman", DateUtils.parseDateStr("2025-09-19"), 15000));
        listBarang.add(new Barang("Kue Soes", "Makanan", DateUtils.parseDateStr("2025-09-21"), 11000));
        listBarang.add(new Barang("Kopi Robusta", "Minuman", DateUtils.parseDateStr("2025-09-23"), 15000));
		User sasha = DataUser.getDataUser(5);
		data.put(sasha, listBarang);


	}
	
	public static void addUserBarangList(User user) {
		if (checkUserData(user)) {
			data.put(user, new ArrayList<>());
		}
	}
	
	public static boolean checkUserData(User user) {
		boolean check = false;
		for (User u : data.keySet()) {			
			if (!(u.getUsername().equals(user.getUsername()) && u.getRole().equals(user.getRole()))) {

				check = true;
			} 
			else{
				return false;
			}
		}
		return check;
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
	
	public static User getUserStr(String username, String role) {
		for (User u : data.keySet()) {
			if(u.getUsername().equalsIgnoreCase(username) && u.getRole().equalsIgnoreCase(role)) {
				return u;
			}
		}
		return null;
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

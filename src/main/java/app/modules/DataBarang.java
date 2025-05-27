package app.modules;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import app.utils.*;

public class DataBarang {
	public static HashMap<String, ArrayList> data = new HashMap<>();
	public static ArrayList<Barang> listBarang = new ArrayList<>();
	
	public static void initializeData() {
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
	}
	
}

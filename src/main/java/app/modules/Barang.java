package app.modules;

import java.text.ParseException;
import java.time.LocalDate;

import app.utils.*;

public class Barang {
	private String name;
	private String type;

	private LocalDate kadaluarsa;
	private int harga;
	
	private LocalDate today = LocalDate.now();
	
	public Barang(String name, String type, LocalDate kadaluarsa, int harga) {
		this.name = name;
		this.type = type;
		this.kadaluarsa= kadaluarsa;
		this.harga = harga;
	}
	
	public boolean isKadaluarsa() throws ParseException {
		if(kadaluarsa.isAfter(today)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getDate() {
		return DateUtils.formatLocalDate(kadaluarsa);
	}
	
	public String getName() {
		return name;
	}
	
	public int getHarga() {
		return harga;
	}
	
	public String getType() {
		return type;
	}
	
}

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
	
	public String getPrice() {
		return CurrencyFormat.formatInt(harga);
	}
	
	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setKadaluarsa(String kadaluarsa) {
		this.kadaluarsa = DateUtils.parseEditedDate(kadaluarsa);
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public void setToday(LocalDate today) {
		this.today = today;
	}
	
	
	
}

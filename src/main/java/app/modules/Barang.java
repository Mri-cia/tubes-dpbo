package app.modules;

import java.text.ParseException;
import java.time.LocalDate;

import app.utils.*;

public class Barang {
	private String name;
	private String type;

	private LocalDate kadaluarsa;
	private int harga;
	
	private double discount = 0.1;
	private double discountedPrice;
	
	private LocalDate today = LocalDate.now();
	
	public Barang(String name, String type, LocalDate kadaluarsa, double harga) {
		this.name = name;
		this.type = type;
		this.kadaluarsa= kadaluarsa;
		this.harga = (int)harga;
		this.discountedPrice = countDiscount(harga);
	}
	
	public boolean isKadaluarsa() throws ParseException {
		if(kadaluarsa.isBefore(today)) {
			return true;
		} else {
			return false;
		}
	}
	
	private double countDiscount(double harga) {
		long days = DateUtils.countDays(today, kadaluarsa);
		if (days < 7) {
			this.discount = 0.6;
		} else if (days < 21) {
			this.discount = 0.4;
		} else {
			this.discount = 0.1;
		}
		return harga - (harga * discount);
	}
	
	public String getDate() {
		return DateUtils.formatLocalDate(kadaluarsa);
	}
	
	public String getName() {
		return name;
	}
	
	public int getPriceInt() {
		return harga;
	}
	
	public String getPriceStr() {
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

	public void setHarga(double harga) {
		this.harga = (int)countDiscount(harga);
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getDiscountedPriceInt() {
		return (int)discountedPrice;
	}

	public String getDiscountedPriceStr() {
		return CurrencyFormat.formatInt((int)discountedPrice);
	}
	
	
}

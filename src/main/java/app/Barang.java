package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Barang {
	private String name;
	private String type;

	private Date kadaluarsa;
	private int harga;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public Barang(String name, String type, Date kadalusarsa, int harga) {
		this.name = name;
		this.type = type;
		this.kadaluarsa= kadaluarsa;
		this.harga = harga;
	}
	
	public boolean getKadaluarsa() throws ParseException {
		Date tgl = sdf.parse(sdf.format(new Date()));
		return tgl.after(this.kadaluarsa);
	}
	
	public String getDate() {
		return sdf.format(kadaluarsa);
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

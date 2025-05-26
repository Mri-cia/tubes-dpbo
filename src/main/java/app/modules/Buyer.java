package app.modules;

public class Buyer extends User{
    private String address;

    public Buyer(String username, String password) {
        super(username, password, "Pembeli");
        this.address = address;
    }
}


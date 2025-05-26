package app.modules;

public class Recipient extends User{
    private String address;

    public Recipient(String username, String password) {
        super(username, password, "Penerima");
        this.address = address;
    }
}

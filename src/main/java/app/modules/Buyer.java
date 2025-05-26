package app.modules;

public class Buyer extends User{
    private String address;

    public Buyer(String username, String password, String role, String address) {
        super(username, password, role);
        this.address = address;
    }
}

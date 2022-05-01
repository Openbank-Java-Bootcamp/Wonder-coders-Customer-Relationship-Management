package Classes;

public class Contact extends Person{
    private static long id;

    public Contact(String name, long phoneNumber, String email) {
        super(name, phoneNumber, email);
        id++;
    }

    public static long getId() {
        return id;
    }
}

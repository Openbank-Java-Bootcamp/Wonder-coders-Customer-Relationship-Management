package Classes;

public class Contact extends Person
    private static int id;


    public Contact(String name, long phoneNumber, String email) {
        super(name, phoneNumber, email);
        id++;
    }

    public static int getId() {

    }
}

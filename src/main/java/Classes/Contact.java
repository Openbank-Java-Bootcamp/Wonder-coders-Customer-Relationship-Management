package Classes;


import java.util.HashMap;
import java.util.Map;

public class Contact extends Person {
    private final int id;

    private static int idCounter;

    private static Map<Integer, Contact> contactList = new HashMap<>();

    public Contact(String name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
        idCounter++;
        this.id = idCounter;
        contactList.put (id,this);
    }

    public int getId() {
        return id;
    }

    public static Map<Integer, Contact> getContactList() {
        return contactList;
    }

    public void printContact (){
        System.out.println("Contact");
        System.out.println("Id: " + id);
        System.out.println("Name: "+ getName());
        System.out.println("Phone number: "+ getPhoneNumber());
        System.out.println("Email: "+ getEmail());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", Name ='" + getName() + '\'' +
                ", Phone Number ='" + getPhoneNumber() + '\'' +
                ", Email ='" + getEmail() + '\'' +
                '}';
    }

    public static void showContacts(){
        String l1 = "%-2.2s";
        String s1 = "%-7.7s";
        String s2 = "%-33.33s";
        String s3 = "%-33.33s";
        String s4 = "%-33.33s";
        String l2 = "%2.2s";
        String format = l1 + " " + s1 + " " + s2 + " "+ s3 + " "+ s4 + " " + l2;

        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "| ","ID", "NAME","PHONE NUMBER","EMAIL", " |");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        contactList.forEach((key, value) -> {
            System.out.format(format, "|", value.getId(), value.getName(), value.getPhoneNumber(),value.getEmail(), " |");
            System.out.println();
        });
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }

    public static void lookUpContact(){
        int id = Integer.parseInt(App.getCurrentId());
        if(Contact.getContactList().containsKey(id)){
            String l1 = "%-2.2s";
            String s1 = "%-7.7s";
            String s2 = "%-33.33s";
            String s3 = "%-33.33s";
            String s4 = "%-33.33s";
            String l2 = "%2.2s";
            String format = l1 + " " + s1 + " " + s2 + " "+ s3 + " "+ s4 + " " + l2;

            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.format(format, "| ","ID", "NAME","PHONE NUMBER","EMAIL", " |");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.format(format, "|", contactList.get(id).getId(), contactList.get(id).getName(), contactList.get(id).getPhoneNumber(), contactList.get(id).getEmail(), "|");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
        } else {
            System.err.println("No contact matches '" + id + "' --> Type 'show contacts' to see the list of available ids.");
        }
    }
}

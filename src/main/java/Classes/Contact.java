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


    public static void showContacts(){
        System.out.println("Contacts list");
        contactList.forEach((id,lead)-> {
            lead.printContact();
        });
    }

    public static void lookUpContact(){
        int id = Integer.parseInt(App.getCurrentId());
        if(Contact.getContactList().containsKey(id)){
            contactList.get(id).printContact();
        } else {
            System.err.println("No contact matches '" + id + "' --> Type 'show contacts' to see the list of available ids.");
        }
    }
}

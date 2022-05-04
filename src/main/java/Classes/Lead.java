package Classes;

import Enums.Industry;
import Enums.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lead extends Person {

    private final int id;

    private static int idCounter;

    private String companyName;

    private static Map<Integer, Lead> leadList = new HashMap<>();

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email);
        idCounter++;
        this.id = idCounter;
        this.companyName = companyName;
        leadList.put(id, this);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public static Map<Integer, Lead> getLeadList() {
        return leadList;
    }

    public void printLead() {
        System.out.println("Lead");
        System.out.println("Id: " + id);
        System.out.println("Name: " + getName());
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id =" + id +
                ", Name ='" + getName() + '\'' +
                ", Phone Number ='" + getPhoneNumber() + '\'' +
                ", Email ='" + getEmail() + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public static void newLead(){
        String name = AppHelp.askForString("Name :");
        String phoneNumber = AppHelp.askForString("Phone number: ");
        String email = AppHelp.askForString("Email :");
        String companyName = AppHelp.askForString("Company name :");
        Lead newLead = new Lead(name, phoneNumber, email, companyName);
        System.out.println("New Lead created" + newLead.toString());
    }

    public static void showLeads() {
        System.out.println("Leads list");
        leadList.forEach((id, lead) -> {
            lead.printLead();
        });
    }

    public static void lookUpLead() {
        int id = Integer.parseInt(App.getCurrentId());
        if (Lead.leadList.containsKey(id)) {
            System.out.println(leadList.get(id).toString());
        } else {
            System.err.println("No lead matches '" + id + "' --> Type 'show leads' to see the list of available ids.");
        }
    }

    public static void removeLead() {
        int id = Integer.parseInt(App.getCurrentId());
        if (Lead.leadList.containsKey(id)) {
            System.out.println("Lead deleted" + leadList.get(id).toString());
            leadList.remove(id);
        } else {
            System.err.println("No lead matches '" + id + "' --> Type 'show leads' to see the list of available ids.");
        }
    }

    public static void convertLead() {
        int id = Integer.parseInt(App.getCurrentId());
        if (Lead.leadList.containsKey(id)) {

            //Define all the parameters first.
            String name = leadList.get(id).getName();
            String phoneNumber = leadList.get(id).getPhoneNumber();
            String email = leadList.get(id).getEmail();
            String companyName = leadList.get(id).getCompanyName();
            Product [] productType = {Product.HYBRID, Product.FLATBED, Product.BOX};
            Industry [] industryType = {Industry.PRODUCE, Industry.ECOMMERCE, Industry.MANUFACTURING, Industry.MEDICAL, Industry.OTHER};

            //Create a new contact with the information of the lead.
            Contact decisionMaker = new Contact(name, phoneNumber, email);
            System.out.println("New contact created from Lead " + id);
            System.out.println(decisionMaker.toString());

            //Create a new opportunity with the information we asked the user and the new contact created.
            System.out.println("Creating a new opportunity.");
            Product product = productType[AppHelp.selectOption("Which product the customer is interested in?", productType)];
            int quantity = AppHelp.askForInt("How many of them does the customer want?");
            Opportunity newOpportunity = new Opportunity(product, quantity, decisionMaker);
            System.out.println("New opportunity created from Lead " + id);
            newOpportunity.showOpportunity();

            //Create a new account with the information we asked the user and the information of the lead.
            System.out.println("Creating a new account.");
            Industry industry = industryType[AppHelp.selectOption("What industry is the company in?", industryType)];
            int employeeCount = AppHelp.askForInt("How many employees are in the company?");
            String city = AppHelp.askForString("What city is the company located in?");
            String country = AppHelp.askForString("What country is the company from?");
            Account newAccount = new Account(companyName, industry, employeeCount, city, country);

            //Add the newly created decision maker and opportunity to the new accounts contacts list and opportunities list.
            newAccount.addContacts(decisionMaker);
            newAccount.addOpportunities(newOpportunity);
            System.out.println("New account created from Lead " + id);
            System.out.println(newAccount.toString());

            //Remove the lead from the memory once all the process is completed.
            removeLead();
        } else {
            System.err.println("No lead matches '" + id + "' --> Type 'show leads' to see the list of available ids.");
        }
    }
}

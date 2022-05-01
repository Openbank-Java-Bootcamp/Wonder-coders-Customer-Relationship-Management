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
            leadList.remove(id);
        } else {
            System.err.println("No lead matches '" + id + "' --> Type 'show leads' to see the list of available ids.");
        }
    }

    public static void convertLead() {
        int id = Integer.parseInt(App.getCurrentId());
        if (Lead.leadList.containsKey(id)) {
            String name = leadList.get(id).getName();
            String phoneNumber = leadList.get(id).getPhoneNumber();
            String email = leadList.get(id).getEmail();
            String companyName = leadList.get(id).getCompanyName();
            Contact decisionMaker = new Contact(name, phoneNumber, email);
            String [] productType = {"HYBRID", "FLATBED", "BOX"};
            String [] industryType = {"PRODUCE", "ECOMMERCE", "MANUFACTURING", "MEDICAL", "OTHER"};
//            Product product = AppHelp.selectOption("Which product the customer is interested in? HYBRID, FLATBED or BOX", productType );
            int quantity = AppHelp.askForInt("How many of them does the customer want?");
            Opportunity newOpportunity = new Opportunity(product, quantity, decisionMaker);
//            Industry industry = AppHelp.selectOption("What industry is the company in? PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL or OTHER", industryType );
            int employeeCount = AppHelp.askForInt("How many employees are in the company?");
            String city = AppHelp.askForString("What city is the company located in?");
            String country = AppHelp.askForString("What country is the company from?");
            Account newAccount = new Account(industry, employeeCount, city, country, companyName);
            List<Contact> contactList = new ArrayList<>();
            contactList.add(decisionMaker);
            newAccount.setContactList(contactList);
            List<Opportunity> opportunityList = new ArrayList<>();
            opportunityList.add(newOpportunity);
            newAccount.setOpportunityList(opportunityList);
            removeLead();
        } else {
            System.err.println("No lead matches '" + id + "' --> Type 'show leads' to see the list of available ids.");
        }
    }
}

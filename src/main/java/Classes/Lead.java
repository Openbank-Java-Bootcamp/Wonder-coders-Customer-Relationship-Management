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

    public void showLead() {
        String l1 = "%-2.2s";
        String s1 = "%-7.7s";
        String s2 = "%-25.25s";
        String s3 = "%-25.25s";
        String s4 = "%-25.25s";
        String s5 = "%-23.23s";
        String l2 = "%2.2s";
        String format = l1 + " " + s1 + " " + s2 + " "+ s3 + " "+ s4 + " " + s5 + " " + l2;
        System.out.print(TextColor.BLUE);
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println("| LEAD                                                                                                            |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "| ","ID", "NAME","PHONE NUMBER","EMAIL","COMPANY NAME", "|");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "|", id, getName(), getPhoneNumber(), getEmail(), getCompanyName(), "|");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.print(TextColor.RESET);
    }

    @Override
    public String toString() {
        return "{" +
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
        System.out.println("New Lead created");
        newLead.showLead();
    }

    public static void showLeads() {
        String l1 = "%-2.2s";
        String s1 = "%-37.37s";
        String s2 = "%-71.71s";
        String l2 = "%2.2s";
        String format = l1 + " " + s1 + " " + s2 + " " + l2;
        System.out.print(TextColor.BLUE);
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println("| LEADS LIST                                                                                                      |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "| ","ID", "NAME", " |");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        leadList.forEach((key, value) -> {
            System.out.format(format, "|", value.getId(), value.getName(), "|");
            System.out.println();
        });
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.print(TextColor.RESET);
    }

    public static void lookUpLead() {
        int id = Integer.parseInt(App.getCurrentId());
        if (Lead.leadList.containsKey(id)) {
            String l1 = "%-2.2s";
            String s1 = "%-7.7s";
            String s2 = "%-25.25s";
            String s3 = "%-25.25s";
            String s4 = "%-25.25s";
            String s5 = "%-23.23s";
            String l2 = "%2.2s";
            String format = l1 + " " + s1 + " " + s2 + " "+ s3 + " "+ s4 + " " + s5 + " " + l2;
            System.out.print(TextColor.BLUE);
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.println("| LEAD                                                                                                            |");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.format(format, "| ","ID", "NAME","PHONE NUMBER","EMAIL","COMPANY NAME", "|");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.format(format, "|", leadList.get(id).getId(), leadList.get(id).getName(), leadList.get(id).getPhoneNumber(), leadList.get(id).getEmail(), leadList.get(id).getCompanyName(), "|");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.print(TextColor.RESET);
        } else {
            System.err.println("No lead matches '" + id + "' --> Type 'show leads' to see the list of available ids.");
        }
    }

    public static void removeLead() {
        int id = Integer.parseInt(App.getCurrentId());
        if (Lead.leadList.containsKey(id)) {
            System.out.println("Lead deleted");
            leadList.get(id).showLead();
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
            decisionMaker.showContact();

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
            newAccount.showAccount();

            //Remove the lead from the memory once all the process is completed.
            removeLead();
        } else {
            System.err.println("No lead matches '" + id + "' --> Type 'show leads' to see the list of available ids.");
        }
    }
}

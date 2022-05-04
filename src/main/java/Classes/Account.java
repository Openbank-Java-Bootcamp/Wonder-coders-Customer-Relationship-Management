package Classes;

import Enums.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {

    private String companyName;
    private final int accountId;
    private static int idCounter = 0;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;

    private static Map<Integer, Account> accountList = new HashMap<>();

    public Account() {
        idCounter++;
        this.accountId = idCounter;
    }

    public Account(String companyName, Industry industry, int employeeCount, String city, String country) {
        this();
        this.companyName = companyName;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contactList = new ArrayList<>();
        this.opportunityList = new ArrayList<>();
        accountList.put(this.accountId,this);
    }

    public void addContacts(Contact contact){
        contactList.add(contact);
    }
    public void addOpportunities(Opportunity opportunity){
        opportunityList.add(opportunity);
    }

    public static void printCommandsTable() {
        String l1 = "%-2.2s";
        String s1 = "%-20.20s";
        String s2 = "%-20.20s";
        String s3 = "%-20.20s";
        String s4 = "%-20.20s";
        String s5 = "%-20.20s";
        String s6 = "%-20.20s";
        String s7 = "%-70.70s";
        String s8 = "%-70.70s";
        String l2 = "%2.2s";
        String format = l1 + " " + s1 + " " + s2 + " " + s3 + " " + " " + s4 + " " + " " + s5 + " " + " " + s6 + " " +s7 + " " +s8 + " " + l2;
        System.out.print(TextColor.BLUE);
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ACCOUNT LIST                                                                                                    |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "| ","ACCOUNT-ID", "COMPANY NAME", "INDUSTRY","EMPLOYEES NUMBER","CITY","COUNTRY","CONTACTS","OPPORTUNITIES"," |");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        accountList.forEach((key, value) -> {
            System.out.format(format, "|", value.getAccountId(), value.getCompanyName(), value.getIndustry(),value.getEmployeeCount(),value.getCity(),value.getCountry(),value.getContactList(),value.getOpportunityList(), "|");
            System.out.println();
        });
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.print(TextColor.RESET);
    }
    public static void showAccounts() { 
        System.out.println("Accounts list");
        accountList.forEach((id, account) -> {
            System.out.println(account.toString());
        });
    }

    public static void lookUpAccounts() {
        int accountId = Integer.parseInt(App.getCurrentId());
        if (Account.getAccountList().containsKey(accountId)) {
            Account account = accountList.get(accountId);
            System.out.println("Account number Id " + accountId + "\n");
            System.out.println(account.toString());
        } else {
            System.err.println("Account number " + accountId + "doesn't exist");
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getAccountId() {
        return accountId;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    public static Map<Integer, Account> getAccountList() {
        return accountList;
    }

    public static void setAccountList(Map<Integer, Account> accountList) {
        Account.accountList = accountList;
    }
}
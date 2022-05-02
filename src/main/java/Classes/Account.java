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



    public Account(String companyName, Industry industry, int employeeCount, String city, String country) {
        idCounter++;
        this.companyName = companyName;
        this.accountId = idCounter;
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

    @Override
    public String toString() {
        return "Account: \n" +
                "Company= " + companyName + "\n" +
                "accountId=" + accountId + "\n" +
                "industry=" + industry + "\n" +
                "employeeCount=" + employeeCount + "\n" +
                "city='" + city + '\'' + "\n" +
                "country='" + country + '\'' + "\n" +
                "contactList=" + contactList + "\n" +
                "opportunityList=" + opportunityList + "\n";
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
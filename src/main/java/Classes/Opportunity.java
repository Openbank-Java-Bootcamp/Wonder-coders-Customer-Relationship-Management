package Classes;

import Enums.*;

import java.util.*;

public class Opportunity {
    private final int id;
    private static int idCount = 0;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    private static Map<Integer, Opportunity> opportunityList = new HashMap<>();

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        idCount++;
        this.id = idCount;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = Status.OPEN;
        opportunityList.put(id, this);
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Map<Integer, Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public static void setOpportunityList(Map<Integer, Opportunity> opportunityList) {
        Opportunity.opportunityList = opportunityList;
    }

    // Show details of an opportunity
    public void showOpportunity() {
        System.out.println("Opportunity");
        System.out.println("Id: " + id);
        System.out.println("Product: " + product);
        System.out.println("Quantity: " + quantity);
        System.out.println("Decision Maker: " + decisionMaker);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------------");
    }

    // Show opportunity with id
    public static void lookUpOpportunity() {
        int id = Integer.parseInt(App.getCurrentId());

        if (Opportunity.getOpportunityList().containsKey(id)) { // If opportunity with exists
            Opportunity opportunity = opportunityList.get(id);
            System.out.println("This is the opportunity with id " + id);
            opportunity.showOpportunity();
        } else {
            System.err.println("No opportunity with id " + id);
        }
    }

    // Show list of opportunities
    public static void showOpportunities() {
        if (opportunityList.isEmpty()) {
            System.err.println("Opportunity list is empty");
        }
        System.out.println("Opportunity list");
        opportunityList.forEach((id, opportunity) -> {
            opportunity.showOpportunity();
        });
    }

    // Change status to CLOSE_WON
    public static void closeWon() {
        int id = Integer.parseInt(App.getCurrentId());

        if (Opportunity.getOpportunityList().containsKey(id)) { // If opportunity with exists
            Opportunity opportunity = opportunityList.get(id);
            opportunity.setStatus(Status.CLOSED_WON);
        } else {
            System.err.println("No opportunity with id " + id);
        }
    }

    // Change status to CLOSE_LOSE
    public static void closeLost() {
        int id = Integer.parseInt(App.getCurrentId());

        if (Opportunity.getOpportunityList().containsKey(id)) { // If opportunity with exists
            Opportunity opportunity = opportunityList.get(id);
            opportunity.setStatus(Status.CLOSED_LOST);
        } else {
            System.err.println("No opportunity with id " + id);
        }
    }
}
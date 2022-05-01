package Classes;

import Enums.*;

import java.util.*;

public class Opportunity {
    private final int id;
    private static int idCount;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    private static Map<Integer, Opportunity> opportunityList = new HashMap<>();

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        ++idCount;
        this.id = idCount;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
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

    public void showOpportunity() {
        System.out.println("Opportunity");
        System.out.println("Id: " + id);
        System.out.println("Product: " + product);
        System.out.println("Quantity: " + quantity);
        System.out.println("Decision Maker: " + decisionMaker);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------------");
    }

    public static void lookUpOpportunity() {
        int id = Integer.parseInt(App.getCurrentId());

        if (Opportunity.getOpportunityList().containsKey(id)) {
            Opportunity opportunity = opportunityList.get(id);
            System.out.println("This is the opportunity with id " + id + "\n");
            opportunity.showOpportunity();
        } else  {
            System.err.println("No opportunity with id " + id);
        }
    }

    public static void showOpportunities() {
        System.out.println("List opportunities");
        opportunityList.forEach((id, opportunity) -> {
            opportunity.showOpportunity();
        });
    }

    public static void closeWon() {
        int id = Integer.parseInt(App.getCurrentId());

        if (Opportunity.getOpportunityList().containsKey(id)) {
            Opportunity opportunity = opportunityList.get(id);
            opportunity.setStatus(Status.CLOSED_WON);
        } else  {
            System.err.println("No opportunity with id " + id);
        }
    }

    public static void closeLost() {
        int id = Integer.parseInt(App.getCurrentId());

        if (Opportunity.getOpportunityList().containsKey(id)) {
            Opportunity opportunity = opportunityList.get(id);
            opportunity.setStatus(Status.CLOSED_LOST);
        } else  {
            System.err.println("No opportunity with id " + id);
        }
    }
}
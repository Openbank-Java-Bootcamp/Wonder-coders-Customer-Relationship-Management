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

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
        idCount++;
        this.id = idCount;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = Status.OPEN;
        opportunityList.put(this.id, this);
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
        /*String l1 = "%-2.2s";
        String s1 = "%-5.5s";
        String s2 = "%-10.10s";
        String s3 = "%-12.12s";
        String s4 = "%-72.72s";
        String s5 = "%-6.6s";
        String l2 = "%2.2s";
        String format = l1 + " " + s1 + " " + s2 + " " + s3 + " " + s4 + " " + s5 + " " + l2;
        System.out.print(TextColor.BLUE);
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "| ","ID", "PRODUCT", "QUANTITY", "DECISION MAKER", "STATUS", " |");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "|", id, product, quantity, decisionMaker, status, "|");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.print(TextColor.RESET);*/
    }

    // Show opportunity with id
    public static void lookUpOpportunity() {
        int id = Integer.parseInt(App.getCurrentId());

        if (Opportunity.getOpportunityList().containsKey(id)) { // If opportunity with exists
            Opportunity opportunity = opportunityList.get(id);
            System.out.println("This is the opportunity with id " + id);
            opportunity.showOpportunity();
            /*String l1 = "%-2.2s";
            String s1 = "%-5.5s";
            String s2 = "%-10.10s";
            String s3 = "%-12.12s";
            String s4 = "%-70.70s";
            String s5 = "%-8.8s";
            String l2 = "%2.2s";
            String format = l1 + " " + s1 + " " + s2 + " " + s3 + " " + s4 + " " + s5 + " " + l2;
            System.out.print(TextColor.BLUE);
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.format(format, "| ","ID", "PRODUCT", "QUANTITY", "DECISION MAKER", "STATUS", " |");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.format(format, "|", opportunity.id, opportunity.product, opportunity.quantity, opportunity.decisionMaker, opportunity.status, "|");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.print(TextColor.RESET);*/
        } else {
            System.err.println("No opportunity matches '" + id + "' --> Type 'show opportunities' to see the list of available ids.");
        }
    }

    // Show list of opportunities
    public static void showOpportunities() {
        if (opportunityList.isEmpty()) {
            System.err.println("Opportunity list is empty");
        }
        System.out.println("Opportunity list");
        /*opportunityList.forEach((id, opportunity) -> {
            opportunity.showOpportunity();
        });*/
        String l1 = "%-2.2s";
        String s1 = "%-5.5s";
        String s2 = "%-10.10s";
        String s3 = "%-12.12s";
        String s4 = "%-70.70s";
        String s5 = "%-8.8s";
        String l2 = "%2.2s";
        String format = l1 + " " + s1 + " " + s2 + " " + s3 + " " + s4 + " " + s5 + " " + l2;
        System.out.print(TextColor.BLUE);
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "| ","ID", "PRODUCT", "QUANTITY", "DECISION MAKER", "STATUS", " |");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        opportunityList.forEach((key, value) -> {
            System.out.format(format, "|", value.id, value.product, value.quantity, value.decisionMaker, value.status, "|");
            System.out.println();
        });
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.print(TextColor.RESET);
    }

    // Change status to CLOSE_WON
    public static void closeWon() {
        int id = Integer.parseInt(App.getCurrentId());

        if (Opportunity.getOpportunityList().containsKey(id)) { // If opportunity with exists
            Opportunity opportunity = opportunityList.get(id);
            opportunity.setStatus(Status.CLOSED_WON);
        } else {
            System.err.println("No opportunity matches '" + id + "' --> Type 'show opportunities' to see the list of available ids.");
        }
    }

    // Change status to CLOSE_LOSE
    public static void closeLost() {
        int id = Integer.parseInt(App.getCurrentId());

        if (Opportunity.getOpportunityList().containsKey(id)) { // If opportunity with exists
            Opportunity opportunity = opportunityList.get(id);
            opportunity.setStatus(Status.CLOSED_LOST);
        } else {
            System.err.println("No opportunity matches '" + id + "' --> Type 'show opportunities' to see the list of available ids.");
        }
    }

    @Override
    public String toString() {
        return "id " + id +
                ", status " + status;
    }
}
package Classes;

public class Lead extends Person{

    private static int id;
  
    private String companyName;

    public Lead(String name, long phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email);
        id++;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public static int getId() {

        return id;
    }

}

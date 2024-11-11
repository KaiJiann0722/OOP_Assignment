package assignment;

public class Customer{
    private static int currentCustID = 10001;
    private String custID;
    private String name;
    private char gender;
    private String telNo;
    private boolean isMember;

    public Customer(){
        this(" ", "012-345 6789", ' ');
    }

    public Customer(String name, String telNo, char gender)
    { 
        this.custID = "C" + currentCustID;
        this.name = name;
        this.telNo = telNo;
        this.gender = gender;
        this.isMember = false;
        currentCustID++;
    }

    public String getCustID() {
        return custID;
    }

    @Override
    public String toString() {
        return "Customer{" + "custID=" + custID + ", name=" + name + ", gender=" + gender + ", telNo=" + telNo + '}';
    }
        
        
}

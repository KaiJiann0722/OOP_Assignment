package assignment;

public class Receptionist {
    private static int currentRecepID = 10001;
    private String recepID;
    private String name;
    private String password;

    public Receptionist(String name, String password) {
        this.recepID = "R" + Receptionist.currentRecepID;
        this.name = name;
        this.password = password;
        currentRecepID++;
    }

    public String getRecepID() {
        return recepID;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Receptionist{" + "recepID=" + recepID + ", name=" + name + ", password=" + password + '}';
    }
    
    
}

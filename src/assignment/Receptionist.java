/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author DingWei
 */
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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.LocalDate;

/**
 *
 * @author DingWei
 */
public class Payment {
    private static int currentPaymentID = 10001;
    private String paymentID;
    private LocalDate date;
    private double amount;
    private String status;
    
    public Payment(){
        this(0.0);
    }

    public Payment(double amount) {
        this.paymentID = "P" + Payment.currentPaymentID;
        this.date = LocalDate.now();
        this.amount = amount;
        this.status = "pending";
        currentPaymentID++;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", date=" + date + ", amount=" + amount + ", status=" + status + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.LocalDate;

import java.util.ArrayList;

public class Booking {
    private static int currentBookingID = 10001;
    private String bookingID;
    private ArrayList<Booking_Details> bDetails;
    private LocalDate bookingDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String status;
    private double totalPrice;

    public Booking(ArrayList<Booking_Details> bDetails) {
        this.bookingID = "B" + Booking.currentBookingID;
        this.bDetails = bDetails;
        this.bookingDate = LocalDate.now();
        this.status = "confirm";                       // confirm, checked in, checked out, cancelled
        countTotalPrice();
        currentBookingID++;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }
    
    public void checkIn(){
        this.checkInDate = LocalDate.now();
    }
    
    public void checkOut(){
        this.checkOutDate = LocalDate.now();
    }

    public ArrayList<Booking_Details> getbDetails() {
        return bDetails;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void countTotalPrice(){
        for (int i = 0; i < bDetails.size(); i++) {
            this.totalPrice += bDetails.get(i).getSubPrice();
        }
    }
    
    public static int getCurrentBookingID() {
        return currentBookingID;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID + ", bookingDate=" + bookingDate + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", status=" + status + ", totalPrice=" + totalPrice + '}';
    }
    
    
    
    
    public boolean validateBookingDate(Booking[] b){
        for (int i = 0; i < b.length; i++) {
            if(this.bookingDate.compareTo(b[i].getBookingDate()) == 0){
                return false;
            }
        }
        
        return true;
    }
}

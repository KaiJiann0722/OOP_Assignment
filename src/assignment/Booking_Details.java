package assignment;

public class Booking_Details {
    
    private int noOfPax;
    private int noOfAdult;
    private int noOfChild;
    private Room room;
    private double subPrice;
    
    public Booking_Details(int noOfPax, int noOfAdult, int noOfChild, Room room, double subPrice) {
        this.noOfPax = noOfPax;
        this.noOfAdult = noOfAdult;
        this.noOfChild = noOfChild;
        this.room = room;
        this.subPrice = subPrice;
    }

    public double getSubPrice() {
        return subPrice;
    }
    
    @Override
    public String toString() {
        return "Booking_Details{" + "noOfPax=" + noOfPax + ", noOfAdult=" + noOfAdult + ", noOfChild=" + noOfChild + ", " + room + ", subPrice=" + subPrice + '}';
    }
    
    

}

package assignment;

import java.util.ArrayList;

public class RoomType {
    private String roomType;
    private int capacity;
    private double price;
    private ArrayList<Room> room;
    private int totalNumOfRoom;

    public RoomType() {
        this("", 1, 0.0);
    }

    public RoomType(String roomType, int capacity, double price) {
        this.roomType = roomType;
        this.capacity = capacity;
        this.price = price;
        this.totalNumOfRoom = 0;
        this.room = new ArrayList<Room>();
    }

    public void addRoom(Room r){
        room.add(r);
        totalNumOfRoom++;
    }   
    
    public String getRoomType() {
        return roomType;
    }

    public ArrayList<Room> getRoom() {
        return room;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }
    
    public void displayAllRoom(){
        for (int i = 0; i < room.size(); i++) {
            System.out.println(room.get(i));
        }
    }

    @Override
    public String toString() {
        return "RoomType{" + "roomName=" + roomType + ", capacity=" + capacity + ", price=" + price + '}';
    }

}

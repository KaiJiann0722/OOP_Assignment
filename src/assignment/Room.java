/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author DingWei
 */
public class Room {
    private static int currentRoomNo = 100;
    private int roomNo;
    private int floor;
    private char status;
    
    public Room(){
        this(0);
    }
    
    public Room(int floor){
        this.roomNo = Room.currentRoomNo;
        this.floor = floor;
        this.status = 'V';
        Room.currentRoomNo++;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" + "roomNo=" + roomNo + ", floor=" + floor + ", status=" + status + '}';
    }
    
  
}

package assignment;

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

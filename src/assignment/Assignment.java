package assignment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class Assignment {
    public static void main(String[] args) {
        ArrayList<RoomType> room_type = new ArrayList<RoomType>();
        room_type.add(new RoomType("Single Room", 1, 250.00));
        room_type.add(new RoomType("Double Room", 2, 450.00));
        room_type.add(new RoomType("Family Room", 5, 950.00));
        
        ArrayList<Room> room_array = new ArrayList<Room>();
        room_array.add(new Room(1));
        room_array.add(new Room(1));
        room_array.add(new Room(1));        
        room_array.add(new Room(2));
        room_array.add(new Room(2));
        room_array.add(new Room(2));
        room_array.add(new Room(3));
        room_array.add(new Room(3));
        room_array.add(new Room(3));
        
        
        room_type.get(0).addRoom(room_array.get(0));
        room_type.get(0).addRoom(room_array.get(1));
        room_type.get(0).addRoom(room_array.get(2));
        
        room_type.get(1).addRoom(room_array.get(3));
        room_type.get(1).addRoom(room_array.get(4));
        room_type.get(1).addRoom(room_array.get(5));
        
        room_type.get(2).addRoom(room_array.get(6));
        room_type.get(2).addRoom(room_array.get(7));
        room_type.get(2).addRoom(room_array.get(8));
        
        ArrayList<Receptionist> recep_array = new ArrayList<>();
        recep_array.add(new Receptionist("John", "abc123"));
        recep_array.add(new Receptionist("Jennie", "jennie"));
        recep_array.add(new Receptionist("Ali", "abuxyz"));
        
        ArrayList<Customer> cust_array = new ArrayList<>();
        cust_array.add(new Customer("Tan Kai Ji", "999", 'F'));
        cust_array.add(new Customer("Chong Jail", "0123", 'M'));
        cust_array.add(new Customer("Chan Tiu Tan", "01213", 'F'));
        
        ArrayList<Member> member_array = new ArrayList<>();
        member_array.add(new Member());
        member_array.add(new Member());
        member_array.add(new Member());
        
        
        ArrayList<Booking> booking_array = new ArrayList<Booking>();

        boolean cont = true;       
        
        Scanner scan = new Scanner(System.in);
        int choice;
        //Login(recep_array);
        do{
            choice = display_main_menu();            
            switch(choice){
                case 1 -> {
                    choice = display_member_menu();
                    switch(choice){
                        case 1 -> {
                    }
                        case 2 -> {
                    }
                        case 3 -> {
                    }
                        case 4 -> {
                    }
                        case 5 -> {
                    }
                    }
                }
                case 2 -> {
                    choice = display_customer_menu();
                    switch(choice){
                        case 1 -> {
                    }
                        case 2 -> {
                    }
                        case 3 -> {
                    }
                        case 4 -> {
                    }
                        case 5 -> {
                    }
                    }
                }
                case 3 -> {
                    choice = display_booking_menu();
                    switch(choice){
                        case 1 -> DisplayAllBooking(booking_array);
                        case 2 -> CreateNewBooking(booking_array, cust_array, room_array, room_type);
                        case 3 -> {
                    }
                        case 4 -> {
                    }
                        case 5 -> {
                    }
                    }
                }
                case 4 -> cont = false;
                default -> System.out.println("Invalid Input, Please Enter Again");
            }
        }while(cont);
        
        
                

        
        
        
    }  
    
    public static boolean validateOpt(int input, int max){
        return input > 0 && input <= max;
    }
    
    public static void DisplayAllBooking(ArrayList<Booking> booking_array){
        for (int i = 0; i < booking_array.size(); i++) {
            System.out.println(booking_array.get(i));
        }
    }
//    
//    public static void countTotalPrice(ArrayList<Booking> booking_array){
//        for (int i = 0; i < booking_array.size(); i++) {
//            double tempTotal = 0;
//            for (int j = 0; j < booking_array.get(i).getbDetails().size(); j++) {
//                 tempTotal += booking_array.get(i).getbDetails().get(j).getSubPrice();
//            }
//            booking_array.get(i).setTotalPrice(tempTotal);
//        }
//    }
    
    public static void CreateNewBooking(ArrayList<Booking> booking_array, ArrayList<Customer> cust_array, ArrayList<Room> room_array, ArrayList<RoomType> room_type){
        
        ArrayList<Booking_Details> bd_array = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("Booking ID                   : B" + Booking.getCurrentBookingID());
        boolean isIdValid = false;
        do {
            System.out.print("Please Enter Customer ID     : ");
            String custID = scan.nextLine();
            for (int i = 0; i < cust_array.size(); i++) {
                if(cust_array.get(i).getCustID().equalsIgnoreCase(custID)){
                    isIdValid = true;
                    break;
                }
            }
            if(!isIdValid)
                System.out.println("<ERROR> Invalid Input, Please Enter Again.");
        } while (!isIdValid);
        
        char anotherBooking = 'Y';
        
        do{
            // Enter Booking Details
            int noOfPax = 0;
            int noOfAdult = 0;
            int noOfChild = 0;
            boolean valid = true;
            
            
            boolean isValidPax = true;
            do {
                isValidPax = true;
                System.out.println("");
                do {
                    try{
                        valid = true;
                        System.out.print("Please Enter Number Of Pax   : ");
                        noOfPax = scan.nextInt();
                    }catch(Exception e){
                        System.out.println("<ERROR> Invalid Input, Please Enter Again");
                        valid = false;
                        scan.nextLine();
                    }
                } while (!valid);
                if(noOfPax <= 0){
                    System.out.println("<ERROR> Invalid Input, Need To Have At Least One Pax.");
                    isValidPax = false;
                    continue;
                }
                else if(noOfPax > 7){
                    System.out.println("<ERROR> Invalid Input, Exceed The Maximum Pax Allowed.");
                    isValidPax = false;
                    continue;
                }
                do {
                    try{
                        valid = true;
                        System.out.print("Please Enter Number Of Adult : ");
                        noOfAdult = scan.nextInt();
                    }catch(Exception e){
                        System.out.println("<ERROR> Invalid Input, Please Enter Again");
                        valid = false;
                        scan.nextLine();
                    }
                } while (!valid);
                if(noOfAdult < 1){
                    System.out.println("<ERROR> Invalid Input, Need To Have At Least One Adult.");
                    isValidPax = false;
                    continue;
                }
                else if(noOfAdult > noOfPax){
                    System.out.println("<ERROR> Invalid Input, Exceed The Total Number Of Pax.");
                    isValidPax = false;
                    continue;
                }

                do {
                    try{
                        valid = true;
                        System.out.print("Please Enter Number Of Child : ");
                        noOfChild = scan.nextInt();
                    }catch(Exception e){
                        System.out.println("<ERROR> Invalid Input, Please Enter Again");
                        valid = false;
                        scan.nextLine();
                    }
                } while (!valid);
                if(noOfChild != (noOfPax - noOfAdult)){
                    System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                    isValidPax = false;
                }
            } while (!isValidPax);
            // Enter number of Adult
            

            // Print all roomtype with capacity more than num of pax
            for (int i = 0; i < room_type.size(); i++) {
                 if(room_type.get(i).getCapacity() >= noOfPax){
                    System.out.println(room_type.get(i));
                 }
            }

            // Enter Room Name
            String roomType;
            scan.nextLine();
            boolean isValidRoomType = false;
            do{
                System.out.print("Please Enter Room Type       : ");
                roomType = scan.nextLine();
                for (int i = 0; i < room_type.size(); i++) {
                     if(room_type.get(i).getRoomType().equalsIgnoreCase(roomType) && room_type.get(i).getCapacity() >= noOfPax)
                     {
                        isValidRoomType = true;
                        System.out.println(room_type.get(i));
                         for (int j = 0; j < room_type.get(i).getRoom().size(); j++) {
                             if(room_type.get(i).getRoom().get(j).getStatus() == 'V')
                                 System.out.println(room_type.get(i).getRoom().get(j));
                         }
                        break; 
                     }
                }
                if(!isValidRoomType)
                    System.out.println("<ERROR> Invalid Room Type, Please Enter Again.");
            }while(!isValidRoomType);

            // Enter Room No
            Room r = new Room();
            double subPrice = 0;
            int roomNo = 0;
            boolean isValidRoomNo = false;
            do{
                do {
                    try{
                        valid = true;
                        System.out.print("Please Enter Room Number     : ");
                        roomNo = scan.nextInt();
                    }catch(Exception e){
                        System.out.println("<ERROR> Invalid Input, Please Enter Number.");
                        valid = false;
                        scan.nextLine();
                    }
                } while (!valid);
                for (int i = 0; i < room_type.size(); i++) {
                    if(room_type.get(i).getRoomType().equalsIgnoreCase(roomType) && room_type.get(i).getCapacity() >= noOfPax)
                        for (int j = 0; j < room_type.get(i).getRoom().size(); j++) {
                            if (room_type.get(i).getRoom().get(j).getRoomNo() == roomNo && room_type.get(i).getRoom().get(j).getStatus() == 'V')
                            {
                                isValidRoomNo = true;
                                r = room_type.get(i).getRoom().get(j);
                                subPrice = room_type.get(i).getPrice();
                            }
                        }
                }
                if(!isValidRoomNo){
                    System.out.println("<ERROR> Invalid Room Number, Please Enter Again.");
                }
            }while(!isValidRoomNo);

            // Display Booking Details
            Booking_Details bd = new Booking_Details(noOfPax, noOfAdult, noOfChild, r, subPrice);
            System.out.println(bd);
            
            char confirmProceed = 'Y';
            do {
                System.out.print("Confirm To Book This Room? (Y/N) : ");
                confirmProceed = Character.toUpperCase(scan.next().charAt(0));
                scan.nextLine();
                if(confirmProceed == 'Y'){
                    bd_array.add(bd);
                    for (int i = 0; i < room_array.size(); i++) {
                        if(room_array.get(i).getRoomNo() == roomNo)
                            room_array.get(i).setStatus('B');
                    }
                }
                if(confirmProceed != 'N' && confirmProceed != 'Y')
                    System.out.println("<ERROR> Invalid Input, Please Enter Again.");
            } while (confirmProceed != 'N' && confirmProceed != 'Y');
            
            
            
            do {
                System.out.print("Wish To Book Another Room? (Y/N) : ");
                anotherBooking = Character.toUpperCase(scan.next().charAt(0));
                scan.nextLine();
                if(anotherBooking != 'N' && anotherBooking != 'Y')
                    System.out.println("<ERROR> Invalid Input, Please Enter Again.");
            } while (anotherBooking != 'N' && anotherBooking != 'Y');
            
        }while(Character.toUpperCase(anotherBooking) == 'Y');
        
        booking_array.add(new Booking(bd_array));
    }
    
    
    public static void Login(ArrayList<Receptionist> recep_array){
        Scanner scan = new Scanner(System.in);
        boolean validLogin = false;
        do{
            System.out.println("Welcome To Shangri-La Hotel POS Booking System");
            System.out.print("Please Enter Your ID : ");
            String login_id = scan.nextLine();
            System.out.print("Please Enter Your Password: ");
            String login_password = scan.nextLine();
            
            for(int i = 0 ; i < recep_array.size() ; i ++){
                if(recep_array.get(i).getRecepID().equals(login_id)){
                    if(recep_array.get(i).getPassword().equals(login_password))
                        validLogin = true;
                }
            }
            if(!validLogin){
                System.out.println("Invalid Input, Please Enter Again");
            }
        }while(!validLogin);
        System.out.println("Successfully Login");
    }
    
    public static int display_main_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Main Menu");
        System.out.println("1. Member");
        System.out.println("2. Customer");
        System.out.println("3. Booking");
        System.out.println("4. Exit");
        System.out.print("Please Enter Your Choice : ");
        int choice = scan.nextInt();
        return choice;
    }
    
    public static int display_member_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Member");
        System.out.println("1. Display All");
        System.out.println("2. Add Member");
        System.out.println("3. Delete Member");
        System.out.println("4. Set Discount Rate");
        System.out.println("5. Back To Main Menu");
        System.out.print("Please Enter Your Choice : ");
        int choice = scan.nextInt();
        return choice;
    }
    
    public static int display_customer_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Customer");
        System.out.println("1. Display All");
        System.out.println("2. Add Customer");
        System.out.println("3. Delete Customer");
        System.out.println("4. Modify Customer");
        System.out.println("5. Back To Main Menu");
        System.out.print("Please Enter Your Choice : ");
        int choice = scan.nextInt();
        return choice;
    }
    
    public static int display_booking_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Booking");
        System.out.println("1. Display All");
        System.out.println("2. Create New Booking");
        System.out.println("3. Delete Booking");
        System.out.println("4. Modify Booking");
        System.out.println("5. Back To Main Menu");
        System.out.print("Please Enter Your Choice : ");
        int choice = scan.nextInt();
        return choice;
    }
}






        
        //================================= Check in
        
        // enter booking id

        // validate
        
        // if valid, change booking status to checked in, change room status to o = occupied
        
        //================================= Check out
        
        // enter booking id 
        
        // validate

        // if valid, change booking status to checked out, change room status to v = vaccant
        
        
        //================================== Create New Booking
        
        // Enter Customer ID
        
        // Check is Member?
        
        // If yes, enter Member ID then isMember = true 
        
        
        // Create Booking Details Array
        
        // Enter RoomType 
        
        
        // Loop and find Room with the same name type and status = V             *v = vaccant   o = occupied   m = maintenence  b = booked
        
        
        // Select One room
        
        // Enter Booking details
        
        
        // Create One Booking details
        
        
        // store booking details into booking details array
        
        // Any other room?
        
        // If yes then loop again create booking details
        
        // If not then create booking 
        
        // payment - choose cash / card              
        
        
        // enter payment details             * Total = 150, Cash = 200, Change = 50
        
        
        // change payment status to valid / paid / completed        change room(s) status = b = booked
        
        
        // next customer? 
        
        
        // If yes, loop back to enter customer details
        
        
        // If not, exit program
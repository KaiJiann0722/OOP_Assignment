package assignment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class Assignment {
    public static void main(String[] args) {

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
        
        ArrayList<RoomType> room_type = new ArrayList<RoomType>();
        room_type.add(new RoomType("Single Room", 1, 250.00));
        room_type.add(new RoomType("Double Room", 2, 450.00));
        room_type.add(new RoomType("Family Room", 5, 950.00));
        
        
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
        cust_array.add(new Customer("Tan Kai Ji", "0123456789", 'F'));
        cust_array.get(0).setIsMember(true);
        cust_array.add(new Customer("Chong Jail", "0123876542", 'M'));
        cust_array.add(new Customer("Chan Tiu Tan", "0121378672", 'F'));
        
        ArrayList<Member> member_array = new ArrayList<>();
        member_array.add(new Member());
        member_array.add(new Member());
        member_array.add(new Member());
        
        ArrayList<Payment> payment_array = new ArrayList<>();
        
        ArrayList<Booking> booking_array = new ArrayList<Booking>();
   
        
        Scanner scan = new Scanner(System.in);
        int menuChoice;
        //Login(recep_array);
        do {
            int choice = 0;
            menuChoice = display_main_menu();            
            switch(menuChoice){
                case 1 -> {
                    do {
                        choice = display_member_menu();
                        switch(choice){
                            case 1:displayMember(member_array);break;
                            case 2:addMember(member_array, cust_array);break;
                            case 3:deleteMember(member_array, cust_array);break;
                            case 4:modifyDiscountRate(member_array);break;
                            case 5:                        }
                    } while (choice != 5);
                }
                case 2 -> {
                    do {
                        choice = display_customer_menu();
                        switch(choice){
                            case 1:displayCustomer(cust_array);break;
                            case 2:addCustomer(cust_array);break;
                            case 3:deleteCustomer(cust_array);break;
                            case 4:modifyCustomer(cust_array);break;
                            case 5:                        }
                    } while (choice != 5);
                }
                case 3 -> {
                    do {
                        choice = display_booking_menu();
                        switch(choice){
                            case 1:displayAllBooking(booking_array);break;
                            case 2:createNewBooking(booking_array, cust_array, room_array, room_type, payment_array);break;
                            case 3:deleteBooking(booking_array, room_array);break;
                            case 4:
                        }   
                    } while (choice != 4);

                }
                case 4 -> {
                    do {
                        choice = display_room_menu();
                        switch(choice){
                            case 1: displayAllRoom(room_array);break;
                            case 2: addRoom(room_array, room_type);break;
                            case 3: removeRoom(room_array, room_type);break;
                            case 4: updateRoomStatus(room_array, room_type);break;
                            case 5: 
                        }  
                    } while (choice != 5);

                }
                case 5 -> {
                    do {
                        choice = display_room_type_menu();
                        switch(choice){
                            case 1 -> displayAllRoomType(room_type);
                            case 2 -> addNewRoomType(room_type);
                            case 3 -> modifyRoomType(room_type);
                            case 4 -> {
                            }
                        }
                    } while (choice != 4);
                }
                case 6 -> {
                    do {
                        choice = display_payment_menu();
                        switch(choice){
                            case 1:displayAllPayment(payment_array);break;
                            case 2:updatePaymentStatus(payment_array);break;
                            case 3:
                        }
                    } while (choice != 3);
                }
            }   
        } while (menuChoice != 7);
        
    }
    
    public static void Login(ArrayList<Receptionist> recep_array){
        Scanner scan = new Scanner(System.in);
        boolean validLogin = false;
        do{
            System.out.println("Welcome To Shangri-La Hotel POS Booking System");
            System.out.print("Please Enter Your ID       : ");
            String login_id = scan.nextLine();
            System.out.print("Please Enter Your Password : ");
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
        boolean valid = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("    Main Menu    ");
        System.out.println("=================");
        System.out.println("1. Member        ");
        System.out.println("2. Customer      ");
        System.out.println("3. Booking       ");
        System.out.println("4. Room          ");
        System.out.println("5. Room Type     ");
        System.out.println("6. Payment       ");
        System.out.println("7. Exit          ");        
        
        System.out.println("");
        int choice = validateChoice(7);
        
        return choice;
    }
    
    public static int validateChoice(int max){
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        boolean isValidChoice = false, valid = false;
        do {
            do {
                try{
                    valid = true;
                    System.out.print("Please Enter Your Choice : ");
                    choice = scan.nextInt();
                }catch(Exception e){
                    System.out.println("<ERROR> Invalid Input, Please Enter Again");
                    valid = false;
                    scan.nextLine();
                }
            } while (!valid);
            if(choice > 0 && choice <= max){
                isValidChoice = true;
            }else
                System.out.println("<ERROR> Invalid Number, Please Enter Again.");
        } while (!isValidChoice);
        
        return choice;
    }
    

    //===================================Boooking========================================//
    
    public static int display_booking_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("       Booking       ");
        System.out.println("=====================");
        System.out.println("1. Display All       ");
        System.out.println("2. Create New Booking");
        System.out.println("3. Delete Booking    ");
        System.out.println("4. Back To Main Menu ");
        System.out.println("");
        int choice = validateChoice(5);
        return choice;
    }
    
    public static void displayAllBooking(ArrayList<Booking> booking_array){
        System.out.println("");
        System.out.println("==========================================");
        System.out.println("                BOOKING                 ");
        System.out.println("==========================================");
        System.out.printf("%-10s %-10s %-8s %-11s\n", "BOOKING ID", "DATE", "STATUS", "TOTAL PRICE");
        System.out.println("==========================================");
        for (int i = 0; i < booking_array.size(); i++) {
            System.out.println(booking_array.get(i));
        }
    }
    
    public static void deleteBooking(ArrayList<Booking> booking_array, ArrayList<Room> room_array){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        boolean isValidBookingID = false;
        do {
            System.out.print("Please Enter Booking ID : ");
            String booking_id = scan.nextLine();
            for (int i = 0; i < booking_array.size(); i++) {
                if(booking_array.get(i).getBookingID().equals(booking_id)){
                    isValidBookingID = true;
                    char confirmDelete = 'Y';
                    do {
                        System.out.print("Confirm To Delete? (Y/N)");
                        confirmDelete = Character.toUpperCase(scan.next().charAt(0));
                        scan.nextLine();
                        if(confirmDelete == 'Y'){
                            for (int j = 0; j < booking_array.get(i).getbDetails().size(); j++) {
                                int roomNo = booking_array.get(i).getbDetails().get(j).getRoom().getRoomNo();
                                for (int k = 0; k < room_array.size(); k++) {
                                    if(room_array.get(k).getRoomNo() == roomNo){
                                        room_array.get(k).setStatus('V');
                                    }
                                }
                            }
                            booking_array.remove(i);
                        }
                        if(confirmDelete != 'N' && confirmDelete != 'Y')
                            System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                            
                    } while (confirmDelete != 'N' && confirmDelete != 'Y');
            
                    
                    break;
                }
            }
            if(!isValidBookingID){
                System.out.println("<ERROR> Booking ID Not Found, Please Enter Again.");
            }
        } while (!isValidBookingID);
        
    }
    
    public static void createNewBooking(ArrayList<Booking> booking_array, ArrayList<Customer> cust_array, ArrayList<Room> room_array, ArrayList<RoomType> room_type, ArrayList<Payment> payment_array){
        
        ArrayList<Booking_Details> bd_array = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("Booking ID                   : B" + Booking.getCurrentBookingID());
        boolean isIdValid = false;
        String custID;
        do {
            System.out.print("Please Enter Customer ID     : ");
            custID = scan.nextLine();
            for (int i = 0; i < cust_array.size(); i++) {
                if(cust_array.get(i).getCustID().equalsIgnoreCase(custID)){
                    isIdValid = true;
                    break;
                }
            }
            if(!isIdValid)
                System.out.println("<ERROR> Customer ID Not Found, Please Enter Again.");
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
        
        Booking b = new Booking(bd_array);
        
        
        
        booking_array.add(b);
        
        payment(payment_array, custID, cust_array, b);
    }
    
    
    //=====================================Room===========================================//
    
    public static int display_room_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("        Room         ");
        System.out.println("=====================");
        System.out.println("1. Display All       ");
        System.out.println("2. Add Room          ");
        System.out.println("3. Remove Room       ");
        System.out.println("4. Update Room Status");
        System.out.println("5. Back To Main Menu ");
        System.out.println("");
        int choice = validateChoice(5);
        return choice;
    }
    
    public static void updateRoomStatus(ArrayList<Room> room_array, ArrayList<RoomType> room_type){
        Scanner scan = new Scanner(System.in);
        
        int roomNo = 0;
        boolean valid = true;
        boolean isValidRoomNo = false;
        do {
            do {
                try{
                    valid = true;
                    System.out.print("Please Enter Room Number : ");
                    roomNo = scan.nextInt();
                }catch(Exception e){
                    System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                    valid = false;
                    scan.nextLine();
                }
            } while (!valid);
            for (int i = 0; i < room_array.size(); i++) {
                if(room_array.get(i).getRoomNo() == roomNo){
                    isValidRoomNo = true;
                    char status = 'O';
                    do {
                        System.out.print("Please Enter Status (V = Vaccant/O = Occupied/M = Maintenance) : ");
                        status = Character.toUpperCase(scan.next().charAt(0));
                        scan.nextLine();
                        if(status != 'V' && status != 'O' && status != 'O')
                            System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                    } while (status != 'V' && status != 'O' && status != 'O');
                    for (int j = 0; j < room_type.size(); j++) {
                        for (int k = 0; k < room_type.get(j).getRoom().size(); k++) {
                            if(room_type.get(j).getRoom().get(k).getRoomNo() == roomNo)
                                room_type.get(j).getRoom().get(k).setStatus(status);
                        }
                    }
                    for (int j = 0; j < room_array.size(); j++) {
                        if (room_array.get(j).getRoomNo() == roomNo) {
                            room_array.get(j).setStatus(status);
                        }
                    }
                    System.out.println("Room Status Updated Successfully.");
                    break;
                }
            }
            if(!isValidRoomNo)
                System.out.println("<ERROR> Invalid Room Number, Please Enter Again.");
        } while (!isValidRoomNo);
        
    }
    
    public static void displayAllRoom(ArrayList<Room> room_array){
        System.out.println("");
        System.out.println("=======================");
        System.out.println("         ROOM          ");
        System.out.println("=======================");
        System.out.printf("%-10s %-5s %-6s\n", "ROOM NO", "FLOOR", "STATUS");
        System.out.println("=======================");
        for (int i = 0; i < room_array.size(); i++) {
            System.out.println(room_array.get(i));
        }
    }
    
    public static void addRoom(ArrayList<Room> room_array, ArrayList<RoomType> room_type){
        Scanner scan = new Scanner(System.in);
        
        int floor = 0;
        boolean valid = true;
        boolean isValidFloor = true;
        do {
            isValidFloor = true;
            do {
                try{
                    valid = true;
                    System.out.print("Please Enter Floor     : ");
                    floor = scan.nextInt();
                }catch(Exception e){
                    System.out.println("<ERROR> Invalid Input, Please Enter Again");
                    valid = false;
                    scan.nextLine();
                }
            } while (!valid);
            if(floor < 1 && floor > 25){
                System.out.println("<ERROR> Invalid Floor, Please Enter Again");
                isValidFloor = false;
            }
        } while (!isValidFloor);
        
        Room room = new Room(floor);
        for (int i = 0; i < room_type.size(); i++) {
            System.out.println(room_type.get(i));
        }
        // Enter Room Name
        String roomType;
        scan.nextLine();
        boolean isValidRoomType = false;
        do{
            System.out.print("Please Enter Room Type : ");
            roomType = scan.nextLine();
            for (int i = 0; i < room_type.size(); i++) {
                 if(room_type.get(i).getRoomType().equalsIgnoreCase(roomType))
                 {
                    isValidRoomType = true;
                    room_type.get(i).getRoom().add(room);
                    room_array.add(room);
                    System.out.println("Room Successfully Added.");
                    break; 
                 }
            }
            if(!isValidRoomType)
                System.out.println("<ERROR> Invalid Room Type, Please Enter Again.");
        }while(!isValidRoomType);
    }
  
    public static void removeRoom(ArrayList<Room> room_array, ArrayList<RoomType> room_type){
        Scanner scan = new Scanner(System.in);
        
        int roomNo = 0;
        boolean valid = true;
        boolean isValidRoomNo = false;
        do {
            do {
                try{
                    valid = true;
                    System.out.print("Please Enter Room Number : ");
                    roomNo = scan.nextInt();
                }catch(Exception e){
                    System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                    valid = false;
                    scan.nextLine();
                }
            } while (!valid);
            for (int i = 0; i < room_array.size(); i++) {
                if(room_array.get(i).getRoomNo() == roomNo){
                    isValidRoomNo = true;
                    char confirmRemove = 'Y';
                    do {
                        System.out.print("Confirm To Remove? (Y/N) : ");
                        confirmRemove = Character.toUpperCase(scan.next().charAt(0));
                        scan.nextLine();
                        if(confirmRemove != 'N' && confirmRemove != 'Y')
                            System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                    } while (confirmRemove != 'N' && confirmRemove != 'Y');
                    
                    if(confirmRemove == 'Y'){
                        room_array.remove(i);
                        for (int j = 0; j < room_type.size(); j++) {
                            for (int k = 0; k < room_type.get(j).getRoom().size(); k++) {
                                if(room_type.get(j).getRoom().get(k).getRoomNo() == roomNo)
                                    room_type.get(j).getRoom().remove(k);
                            }
                        }
                        System.out.println("Room Successfully Removed.");
                    }
                    break;
                }
            }
            if(!isValidRoomNo)
                System.out.println("<ERROR> Invalid Room Number, Please Enter Again.");
        } while (!isValidRoomNo);
        
        
    }
    
   
    

    //======================================Room Type========================================//
    
    public static int display_room_type_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("      Room Type     ");
        System.out.println("====================");
        System.out.println("1. Display All      ");
        System.out.println("2. Add New Room Type");
        System.out.println("3. Modify Room Type ");
        System.out.println("4. Back To Main Menu");
        System.out.println("");
        int choice = validateChoice(4);
        return choice;
    }
    
    public static void modifyRoomType(ArrayList<RoomType> room_type){
        Scanner scan = new Scanner(System.in);
        boolean isValidRoomType, valid, isValidCapacity, isValidPrice;
        String roomType;
        do {
            isValidRoomType = false;
            System.out.print("Please Enter Room Type : ");
            roomType = scan.nextLine();
            for (int i = 0; i < room_type.size(); i++) {
                if(room_type.get(i).getRoomType().equalsIgnoreCase(roomType)){
                    isValidRoomType = true;
                    System.out.println(room_type.get(i));
                    int capacity = 0;
                    do {
                        isValidCapacity = false;
                        do {
                            try{
                                valid = true;
                                System.out.print("Please Enter Capacity  : ");
                                capacity = scan.nextInt();
                            }catch(Exception e){
                                System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                                valid = false;
                                scan.nextLine();
                            }
                        } while (!valid);
                        if (capacity > 0 && capacity <= 7) {
                            isValidCapacity = true;
                        }else
                            System.out.println("<ERROR> Invalid Input, Capacity Out Of Range.");
                    } while (!isValidCapacity);
                    room_type.get(i).setCapacity(capacity);
                    double price = 0;
                    do {
                        isValidPrice = false;
                        do {
                            try{
                                valid = true;
                                System.out.print("Please Enter Price     : ");
                                price = scan.nextInt();
                            }catch(Exception e){
                                System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                                valid = false;
                                scan.nextLine();
                            }
                        } while (!valid);
                        if (price > 0 && price <= 1000) {
                            isValidPrice = true;
                        }else
                            System.out.println("<ERROR> Invalid Input, Price Out Of Range.");
                    } while (!isValidPrice);
                    room_type.get(i).setPrice(price);
                }
            }
            if (!isValidRoomType) {
                System.out.println("<ERROR> Invalid Input, Please Enter Again.");
            }
        } while (!isValidRoomType);
        
    }
    
    public static void displayAllRoomType(ArrayList<RoomType>room_type){
        System.out.println("");
        System.out.println("========================================");
        System.out.println("               ROOM TYPE                ");
        System.out.println("========================================");
        System.out.printf("%-25s %-8s %-5s\n", "ROOM TYPE", "CAPACITY", "PRICE");
        System.out.println("========================================");
        for (int i = 0; i < room_type.size(); i++) {
            System.out.println(room_type.get(i));
        }
    }
    
    public static void addNewRoomType(ArrayList<RoomType>room_type){
        Scanner scan = new Scanner(System.in);
        boolean isValidRoomType, valid, isValidCapacity, isValidPrice;
        String roomType;
        do {
            isValidRoomType = true;
            System.out.print("Please Enter Room Type : ");
            roomType = scan.nextLine();
            for (int i = 0; i < room_type.size(); i++) {
                if(room_type.get(i).getRoomType().equalsIgnoreCase(roomType)){
                    isValidRoomType = false;
                    System.out.println("<ERROR> Invalid Input, Room Name Already Exists.");

                }
            }
        } while (!isValidRoomType);
        
        int capacity = 0;
        do {
            isValidCapacity = false;
            do {
                try{
                    valid = true;
                    System.out.print("Please Enter Capacity  : ");
                    capacity = scan.nextInt();
                }catch(Exception e){
                    System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                    valid = false;
                    scan.nextLine();
                }
            } while (!valid);
            if (capacity > 0 && capacity <= 7) {
                isValidCapacity = true;
            }else
                System.out.println("<ERROR> Invalid Input, Capacity Out Of Range.");
        } while (!isValidCapacity);
        
        double price = 0;
        do {
            isValidPrice = false;
            do {
                try{
                    valid = true;
                    System.out.print("Please Enter Price     : ");
                    price = scan.nextInt();
                }catch(Exception e){
                    System.out.println("<ERROR> Invalid Input, Please Enter Again.");
                    valid = false;
                    scan.nextLine();
                }
            } while (!valid);
            if (price > 0 && price <= 1000) {
                isValidPrice = true;
            }else
                System.out.println("<ERROR> Invalid Input, Price Out Of Range.");
        } while (!isValidPrice);
        room_type.add(new RoomType(roomType, capacity, price));
    }

    
    
    //======================================Member===========================================//
    public static int display_member_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("       Member        ");
        System.out.println("=====================");
        System.out.println("1. Display All       ");
        System.out.println("2. Add Member        ");
        System.out.println("3. Delete Member     ");
        System.out.println("4. Set Discount Rate ");
        System.out.println("5. Back To Main Menu ");
        System.out.println("");
        int choice = validateChoice(5);
        return choice;
    }
        
    public static void displayMember(ArrayList<Member> array_member) {
        System.out.println("");
        System.out.println("======================");
        System.out.println("        MEMBER        ");
        System.out.println("======================");
        System.out.printf("%-10s %-10s\n", "ID", "DATE JOINED");
        System.out.println("======================");
        for (int i = 0; i < array_member.size(); i++) {
            System.out.println(array_member.get(i).toString());
        }
    }
    
    public static void searchMember(ArrayList<Member> array_member) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        int choice;
        boolean validation = true;
        do {
            validation = false;
            do {
                System.out.print("Enter Member ID that you want to search: ");
                String ID = scn.nextLine();

                for (int i = 0; i < array_member.size(); i++) {
                    if (array_member.get(i).getMemberID().equals(ID)) {
                        validation = true;
                        System.out.println(array_member.get(i).toString());
                    }
                }
                if (!validation) {
                    System.out.println("Sorry. We couldn't find this member. ");
                    System.out.println("Please Enter Again!");
                }
            }while(!validation);
            System.out.print("Any Other Records to Search?(Y/N): ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }
    
    public static void modifyDiscountRate(ArrayList<Member> array_member) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        
        System.out.print("Enter New Discount Rate: ");
        double discountRate = scn.nextDouble();
        System.out.println("Are you sure to modify the Discount Rate? (Y/N): ");
        yesNo = scn.next().charAt(0); 
        if(Character.toUpperCase(yesNo) == 'Y')
        {
            Member.setDiscountRate(discountRate);
        }
    }
    
    public static void deleteMember(ArrayList<Member> array_member, ArrayList<Customer> array_customer) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        boolean isValidCustID = true, isValidMemberID = true;
        do {
            do{
                isValidCustID = false;
                System.out.print("Enter Customer ID: ");
                String custID = scn.nextLine();

                for (int i = 0; i < array_customer.size(); i++) {
                    if (array_customer.get(i).getCustID().equals(custID) && array_customer.get(i).isIsMember())
                    {
                        isValidCustID = true;
                        isValidMemberID = false;
                        do{
                            System.out.print("Enter Member ID That You Want To Delete: ");
                            String memberID = scn.nextLine();

                            for (int j = 0; j < array_member.size(); j++) {
                                if (array_member.get(j).getMemberID().equals(memberID)) 
                                {
                                    isValidMemberID = true;

                                    System.out.println(array_member.get(j));
                                    System.out.print("Confirm To Delete? (Y/N): ");
                                    char sure = scn.next().charAt(0);
                                    if(Character.toUpperCase(sure) == 'Y')
                                    {
                                        array_member.remove(j);
                                        array_customer.get(i).setIsMember(false);
                                        System.out.println("This Member Has Been Successfully Deleted From The System.");
                                    }
                                }
                            }
                            if (isValidMemberID == false) {
                                System.out.println("<ERROR> Member ID Not Found, Please Enter Again.");
                            }
                        }while(!isValidMemberID);   
                    }
                }
                if (!isValidCustID) {
                    System.out.println("<ERROR> This Customer Is Not A Member, Please Enter Again.");
                }
            }while(!isValidCustID);
            
            System.out.print("Proceed To Add Another Member? (Y/N): ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }
    
    public static void addMember(ArrayList<Member> array_member, ArrayList<Customer> array_customer) {
        Scanner scan = new Scanner(System.in);
        char yesNo;
        boolean valid;
        do {
            valid = false;
            do{
                System.out.print("Enter Customer ID: ");
                String ID = scan.nextLine();

                for (int i = 0; i < array_customer.size(); i++) {
                    if (array_customer.get(i).getCustID().equals(ID)) {
                        valid = true;
                        if (array_customer.get(i).isIsMember()) {
                            System.out.println("This Customer Is Already A Member.");
                        }else{
                            array_customer.get(i).setIsMember(true);
                            array_member.add(new Member());
                            System.out.println("This Customer Has Been Successfully Granted As A Member.");
                        }
                    }
                }
                if (!valid) {
                    System.out.println("<ERROR> Customer ID Not Found, Please Enter Again.");
                }
            }while(!valid);
            
            System.out.print("Proceed To Add Another Member? (Y/N): ");
            yesNo = scan.next().charAt(0);
            scan.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }
    
    
    
    //======================================Customer===========================================//
    public static int display_customer_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("      Customer      ");
        System.out.println("====================");
        System.out.println("1. Display All      ");
        System.out.println("2. Add Customer     ");
        System.out.println("3. Delete Customer  ");
        System.out.println("4. Modify Customer  ");
        System.out.println("5. Back To Main Menu");
        System.out.println("");
        int choice = validateChoice(5);
        return choice;
    }
    
    public static int searchCustomerMenu() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Search Customer Menu");
        System.out.println("1. Customer ID");
        System.out.println("2. Customer Name");
        System.out.println("3. TEL NO.");
        System.out.println("4. Gender");
        System.out.println("5. Back to Customer Menu");
        System.out.print("Enter your Choice: ");
        int choice = scn.nextInt();
        return choice;
    }
    
    public static void findByID(ArrayList<Customer> array_customer) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        int choice;
        boolean validation = true;
        do {
            validation = false;
            do{
                System.out.print("Enter customer ID that you want to search: ");
                String ID = scn.nextLine();
                for (int i = 0; i < array_customer.size(); i++) {
                    if (array_customer.get(i).getCustID().equals(ID)) {
                        validation = true;
                        System.out.println(array_customer.get(i).toString());
                    }
                }
                if (validation == false) {
                    System.out.println("Sorry. We couldn't find this customer.");
                    System.out.println("Please Enter Again!");
                }
            }while(!validation);
            
            System.out.print("Any other records that you want to search using CustomerID? (Y/N): ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }
    
    public static void findByName(ArrayList<Customer> array_customer) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        int choice;
        boolean validation = true;
        do {
            validation = false;
            
            do{
                System.out.print("Enter customer Name: ");
                String name = scn.nextLine();
                for (int i = 0; i < array_customer.size(); i++) {
                    if (array_customer.get(i).getName().equals(name)) {
                        validation = true;
                        System.out.println(array_customer.get(i).toString());
                    }
                }
                if (validation == false) {
                    System.out.println("Sorry. We couldn't find this customer.");
                }
            }while(!validation);
            
            System.out.print("Any other records that you want to search using Customer Name? (Y/N): ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }
    
    public static void findByTelNo(ArrayList<Customer> array_customer) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        int choice;
        boolean validation = true;
        do {
            validation = false;
            do{
                System.out.print("Enter TelNo: ");
                String telNo = scn.nextLine();
                for (int i = 0; i < array_customer.size(); i++) {
                    if (array_customer.get(i).getTelNo().equals(telNo)) {
                        validation = true;
                        System.out.println(array_customer.get(i).toString());
                    }
                }
                if (validation == false) {
                    System.out.println("Sorry. We couldn't find this customer.");
                    System.out.println("Please Enter Again!");
                }
            
            }while(!validation);
            System.out.print("Any other records that you want to search using TelNo.? (Y/N): ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }
    
    public static void findByGender(ArrayList<Customer> array_customer) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        int choice;
        boolean validation = true;
        do {
            validation = false;
            do{
                System.out.print("Enter Gender: ");
                char gender = scn.next().charAt(0);
                for (int i = 0; i < array_customer.size(); i++) {
                    if (array_customer.get(i).getGender() == gender) {
                        validation = true;
                        System.out.println(array_customer.get(i).toString());
                    }
                }
                if (validation == false) {
                    System.out.println("Sorry. We couldn't find this customer.");
                    System.out.println("Please Enter Again!");
                }
            }while(!validation);
            System.out.print("Any other records that you want to search using Gender? (Y/N): ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }
    
    public static void searchCustomer(ArrayList<Customer> array_customer) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        int choice;
        boolean validation = true;
        do {
            
            do {
                choice = searchCustomerMenu();
                switch (choice) {
                    case 1:
                        findByID(array_customer);
                        break;
                    case 2:
                        findByName(array_customer);
                        break;
                    case 3:
                        findByTelNo(array_customer);
                        break;
                    case 4:
                        findByGender(array_customer);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                    
                }
            } while (choice != 5);
            System.out.print("Do u want to search other customer: ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }
    
    public static void displayCustomer(ArrayList<Customer> array_customer) {
        System.out.println("");
        System.out.println("========================================================");
        System.out.println("                      Customer                          ");
        System.out.println("========================================================");
        System.out.printf("%-10s %-20s %5s %-12s\n", "ID", "NAME", "GENDER", "TEL NUMBER");
        System.out.println("========================================================");
        for (int i = 0; i < array_customer.size(); i++) {
            System.out.println(array_customer.get(i).toString());
        }
    }
    
    public static void addCustomer(ArrayList<Customer> array_customer) {
        Scanner scn = new Scanner(System.in);
        boolean validation = true;
        char yesNo;
        boolean isValidName = true;
        boolean isValidPhoneNo = true;
        String name;
        String phoneNo;
        char gender;
        do {
            
           do{
            System.out.print("Enter name: ");
            name = scn.nextLine(); 
            isValidName = validateName(name);
                if(!isValidName)
                {
                    System.out.println("Invalid Input. Please Enter Again.");
                }
            
            }while(!isValidName);

            do{
                System.out.print("Enter TelNo: ");
                phoneNo = scn.nextLine();
                
                isValidPhoneNo = isDigit(phoneNo);
                if((!isValidPhoneNo) || (phoneNo.length() != 10))
                {
                    System.out.println("Invalid TelNo. Please Enter Again. ");  
                }
            }while((!isValidPhoneNo) || (phoneNo.length() != 10));
            

// Validate whether M or F

            do{
                System.out.print("Enter Gender: ");
                gender = Character.toUpperCase(scn.next().charAt(0));
                
                scn.nextLine();
                if((gender != 'M') && (gender != 'F'))
                {
                    System.out.println("Invalid Input. Please Enter Again.");
                }
            }while((gender != 'M') && (gender != 'F'));

            // Store into customer array     
            array_customer.add(new Customer(name, phoneNo, gender));
            System.out.println("This Customer has been successfully added into the system.");
            System.out.print("Do you want to add more Customer? (Y/N): ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');

    }
    
    public static void deleteCustomer(ArrayList<Customer> array_customer) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        boolean validation = true;
        do {
            validation = false;
            do{
                System.out.print("Enter customer ID that you want to delete: ");
                String ID = scn.nextLine();
                for (int i = 0; i < array_customer.size(); i++) {
                    if (array_customer.get(i).getCustID().equals(ID)) {
                        validation = true;
                        
                        System.out.println(array_customer.get(i));
                        System.out.print("Sure to Delete? (Y/N): ");
                        char sure = scn.next().charAt(0);
                        if(Character.toUpperCase(sure) == 'Y')
                        {
                            array_customer.remove(i);
                            System.out.println("This Customer has been successfully deleted from the system.");
                        }
                    }
                }
                if (validation == false) {
                    System.out.println("Sorry. We couldn't find this customer.");
                    System.out.println("Please Enter Again!");
                }
            }while(!validation);
            System.out.print("Do you want to delete other customer? (Y/N): ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }
    
    public static void modifyCustomer(ArrayList<Customer> array_customer) {
        Scanner scn = new Scanner(System.in);
        char yesNo;
        boolean validation = true;
        boolean isValidName = true;
        boolean isValidPhoneNo = true;
        String name;
        String phoneNo;
        char gender;
        do {
            System.out.println("Customer Details");
            System.out.println("1. Name");
            System.out.println("2. Tel No");
            System.out.println("3. Gender");
            System.out.print("Enter your choice: ");
            int choice = scn.nextInt();
            scn.nextLine();
            validation = false;
            do {
                System.out.print("Enter customer ID that you want to modify: ");
                String ID = scn.nextLine();
                for (int i = 0; i < array_customer.size(); i++) {
                    if (array_customer.get(i).getCustID().equals(ID)) {
                        validation = true;
                        System.out.println(array_customer.get(i));
                        System.out.print("Sure to Modify?(Y/N): ");
                        char confirmModify = scn.next().charAt(0);
                        scn.nextLine();
                        if(Character.toUpperCase(confirmModify) == 'Y')
                        {
                            if (choice == 1) {
                                    do{
                                    System.out.print("Enter new name: ");
                                    name = scn.nextLine(); 
                                    isValidName = validateName(name);
                                      if(!isValidName)
                                      {
                                          System.out.println("Invalid Input. Please Enter Again.");
                                      }
                                    }while(!isValidName);
                                    array_customer.get(i).setName(name);
                                    
                                } else if (choice == 2) {
                                    do{
                                        System.out.print("Enter TelNo: ");
                                        phoneNo = scn.nextLine();

                                        isValidPhoneNo = isDigit(phoneNo);
                                        if((!isValidPhoneNo) || (phoneNo.length() != 10))
                                        {
                                            System.out.println("Invalid TelNo. Please Enter Again. ");  
                                        }
                                    }while((!isValidPhoneNo) || (phoneNo.length() != 10));
                                    array_customer.get(i).setTelNo(phoneNo);
                                    
                                } else if (choice == 3) {
                                        do{
                                            System.out.print("Enter Gender: ");
                                            gender = Character.toUpperCase(scn.next().charAt(0));

                                            scn.nextLine();
                                            if((gender != 'M') && (gender != 'F'))
                                            {
                                                System.out.println("Invalid Input. Please Enter Again.");
                                            }
                                        }while((gender != 'M') && (gender != 'F'));
                                        array_customer.get(i).setGender(gender);
                                }
                                
                                System.out.println("Customer details have been successfully modified.");
                            }
                        }
                    }
                if (!validation) {
                    System.out.println("Sorry. We couldn't find this customer.");
                }
            }while(!validation);
            System.out.print("Do you want to modify other customer? (Y/N): ");
            yesNo = scn.next().charAt(0);
            scn.nextLine();
        } while (Character.toUpperCase(yesNo) == 'Y');
    }

    public static boolean validateName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!Character.isLetter(ch) && !Character.isSpaceChar(ch)) {
                return false;
            }
        }

        return true;
    }
    
    public static boolean isDigit(String phoneNo) {
        char[] chars = phoneNo.toCharArray();

        for (char c : chars) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    
    //=====================================Payment=============================================//
    
    public static int display_payment_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("         Payment        ");
        System.out.println("========================");
        System.out.println("1. Display All          ");
        System.out.println("2. Update Payment Status");
        System.out.println("3. Back To Main Menu");
        System.out.println("");
        int choice = validateChoice(3);
        return choice;
    }
    
    public static int subpayment_menu() {
        Scanner scn = new Scanner(System.in);
        System.out.println("          Payment Menu          ");
        System.out.println("================================");
        System.out.println("1. Cash");
        System.out.println("2. Debit / CreditCard");
        System.out.println("3. Exit");
        System.out.println("");
        int choice = validateChoice(3);
        return choice;
    }
    
    public static void payment(ArrayList<Payment> payment, String custID, ArrayList<Customer> cust_array, Booking b) {
        System.out.println("");
        Scanner scn = new Scanner(System.in);
        double totalPrice = b.getTotalPrice();
        boolean isValidPayment = true;
        for (int i = 0; i < cust_array.size(); i++) {
            if (cust_array.get(i).getCustID().equals(custID)) {
                if (cust_array.get(i).isIsMember()) {
                    totalPrice = (1 - Member.getDiscountRate()) * totalPrice;
                }
            }
        }
        int select;
        do {
            select = subpayment_menu();
            switch (select) {
                case 1:
                    payment.add(new Cash(totalPrice)); 
                    payment.get(payment.size()-1).calcGrandTotal();
                    break;
                case 2:
                    System.out.print("Enter Card Type (Debit/Credit):");
                    String cardType = scn.nextLine();
                    System.out.print("Enter username: ");
                    String username = scn.nextLine();
                    System.out.print("Enter Card Number: ");
                    String cardNum = scn.nextLine();
                    System.out.print("Enter expiry Date: ");
                    String date = scn.nextLine();
                    System.out.print("Enter CVV: ");
                    String cvv = scn.nextLine();
                    payment.add(new Card(cardType, username, cardNum, date, cvv, totalPrice)); // totalPrice = 750
                    payment.get(payment.size()-1).calcGrandTotal();
                    break;
                case 3:
                    break;
                default:
                    System.out.println(" <Error> Invalid Choice. Please Enter Again");
                    break;
            }
            if (select == 1 || select == 2) {
                System.out.println("");
                if(payment.get(payment.size()-1) instanceof Cash)
                    System.out.println("=========Cash===========");
                else
                    System.out.println("=========Card===========");
                System.out.println(payment.get(payment.size()-1));
                System.out.print("Are you sure to make this payment? (Y/N): ");
                char confirm = Character.toUpperCase(scn.next().charAt(0));
                if (confirm == 'Y') {
                    payment.get(payment.size() - 1).setStatus("Completed");
                    System.out.println("Payment Completed. Thanks for your purhcase");
                    break;
                } else if (confirm == 'N') {
                    System.out.println("Your Payment Still Pending");
                }
            }
        } while (select != 3);
        System.out.println("");
    }
    
    public static void updatePaymentStatus(ArrayList<Payment> payment) {
        System.out.println("");
        Scanner scn = new Scanner(System.in);
        char yesNo;
        boolean validation = true;
        do {
            validation = false;
            System.out.print("Enter PaymentID that You want to modify: ");
            String ID = scn.nextLine();
            for (int i = 0; i < payment.size(); i++) {
                if (payment.get(i).getPaymentID().equals(ID)) {
                    System.out.println(payment.get(i));
                    System.out.print("Enter new Payment Status: ");
                    String status = scn.nextLine();
                    validation = true;
                    System.out.print("Sure to Modify? (Y/N): ");
                    char confirm = Character.toUpperCase(scn.next().charAt(0));
                    scn.nextLine();
                    if (confirm == 'Y') {
                        payment.get(i).setStatus(status);
                        System.out.println(payment.get(i));
                    }
                    else if(confirm == 'N')
                    {
                        System.out.println("Payment still Pending");
                    }
                }
            }
            if (!validation) {
                System.out.println("Sorry. We couldn't find this Payment Details");
            }
            System.out.print("Any other Record to Update Payment Status: ");
            yesNo = Character.toUpperCase(scn.next().charAt(0));
            scn.nextLine();
        } while (!validation);
    }

    public static void displayAllPayment(ArrayList<Payment> payment) {
        System.out.println("");
        for (int i = 0; i < payment.size(); i++) {
            if (payment.get(i) instanceof Cash) {
                System.out.println("CASH\n====\n" + payment.get(i));
            } else {
                System.out.println("CARD\n====\n " + payment.get(i));
            }
        }
    }
}

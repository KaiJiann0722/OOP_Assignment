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
public class Member {
    private static int currentMemberID = 10001;
    private String memberID;
    private LocalDate dateJoined;
    private int memberPoint;
    private static double discountRate;
    
    public Member(){
        this.memberID = "M" + Member.currentMemberID;
        this.dateJoined = LocalDate.now();
        this.memberPoint = 0;
        currentMemberID++;
    }

    @Override
    public String toString() {
        return "Member{" + "memberID=" + memberID + ", dateJoined=" + dateJoined + ", memberPoint=" + memberPoint + '}';
    }
    
    
}
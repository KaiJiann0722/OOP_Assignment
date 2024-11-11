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
public class Card extends Payment {
    private String cardType;
    private String username;
    private String cardNo;
    private LocalDate expiredDate;
    private String cvv;
    
    public Card(){
        this("", "", "", "", "", 0.0);
    }
    
    public Card(String cardType, String username, String cardNo, String expiredDate, String cvv, double amount) {
        super(amount);
        this.cardType = cardType;
        this.username = username;
        this.cardNo = cardNo;
        this.expiredDate = LocalDate.parse(expiredDate);
        this.cvv = cvv;
    }
    
    @Override
    public String toString() {
        return "Card{" + "cardType=" + cardType + ", username=" + username + ", cardNo=" + cardNo + ", expiredDate=" + expiredDate + ", cvv=" + cvv + '}';
    }
    
}
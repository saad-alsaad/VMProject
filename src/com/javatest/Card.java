package com.javatest;

import java.util.Date;

public class Card implements PaymentMethod{
    private final String type;
    private final String holderName;
    private final int number;
    private final Date expirationDate;
    private final int pin;
    private double availableBalance;

    public Card(String type, String holderName, int number, Date expirationDate, int pin, double availableBalance){
        this.type = type;
        this.holderName = holderName;
        this.number = number;
        this.expirationDate = expirationDate;
        this.availableBalance = availableBalance;
        this.pin = pin;
    }

    public boolean withdrawMoney(double amount, int pin){
        if(pin == this.pin){
            if(amount <= this.availableBalance) {
                this.availableBalance -= amount;
                System.out.println("Withdraw completed");
                return true;
            }
            else
                System.out.println("Insufficient amount of money in the card to finish the operation");
        }
        else
            System.out.println("Wrong PIN!");

        return false;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public int getNumber() {
        return number;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getType() {
        return type;
    }
}

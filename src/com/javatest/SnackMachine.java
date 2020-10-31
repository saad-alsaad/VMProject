package com.javatest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class SnackMachine extends VendingMachine{
    ArrayList<Coin> acceptableCoins;
    ArrayList<Note> acceptableNotes;

    public SnackMachine(ArrayList<Coin> acceptableCoins, ArrayList<Note> acceptableNotes) {
        super("Snacks Machine 1", 5, 5);
        this.acceptableCoins = acceptableCoins;
        this.acceptableNotes = acceptableNotes;
    }

    @Override
    public MachineOutput dispenseItem(int itemNumber, PaymentMethod paymentMethod) {
        Item item;
        int column = 0;
        int row = 0;
        double change = 0;

        if(itemNumber < this.numberOfRows * this.numberOfColumns) {
            if (itemNumber < this.numberOfColumns)
                column = itemNumber;
            else {
                row = itemNumber / this.numberOfColumns;
                column = itemNumber - ((itemNumber / this.numberOfColumns) * this.numberOfColumns);
            }
        }
        item = this.availableItems[row][column];
        change = this.availableBalance;
        if(item == null){
            System.out.println("Item is unavailable");
            return new MachineOutput(null, change);
        }


        if(paymentMethod instanceof Coin){
            if(validateCoin((Coin) paymentMethod)){
                this.availableBalance += ((Coin) paymentMethod).getValue() / 100.0;
            }
            else {
                System.out.println("Invalid Coin");
                return new MachineOutput(null, this.availableBalance);
            }
        }
        else if(paymentMethod instanceof Note){
            if(validateNote((Note) paymentMethod)){
                this.availableBalance += ((Note) paymentMethod).getValue() * 1.0;
            }
            else {
                System.out.println("Invalid Money");
                return new MachineOutput(null, this.availableBalance);
            }
        }
        else if(paymentMethod instanceof Card){
            if(validateCard((Card) paymentMethod)){
                if(((Card) paymentMethod).withdrawMoney(item.getPrice(), 123))
                    change = this.availableBalance;
            }
            else {
                System.out.println("Invalid Money");
                return new MachineOutput(null, this.availableBalance);
            }
        }

        if (this.availableBalance >= this.availableItems[row][column].getPrice()){
            this.availableItems[row][column] = null;
            this.availableBalance -= item.getPrice();
            change = this.availableBalance;
            return new MachineOutput(item, change);
        }

        return new MachineOutput(null, change);
    }

    private boolean validateCoin(Coin coin){
        for (Coin acceptableCoin : acceptableCoins)
            if (coin.getValue() == acceptableCoin.getValue())
                return true;
        return false;
    }

    private boolean validateNote(Note note){
        for (Note acceptableNote : acceptableNotes)
            if (note.getValue() == acceptableNote.getValue())
                return true;
        return false;
    }

    private boolean validateCard(Card card){
        LocalDate today = LocalDate.now();
        return card.getExpirationDate().compareTo(Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant())) < 0;
    }
}

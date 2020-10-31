package com.javatest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SnackMachineTest {

    @Test
    void dispenseItem() {
        ArrayList<Coin> acceptableCoins = new ArrayList<Coin>();
        ArrayList<Note> acceptableNotes = new ArrayList<Note>();

        acceptableCoins.add(new Coin(10));
        acceptableCoins.add(new Coin(20));
        acceptableCoins.add(new Coin(50));
        acceptableCoins.add(new Coin(100));

        acceptableNotes.add(new Note(20));
        acceptableNotes.add(new Note(50));
        SnackMachine snackMachine = new SnackMachine(acceptableCoins, acceptableNotes);
//        snackMachine.addItem(new Item("Chocolate", 10.2),0,0);
        assertTrue(snackMachine.addItem(new Item("Chocolate", 2.2),0,0));
        assertTrue(snackMachine.addItem(new Item("Chips", 1),0,1));
        PaymentMethod paymentMethod = (PaymentMethod) new Note(20);
        assertEquals("Chocolate", snackMachine.dispenseItem(0, new Note(20)).getItem().getName());

    }
}
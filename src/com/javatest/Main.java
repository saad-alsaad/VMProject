package com.javatest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    public static void main(String[] args) {
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
        snackMachine.addItem(new Item("Chocolate", 2.2),0,0);
        snackMachine.addItem(new Item("Chips", 1),0,1);
        snackMachine.dispenseItem(1, new Note(20)).getItem().getName();

    }
}

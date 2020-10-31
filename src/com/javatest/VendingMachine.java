package com.javatest;

public abstract class VendingMachine {
    protected Item availableItems[][];
    protected int numberOfRows = 0;
    protected int numberOfColumns = 0;
    protected double availableBalance = 0.0;
    protected String name;

    public VendingMachine(String name, int numberOfRows, int numberOfColumns){
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.name = name;
        this.availableItems = new Item[numberOfRows][numberOfColumns];
        for (int count = 0; count < numberOfRows; count++){
            for (int columnCount = 0; columnCount < numberOfColumns; columnCount++){
                this.availableItems[count][columnCount] = null;
            }
        }
    }
    public boolean addItem(Item item, int rowNumber, int columnNumber){
        if(rowNumber > this.numberOfRows || columnNumber > this.numberOfColumns)
            System.out.println("Please enter valid row and column number to add the item");
        else if(this.availableItems[rowNumber][columnNumber] == null){
            this.availableItems[rowNumber][columnNumber] = item;
            return true;
        }
        else
            System.out.println("There is an existing item in this cell");
        return false;
    }

    public abstract MachineOutput dispenseItem(int itemNumber, PaymentMethod paymentMethod);
}

package com.javatest;

public class MachineOutput {
    private final Item item;
    private final double change;

    public MachineOutput(Item item, double change){
        this.item = item;
        this.change = change;
    }

    public Item getItem() {
        return item;
    }

    public double getChange() {
        return change;
    }
}

package com.javatest;

public class Note implements PaymentMethod{
    private final int value;
    public Note(int value) {
        if(value <= 100)
            this.value = value;
        else {
            System.out.println("Note money Cannot be more than 100 usd");
            this.value = 0;
            try {
                this.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

    }

    public int getValue() {
        return value;
    }
}

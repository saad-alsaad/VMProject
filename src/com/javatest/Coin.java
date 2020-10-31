package com.javatest;

public class Coin implements PaymentMethod{
    private final int value;    // this can be float but with condition not greater than 1.0

    public Coin(int value) {
        if(value <= 100)
            this.value = value;
        else {
            System.out.println("Coin Cannot be more than 100 cents");
            this.value = 0;
            try {
                this.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public int getValue() {
        return this.value;
    }
}

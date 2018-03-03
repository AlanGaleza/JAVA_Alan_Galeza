package com.kodilla.testing.calculator;

public class Calculator {

    private int a;
    private int b;

    public int add(int a, int b) {
        this.a = a;
        this.b = b;

        return a + b;
    }

    public int subtract(int a, int b) {
        this.a = a;
        this.b = b;

        return a - b;
    }

    public int getAdds() { return a + b; }
    public int getSubstraction() { return this.a - this.b; }
}

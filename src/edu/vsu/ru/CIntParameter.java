package edu.vsu.ru;

import java.util.Scanner;

public class CIntParameter {
    int value;
    String name;
    boolean parity;

    public CIntParameter(String name, boolean parity) {
        this.name = name;
        this.parity = parity;
        readValue();
    }

    public void readValue() {
        Scanner scanner = new Scanner(System.in);

        if (parity) {
            System.out.println("Enter your parameter (" + name + " >= 2, " + name + " - even number): ");
        } else System.out.println("Enter your parameter (" + name + " >= 2)");
        System.out.print(name + " = ");

        while (!scanner.hasNextInt()) {
            System.out.println("Parameter entered incorrectly. Re-enter.");
            System.out.print(name + " = ");
            scanner.next();
        }

        value = scanner.nextInt();

        if (value < 2) {
            System.out.println("Invalid input. Re-enter the " + name);
            readValue();
        }

        if (parity) {
            if ((value % 2) != 0) {
                System.out.println("Invalid input. " + name + " - not even number Re-enter the " + name);
                readValue();
            }
        }
    }

    public int getValue() {
        return value;
    }

}

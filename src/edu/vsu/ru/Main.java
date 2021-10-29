package edu.vsu.ru;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int w = readValue("w", true);
        int h = readValue("h", false);

        drawPicture(w, h);
    }

    static int readValue(String name, boolean parity) {
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

        int value = scanner.nextInt();

        if (value < 2) {
            System.out.println("Invalid input. Re-enter the " + name);
            value = readValue(name, parity);
        }

        if (parity) {
            if ((value % 2) != 0) {
                System.out.println("Invalid input. " + name + " - not even number Re-enter the " + name);
                value = readValue(name, parity);
            }
        }

        return value;
    }

    public static void drawPicture(int w, int h) {
        drawBeginEnd(w);

        int j = 1;

        while (h != 2) {
            for (int k = 0; k < j; ++k) {
                if ((--h) > 1) {
                    drawTwoSymbols(w,'*', ' ');
                } else {
                    ++h;
                    break;
                }
            }

            for (int k = 0; k < j; ++k) {
                if ((--h) > 1) {
                    drawTwoSymbols(w,' ', '*');
                } else {
                    ++h;
                    break;
                }
            }
            ++j;
        }

        drawBeginEnd(w);
    }

    static void drawBeginEnd(int w) {
        System.out.print("+");

        for (int i = 0; i < (w - 2); ++i) {
            System.out.print("-");
        }

        System.out.println("+");
    }

    static void drawTwoSymbols(int w, char start, char end) {
        System.out.print("|");
        int numberSymbol = (w - 2) / 2;

        for (int i = 0; i < numberSymbol; ++i) {
            System.out.print(start);
        }

        for (int i = 0; i < numberSymbol; ++i) {
            System.out.print(end);
        }

        System.out.println("|");
    }
}

package edu.vsu.ru;

import java.util.Scanner;

public class CPicture_21 {
    static CIntParameter w = new CIntParameter("w", true);
    static CIntParameter h = new CIntParameter("h", false);

    public static void drawPicture() {
        drawBeginEnd();

        int j = 1;
        int h = CPicture_21.h.getValue();

        while (h != 2) {
            for (int k = 0; k < j; ++k) {
                if ((--h) > 1) {
                    drawTwoSymbols('*', ' ');
                } else {
                    ++h;
                    break;
                }
            }

            for (int k = 0; k < j; ++k) {
                if ((--h) > 1) {
                    drawTwoSymbols(' ', '*');
                } else {
                    ++h;
                    break;
                }
            }
            ++j;
        }

        drawBeginEnd();
    }

    static void drawBeginEnd() {
        System.out.print("+");

        for (int i = 0; i < (w.getValue() - 3); ++i) {
            System.out.print("-");
        }

        System.out.println("+");
    }

    static void drawTwoSymbols(char start, char end) {
        System.out.print("|");
        int numberSymbol = (w.getValue() - 2) / 2;

        for (int i = 0; i < numberSymbol; ++i) {
            System.out.print(start);
        }

        for (int i = 0; i < numberSymbol; ++i) {
            System.out.print(end);
        }

        System.out.println("|");
    }


}





/* 21.	w >= 2, h >= 2 (в примере ниже: w = 12, h = 23)

        +----------+
        |*****     |
        |     *****|
        |*****     |
        |*****     |
        |     *****|
        |     *****|
        |*****     |
        |*****     |
        |*****     |
        |     *****|
        |     *****|
        |     *****|
        |*****     |
        |*****     |
        |*****     |
        |*****     |
        |     *****|
        |     *****|
        |     *****|
        |     *****|
        |*****     |
        *----------*
*/

package edu.vsu.ru;

public class CTestMonotony {

    public static void findMonotoneNumber(int num){
        if (num < 101) {
            System.out.println("n-th \"monotone\" integer = " + (num - 1));
        } else {
            int k = 100;
            int number = 100;
            while (k != num) {
                boolean a = checkMonotonicityOfNumber(number);
                if (a) {
                    ++k;
                }
                ++number;
            }
            System.out.println("n-th \"monotone\" integer = "+ number);
        }
    }

    public static boolean checkMonotonicityOfNumber(int number) {
        enum EMonotone {
            Descending,
            Equals,
            Ascending
        }
        EMonotone monotone = EMonotone.Equals.Equals;

        for (int next, previous = number % 10; (number /= 10) != 0; previous = next) {
            next = number % 10;

            switch (monotone) {
                case Equals -> {
                    if (next > previous) {
                        monotone = EMonotone.Ascending;
                    } else if (next < previous) {
                        monotone = EMonotone.Descending;
                    }
                }

                case Ascending -> {
                    if (next < previous) {
                        return false;
                    }
                }

                case Descending -> {
                    if (next > previous) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

import lab1.Laborator1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // --------------------------------------------Laborator 1--------------------------------------------------------

        // Ex1
        // System.out.println(Laborator1.reverse(123));
        // System.out.println(Laborator1.reverse(120));

        // Ex2
        // System.out.println(Laborator1.parse("432452"));

        // Ex4
        int[][] m = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println(Arrays.toString(Laborator1.spiral(m)));
        // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
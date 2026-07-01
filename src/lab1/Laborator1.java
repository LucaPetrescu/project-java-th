package lab1;

public class Laborator1 {

    // Exercise 1
    public static int reverse(int x) {

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
    
        long reverseNumber = 0;

        while(x != 0) {
            reverseNumber = reverseNumber * 10 + (x % 10); 
            x = x / 10;
        }

        if(reverseNumber > max || reverseNumber < min) {
            return 0;
        }

        return (int) reverseNumber;
    }

}

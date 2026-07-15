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

    // Exercise 2
    public static int parse(String s) {

        if(s == null || s.isEmpty()) {
            throw new NumberFormatException("String must not be null or empty");
        }

        int index = 0;
        boolean negative = false;

        char firstChar = s.charAt(0);
        if(firstChar == '-' || firstChar == '+') {
            negative = firstChar == '-';
            index = 1;
        }

        if(index == s.length()) {
            throw new NumberFormatException("No digits found in: " + s);
        }

        long result = 0;

        for(int i = index; i < s.length(); i++) {

            char c = s.charAt(i);
            if(c < '0' || c > '9') {
                throw new NumberFormatException("Invalid character in: " + s);
            }

            result = result * 10 + (c - '0');

            if(result > 2147483648L) {
                throw new NumberFormatException("Value out of range: " + s);
            }
        }

        if(negative) {
            result = -result;
        }

        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            throw new NumberFormatException("Value out of range: " + s);
        }

        return (int) result;
    }

    // Exercise 3
    public static int[] reverse(int[] a, int from, int to) {
        while (from < to) {
            int t = a[from];
            a[from] = a[to];
            a[to] = t;
            from++;
            to--;
        }

        return a;

    }

    public static int[] rotate(int[] a, int k) {
        int n = a.length;
        if (n == 0) return null;
        k = ((k % n) + n) % n;
        if (k == 0) return null;
        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        return reverse(a, k, n - 1);
    }

    // Exercise 4
    public static int[] spiral(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) return new int[0];

        int rows = m.length;
        int cols = m[0].length;
        int[] result = new int[rows * cols];
        int idx = 0;

        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {

            for (int col = left; col <= right; col++) {
                result[idx++] = m[top][col];
            }
            top++;

            for (int row = top; row <= bottom; row++) {
                result[idx++] = m[row][right];
            }
            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result[idx++] = m[bottom][col];
                }
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result[idx++] = m[row][left];
                }
                left++;
            }
        }

        return result;
    }

}

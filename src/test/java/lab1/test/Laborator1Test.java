package lab1.test;

import lab1.Laborator1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laborator1Test {

    // Exercise 1: reverse

    @Test
    void reversePositiveNumber() {
        assertEquals(321, Laborator1.reverse(123));
    }

    @Test
    void reverseNumberWithTrailingZero() {
        assertEquals(21, Laborator1.reverse(120));
    }

    @Test
    void reverseNegativeNumber() {
        assertEquals(-321, Laborator1.reverse(-123));
    }

    @Test
    void reverseOverflowReturnsZero() {
        assertEquals(0, Laborator1.reverse(1534236469));
    }

    // Exercise 2: parse

    @Test
    void parsePositiveNumber() {
        assertEquals(123, Laborator1.parse("123"));
    }

    @Test
    void parseNegativeNumber() {
        assertEquals(-123, Laborator1.parse("-123"));
    }

    @Test
    void parseExplicitPositiveSign() {
        assertEquals(123, Laborator1.parse("+123"));
    }

    @Test
    void parseIntMaxValue() {
        assertEquals(Integer.MAX_VALUE, Laborator1.parse("2147483647"));
    }

    @Test
    void parseIntMinValue() {
        assertEquals(Integer.MIN_VALUE, Laborator1.parse("-2147483648"));
    }

    @Test
    void parseNullThrows() {
        assertThrows(NumberFormatException.class, () -> Laborator1.parse(null));
    }

    @Test
    void parseEmptyThrows() {
        assertThrows(NumberFormatException.class, () -> Laborator1.parse(""));
    }

    @Test
    void parseWhitespaceOnlyThrows() {
        assertThrows(NumberFormatException.class, () -> Laborator1.parse("   "));
    }

    @Test
    void parseNonDigitCharacterThrows() {
        assertThrows(NumberFormatException.class, () -> Laborator1.parse("12a3"));
    }

    @Test
    void parseSignOnlyThrows() {
        assertThrows(NumberFormatException.class, () -> Laborator1.parse("+"));
        assertThrows(NumberFormatException.class, () -> Laborator1.parse("-"));
    }

    @Test
    void parseOverflowThrows() {
        assertThrows(NumberFormatException.class, () -> Laborator1.parse("2147483648"));
    }

    @Test
    void parseUnderflowThrows() {
        assertThrows(NumberFormatException.class, () -> Laborator1.parse("-2147483649"));
    }

    @Test
    void parseHugeNumberThrows() {
        assertThrows(NumberFormatException.class, () -> Laborator1.parse("99999999999999999999"));
    }

    //Exercise 3: reverse(int[], int, int)

    @Test
    void reverseArraySubrange() {
        int[] a = {1, 2, 3, 4, 5};
        assertArrayEquals(new int[]{1, 4, 3, 2, 5}, Laborator1.reverse(a, 1, 3));
    }

    @Test
    void reverseFullArray() {
        int[] a = {1, 2, 3, 4};
        assertArrayEquals(new int[]{4, 3, 2, 1}, Laborator1.reverse(a, 0, a.length - 1));
    }

    @Test
    void reverseSingleElementRangeIsNoOp() {
        int[] a = {1, 2, 3};
        assertArrayEquals(new int[]{1, 2, 3}, Laborator1.reverse(a, 1, 1));
    }

    //Exercise 3: rotate

    @Test
    void rotateBySmallerThanLength() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, Laborator1.rotate(a, 3));
    }

    @Test
    void rotateByOne() {
        int[] a = {1, 2, 3};
        assertArrayEquals(new int[]{3, 1, 2}, Laborator1.rotate(a, 1));
    }

    @Test
    void rotateByMoreThanLengthWrapsAround() {
        int[] a = {1, 2, 3};
        assertArrayEquals(new int[]{2, 3, 1}, Laborator1.rotate(a, 5));
    }

    @Test
    void rotateByNegativeKRotatesLeft() {
        int[] a = {1, 2, 3, 4, 5};
        assertArrayEquals(new int[]{2, 3, 4, 5, 1}, Laborator1.rotate(a, -1));
    }

    @Test
    void rotateByZeroReturnsNull() {
        int[] a = {1, 2, 3};
        assertNull(Laborator1.rotate(a, 0));
        assertArrayEquals(new int[]{1, 2, 3}, a);
    }

    @Test
    void rotateByMultipleOfLengthReturnsNull() {
        int[] a = {1, 2, 3};
        assertNull(Laborator1.rotate(a, 3));
        assertArrayEquals(new int[]{1, 2, 3}, a);
    }

    @Test
    void rotateSingleElementArrayReturnsNull() {
        int[] a = {7};
        assertNull(Laborator1.rotate(a, 3));
        assertArrayEquals(new int[]{7}, a);
    }

    @Test
    void rotateEmptyArrayReturnsNull() {
        int[] a = {};
        assertNull(Laborator1.rotate(a, 2));
    }

    // Exercise 4: spiral

    @Test
    void spiralRectangularMatrix() {
        int[][] m = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        assertArrayEquals(new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}, Laborator1.spiral(m));
    }

    @Test
    void spiralSquareMatrix() {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        assertArrayEquals(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}, Laborator1.spiral(m));
    }

    @Test
    void spiralTallerThanWideMatrix() {
        int[][] m = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        assertArrayEquals(new int[]{1, 2, 4, 6, 5, 3}, Laborator1.spiral(m));
    }

    @Test
    void spiralSingleRow() {
        int[][] m = {{1, 2, 3, 4}};
        assertArrayEquals(new int[]{1, 2, 3, 4}, Laborator1.spiral(m));
    }

    @Test
    void spiralSingleColumn() {
        int[][] m = {{1}, {2}, {3}};
        assertArrayEquals(new int[]{1, 2, 3}, Laborator1.spiral(m));
    }

    @Test
    void spiralSingleElement() {
        int[][] m = {{42}};
        assertArrayEquals(new int[]{42}, Laborator1.spiral(m));
    }

    @Test
    void spiralEmptyMatrixReturnsEmptyArray() {
        int[][] m = {};
        assertArrayEquals(new int[0], Laborator1.spiral(m));
    }

    @Test
    void spiralEmptyRowsReturnsEmptyArray() {
        int[][] m = {{}, {}};
        assertArrayEquals(new int[0], Laborator1.spiral(m));
    }
}

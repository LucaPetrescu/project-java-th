package lab2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.sun.source.tree.Tree;

import lab2.Rational;

public class Laborator2Test {
 
    // Exercise 1

    @Test
    void Test_EqualMoneyObjects() {
        Money firstMoney = new Money(20000, "EUR");
        Money secondMoney = new Money(20000, "EUR");

        assertEquals(firstMoney.equals(secondMoney), true);
    }

    @Test
    void Test_Plus() {
        Money money = new Money(20000, "EUR");
        Money newMoney = money.plus(new Money(10000, "EUR"));

        assertEquals(money.equals(newMoney), false);
    }

    @Test
    void Test_PlusDifferentCurrency() {
        Money money = new Money(10000, "EUR");
        assertThrows(IllegalArgumentException.class, () -> money.plus(new Money (20000, "USD")));
    }

    @Test
    void Test_IncorrectCurrencyAtBuild() {
        assertThrows(IllegalArgumentException.class, () -> new Money(10000, "us"));
    }

    // Exercise 2

    @Test
    void Test_HashCode() {
        assertEquals(new TagDemo.Tag("Tag1", "animal").hashCode(), new TagDemo.Tag("Tag1", "animal").hashCode());
    }

    @Test
    void Test_HashCodeNotEquals() {
        assertNotEquals(new TagDemo.Tag("Tag1", "animal").hashCode(),  new TagDemo.Tag("Tag1", "object").hashCode());
    }

    @Test
    void Test_MutateObjectInSetWithIncorrectHashCodeImplementation() {
        Set<TagDemo.Tag> set = new HashSet<>();
        TagDemo.Tag t = new TagDemo.Tag("java", "language");
        set.add(t);
        assertEquals(set.contains(t), true);
        t.setCategory("framework");
        assertNotEquals(set.contains(t), true);
    }

    @Test
    void Test_MutateObjectInSetWithCorrectHashCodeImplementation() {
        Set<TagDemo.Tag> set = new HashSet<>();
        TagDemo.Tag t = new TagDemo.Tag("java", "language");
        set.add(t);
        assertEquals(set.contains(t), true);
        t.setCategory("framework");
        assertEquals(set.contains(t), false);
    }

    // Exercise 3

    @Test
    void Test_RationaIsCorrectlyReduced() {
        assertEquals(new Rational(2,4).equals(new Rational(1, 2)), true);
    }

    @Test
    void Test_AddRationalNumbers() {
        assertEquals(new Rational(1, 3).add(new Rational(1, 6)), new Rational(1,2));
    }

    @Test
    void Test_PrintRationalsFromTreeSet() {
        TreeSet<Rational> rationalTreeSet = new TreeSet<Rational>();

        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(1, 4);
        Rational rational3 = new Rational(1, 3);

        rationalTreeSet.add(rational1);
        rationalTreeSet.add(rational2);
        rationalTreeSet.add(rational3);

        assertEquals(rationalTreeSet.first(), rational2);
    }

    @Test
    void Test_SameElementsInSetAfterReduction() {

        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(2, 4);

        TreeSet<Rational> rationalTreeSet = new TreeSet<Rational>();

        rationalTreeSet.add(rational1);
        rationalTreeSet.add(rational2);

        assertEquals(rationalTreeSet.size(), 1);

        assertEquals(rational1.equals(rational2), true);
    }

    // Exercise 4

    @Test
    void Test_InitalArrayDoesNotMutate() {
        int[] meetings = {90, 30, 30};
        Schedule schedule = new Schedule("Luca", meetings);

        meetings[0] = 60;

        Schedule expected = new Schedule("Luca", new int[]{90, 30, 30});

        assertEquals(schedule, expected);
    }

    @Test
    void Test_ReturnedArrayDoesNotAffetcSchedule() {
        int[] meetings = {90, 30, 30};
        Schedule schedule = new Schedule("Luca", meetings);

        int [] returnedArray = schedule.getMeetings();
        returnedArray[0] = 45;

        Schedule expected = new Schedule("Luca", new int[]{90, 30, 30});

        assertEquals(schedule, expected);
    }

    @Test
    void Test_WithMeetingsDoesNotMutateOriginalObject() {
        int[] meetings = {90, 30, 30};
        Schedule schedule = new Schedule("Luca", meetings);

        Schedule updated = schedule.withMeeting(20);

        Schedule original = new Schedule("Luca", new int[]{90, 30, 30});
        Schedule expected = new Schedule("Luca", new int[]{90, 30, 30, 20});

        assertEquals(schedule, original); 
        assertEquals(updated, expected);
        assertNotEquals(schedule, updated);
    }

    @Test
    void Test_TwoSchedulesWithSameOwnerAndSameMeetingsAreEqual() {
        int[] meetings = {90, 30, 30};
        
        Schedule schedule1 = new Schedule("Luca", meetings);
        Schedule schedule2 = new Schedule("Luca", meetings);

        assertEquals(schedule1, schedule2);
    }


}

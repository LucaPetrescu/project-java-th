package lab2;

import java.util.Objects;

public final class Rational implements Comparable<Rational>{

    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator){
        if (denominator == 0) throw new ArithmeticException("denominator is zero");
        int sign = denominator < 0 ? -1 : 1;
        int g    = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = sign * numerator / g;
        this.denominator = Math.abs(denominator) / g;
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    public Rational add(Rational o) {
        return new Rational(this.numerator * o.denominator + this.denominator * o.numerator, this.denominator * o.denominator);
    }

    public Rational subract(Rational o) {
        return new Rational(this.numerator * o.denominator - this.denominator * o.numerator, this.denominator * o.denominator);
    }

    public Rational multiply(Rational o) {
        return new Rational(this.numerator * o.numerator, this.denominator * o.denominator);
    }

    public Rational divide(Rational o) {
        return new Rational(this.numerator * o.denominator, this.denominator * o.numerator);
    }

    @Override
    public int compareTo(Rational o){
        return Long.compare((long) this.numerator * o.denominator, (long) o.numerator * this.denominator);
    }

    @Override
    public boolean equals(Object o) {
            
        if(o == this) {
            return true;
        }

        if(!(o instanceof Rational)) {
            return false;
        }
            
        Rational r = (Rational) o;

        return numerator == r.numerator && denominator == r.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numerator, this.denominator);
    }

    @Override
    public String toString() {
        return denominator == 1 ? String.valueOf(numerator) : numerator + "/" + denominator;
    }
    
}

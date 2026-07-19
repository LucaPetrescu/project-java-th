package lab2;

import java.util.Objects;

public final class Money {

    private final long amountMinorUnits;
    private final String currencyCode;

    public Money(long amountMinorUnits, String currencyCode) {
        Objects.requireNonNull(currencyCode, "currencyCode must not be null");
        if (!currencyCode.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Incorrect currency format");
        }
        this.amountMinorUnits = amountMinorUnits;
        this.currencyCode = currencyCode;
    }

    public long getAmountMinorUnits() { return amountMinorUnits; }
    public String getCurrencyCode()   { return currencyCode; }

    public Money plus(Money other) {
        if(!other.currencyCode.equals(this.currencyCode)){
            throw new IllegalArgumentException("Currencies do not match");
        }

        return new Money(amountMinorUnits + other.amountMinorUnits, currencyCode);
    }

    @Override
    public boolean equals(Object o) {

        if(o == this) {
            return true;
        }

        if(!(o instanceof Money)) {
            return false;
        }

        Money other = (Money)o;
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
            || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));

        return this.amountMinorUnits == other.amountMinorUnits && currencyCodeEquals;

    }

    @Override
    public int hashCode() {
        return Objects.hash(amountMinorUnits, currencyCode);
    }

    @Override
    public String toString(){
        String sign = amountMinorUnits < 0 ? "-" : "";
        long whole = Math.abs(amountMinorUnits) / 100;
        long frac = Math.abs(amountMinorUnits) % 100;
        return sign + String.format("%d.%02d %s", whole, frac, currencyCode);
    }

}

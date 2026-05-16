package Functions;

public class PrimeFactor {
    private final int value;
    private int exponent;

    public PrimeFactor(int value, int exponent) {
        this.value = value;
        this.exponent = exponent;
    }

    public void increaseExponent() {
        exponent++;
    }

    public int getValue() {
        return value;
    }

    public int getExponent() {
        return exponent;
    }

    /*
    public int getTotalValue(){
        return (int)Math.pow(value, exponent);
    }
     */

    public String toString(PrimeFactor p) {
        return p.value + "^" + p.exponent;
    }
}

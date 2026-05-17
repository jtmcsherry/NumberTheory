package functions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PrimeFactorTest {

    @Test
    void testConstructor() {
        PrimeFactor pf = new PrimeFactor(2, 3);
        assertEquals(2, pf.getValue());
        assertEquals(3, pf.getExponent());
    }

    @Test
    void testIncreaseExponent() {
        PrimeFactor pf = new PrimeFactor(5, 1);
        pf.increaseExponent();
        assertEquals(2, pf.getExponent());
        pf.increaseExponent();
        assertEquals(3, pf.getExponent());
    }

    @Test
    void testValueOneExponentOne() {
        PrimeFactor pf = new PrimeFactor(1, 1);
        assertEquals(1, pf.getValue());
        assertEquals(1, pf.getExponent());
    }

    @Test
    void testZeroExponent() {
        PrimeFactor pf = new PrimeFactor(7, 0);
        assertEquals(7, pf.getValue());
        assertEquals(0, pf.getExponent());
    }

    @Test
    void testLargeExponent() {
        PrimeFactor pf = new PrimeFactor(2, 10);
        assertEquals(10, pf.getExponent());
    }

    @Test
    void testToString() {
        PrimeFactor pf = new PrimeFactor(3, 4);
        assertEquals("3^4", pf.toString(pf));
    }

    @Test
    void testToStringExponentOne() {
        PrimeFactor pf = new PrimeFactor(2, 1);
        assertEquals("2^1", pf.toString(pf));
    }
}

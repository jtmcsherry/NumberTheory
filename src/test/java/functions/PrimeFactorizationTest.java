package functions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class PrimeFactorizationTest {

    @Test
    void testIsPrime() {
        assertFalse(PrimeFactorization.isPrime(1));
        assertTrue(PrimeFactorization.isPrime(2));
        assertTrue(PrimeFactorization.isPrime(3));
        assertFalse(PrimeFactorization.isPrime(4));
        assertTrue(PrimeFactorization.isPrime(5));
        assertFalse(PrimeFactorization.isPrime(9));
        assertFalse(PrimeFactorization.isPrime(15));
        assertTrue(PrimeFactorization.isPrime(17));
        assertTrue(PrimeFactorization.isPrime(23));
        assertFalse(PrimeFactorization.isPrime(25));
        assertFalse(PrimeFactorization.isPrime(49));
        assertFalse(PrimeFactorization.isPrime(121));
    }

    @Test
    void testPrimeNumber() {
        PrimeFactorization pf = new PrimeFactorization(17);
        assertEquals(17, pf.getValue());
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        assertEquals(2, factors.size());
        assertEquals(1, factors.get(0).getValue());
        assertEquals(17, factors.get(1).getValue());
        assertEquals(1, factors.get(1).getExponent());
    }

    @Test
    void testCompositeSquare() {
        PrimeFactorization pf = new PrimeFactorization(4);
        assertEquals(4, pf.getValue());
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        assertEquals(2, factors.size());
        assertEquals(1, factors.get(0).getValue());
        assertEquals(2, factors.get(1).getValue());
        assertEquals(2, factors.get(1).getExponent());
    }

    @Test
    void testCompositeMultiplePrimes() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(12, pf.getValue());
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        assertEquals(3, factors.size());
        assertEquals(1, factors.get(0).getValue());
        assertEquals(2, factors.get(1).getValue());
        assertEquals(2, factors.get(1).getExponent());
        assertEquals(3, factors.get(2).getValue());
        assertEquals(1, factors.get(2).getExponent());
    }

    @Test
    void testNumberOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, pf.getValue());
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        assertEquals(1, factors.size());
        assertEquals(1, factors.get(0).getValue());
    }

    @Test
    void testLargeComposite() {
        PrimeFactorization pf = new PrimeFactorization(30);
        assertEquals(30, pf.getValue());
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        assertTrue(factors.size() >= 3);
    }

    @Test
    void testPerfectSquare() {
        PrimeFactorization pf = new PrimeFactorization(36);
        assertEquals(36, pf.getValue());
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        assertEquals(1, factors.get(0).getValue());
        assertEquals(2, factors.get(1).getValue());
        assertEquals(2, factors.get(1).getExponent());
        assertEquals(3, factors.get(2).getValue());
        assertEquals(2, factors.get(2).getExponent());
    }

    @Test
    void testPrimeCube() {
        PrimeFactorization pf = new PrimeFactorization(8);
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        assertEquals(2, factors.get(1).getValue());
        assertEquals(3, factors.get(1).getExponent());
    }

    @Test
    void testToString() {
        PrimeFactorization pf = new PrimeFactorization(12);
        String result = pf.toString();
        assertTrue(result.contains("1^1"));
        assertTrue(result.contains("2^2"));
        assertTrue(result.contains("3^1"));
    }
}

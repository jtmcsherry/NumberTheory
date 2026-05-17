package functions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AddativeFunctionsTest {

    @Test
    void testUpperOmegaPrime() {
        PrimeFactorization pf = new PrimeFactorization(17);
        assertEquals(1, AddativeFunctions.upperOmega(pf));
    }

    @Test
    void testUpperOmegaComposite() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(3, AddativeFunctions.upperOmega(pf));
    }

    @Test
    void testUpperOmegaSquare() {
        PrimeFactorization pf = new PrimeFactorization(4);
        assertEquals(2, AddativeFunctions.upperOmega(pf));
    }

    @Test
    void testUpperOmegaOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(0, AddativeFunctions.upperOmega(pf));
    }

    @Test
    void testUpperOmegaLarge() {
        PrimeFactorization pf = new PrimeFactorization(72);
        assertEquals(5, AddativeFunctions.upperOmega(pf));
    }

    @Test
    void testLowerOmegaPrime() {
        PrimeFactorization pf = new PrimeFactorization(17);
        assertEquals(2, AddativeFunctions.lowerOmega(pf));
    }

    @Test
    void testLowerOmegaComposite() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(3, AddativeFunctions.lowerOmega(pf));
    }

    @Test
    void testLowerOmegaOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, AddativeFunctions.lowerOmega(pf));
    }

    @Test
    void testSumPrimes() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(7, AddativeFunctions.sumPrimes(pf));
    }

    @Test
    void testSumPrimesTwoThousand() {
        PrimeFactorization pf = new PrimeFactorization(2000);
        assertEquals(23, AddativeFunctions.sumPrimes(pf));
    }

    @Test
    void testSumPrimesPrime() {
        PrimeFactorization pf = new PrimeFactorization(7);
        assertEquals(7, AddativeFunctions.sumPrimes(pf));
    }

    @Test
    void testSumPrimesOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(0, AddativeFunctions.sumPrimes(pf));
    }

    @Test
    void testSumDistinctPrimeDivisors() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(5, AddativeFunctions.sumDistinctPrimeDivisors(pf));
    }

    @Test
    void testSumDistinctPrimeDivisorsTwoThousand() {
        PrimeFactorization pf = new PrimeFactorization(2000);
        assertEquals(7, AddativeFunctions.sumDistinctPrimeDivisors(pf));
    }

    @Test
    void testSumDistinctPrimeDivisorsPrime() {
        PrimeFactorization pf = new PrimeFactorization(13);
        assertEquals(13, AddativeFunctions.sumDistinctPrimeDivisors(pf));
    }

    @Test
    void testSumDistinctPrimeDivisorsOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(0, AddativeFunctions.sumDistinctPrimeDivisors(pf));
    }

    @Test
    void testLowerOmegaUpperOmegaConsistency() {
        PrimeFactorization pf = new PrimeFactorization(72);
        assertTrue(AddativeFunctions.lowerOmega(pf) <= AddativeFunctions.upperOmega(pf));
    }
}

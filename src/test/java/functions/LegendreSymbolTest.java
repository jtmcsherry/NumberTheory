package functions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LegendreSymbolTest {

    @Test
    void testOneIsAlwaysResidue() {
        assertEquals(1, LegendreSymbol.legendreSymbol(1, 3));
        assertEquals(1, LegendreSymbol.legendreSymbol(1, 5));
        assertEquals(1, LegendreSymbol.legendreSymbol(1, 7));
        assertEquals(1, LegendreSymbol.legendreSymbol(1, 11));
        assertEquals(1, LegendreSymbol.legendreSymbol(1, 13));
    }

    @Test
    void testZeroIsDivisible() {
        assertEquals(0, LegendreSymbol.legendreSymbol(0, 3));
        assertEquals(0, LegendreSymbol.legendreSymbol(0, 5));
        assertEquals(0, LegendreSymbol.legendreSymbol(0, 7));
    }

    @Test
    void testPdividesA() {
        assertEquals(0, LegendreSymbol.legendreSymbol(7, 7));
        assertEquals(0, LegendreSymbol.legendreSymbol(21, 7));
        assertEquals(0, LegendreSymbol.legendreSymbol(33, 11));
    }

    @Test
    void testTwoModP() {
        assertEquals(-1, LegendreSymbol.legendreSymbol(2, 3));
        assertEquals(-1, LegendreSymbol.legendreSymbol(2, 5));
        assertEquals(1, LegendreSymbol.legendreSymbol(2, 7));
        assertEquals(-1, LegendreSymbol.legendreSymbol(2, 11));
        assertEquals(-1, LegendreSymbol.legendreSymbol(2, 13));
        assertEquals(1, LegendreSymbol.legendreSymbol(2, 17));
        assertEquals(-1, LegendreSymbol.legendreSymbol(2, 19));
        assertEquals(1, LegendreSymbol.legendreSymbol(2, 23));
        assertEquals(-1, LegendreSymbol.legendreSymbol(2, 29));
        assertEquals(1, LegendreSymbol.legendreSymbol(2, 31));
    }

    @Test
    void testQuadraticResiduesMod7() {
        assertEquals(1, LegendreSymbol.legendreSymbol(1, 7));
        assertEquals(1, LegendreSymbol.legendreSymbol(2, 7));
        assertEquals(1, LegendreSymbol.legendreSymbol(4, 7));
    }

    @Test
    void testQuadraticNonresiduesMod7() {
        assertEquals(-1, LegendreSymbol.legendreSymbol(3, 7));
        assertEquals(-1, LegendreSymbol.legendreSymbol(5, 7));
        assertEquals(-1, LegendreSymbol.legendreSymbol(6, 7));
    }

    @Test
    void testQuadraticResiduesMod11() {
        assertEquals(1, LegendreSymbol.legendreSymbol(1, 11));
        assertEquals(1, LegendreSymbol.legendreSymbol(3, 11));
        assertEquals(1, LegendreSymbol.legendreSymbol(4, 11));
        assertEquals(1, LegendreSymbol.legendreSymbol(5, 11));
        assertEquals(1, LegendreSymbol.legendreSymbol(9, 11));
    }

    @Test
    void testQuadraticNonresiduesMod11() {
        assertEquals(-1, LegendreSymbol.legendreSymbol(2, 11));
        assertEquals(-1, LegendreSymbol.legendreSymbol(6, 11));
        assertEquals(-1, LegendreSymbol.legendreSymbol(7, 11));
        assertEquals(-1, LegendreSymbol.legendreSymbol(8, 11));
        assertEquals(-1, LegendreSymbol.legendreSymbol(10, 11));
    }

    @Test
    void testNegativeReduction() {
        assertEquals(LegendreSymbol.legendreSymbol(-1, 7), LegendreSymbol.legendreSymbol(6, 7));
        assertEquals(LegendreSymbol.legendreSymbol(-2, 7), LegendreSymbol.legendreSymbol(5, 7));
        assertEquals(LegendreSymbol.legendreSymbol(-3, 7), LegendreSymbol.legendreSymbol(4, 7));
    }

    @Test
    void testNegativeOneMod3() {
        assertEquals(-1, LegendreSymbol.legendreSymbol(-1, 3));
    }

    @Test
    void testNegativeOneMod5() {
        assertEquals(1, LegendreSymbol.legendreSymbol(-1, 5));
    }

    @Test
    void testCompositeSquare() {
        assertEquals(1, LegendreSymbol.legendreSymbol(4, 7));
        assertEquals(1, LegendreSymbol.legendreSymbol(9, 7));
        assertEquals(1, LegendreSymbol.legendreSymbol(25, 11));
    }

    @Test
    void testCompositeProduct() {
        assertEquals(-1, LegendreSymbol.legendreSymbol(6, 7));
        assertEquals(1, LegendreSymbol.legendreSymbol(15, 11));
        assertEquals(-1, LegendreSymbol.legendreSymbol(21, 11));
    }

    @Test
    void testQuadraticReciprocityScenario() {
        assertEquals(-1, LegendreSymbol.legendreSymbol(35, 11));
    }

    @Test
    void testLargeA() {
        assertEquals(1, LegendreSymbol.legendreSymbol(100, 7));
        assertEquals(-1, LegendreSymbol.legendreSymbol(101, 7));
        assertEquals(0, LegendreSymbol.legendreSymbol(121, 11));
    }

    @Test
    void testRejectsNonPrimeP() {
        assertEquals(0, LegendreSymbol.legendreSymbol(1, 1));
        assertEquals(0, LegendreSymbol.legendreSymbol(1, 4));
        assertEquals(0, LegendreSymbol.legendreSymbol(1, 6));
        assertEquals(0, LegendreSymbol.legendreSymbol(1, 9));
        assertEquals(0, LegendreSymbol.legendreSymbol(1, 15));
    }

    @Test
    void testRejectsPEquals2() {
        assertEquals(0, LegendreSymbol.legendreSymbol(1, 2));
    }

    @Test
    void testSameValueDifferentP() {
        assertNotEquals(LegendreSymbol.legendreSymbol(3, 7), LegendreSymbol.legendreSymbol(3, 11));
    }

    @Test
    void testWithPrimeFactorization() {
        PrimeFactorization pf = new PrimeFactorization(6);
        assertEquals(-1, LegendreSymbol.legendreSymbol(pf, 7));
    }

    @Test
    void testPFWithPrime() {
        PrimeFactorization pf = new PrimeFactorization(7);
        assertEquals(-1, LegendreSymbol.legendreSymbol(pf, 11));
    }

    @Test
    void testPFWithSquare() {
        PrimeFactorization pf = new PrimeFactorization(4);
        assertEquals(1, LegendreSymbol.legendreSymbol(pf, 7));
    }

    @Test
    void testPFWithOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, LegendreSymbol.legendreSymbol(pf, 7));
    }

    @Test
    void testPFWithLargeComposite() {
        PrimeFactorization pf = new PrimeFactorization(35);
        assertEquals(-1, LegendreSymbol.legendreSymbol(pf, 11));
    }

    @Test
    void testPFRejectsPEquals2() {
        PrimeFactorization pf = new PrimeFactorization(3);
        assertEquals(0, LegendreSymbol.legendreSymbol(pf, 2));
    }

    @Test
    void testPFRejectsNonPrimeP() {
        PrimeFactorization pf = new PrimeFactorization(3);
        assertEquals(0, LegendreSymbol.legendreSymbol(pf, 9));
    }

    @Test
    void testJacobiSymbolExample() {
        assertEquals(-1, LegendreSymbol.legendreSymbol(5, 7));
        assertEquals(-1, LegendreSymbol.legendreSymbol(10, 7));
        assertEquals(1, LegendreSymbol.legendreSymbol(8, 7));
    }
}

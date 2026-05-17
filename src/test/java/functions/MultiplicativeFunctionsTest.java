package functions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MultiplicativeFunctionsTest {

    @Test
    void testPhiPrime() {
        PrimeFactorization pf = new PrimeFactorization(7);
        assertEquals(6, MultiplicativeFunctions.phi(pf));
    }

    @Test
    void testPhiComposite() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(4, MultiplicativeFunctions.phi(pf));
    }

    @Test
    void testPhiOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.phi(pf));
    }

    @Test
    void testPhiPrimeSquare() {
        PrimeFactorization pf = new PrimeFactorization(9);
        assertEquals(6, MultiplicativeFunctions.phi(pf));
    }

    @Test
    void testPhiLarge() {
        PrimeFactorization pf = new PrimeFactorization(30);
        assertEquals(8, MultiplicativeFunctions.phi(pf));
    }

    @Test
    void testSigmaPrime() {
        PrimeFactorization pf = new PrimeFactorization(7);
        assertEquals(8, MultiplicativeFunctions.sigma(pf));
    }

    @Test
    void testSigmaComposite() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(28, MultiplicativeFunctions.sigma(pf));
    }

    @Test
    void testSigmaOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.sigma(pf));
    }

    @Test
    void testSigmaPrimeSquare() {
        PrimeFactorization pf = new PrimeFactorization(9);
        assertEquals(13, MultiplicativeFunctions.sigma(pf));
    }

    @Test
    void testSigmaPerfect() {
        PrimeFactorization pf = new PrimeFactorization(6);
        assertEquals(12, MultiplicativeFunctions.sigma(pf));
    }

    @Test
    void testTauPrime() {
        PrimeFactorization pf = new PrimeFactorization(7);
        assertEquals(2, MultiplicativeFunctions.tau(pf));
    }

    @Test
    void testTauComposite() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(6, MultiplicativeFunctions.tau(pf));
    }

    @Test
    void testTauOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.tau(pf));
    }

    @Test
    void testTauPerfectSquare() {
        PrimeFactorization pf = new PrimeFactorization(36);
        assertEquals(9, MultiplicativeFunctions.tau(pf));
    }

    @Test
    void testMuSquareFree() {
        PrimeFactorization pf = new PrimeFactorization(6);
        assertEquals(1, MultiplicativeFunctions.mu(pf));
    }

    @Test
    void testMuSquareFreeOddCount() {
        PrimeFactorization pf = new PrimeFactorization(30);
        assertEquals(-1, MultiplicativeFunctions.mu(pf));
    }

    @Test
    void testMuHasSquare() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(0, MultiplicativeFunctions.mu(pf));
    }

    @Test
    void testMuOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.mu(pf));
    }

    @Test
    void testOne() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(1, MultiplicativeFunctions.one(pf));
    }

    @Test
    void testOneAnyInput() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.one(pf));
    }

    @Test
    void testIdentity() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(12, MultiplicativeFunctions.identity(pf));
    }

    @Test
    void testIdentityOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.identity(pf));
    }

    @Test
    void testUnitFunctionWithOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.unitFunction(pf));
    }

    @Test
    void testUnitFunctionGreaterThanOne() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(0, MultiplicativeFunctions.unitFunction(pf));
    }

    @Test
    void testRad() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(6, MultiplicativeFunctions.rad(pf));
    }

    @Test
    void testRadOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.rad(pf));
    }

    @Test
    void testRadPrime() {
        PrimeFactorization pf = new PrimeFactorization(7);
        assertEquals(7, MultiplicativeFunctions.rad(pf));
    }

    @Test
    void testRadPrimePower() {
        PrimeFactorization pf = new PrimeFactorization(8);
        assertEquals(2, MultiplicativeFunctions.rad(pf));
    }

    @Test
    void testLiouvilleSquareFreeEvenOmega() {
        PrimeFactorization pf = new PrimeFactorization(6);
        assertEquals(1, MultiplicativeFunctions.liouville(pf));
    }

    @Test
    void testLiouvilleSquareFreeOddOmega() {
        PrimeFactorization pf = new PrimeFactorization(30);
        assertEquals(-1, MultiplicativeFunctions.liouville(pf));
    }

    @Test
    void testLiouvilleComposite() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(-1, MultiplicativeFunctions.liouville(pf));
    }

    @Test
    void testLiouvilleOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.liouville(pf));
    }

    @Test
    void testPsiOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.psi(pf));
    }

    @Test
    void testPsiPrime() {
        PrimeFactorization pf = new PrimeFactorization(7);
        assertEquals(8, MultiplicativeFunctions.psi(pf));
    }

    @Test
    void testPsiComposite() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(24, MultiplicativeFunctions.psi(pf));
    }

    @Test
    void testPsiPrimePower() {
        PrimeFactorization pf = new PrimeFactorization(8);
        assertEquals(12, MultiplicativeFunctions.psi(pf));
    }

    @Test
    void testJordanTotientKOne() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(4, MultiplicativeFunctions.jordanTotient(pf, 1));
    }

    @Test
    void testJordanTotientKTwo() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(96, MultiplicativeFunctions.jordanTotient(pf, 2));
    }

    @Test
    void testJordanTotientPrime() {
        PrimeFactorization pf = new PrimeFactorization(7);
        assertEquals(6, MultiplicativeFunctions.jordanTotient(pf, 1));
    }

    @Test
    void testJordanTotientOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.jordanTotient(pf, 5));
    }

    @Test
    void testSquareFreeTrue() {
        PrimeFactorization pf = new PrimeFactorization(6);
        assertEquals(1, MultiplicativeFunctions.squareFree(pf));
    }

    @Test
    void testSquareFreeFalse() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(0, MultiplicativeFunctions.squareFree(pf));
    }

    @Test
    void testSquareFreeOne() {
        PrimeFactorization pf = new PrimeFactorization(1);
        assertEquals(1, MultiplicativeFunctions.squareFree(pf));
    }

    @Test
    void testSquareFreePrime() {
        PrimeFactorization pf = new PrimeFactorization(17);
        assertEquals(1, MultiplicativeFunctions.squareFree(pf));
    }

    @Test
    void testIsPerfect() {
        PrimeFactorization pf = new PrimeFactorization(6);
        assertEquals(0, MultiplicativeFunctions.isPerfect(pf));
    }

    @Test
    void testIsAbundant() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertEquals(1, MultiplicativeFunctions.isPerfect(pf));
    }

    @Test
    void testIsDeficient() {
        PrimeFactorization pf = new PrimeFactorization(8);
        assertEquals(-1, MultiplicativeFunctions.isPerfect(pf));
    }

    @Test
    void testIsPerfectPrime() {
        PrimeFactorization pf = new PrimeFactorization(7);
        assertEquals(-1, MultiplicativeFunctions.isPerfect(pf));
    }

    @Test
    void testPhiSigmaConsistency() {
        PrimeFactorization pf = new PrimeFactorization(12);
        assertTrue(MultiplicativeFunctions.phi(pf) < MultiplicativeFunctions.sigma(pf));
    }
}

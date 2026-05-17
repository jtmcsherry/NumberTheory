package functions;
import java.util.ArrayList;

public class LegendreSymbol {

    public static int legendreSymbol(int a, int p) {
        if (p == 2 || !PrimeFactorization.isPrime(p)) {
            System.out.println(p + " must be an odd prime.");
            return 0;
        }

        a = a % p;
        if (a < 0) {
            a += p;
        }

        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }

        int result = 1;

        while (a % 2 == 0) {
            result *= legendreSymbolTwo(p);
            a /= 2;
        }

        if (a > 1) {
            PrimeFactorization pf = new PrimeFactorization(a);
            ArrayList<PrimeFactor> factors = pf.getFactorization();
            for (int i = 1; i < factors.size(); i++) {
                PrimeFactor factor = factors.get(i);
                if (factor.getExponent() % 2 == 1) {
                    result *= legendreSymbolPrime(factor.getValue(), p);
                }
            }
        }

        return result;
    }

    public static int legendreSymbol(PrimeFactorization pf, int p) {
        if (p == 2 || !PrimeFactorization.isPrime(p)) {
            System.out.println(p + " must be an odd prime.");
            return 0;
        }

        if (pf.getValue() == 0) {
            return 0;
        }

        int result = 1;

        ArrayList<PrimeFactor> factors = pf.getFactorization();
        for (int i = 1; i < factors.size(); i++) {
            PrimeFactor factor = factors.get(i);
            if (factor.getExponent() % 2 == 1) {
                if (factor.getValue() == 2) {
                    result *= legendreSymbolTwo(p);
                } else {
                    result *= legendreSymbolPrime(factor.getValue(), p);
                }
            }
        }

        return result;
    }

    private static int legendreSymbolPrime(int q, int p) {
        if (q == 1) {
            return 1;
        }

        int sign = 1;
        if (q % 4 == 3 && p % 4 == 3) {
            sign = -1;
        }

        int r = p % q;
        return sign * legendreSymbol(r, q);
    }

    private static int legendreSymbolTwo(int p) {
        int mod8 = p % 8;
        if (mod8 == 1 || mod8 == 7) {
            return 1;
        }
        return -1;
    }
}

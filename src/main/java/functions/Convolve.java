package functions;
import java.util.ArrayList;

class Convolve {



    public static int convolve(PrimeFactorization pf){
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        for(int i = 1; i < factors.size(); i++){

        }
        return 0;
    }

    public static int convolveForSinglePrime(PrimeFactor factor){
        int value = 0;
        int exponent = factor.getExponent();
        for(int i = 0; i < exponent + 1; i++){
            int tau = (exponent - i) + 1;
            int pf = fastPow(factor.getValue(), i);
            value += tau * pf;
        }
        return value;
    }

    private static int fastPow(int base, int exp) {
        int result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
            }
            base *= base;
            exp >>= 1;
        }
        return result;
    }
}
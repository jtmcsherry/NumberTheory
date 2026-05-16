package Functions;
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
        int exponent = factor.getExponent() - 1;
        for(int i = 0; i < factor.getExponent() + 1; i++){
            value += tauForPrime(new PrimeFactor(factor.getValue(), exponent - i)) * phiForPrime(new PrimeFactor(factor.getValue(), exponent));
        }
        return value;
    }
}
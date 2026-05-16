package functions;
import java.util.ArrayList;

public class AddativeFunctions {
    public AddativeFunctions(){

    }

    /*
    Total number of prime factors, counting multiplicity
    */
    public static int upperOmega(PrimeFactorization  PF) {
        int result = 0;

        for(PrimeFactor factor: PF.getFactorization()) {
            result += factor.getExponent();
        }

        return result;
    }

    /*
    Number of distinct primes diving n
    */
    public static int lowerOmega(PrimeFactorization  PF) {
        return PF.getFactorization().size();
    }

    /*
    CHANGE NAME - I DONT KNOW WHAT TO BUT SOMETHING ELSE
    Sum of primes dividing n, 2000 = 23
     */
    public static int sumPrimes(PrimeFactorization pf){
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        int value = 0;

        for (int i = 1; i < factors.size(); i++) {
            PrimeFactor f = factors.get(i);
            value += f.getExponent() * f.getValue();
        }

        return value;
    }

    /*
    CHANGE NAME - I DONT KNOW WHAT TO BUT SOMETHING ELSE
    Sum of distinct primes dividing n, 2000 = 7
     */
    public static int sumDistinctPrimeDivisors(PrimeFactorization pf){
        ArrayList<PrimeFactor> primeF = pf.getFactorization();
        int value = 0;

        for(int i = 1; i < primeF.size(); i++){
            value += primeF.get(i).getValue();
        }

        return value;
    }
}
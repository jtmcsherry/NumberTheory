package Functions;
import java.util.ArrayList;

public class AddativeFunctions {
    public AddativeFunctions(){

    }

    /*
    The total number of prime factors of n
     */
    public static int upperOmega(PrimeFactorization pf){
        ArrayList<PrimeFactor> primeF = pf.getFactorization();
        int value = 0;

        for(int i = 1; i < primeF.size(); i++){
            value += upperOmegaForPrime(primeF.get(i));
        }

        return value;
    }

    /*

     */
    private static int upperOmegaForPrime(PrimeFactor factor){
        return factor.getExponent();
    }

    /*
    This funcrtion returns the number of distict prime factors
     */
    public static int lowerOmega(PrimeFactorization pf){
        ArrayList<PrimeFactor> primeF = pf.getFactorization();
        return primeF.size()-1;
    }

    /*
    CHANGE NAME - I DONT KNOW WHAT TO BUT SOMETHING ELSE
    Sum of primes dividing n, 2000 = 23
     */
    public static int sumPrimes(PrimeFactorization pf){
        ArrayList<PrimeFactor> primeF = pf.getFactorization();
        int value = 0;

        for(int i = 1; i < primeF.size(); i++){
            value += sumPrimeDivisors(primeF.get(i));
        }

        return value;
    }

    private static int sumPrimeDivisors(PrimeFactor factor){
        int value = 0;

        for(int i = 0; i < factor.getExponent(); i++){
            value += factor.getValue();
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
package Functions;
import java.util.ArrayList;

public class MultiplicativeFunctions {
    public MultiplicativeFunctions(){

    }

    /*
    This function returns the number of numbers less than the number that is coprime to it
    Or numbers that don't share any divisors
    The function is n * phiForPrime(all divisors of n)
     */
    public static int phi(PrimeFactorization pf){
        ArrayList<PrimeFactor> primeF = pf.getFactorization();
        int value = 1;

        for(int i = 1; i < primeF.size(); i++){
            value = value * phiForPrime(primeF.get(i));
        }

        return value;
    }

    /*
    This is a helper method for phi it returns the phi value for a single prime factor
    the equation is (p-1)/p
     */
    private static int phiForPrime(PrimeFactor factor){
        int value = (int)(Math.pow(factor.getValue(),factor.getExponent()));
        value = (value * (factor.getValue() - 1) / factor.getValue());
        return value;
    }

    /*
    This function returns the sum of the divisors of the number that was given
     */
    public static int sigma(PrimeFactorization pf){
        ArrayList<PrimeFactor> primeF = pf.getFactorization();
        int value = 1;

        for(int i = 1; i < primeF.size(); i++){
            value = value * sigmaForPrime(primeF.get(i));
        }

        return value;
    }

    /*
    This function returns the sigma value of the prime that was given
    the formula is
    (p^(k+1)-1)/(p-1)
     */
    private static int sigmaForPrime(PrimeFactor factor){
        int value = (int)(Math.pow(factor.getValue(), factor.getExponent() + 1));
        value--;
        value = value/(factor.getValue() - 1);
        return value;
    }

    /*

     */
    public static int tau(PrimeFactorization pf){
        ArrayList<PrimeFactor> primeF = pf.getFactorization();
        int value = 1;

        for(int i = 1; i < primeF.size(); i++) {
            value = value * tauForPrime(primeF.get(i));
        }

        return value;
    }

    /*

     */
    private static int tauForPrime(PrimeFactor factor){
        return (factor.getExponent() + 1);
    }

    /*
    This function checks to see if the number is "square free"
    Which means that if the number is divisible by and number to a power greater
    than 1 it will return 0;
    If all the prime factors are to the power of 1, it will return
    -1 to the power of the number of divisors (execpt for the divisor 1)
     */
    public static int mew(PrimeFactorization pf){
        ArrayList<PrimeFactor> primeF = pf.getFactorization();
        int value = 1;

        for(int i = 1; i < primeF.size(); i++) {
            value = value * mewForPrime(primeF.get(i));
        }

        return value;
    }

    /*
    This is a helper method for the mew function
    It will return 0 if the exponent for the prime factor is greater than 1
    Which means that it has a square divisor
    If there is just a single power of a prime it will return -1
     */
    private static int mewForPrime(PrimeFactor factor){
        if(factor.getExponent() > 1){
            return 0;
        }
        return -1;
    }

    /*
    This function returns 1 for every input that it is given
     */
    public static int one(PrimeFactorization pf){
        return 1;
    }

    /*
    This function returns that value that it was given
     */
    public static int N(PrimeFactorization pf){
        return pf.getValue();
    }

    /*
    This function returns 1 only when the number is 1
    Otherwise it returns 0
     */
    public static int unitFunction(PrimeFactorization pf){
        if(pf.getValue() == 1){
            return 1;
        }
        return 0;
    }

    /*

     */
    public static int legendreSymbol(PrimeFactorization pf, int prime){
        if(!PrimeFactorization.isPrime(prime)){
            System.out.println(prime + " must be prime.");
            return 0;
        }

        int value = 1;
        long checkValue;
        PrimeFactor p;
        ArrayList<PrimeFactor> primeF = pf.getFactorization();
        for(int i = 1; i < primeF.size(); i++){
            p = primeF.get(i);
            if(p.getExponent() % 2 == 1 && p.getExponent() > 2){
                return -1;
            }

            int primeFactorValue = (int)Math.pow(p.getValue(), p.getExponent());
            checkValue = (long)Math.pow(primeFactorValue, (double)(prime - 1) /2);
            checkValue = checkValue % prime;
            if(checkValue == prime - 1){
                value = value * -1;
            }else{
                value = (int)(value * checkValue);
            }
        }
        return value;
    }

    /*
    This function returns 0 if the number is perfect(simga(n) = 2n)
    Returns 1 if the number is abundant(sigma(n) > 2n)
    Returns -1 if the number is deficient(sigma(n) < 2n)
     */
    public static int isPerfect(PrimeFactorization pf){
        int sigma = sigma(pf);
        int target = pf.getValue() * 2;

        if(sigma == target){
            return 0;
        }else if(sigma > target){
            return 1;
        }

        return -1;
    }


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
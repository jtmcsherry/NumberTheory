package functions;
import java.util.ArrayList;

public class MultiplicativeFunctions {
    public MultiplicativeFunctions(){}

    /*
    This function returns the number of numbers less than the number that is coprime to it
    Or numbers that don't share any divisors
    The function is n * phiForPrime(all divisors of n)
    */
    /*
    This is a helper method for phi it returns the phi value for a single prime factor
    the equation is (p-1)/p
    */
    public static int phi(PrimeFactorization PF) {
        int result = 1;

        for(PrimeFactor factor: PF.getFactorization()) {
            int p = factor.getValue();
            int e = factor.getExponent();

            int phiForP = fastPow(p, e - 1);

            result *= phiForP * (p - 1);
        }

        return result;
    }

    /*
    This function returns the sum of the divisors of the number that was given
    */
    /*
    This function returns the sigma value of the prime that was given
    the formula is
    (p^(k+1)-1)/(p-1)
    */
    public static int sigma(PrimeFactorization PF) {
        int result = 1;

        for(PrimeFactor factor: PF.getFactorization()) {
            int p = factor.getValue();
            int e = factor.getExponent();

            int sigmaForP = fastPow(p, e + 1);

            sigmaForP--;

            result *= sigmaForP / (p - 1);
        }

        return result;
    }

    /*
    //ToDo: add documentation for this function
     */
    public static int tau(PrimeFactorization PF) {
        int result = 1;

        for(PrimeFactor factor: PF.getFactorization()) {
            int e = factor.getExponent();

            result *= (e + 1);
        }

        return result;
    }

    /*
    This function checks to see if the number is "square free"
    Which means that if the number is divisible by and number to a power greater
    than 1 it will return 0;
    If all the prime factors are to the power of 1, it will return
    -1 to the power of the number of divisors (execpt for the divisor 1)
    */
    /*
    This is a helper method for the mew function
    It will return 0 if the exponent for the prime factor is greater than 1
    Which means that it has a square divisor
    If there is just a single power of a prime it will return -1
    */
    public static byte mu(PrimeFactorization PF) {
        for(PrimeFactor factor: PF.getFactorization()) {
            if (factor.getExponent() > 1){
                return 0;
            }
        }

        if (PF.getFactorization().size() % 2 == 0){
            return 1;
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
    public static int identity(PrimeFactorization pf){
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
    Product of distinct primes dividing n
    */
    public static int rad(PrimeFactorization  PF) {
        int result = 1;

        for(PrimeFactor factor: PF.getFactorization()) {
            result *= factor.getValue();
        }

        return result;
    }

    /*
    Liouville Function, 1 if bigOmega is even, -1 is bigOmega is odd
    */
    public static byte liouville(PrimeFactorization  PF) {
        int bigOmega = AddativeFunctions.upperOmega(PF);

        if (bigOmega % 2 == 0){
            return 1;
        }

        return -1;
    }

    /*
    Dedekind Psi
    */
    public static int psi(PrimeFactorization PF) {
        int result = 1;

        for(PrimeFactor factor: PF.getFactorization()) {
            int p = factor.getValue();
            int e = factor.getExponent();

            int psiForP = fastPow(p, e-1);

            result *= psiForP + (psiForP * p);
        }

        return result;
    }

    /*
    Jordan Totients
    */
    public static int jordanTotient(PrimeFactorization PF, int k){
        int result = 1;
        
        for(PrimeFactor factor: PF.getFactorization()) {
            int p = factor.getValue();
            int e = factor.getExponent();

            int exponent_1 = e * k;
            int value_1 = fastPow(p, exponent_1);

            int exponent_2 = (e - 1) * k;
            int value_2 = fastPow(p, exponent_2);

            result *= value_1 - value_2;
        }

        return result;
    }

    /*
    Squarefree Indicator
    If every prime factor has an exponent 1, returns 1
    Otherwise returns 0
    */
    public static byte squareFree(PrimeFactorization PF) {
        for(PrimeFactor factor: PF.getFactorization()) {
            if(factor.getExponent() != 1) {
                return 0;
            }
        }

        return 1;
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
}
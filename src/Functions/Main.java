package Functions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scan.nextInt();
        PrimeFactorization pf = new PrimeFactorization(num);
        System.out.println(pf.toString());



        System.out.println(AddativeFunctions.lowerOmega(pf));
        System.out.println(AddativeFunctions.sumPrimes(pf));
        System.out.println(AddativeFunctions.sumDistinctPrimeDivisors(pf));

         */

        PrimeFactorization pf = new PrimeFactorization(4);
        PrimeFactor twoValue = new PrimeFactor(2, 2);
        System.out.println(MultiplicativeFunctions.sigma(pf));
        System.out.println(MultiplicativeFunctions.convolveForSinglePrime(twoValue));
        /*
        System.out.println(MultiplicativeFunctions.phi(pf));
        System.out.println(MultiplicativeFunctions.tau(pf));
        System.out.println(MultiplicativeFunctions.mew(pf));
        System.out.println(MultiplicativeFunctions.sigma(pf));
        System.out.println(MultiplicativeFunctions.legendreSymbol(pf,23));

         */
    }
}
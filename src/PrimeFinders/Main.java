package PrimeFinders;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long num = 10000000;
        System.out.print("Brute force: ");
        PrimeFinders.bruteForce(num);

        System.out.print("Trial division: ");
        PrimeFinders.trialDivision(num);

        /*
        After doing tests the trial division is faster when looking for prime greater than 330,000
        It was strange that the brute force was faster but that was only for smaller input numbers
         */

        System.out.println("Djiksta Algorithm: ");
        PrimeFinders.djikstrasAlgorithm(num);



    }
}

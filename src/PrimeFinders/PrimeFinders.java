package PrimeFinders;

import java.util.ArrayList;

public class PrimeFinders {

    public PrimeFinders(){

    }

    /*
    This is pretty slow and n^2 running times lets see if there are faster primes finding algorithms
    This method is inefficient because it is checking every number less than or equal to the square root
    of the number. So it would see if the number is divisible by 2, but then it would also check to see
    if the other multiples of two are a divisor. We would already know by the checking two that the number
    is not divisible by an even number.
     */
    public static void bruteForce(long max){
        long startTime = System.nanoTime();
        int numPrimes = 0;
        boolean isPrime = true;
        for(int i = 2; i < max; i++){
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                numPrimes++;
            }
            isPrime = true;
        }
        long endTime = System.nanoTime();
        double duration = (double) (endTime - startTime) /1000000;
        System.out.println(duration + " milliseconds to find primes less than " + max);//divide by 1000000 to get milliseconds.
    }

    /*
    This is if I want the list of primes
    public static ArrayList<Integer>  bruteForce(long max){
        long startTime = System.nanoTime();

        ArrayList<Integer> primes = new ArrayList<>();
        boolean isPrime = true;
        for(int i = 2; i < max; i++){
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes.add(i);
            }
            isPrime = true;
        }
        long endTime = System.nanoTime();
        double duration = (double) (endTime - startTime) /1000000;
        System.out.println(duration + " milliseconds to find primes less than " + max);//divide by 1000000 to get milliseconds.

        return primes;
    }
     */

    /*
    Not writen yet
     */
    public static ArrayList<Integer> trialDivision(long max){
        long startTime = System.nanoTime();

        ArrayList<Integer> primes = new ArrayList<>();


        long endTime = System.nanoTime();
        double duration = (double) (endTime - startTime) /1000000;
        System.out.println(duration + " milliseconds to find primes less than " + max);//divide by 1000000 to get milliseconds.

        return primes;
    }

    /*
    Not writen yet
     */
    public static ArrayList<Integer> seigeOfEratosthenes(long max){
        long startTime = System.nanoTime();

        ArrayList<Integer> primes = new ArrayList<>();


        long endTime = System.nanoTime();
        double duration = (double) (endTime - startTime) /1000000;
        System.out.println(duration + " milliseconds to find primes less than " + max);//divide by 1000000 to get milliseconds.

        return primes;
    }

    /*
    Not writen yet
     */
    public static ArrayList<Integer> djikstrasAlgorithm(long max){
        long startTime = System.nanoTime();

        ArrayList<Integer> primes = new ArrayList<>();


        long endTime = System.nanoTime();
        double duration = (double) (endTime - startTime) /1000000;
        System.out.println(duration + " milliseconds to find primes less than " + max);//divide by 1000000 to get milliseconds.

        return primes;
    }
}


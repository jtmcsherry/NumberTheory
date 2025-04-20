package PrimeFinders;

import java.util.ArrayList;

public class PrimeFinders {

    public PrimeFinders(){

    }

    /*
    This is pretty slow and probably n*log(n) running times lets see if there are faster primes finding algorithms
    This method is inefficient because it is checking every number less than or equal to the square root
    of the number. So it would see if the number is divisible by 2, but then it would also check to see
    if the other multiples of two are a divisor. We would already know by the checking two that the number
    is not divisible by an even number.
     */
    public static void bruteForce(long max){
        long startTime = System.nanoTime();
        //long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        //System.out.println(startMemory);
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
        //long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        /*
        System.out.println(endMemory);
        System.out.println("Amount of memory used: " + memoryUsed);
        long memoryUsed = startMemory-endMemory;
         */
        System.out.println(numPrimes);
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

     */
    public static void trialDivision(long max){
        long startTime = System.nanoTime();

        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        boolean isPrime = true;
        for(int i = 3; i < max; i++){
            for (Integer prime : primes) {
                if(prime > Math.sqrt(i)){
                    break;
                }
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                primes.add(i);
            }
            isPrime = true;
        }
        /*
        while(iteratorValue < max){
            for (Integer prime : primes) {
                if(prime > Math.sqrt(iteratorValue)){
                    break;
                }
                if (iteratorValue % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                primes.add(iteratorValue);
            }
            isPrime = true;
            iteratorValue++;
        }

         */


        long endTime = System.nanoTime();
        double duration = (double) (endTime - startTime) /1000000;
        System.out.println(primes.size());
        System.out.println(duration + " milliseconds to find primes less than " + max);//divide by 1000000 to get milliseconds.
    }

    /*
    public static ArrayList<Integer> trialDivision(long max){
        long startTime = System.nanoTime();

        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        boolean isPrime = true;
        int iteratorValue = 3;
        while(iteratorValue < max){
            for(int i  = 0; i < primes.size(); i++){
                if(iteratorValue % primes.get(i) == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                primes.add(iteratorValue);
            }
            isPrime = true;
            iteratorValue++;
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
    public static ArrayList<Integer> seigeOfEratosthenes(long max){
        long startTime = System.nanoTime();

        ArrayList<Integer> primes = new ArrayList<>();


        long endTime = System.nanoTime();
        double duration = (double) (endTime - startTime) /1000000;
        System.out.println(duration + " milliseconds to find primes less than " + max);//divide by 1000000 to get milliseconds.

        return primes;
    }

    /*
    Doesn't work very well
     */
    public static /*ArrayList<Integer>*/void djikstrasAlgorithm(long max){
        long startTime = System.nanoTime();

        ArrayList<DjikstraPrimes> primes = new ArrayList<>();
        primes.add(new DjikstraPrimes(2));

        for(long i = 3; i < max; i++){
            for(int j = 0; j < primes.size(); j++){
                if(i < primes.get(j).getNumberLess()){
                    primes.add(new DjikstraPrimes(i));
                    break;
                }
            }
        }

        long endTime = System.nanoTime();
        double duration = (double) (endTime - startTime) /1000000;
        System.out.println(duration + " milliseconds to find primes less than " + max);//divide by 1000000 to get milliseconds.

        //return primes;
    }
}


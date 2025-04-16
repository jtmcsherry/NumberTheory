package Functions;
import java.util.ArrayList;

public class PrimeFactorization {
    private final ArrayList<PrimeFactor> factorization = new ArrayList<>();
    private final int value;

    public PrimeFactorization(int x){
        value = x;
        factor(x);
    }

    private void factor(int x) {
        PrimeFactor pf = new PrimeFactor(1, 1);
        factorization.add(pf);
        for (int i = 2; i <= x; i++) {
            if (isPrime(i) && x % i == 0) {
                pf = new PrimeFactor(i, 0);
                while (x % i == 0) {
                    pf.increaseExponent();
                    x = x/i;
                }
                factorization.add(pf);
            }
        }
    }

    public ArrayList<PrimeFactor> getFactorization(){
        return factorization;
    }

    public int getValue(){
        return value;
    }

    public static boolean isPrime(int x){
        if(x <= 1){
            return false;
        }

        for(int i = 2; i < Math.sqrt(x); i++){
            if(x % i == 0){
                return false;
            }
        }

        return true;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (PrimeFactor primeFactor : factorization) {
            sb.append(primeFactor.toString(primeFactor)).append(" ");
        }
        return sb.toString();
    }
}
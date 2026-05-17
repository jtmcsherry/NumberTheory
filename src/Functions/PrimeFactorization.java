package Functions;
import java.util.ArrayList;


/*
This class takes a number and then gets the prime factorization, it returns an array 
of type PrimeFactor, which includes the prime factor and the exponent.
*/
public class PrimeFactorization {
    private final ArrayList<PrimeFactor> factorization = new ArrayList<>();
    private final int value;

    public PrimeFactorization(int x){
        value = x;
        factor(x);
    }
    
    /*
    This function goes finds each prime factor and then adds it to the 
    ArrayList factorization, it starts out by getting all of the factors that are 2 out.
    */
    private void factor(int x) {
        int n = x;
        int exponent = 0;

        while(n % 2 ==0){
            exponent++;
            n /= 2;
        }
        
        if(exponent > 0){
            factorization.add(new PrimeFactor(2, exponent));
        }
        
        for(int i = 3; i*i <= n; i += 2){
            exponent = 0;
            while(n % i ==0 ){
                exponent++;
                n /= i;
            }
            if(exponent > 0){
                factorization.add(new PrimeFactor(i, exponent));
            }
        }

        if(n > 1){
            factorization.add(new PrimeFactor(n, 1));
        }
    }

    public ArrayList<PrimeFactor> getFactorization(){
        return factorization;
    }

    public int getValue(){
        return value;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (PrimeFactor PF : factorization) {
            sb.append(PF.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}

/*
This is a class used by PrimeFactorization and other functions as an esay
way to store prime factors and their exponent
*/
class PrimeFactor {
    private final int value;
    private byte exponent;

    public PrimeFactor(int value, int exponent) {
        this.value = value;
        this.exponent = exponent;
    }

    public void increaseExponent() {
        exponent++;
    }

    public int getValue() {
        return value;
    }

    public byte getExponent() {
        return exponent;
    }

    @Override
    public String toString() {
        return this.value + "^" + this.exponent;
    }
}
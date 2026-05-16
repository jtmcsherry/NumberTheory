package functions;
import java.util.ArrayList;

public class LegendreSymbol {

    /*
    ToDo: Write documentation
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
}
    
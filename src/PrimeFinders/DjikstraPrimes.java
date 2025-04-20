package PrimeFinders;

public class DjikstraPrimes {
    private long prime;
    private long numberLess;

    public DjikstraPrimes(long num){
        prime = num;
        numberLess = num*num;
    }

    public long getNumberLess(){
        return numberLess;
    }

    public void increaseNumber(){
        numberLess += prime;
    }
}

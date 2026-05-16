package PrimeFinders;

public class DijkstraPrimes {
    private long prime;
    private long numberLess;

    public DijkstraPrimes(long num){
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

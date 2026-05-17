package mathcircles;

public class Main {
    public static void main(String[] args) {
        CollatzConjecture cc = new CollatzConjecture(1000000);
        cc.findMaxChain();

        LychrelNumbers ln = new LychrelNumbers(10000);
        System.out.println("The number of Lychrel Numbers below 10,000 is " + ln.numLychrel());
    }
}

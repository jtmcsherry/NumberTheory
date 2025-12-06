package MathCircles;

public class Main {
    public static void main(String[] args) {
        CollatzConjecture CC = new CollatzConjecture(1000000);
        CC.findMaxChain();

        LychrelNumbers LN = new LychrelNumbers(10000);
        System.out.println("The number of Lychrel Numbers below 10,000 is " + LN.numLychrel());
    }
}

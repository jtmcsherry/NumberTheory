package MathCircles;

public class CollatzConjecture {
    int max;

    public CollatzConjecture(int max){
        this.max = max;
    }

    public static int Collatz(int value){
        long longValue = value;
        int length = 1;

        while(longValue != 1){
            if(longValue % 2 == 0){
                longValue = longValue/2;
            }else{
                longValue = (3 * longValue) + 1;
            }
            length++;
        }
        return length;
    }

    public void findMaxChain(){
        int maxChainLength = 0;
        int maxChainValue = 0;
        int temp;
        for(int i = 1; i < max; i++){
            temp = Collatz(i);
            if(temp > maxChainLength){
                maxChainLength = temp;
                maxChainValue = i;
            }
        }

        System.out.println("The number in range 0-" + max + " is " + maxChainValue + " with a chain length of " + maxChainLength);
    }
}

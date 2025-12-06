package MathCircles;

import java.math.BigInteger;

public class LychrelNumbers {
    int max;

    public LychrelNumbers(int max){
        this.max = max;
    }

    private boolean isLychrelNumber(long value){
        BigInteger number = BigInteger.valueOf(value);
        for(int i = 0; i < 50; i++){
            number = number.add(reverseNumber(number));
            if(isPalindrome(number)){
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(BigInteger value){
        String number = value.toString();
        String reverse = new StringBuilder(number).reverse().toString();

        return number.equals(reverse);
    }

    private BigInteger reverseNumber(BigInteger value){
        String number = value.toString();
        String reverse = new StringBuilder(number).reverse().toString();

        return new BigInteger(reverse);
    }

    public int numLychrel(){
        int numLychrelNumbers = 0;
        for(int i = 1; i < max; i++){
            if(isLychrelNumber(i)){
                numLychrelNumbers++;
            }
        }

        return numLychrelNumbers;
    }
}

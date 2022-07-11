package kyu6;

import java.math.BigInteger;

public class IsANumberPrime {

    // https://www.codewars.com/kata/5262119038c0985a5b00029f/train/java

    // all test passed! - run into problem as follows: Execution Timed Out (16000 ms)
    public static boolean isPrime(int num) {
        // return false; //TODO
        if (num <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < num; i++)
            if (num % i == 0)
                return false;

        return true;
    }

    public static boolean isPrime2(int number) {
        if(number < 2)
            return false;
        for (int i=2; i<=Math.sqrt(number); i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrime3(int num) {
        return num > 1 && java.math.BigInteger.valueOf(num).isProbablePrime(20);
    }

    public static boolean isPrime4(int num) {

        if (num < 2) { return false; }

        BigInteger result = BigInteger.valueOf(num);
        return result.isProbablePrime((int)Math.log(num));
    }
}

package kyu8;

import java.util.Arrays;

public class SumArrays {

    // https://www.codewars.com/kata/53dc54212259ed3d4f00071c/solutions/java

    public static double sum(double[] numbers) {
        double sum = 0.0;
        if (numbers.length != 0 || numbers != null) {
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            return sum;
        }
        return sum;
    }

    public static double sum2(double[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static double sum3(double[] numbers) {
        double result = 0;
        for(double value : numbers){result += value;}
        return result;
    }
}

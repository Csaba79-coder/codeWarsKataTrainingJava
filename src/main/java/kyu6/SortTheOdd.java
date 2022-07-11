package kyu6;

import java.util.*;
import java.util.stream.IntStream;

public class SortTheOdd {

    // https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/train/java

    public static int[] sortArray(int[] array) {
        int min;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
            } else {
                for (int j = i; j < array.length; j++) {
                    if (array[j] % 2 == 0) {
                    } else {
                        if (array[i] > array[j]) {
                            min = array[j];
                            array[j] = array[i];
                            array[i] = min;
                        }
                    }
                }
            }
        }
        return array;
    }

    public static int[] sortArray2(int[] array) {
        PrimitiveIterator.OfInt sortedOdds = IntStream
                .of(array)
                .filter(i -> i % 2 == 1)
                .sorted()
                .iterator();

        return IntStream
                .of(array)
                .map(i -> i % 2 == 0 ? i : sortedOdds.nextInt())
                .toArray();
    }

    public static int[] sortArray3(int[] array) {
        for(int i=0 ; i<array.length-1 ; i++){
            for(int j=i+1; j<array.length ; j++){
                if(array[i]>array[j] && array[i]%2 == 1 && array[j]%2 == 1){
                    int aux=array[i];
                    array[i]=array[j];
                    array[j]=aux;
                }
            }
        }
        return array;
    }

    public static int[] sortArray4(int[] array) {
        ArrayList<Integer> oddList = new ArrayList<>(array.length);
        for (int k : array) {
            if (k % 2 == 1) {
                oddList.add(k);
            }
        }
        Collections.sort(oddList);

        for (int i = 0, j = 0; i < oddList.size(); i++, j++) {
            while (array[j] % 2 == 0) {
                j++;
            }
            array[j] = oddList.get(i);
        }
        return array;
    }

    public static int[] sortArray5(final int[] array) {
        final Iterator<Integer> sortedOdds = IntStream.of(array)
                .filter(SortTheOdd::isOdd)
                .sorted()
                .iterator();
        return IntStream.of(array)
                .map(n -> isOdd(n) ? sortedOdds.next() : n)
                .toArray();
    }

    public static boolean isOdd(final int n) {
        return n % 2 != 0;
    }

    public static int[] sortArray6(int[] array) {
        if (array.length == 0)
            return array;

        // linear sort skipping even numbers.
        for (int i=0; i<array.length; i++) {
            if (array[i] % 2 != 0) {
                for (int j=0; j<i; j++) {
                    if (array[j] % 2 != 0 && array[j] > array[i]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }

        return array;
    }

    static int[] sortArray7(final int[] array) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                indices.add(i);
                odds.add(array[i]);
            }
        }
        odds.sort(Integer::compareTo);
        for (int i = 0; i < indices.size(); i++) {
            array[indices.get(i)] = odds.get(i);
        }
        return array;
    }
}

package Kyu6;

public class SortTheOdd {

    // https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/train/java

    public static int[] sortArray(int[] array) {
        int min = 0;
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
}

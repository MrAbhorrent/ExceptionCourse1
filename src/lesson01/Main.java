package lesson01;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int[] someArray = {3, 5, 9, 4, 1, 5, 2, -1, 0};
    private static int[] someArray2 = {1, 3, 4, 5};
    private static int[] someArray3 = {5, 3, 2, 1};
    private static int[] someArray4 = {5, 3};
    private static int[][] someArray2D = new int[][] {
            {1, 0, 1},
            {0, 0, 1},
            {1, 1, 0}
    };
    private static int findValue;

    public static void main(String[] args) {
        System.out.println("Поиск в массиве значения");
        findValue = 5;
//        System.out.printf("Результат поиска числа %s в массиве: %s%n", findValue, findNumberInArray(someArray, findValue));
//        System.out.printf("Результат поиска числа %s в массиве: %s%n", findValue, findNumberInArray(new int[]{2,4}, findValue));
        System.out.println("========================================================");
//        System.out.println(sumArray2D(someArray2D));
//        System.out.println(sumArray2D(new int[][]{{1, 0, 1, 2},{1, 0, 1, 0, 2}, {3, 4, 2, 1}, {1}}));
        System.out.println("========================================================");
//        checkArray(new Integer[] {1, 2, null, 4, 5});
        System.out.println(Arrays.toString(sumTwoArray(someArray2, someArray3)));
        System.out.println(Arrays.toString(sumTwoArray(someArray2, someArray4)));

    }

    private static int sumArray2D(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length != array[i].length) {
                throw new RuntimeException("Массив не квадрантный");
            }
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1) {
                    throw new RuntimeException("Элемент не равен 0 или 1");
                }
                sum += array[i][j];
            }
        }
        return sum;
    }

    private static void checkArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            try {
                if (array[i] == null) throw new NullPointerException(String.format("Элемент с индексом %s равен null", i));
            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }
        }
    }

    private static int[] sumTwoArray(int[] array1, int[] array2) {
        int[] result = null;
        try {
            if (array1.length != array2.length) {
                throw new CheckArrayException(array1.length, array2.length);
            }
            result = new int[array1.length];
            for (int i = 0; i < array1.length; i ++) {
                result[i] = array1[i] + array2[i];
            }
            return result;
        } catch (CheckArrayException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int findNumberInArray(int[] array, int findValue) {

        if (array == null) {
            return -3;
        }
        if (array.length < 3 ) {
            return  -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findValue) {
                return i;
            }
        }
        return  -2;
    }
}

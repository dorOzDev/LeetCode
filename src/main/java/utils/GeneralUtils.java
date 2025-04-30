package utils;

import java.util.Arrays;

public class GeneralUtils {

    public static void print2DArray(int[][] mat) {
        System.out.println("-------------------------------------");
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------------------------------");
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}

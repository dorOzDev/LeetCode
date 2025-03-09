package topinterview150.medium.twosum167;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];

        for(int i = 0; i < numbers.length; ++i) {
            int elem = target - numbers[i];
            int index = Arrays.binarySearch(numbers, elem);
            if(index >= 0) {
                if(index == i && index > 0 && numbers[index - 1] == elem) {
                    return new int[] {index + 1, i + 2};
                } else if(index == i && index < numbers.length - 1 && numbers[index + 1] == elem) {
                    return new int[] {i + 1, index + 2};
                }

                return new int[] {i + 1, index + 1};
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2, 4};

        int index = Arrays.binarySearch(arr, -3);
        System.out.println();
    }

}

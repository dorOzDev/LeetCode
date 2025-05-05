package topinterview150.medium.twosum167;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[] {left + 1, right + 1};
            } else if(numbers[left] + numbers[right] > target) {
                right--;
            } else if(numbers[left] + numbers[right] < target) {
                left++;
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2, 4};

        int index = Arrays.binarySearch(arr, -3);
        System.out.println();
    }

}

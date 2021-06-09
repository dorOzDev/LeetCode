package leetcode.junecontest;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class JumpGameVI {

    public static void main(String[] args) {

        int[] arr = {-123};
        int k = 7;
        System.out.println(Solution.maxResult(arr, k));
    }

    static class Solution {

        static TreeSet<Integer> maxHeapSort = new TreeSet<>(Collections.reverseOrder());

        public static int maxResult(int[] nums, int k) {

            int[] maxCostArr = new int[nums.length];
            int maxAllowedJump = Math.min(k, Math.max(nums.length - 1, 1));
            HashMap<Integer, Integer> mapValueToInsertionTime = new HashMap<>();

            maxCostArr[0] = nums[0];
            maxHeapSort.add(nums[0]);
            mapValueToInsertionTime.put(nums[0], 0);
            // Base case for the min array. Basing the first k elements min cost;
            for(int i = 1; i < maxAllowedJump; ++i) {
                int currMax = maxHeapSort.first() + nums[i];
                maxCostArr[i] = currMax;
                maxHeapSort.add(maxCostArr[i]);
                mapValueToInsertionTime.put(currMax, i);
            }

            for(int i = maxAllowedJump; i < nums.length; ++i) {
                int currMax = maxHeapSort.first() + nums[i];
                maxCostArr[i] = currMax;
                if(mapValueToInsertionTime.get(maxCostArr[i - maxAllowedJump]) == i - maxAllowedJump) {
                    maxHeapSort.remove(maxCostArr[i - maxAllowedJump]);
                }

                maxHeapSort.add(currMax);
                mapValueToInsertionTime.put(currMax, i);
            }


            return maxCostArr[maxCostArr.length - 1];
        }

        private static void printIntArray(int[] arr) {

            for(int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();
        }
    }
}

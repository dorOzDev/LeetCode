package topinterview150.easy.removeelement;

import java.util.*;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int k = 0;
        while (left <= right) {
            if (nums[left] == val) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    k++;
                    left++;
                }
                right--;
            } else {
                left++;
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        new Solution().removeElement(new int[]{3,2,2,3},3);
    }
}

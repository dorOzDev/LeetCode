package dailyquestions.medium;

import java.util.Arrays;

public class Solution {

    public int partitionArray(int[] nums, int k) {
        int counter = 1;
        Arrays.sort(nums);
        int currMax = nums[0];
        for (int num : nums) {
            if (num - currMax > k) {
                counter++;
                currMax = num;
            }
        }

        return counter;
    }
}

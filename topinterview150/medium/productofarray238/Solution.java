package topinterview150.medium.productofarray238;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);

        int left = 1;
        for(int i = 1; i < nums.length; ++i) {
            left *= nums[i - 1];
            ans[i] = left;
        }

        int right = 1;
        for(int i = nums.length - 1; i >= 0; --i) {
            ans[i] = ans[i] * right;
            right *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().productExceptSelf(new int[]{1,2,3,0,4,5});
    }
}
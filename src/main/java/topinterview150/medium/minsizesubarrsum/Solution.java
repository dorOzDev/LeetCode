package topinterview150.medium.minsizesubarrsum;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums[0] >= target ? 1 : Integer.MAX_VALUE;

        int leftIndex = 0;
        int currentSum = nums[0];

        for(int rightIndex = 1; rightIndex < nums.length; ++rightIndex) {
            currentSum += nums[rightIndex];
            if(currentSum >= target) {
                int localSubSum = currentSum;
                while(leftIndex <= rightIndex && localSubSum >= target) {
                    localSubSum -= nums[leftIndex];
                    ans = Math.min(ans, rightIndex - leftIndex + 1);
                    leftIndex++;
                }

                currentSum = localSubSum;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
}

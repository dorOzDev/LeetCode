package topinterview150.medium.houserobber;

public class Solution {

    public int rob(int[] nums) {

        int prev = 0;
        int curr = 0;


        for(int i = 0; i < nums.length; ++i) {
            int tempMax = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = tempMax;
        }

        return curr;
    }
}

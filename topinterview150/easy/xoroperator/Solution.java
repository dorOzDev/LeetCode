package topinterview150.easy.xoroperator;

public class Solution {

    public int singleNumber(int[] nums) {
        int item = 0;
        for(int i = 0; i < nums.length; ++i) {
            item ^= nums[i];
        }

        return item;
    }
}

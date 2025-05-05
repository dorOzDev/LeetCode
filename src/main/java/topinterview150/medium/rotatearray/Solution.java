package topinterview150.medium.rotatearray;

public class Solution {

    public void rotate(int[] nums, int k) {

        int writeIndex;
        int writeValue = nums[0];
        int readIndex = 0;

        for(int i = 0; i < nums.length; ++i) {
            writeIndex = (readIndex + k) % nums.length;
            int keepOverriddenValue = nums[writeIndex];
            readIndex = writeIndex;
            nums[writeIndex] = writeValue;
            writeValue = keepOverriddenValue;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,99,-1,-100};
        new Solution().rotate(nums, 2);
    }
}

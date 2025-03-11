package topinterview150.medium.rotatearray;

public class Solution {

    public void rotate(int[] nums, int k) {
        int[] newNums = new int[nums.length];

        for(int i = 0; i < nums.length; ++i) {
            int writeIndex = (i + k) % nums.length;
            newNums[writeIndex] = nums[i];
        }

        for(int i = 0; i < nums.length; ++i) {
            nums[i] = newNums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
        System.out.println();
    }
}

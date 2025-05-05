package topinterview150.hard.trappingrainwater;

public class Solution {

    public int trap(int[] height) {
        int trappedWater = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];

        while(left < right) {
            if(maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                trappedWater += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                trappedWater += maxRight - height[right];
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int water = new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println();
    }
}

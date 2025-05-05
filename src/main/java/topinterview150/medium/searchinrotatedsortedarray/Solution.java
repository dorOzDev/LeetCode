package topinterview150.medium.searchinrotatedsortedarray;

import java.util.Arrays;

public class Solution {

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int ans = -1;
        if(nums[pivot] <= target && target <= nums[nums.length - 1]) {
            ans = Arrays.binarySearch(nums, pivot, nums.length, target);
        } else if(pivot > 0 && nums[0] <= target && target <= nums[pivot - 1]) {
            ans = Arrays.binarySearch(nums, 0, pivot, target);
        }

        return Math.max(ans, -1);
    }

    private int findPivot(int[] nums) {
        int end = nums.length - 1;
        int start = 0;

        while(start < end) {
            int mid = (end + start ) / 2;
            if(nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }


        return start;
    }
}

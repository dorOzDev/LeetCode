package topinterview150.hard.slidingwindowmaximum;

import java.util.Collections;
import java.util.TreeMap;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length -k + 1];
        ans[0] = nums[0];
        TreeMap<Integer, Integer> slidingWindow = new TreeMap<>(Collections.reverseOrder());
        int writeIndex = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(i < k) {
                Integer counter = slidingWindow.getOrDefault(nums[i], 0);
                counter++;
                slidingWindow.put(nums[i], counter);
                ans[0] = Math.max(ans[0], nums[i]);
            } else {
                Integer counter = slidingWindow.get(nums[i - k]);
                counter--;
                if(counter == 0) {
                    slidingWindow.remove(nums[i - k]);
                } else {
                    slidingWindow.put(nums[i - k], counter);
                }
                counter = slidingWindow.getOrDefault(nums[i], 0);
                counter++;
                slidingWindow.put(nums[i], counter);
                writeIndex++;
                ans[writeIndex] = slidingWindow.firstKey();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5);
        System.out.println();
    }
}

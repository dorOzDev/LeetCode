package topinterview150.easy.twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            if(seen.containsKey(nums[i])) {
                return new int[] {i, seen.get(nums[i])};
            }
            seen.put(target - nums[i], i);
        }

        return new int[]{-1, -1};
    }
}

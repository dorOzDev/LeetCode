package leetcode.junecontest;

import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] arr = { 4,200,1,3,2 };
        System.out.println(Solution.longestConsecutive(arr));
    }

    static class Solution {

        static HashSet<Integer> visited = new HashSet<>();
        static HashSet<Integer> seen = new HashSet<>();

        public static int longestConsecutive(int[] nums) {

            for(int i = 0; i < nums.length; ++i) {
                seen.add(nums[i]);
            }

            int max = 0;
            for(Integer elem : seen) {
                if(!visited.contains(elem)) {
                    max = Math.max(max, bfs(elem));
                }
            }

            return max;
        }

        private static int bfs(int elem) {

            int size = 0;
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(elem);


            while(!queue.isEmpty()) {
                int tempElem = queue.pop();
                visited.add(tempElem);
                if(seen.contains(tempElem - 1) && !visited.contains(tempElem - 1)) queue.add(tempElem - 1);

                if(seen.contains(tempElem + 1) && !visited.contains(tempElem + 1)) queue.add(tempElem + 1);

                ++size;
            }

            return size;
        }
    }
}

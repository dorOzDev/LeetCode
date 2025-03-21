package topinterview150.easy.mergesortedarray;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        for(int i = m - 1; i >= 0; --i) {
            nums1[end] = nums1[i];
            end--;
        }

        int nums1Index = n;
        int nums2Index = 0;

        for(int i = 0; i < m + n; ++i) {
            if(nums1Index < nums1.length) {
                if(nums2Index >= n || nums1[nums1Index] <= nums2[nums2Index]) {
                    nums1[i] = nums1[nums1Index];
                    nums1Index++;
                } else {
                    nums1[i] = nums2[nums2Index];
                    nums2Index++;
                }
            } else {
                nums1[i] = nums2[nums2Index];
                nums2Index++;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}

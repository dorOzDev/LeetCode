package topinterview150.medium.hindex;

public class Solution {

    public int hIndex(int[] citations) {
        int [] bucket = new int[1001];

        for(int i = 0; i < citations.length; ++i) {
            bucket[citations[i]]++;
        }

        int totalHIndex = 0;
        for(int i = bucket.length - 1; i >= 0; --i) {
            totalHIndex += bucket[i];
            if(totalHIndex >= i && bucket[i] != 0) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        new Solution().hIndex(new int[] {1, 3, 1});
    }
}

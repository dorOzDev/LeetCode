package topinterview150.hard.candy;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        candies[0] = 1;
        for(int i = 1; i < ratings.length; ++i) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for(int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        return Arrays.stream(candies).sum();
    }

    public static void main(String[] args) {
        new Solution().candy(new int[] {29,51,87,87,72,12});
    }
}

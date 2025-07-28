package topinterviewquestions.design.shuffleanarray;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] origin;
    int[] shuffledArray;
    Random random = new Random();

    public Solution(int[] nums) {
        origin = nums;
        shuffledArray = Arrays.copyOf(origin, origin.length);

    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        for(int i = 0; i < shuffledArray.length; ++i) {
            int indexToFill = shuffledArray.length - i - 1;
            int randIndex = random.nextInt(indexToFill + 1);
            int temp = shuffledArray[indexToFill];
            shuffledArray[indexToFill] = shuffledArray[randIndex];
            shuffledArray[randIndex] = temp;

        }
        return shuffledArray;
    }
}

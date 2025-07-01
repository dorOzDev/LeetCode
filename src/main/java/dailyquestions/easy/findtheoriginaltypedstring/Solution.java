package dailyquestions.easy.findtheoriginaltypedstring;

public class Solution {

    public int possibleStringCount(String word) {
        int counter = 1;
        for(int i = 0; i < word.length() - 1; ++i) {
            if(word.charAt(i) == word.charAt(i + 1)) {
                counter++;
            }
        }
        return counter;
    }
}

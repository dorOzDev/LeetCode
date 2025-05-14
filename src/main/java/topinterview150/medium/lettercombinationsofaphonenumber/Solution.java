package topinterview150.medium.lettercombinationsofaphonenumber;

import java.util.*;

public class Solution {

    public static final Map<Character, Set<String>> PHONE_MAP = Map.of(
            '2', Set.of("a", "b", "c"),
            '3', Set.of("d", "e", "f"),
            '4', Set.of("g", "h", "i"),
            '5', Set.of("j", "k", "l"),
            '6', Set.of("m", "n", "o"),
            '7', Set.of("p", "q", "r", "s"),
            '8', Set.of("t", "u", "v"),
            '9', Set.of("w", "x", "y", "z")
    );

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        Queue<Character> digitQueue = new LinkedList<>();

        for(Character digit : digits.toCharArray()) {
            digitQueue.add(digit);
        }

        List<String> ans = new ArrayList<>(PHONE_MAP.get(digitQueue.poll()));
        while(!digitQueue.isEmpty()) {
            Character digit = digitQueue.poll();
            List<String> tempAns = new ArrayList<>();
            for(String combination : ans) {
                for(String charVal : PHONE_MAP.get(digit)) {
                    tempAns.add(combination + charVal);
                }
            }

            ans = tempAns;
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().letterCombinations("23");
    }
}

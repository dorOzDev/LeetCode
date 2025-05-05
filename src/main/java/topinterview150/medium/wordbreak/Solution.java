package topinterview150.medium.wordbreak;

import java.util.*;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Character, Set<String>> dictionary = new HashMap<>();

        for(String word : wordDict) {
            Set<String> wordSet = dictionary.getOrDefault(word.charAt(0), new HashSet<>());
            wordSet.add(word);
            dictionary.put(word.charAt(0), wordSet);
        }

        Set<String> emptySet = Collections.emptySet();
        for(int i = 0; i < s.length(); ++i) {
            for(int j = i ; j < s.length(); ++j) {
                String substring = s.substring(i, j);
                Set<String> wordSet = dictionary.getOrDefault(s.charAt(i), emptySet);
                boolean isContainSubStr = wordSet.contains(substring);

            }
        }

        return false;
    }
}

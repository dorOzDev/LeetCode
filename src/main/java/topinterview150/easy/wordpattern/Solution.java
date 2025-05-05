package topinterview150.easy.wordpattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> mapWordToCharacter = new HashMap<>();
        Map<Character, String> mapCharacterToWord = new HashMap<>();
        String[] split = s.split(" ");

        if(split.length != pattern.length()) {
            return false;
        }

        for(int i = 0; i < pattern.length(); ++i) {
            Character c = mapWordToCharacter.putIfAbsent(split[i], pattern.charAt(i));
            String s1 = mapCharacterToWord.putIfAbsent(pattern.charAt(i), split[i]);

            if(c != null && c != pattern.charAt(i)) {
                return false;
            }

            if(s1 != null && !s1.equals(split[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().wordPattern("abba", "dog dog dog dog");
    }
}

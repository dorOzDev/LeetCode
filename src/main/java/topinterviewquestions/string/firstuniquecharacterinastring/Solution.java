package topinterviewquestions.string.firstuniquecharacterinastring;

import java.util.*;

public class Solution {

    public int firstUniqChar(String s) {
        int index = Integer.MAX_VALUE;
        Map<Character, UniqueCharacter> map = new HashMap<>();

        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            UniqueCharacter uniqueCharacter = map
                    .getOrDefault(ch, new UniqueCharacter(i, 0))
                    .incrementCounter();
            map.put(ch, uniqueCharacter);
        }

        for(Map.Entry<Character, UniqueCharacter> entry : map.entrySet()) {
            if(entry.getValue().counter == 1 && entry.getValue().index < index) {
                index = entry.getValue().index;
            }
        }

        return index != Integer.MAX_VALUE ? index : -1;
    }

    private static class UniqueCharacter {
        int index;
        int counter;

        public UniqueCharacter(int index, int counter) {
            this.index = index;
            this.counter = counter;
        }

        public UniqueCharacter incrementCounter() {
            counter++;
            return this;
        }

        public int getIndex() {
            return index;
        }

        public int getCounter() {
            return counter;
        }
    }

    public static void main(String[] args) {
        int index = new Solution().firstUniqChar("ll");
        System.out.println(index);
    }
}

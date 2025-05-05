package topinterview150.medium.groupanagram;

import java.util.*;


public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> anagrams = new HashMap();
        for(int i = 0; i < strs.length; ++i) {
            int[] frequencyArr = generateFrequencyArray(strs[i]);
            int hash = Arrays.hashCode(frequencyArr);
            List<String> anagramList = anagrams.getOrDefault(hash, new ArrayList<>());
            anagramList.add(strs[i]);
            anagrams.put(hash, anagramList);
        }

        return anagrams.values().stream().toList();
    }

    private static int[] generateFrequencyArray(String str) {
        int[] frequencyArr = new int[26];
        for(int i = 0; i < str.length(); ++i) {
            frequencyArr[str.charAt(i) - 'a']++;
        }

        return frequencyArr;
    }
}

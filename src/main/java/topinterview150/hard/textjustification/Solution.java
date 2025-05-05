package topinterview150.hard.textjustification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> currentRow = new ArrayList<>();
        int currentRowSize = 0;
        for(int i = 0; i < words.length; ++i) {
            if(currentRowSize + words[i].length() < maxWidth) {
                currentRowSize += words[i].length();
                currentRow.add(words[i]);
            } else {
                StringBuilder rowBuilder = new StringBuilder();
                int extraSpace = maxWidth - currentRowSize;
                int evenlyDistributedSpace = currentRow.size() - 1 > 0 ? extraSpace / (currentRow.size() - 1) : 0;
                int remainder = currentRow.size() - 1 > 0 ? extraSpace % (currentRow.size() - 1) : 0;
                for(int j = 0; j < currentRow.size(); ++j) {
                    rowBuilder.append(currentRow.get(j));
                    int totalSpace = j < (currentRow.size() - 1) ? evenlyDistributedSpace + Math.min(1, remainder) : 0;
                    rowBuilder.append(String.join("", Collections.nCopies(totalSpace, " ")));
                    remainder = Math.max(remainder - 1, 0);
                }

                ans.add(rowBuilder.toString());
                currentRowSize = 0;
                currentRow.clear();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().fullJustify(new String[] {"What","must","be","acknowledgment","shall","be"}, 16);
    }
}

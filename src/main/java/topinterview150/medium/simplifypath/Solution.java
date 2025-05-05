package topinterview150.medium.simplifypath;

import java.util.Stack;

public class Solution {

    public static final String BACK_SLASH = "/";

    public String simplifyPath(String path) {
        String[] split = path.split(BACK_SLASH);
        Stack<String> dirsStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int countParentDirs = 0;
        for(int i = split.length - 1; i >= 0; --i) {
            String currentStr = split[i];
            if(currentStr.equals(".") || currentStr.isEmpty()) {
                // do nothing
            } else if(currentStr.equals("..")) {
                countParentDirs++;
            } else {
                if (countParentDirs == 0) {
                    dirsStack.push(currentStr);
                } else {
                    countParentDirs--;
                }
            }
        }

        if(dirsStack.isEmpty()) {
            sb.append(BACK_SLASH);
        }

        while(!dirsStack.isEmpty()) {
            sb.append(BACK_SLASH);
            sb.append(dirsStack.pop());
        }

        return  sb.toString();
    }

    public static void main(String[] args) {
        new Solution().simplifyPath("/home/");
    }
}

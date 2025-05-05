package topinterview150.medium.validsudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    private static final Character EMPTY_CELL = '.';

    public boolean isValidSudoku(char[][] board) {

        HashMap<Integer, Set<Character>> seenSubBox = new HashMap<>();

        for(int row = 0; row < 9; ++row) {
            Set<Character> rowSeen = new HashSet<>();
            Set<Character> colSeen = new HashSet<>();
            for(int col = 0; col < 9; ++col) {
                char currentRowCell = board[row][col];
                if(currentRowCell != EMPTY_CELL) {
                    if(rowSeen.contains(currentRowCell)) {
                        return false;
                    }
                    rowSeen.add(currentRowCell);
                }

                char currentColCell = board[col][row];
                if(currentColCell != EMPTY_CELL) {
                    if(colSeen.contains(currentColCell)) {
                        return false;
                    }
                    colSeen.add(currentColCell);
                }

                int subBoxIndex = (row / 3) * 3 + col / 3;
                Set<Character> seenSet = seenSubBox.getOrDefault(subBoxIndex, new HashSet<>());
                seenSubBox.put(subBoxIndex, seenSet);
                char currentCell = board[row][col];
                if(currentCell != EMPTY_CELL) {
                    if(seenSet.contains(currentCell)) {
                        return false;
                    }
                    seenSet.add(currentCell);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean validSudoku = new Solution().isValidSudoku(board);
    }
}

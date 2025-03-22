package src.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem34_ValidSuDoku {
    public static void main(String[] args)
    {
        Problem34_ValidSuDoku obj=new Problem34_ValidSuDoku();
        char[][] board1=new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
System.out.println(obj.isValidSudoku(board1));

    }
    public boolean isValidSudoku(char[][] board) {
        if (board == null)
            return false;

        boolean isValidSudoku = true;

        int size = board.length;
        Map<Character, Set<Integer>> rowPosition = new HashMap<>();
        Map<Character, Set<Integer>> colPosition = new HashMap<>();
        Map<Character,Set<Integer>> boxPosition=new HashMap<>();
        //i is row and j is col
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char val = board[i][j];
                Set<Integer> rowSet = rowPosition.getOrDefault(val, new HashSet<Integer>());
                Set<Integer> colSet = colPosition.getOrDefault(val, new HashSet<Integer>());
                Set<Integer> boxSet=boxPosition.getOrDefault(val,new HashSet<>());

                if(val!='.') {
                    if (rowSet.contains(i)) {
                        return false;
                    } else {
                        if (rowSet.size() == 0) {
                            rowSet.add(i);
                            rowPosition.put(val, rowSet);
                        } else {
                            rowPosition.get(val).add(i);
                        }
                    }

                    if (colSet.contains(j)) {
                        return false;
                    } else {
                        if (colSet.size() == 0) {
                            colSet.add(j);
                            colPosition.put(val, colSet);
                        } else {
                            colPosition.get(val).add(j);
                        }
                    }
                    int boxNumber=((i/3)*3)+(j/3);
                    if(boxSet.contains(boxNumber))
                    {
                        return false;
                    }
                    else
                    {
                        if(boxSet.size()==0)
                        {
                            boxSet.add(boxNumber);
                            boxPosition.put(val,boxSet);
                        }
                        else
                        {
                            boxPosition.get(val).add(boxNumber);
                        }
                    }
                }
            }
        }

        return isValidSudoku;
    }
}

package src.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSuDoku {
	
	public static void main(String args[])
	{
		char board[][]=new char[][] 
			{{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},
				{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},
				{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
				
			ValidSuDoku obj=new ValidSuDoku();
			System.out.println(obj.isValidSudoku(board));
	}
	//TODO: Incorrect. Needs to be fixed
	 public boolean isValidSudoku(char[][] board) {
	    Map<Character,List<Integer>> rowMap=new HashMap<>();
	    Map<Character,List<Integer>> colMap=new HashMap<>();

	    for(int i=0;i<board.length;i++)
	    {
	    	for(int j=0;j<board[i].length;j++)
	    	{
	    		  if(board[i][j]=='.')
	                    continue;
	    		  
	    		if(rowMap.containsKey(board[i][j])||colMap.containsKey(board[i][j]))
	    		{
	    			if(rowMap.containsKey(board[i][j]) && rowMap.get(board[i][j]).contains(i))
	    				return false;
	    			
	    			if(colMap.containsKey(board[i][j]) && colMap.get(board[i][j]).contains(j))
	    				return false;	
	    		}
	    		rowMap.computeIfAbsent(board[i][j],k->new ArrayList()).add(i);
    			colMap.computeIfAbsent(board[i][j],k->new ArrayList()).add(j);
	    	}
	    }
	    
	    return true;
	    }
	}

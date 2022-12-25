package src.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
public static void main(String[] args)
{
	NQueen obj=new NQueen();
	System.out.println(obj.solveNQueens(5));
}

public List<List<String>> solveNQueens(int n) {
 

List<List<String>> queen=new ArrayList<>();
		int [][] arr=new int[n][n];
	if(isNQueen(arr,n,0,0,queen))
	{
		//printNQueen(arr,n);
	}
return queen;
}

public boolean isNQueen(int[][] arr, int n,int row,int count,List<List<String>> queen)
{
	boolean isQueen=false;
	if(count==n)
	{
		//save queen and reset arr for next loop iteration
		List<String> output=new ArrayList();
		for(int rowNum=0;rowNum<n;rowNum++)
		{
			StringBuilder str=new StringBuilder();
			for(int colNum=0;colNum<n;colNum++)
			{
				if(arr[rowNum][colNum]==0)
					str.append(".");
				else
					str.append("Q");
			}
			output.add(str.toString());
		}
		queen.add(output);
		return true;
	}
	if(row>=n)
		return false;
	
	for(int i=0;i<n;i++)
	{
		if(isQueenSafe(arr,n,row,i))
		{
			arr[row][i]=1;
			if(isNQueen(arr,n,row+1,count+1,queen))
			{
				isQueen= true;
				arr=new int[n][n];
				count=0;
			}
			else
			{
				arr[row][i]=0;
			}
		}
	}
return isQueen;	
}

public boolean isQueenSafe(int[][] arr,int n, int row, int col)
{
	//same row check
	for(int i=row-1;i>=0;i--)
	{
		if(arr[i][col]==1)
			return false;
	}
	
	//diagonal left check
	for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
	{
		if(arr[i][j]==1)
			return false;
	
	}	
	//diagonal right check
	for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++)
	{
		if(arr[i][j]==1)
			return false;
	
	}	

	return true;
}

public void printNQueen(int [][] arr,int n)
{
	System.out.println("============N Queen============");
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			System.out.print(arr[i][j]+"  ");
		}
		System.out.println();
	}
}
}

package src.leetcode.medium;

import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][]matrix=new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		SpiralMatrix obj=new SpiralMatrix();
		obj.printSpiralTraversal(matrix);
	}

    public List<Integer> spiralOrder(int[][] matrix) {
        
    	return null;
    }

    public void printSpiralTraversal(int[][] matrix)
    {
    	int rowSize=matrix.length;
    	int colSize=matrix[0].length;
    	for(int i=0,j=rowSize-1; j>=0;j--,i++)
    	{
    		//print right
    		for(int k=i;k<j;k++)	
    		{
    			System.out.print(matrix[i][k]+" ");
    		}
    		//print down
    		for(int k=i;k<j;k++)
    		{
    			System.out.print(matrix[k][j]+" ");
    		}
    		//print left
    		for(int k=j;k>i;k--)
    		{
    			System.out.print(matrix[j][k]+" ");
    		}
    		//print up
    		for(int k=j;k>i;k--)
    		{
    			System.out.print(matrix[k][i]+" ");
    		}
    	}
    }
}

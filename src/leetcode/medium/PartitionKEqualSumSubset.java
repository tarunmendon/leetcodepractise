package src.leetcode.medium;

import java.util.Arrays;

public class PartitionKEqualSumSubset {

	public static void main(String args[])
	{
		int nums[] = new int[] {2,1,5,5,6};
		int k = 3;
		PartitionKEqualSumSubset obj=new PartitionKEqualSumSubset();
		System.out.println(obj.canPartitionKSubsets(nums, k));
		
	}
	
	public boolean canPartitionKSubsets(int[] nums, int k)
	{
		if(nums==null)
			return false;
		
		int total=Arrays.stream(nums).sum();
		
		if(total%2!=0)
			return false;
		int weight=total/k;
		int t[][]=new int[nums.length+1][weight+1];
		int count=countsubsetsum(nums,nums.length,weight,0,t);
		System.out.println("Count:"+count);
		if(count>=k)
			return true;
		else 
			return false;
	}
	public int countsubsetsum(int[] arr,int N,int weight,int pos,int[][] t)
	{
		//Base Case
		if(weight==0)
			return  1;
		else if(pos>=N||weight<0)
			return 0;
		else
		{
			/*
			 * if(t[pos][weight]!=-1) return t[pos][weight];
			 */	//From Choice Diagram
			if(arr[pos]<=weight)
			t[pos][weight]= countsubsetsum(arr,N,weight-arr[pos],pos+1,t)+
					countsubsetsum(arr,N,weight,pos+1,t);
			else
				t[pos][weight]= countsubsetsum(arr,N,weight,pos+1,t);

		}
	return t[pos][weight];	
	}
}

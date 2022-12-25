package src.leetcode.medium;

import java.util.stream.IntStream;

public class NextPermutation {

	public static void main(String args[])
	{
		int[] nums=new int[] {1,3,2}; 
		NextPermutation obj=new NextPermutation();
		obj.nextPermutation(nums);
		IntStream.of(nums).forEach(i-> System.out.print(i+" "));
	}
	 public void nextPermutation(int[] nums) {
		 //The steps to solve this problem:
		 //1) scan from right to left, find the first element that is less than its previous one.
		 int p=-1,q=-1,temp=-1;
		 for(int i=nums.length-1;i>0;i--)
		 {
			 if(nums[i-1]<nums[i])
			 {
				 p=i-1;
				 break;
			 }
		 }	
		//reverse and return - array sorted in decreasing order
		 if(p==-1)
		 {
			 reverse(nums,0,nums.length-1);
			 return;
		 }
		 //2) scan from right to left, find the first element that is greater than p.
		 for(int i=nums.length-1;i>0;i--)
		 {
			 if(nums[i]>nums[p])
			 {
				 q=i;
				 break;
			 }
		 }	 
		 //3) swap p and q
		 swap(nums,p,q);
		 //4) reverse elements [p+1, nums.length]
		 reverse(nums,p+1,nums.length-1);
		 
	 	}
	 public void reverse(int[] nums,int i,int j)
	 {

		 while(i<j)
		 {
			 swap(nums,i,j);
			 i++;
			 j--;
		 }
	 }
	 public void swap(int[] nums, int i,int j)
	 {
		 int temp=nums[i];
		 nums[i]=nums[j];
		 nums[j]=temp;
	 }
	 }

package src.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindowMax {

	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		
		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int k = 3;
		SlidingWindowMax obj=new SlidingWindowMax();
		
		Arrays.stream(obj.maxSlidingWindow(nums, k)).forEach(i->System.out.print(i+" "));
		
		nums=new int[] {1,-1};
		k=1;
		
		System.out.println();
		//Arrays.stream(obj.maxSlidingWindow(nums, k)).forEach(i->System.out.print(i+" "));
		
		nums=new int[] {1,3,1,2,0,5};
		k=3;
		
		System.out.println();
		//Arrays.stream(obj.maxSlidingWindow(nums, k)).forEach(i->System.out.print(i+" "));
		
		nums=new int[] {9,10,9,-7,-4,-8,2,-6};
		k=5;
		//Arrays.stream(obj.maxSlidingWindow(nums, k)).forEach(i->System.out.print(i+" "));
		
		nums= new int[] {-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7};
		k=7;
		Arrays.stream(obj.maxSlidingWindow(nums, k)).forEach(i->System.out.print(i+" "));
		
		/*
		 * 
		 */
	}

	 public int[] maxSlidingWindow(int[] nums, int k) {
		 ArrayList<Integer> list=new ArrayList<>();
	        if(nums==null ||nums.length<k)
	        	throw new IllegalArgumentException("Incorrect details provided");
	        if(k==1)
	        	return nums;
	     int[] out=new int[nums.length-k+1];   
		int j=0,i=0,max=Integer.MIN_VALUE;
	        while(j<nums.length)
	        {
	        	while(list.size()>0 && list.get(list.size()-1)<nums[j])
	        		list.remove(list.size()-1);
	        	
	        	list.add(nums[j]);
        		
	        	if(j-i+1<k)
	        	{

	        	 j++;	
	        	}
	        	else if(j-i+1==k)
	        	{
	        		out[i]=list.get(0);
	        		if(list.get(0)==nums[i])
	        			list.remove(0);
	        		i++;
	        		j++;
	        	}
	        	
	        }
	        return out;
	    }
}

package src.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

	public static void main(String args[])
	{
	int[] nums = new int[] {2,7,11,15};
	int target = 9;
	TwoSum twoSum=new TwoSum();
	int[] out=new int[2];
	//out=twoSum.twoSum(nums, target);
	//	Arrays.stream(out).forEach(i->System.out.print(i+" "));
		
		System.out.println();
		out=twoSum.twoSum_tuned(new int[] {3,3}, 6);
		Arrays.stream(out).forEach(i->System.out.print(i+" "));
	}

	 public int[] twoSum(int[] nums, int target) {
		 int[] out=new int[] {-1,-1};
		 int[] idx = new int[] { 0 };
		 HashMap<Integer,List<Integer>> map=new HashMap();
		 
		 Arrays.stream(nums).forEach(num->map.computeIfAbsent(num, x->new ArrayList()).add(idx[0]++));
		 
		 
		 System.out.println(map);
			
			  for(int i=0;i<nums.length;i++)
				  if(map.containsKey(target-nums[i]) ) 
				  {
					  out[0]=i;
					  List<Integer> vals=map.get(target-nums[i]);
					  for(int val:vals)
						  if(i!=val)
							  out[1]=val;
				 }
			  
		 
		 return out;
	 }
	 
	 public int[] twoSum_tuned(int[] nums, int target) {
		 HashMap<Integer, Integer> map=new HashMap();
		 int complement=0;
		 for(int i=0;i<nums.length;i++)
		 {
			 complement=target-nums[i];
			 if(map.containsKey(complement))
			 {
				 return new int[] {map.get(complement),i};
			 }
			 map.put(nums[i],i);
		 }
		 
		 return null;
	 }
	 }

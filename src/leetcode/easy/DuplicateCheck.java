package src.leetcode.easy;

import java.util.HashSet;

public class DuplicateCheck {

	public boolean containsDuplicate(int[] nums) {
	      HashSet<Integer> set=new HashSet<>();
	        for(int i=0;i<nums.length;i++)
	        {
	            if(!set.add(nums[i]))
	                return false;
	        }
	        return true;
	    }
	
	public static void main(String[] args) {
		DuplicateCheck dupCheck=new DuplicateCheck();
		System.out.println(dupCheck.containsDuplicate(new int[] {1,2,3}));
		
	}

}

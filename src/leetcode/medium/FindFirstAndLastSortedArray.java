package src.leetcode.medium;

import java.util.stream.IntStream;

public class FindFirstAndLastSortedArray {

	public static void main(String[] args) {
		int[] nums=new int[] {1,4};
		FindFirstAndLastSortedArray obj=new FindFirstAndLastSortedArray();
		IntStream.of(obj.searchRange(nums, 4)).forEach(i->System.out.print(i+" "));
	}

    public int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1,mid=-1;
        int first=-1,last=-1;
        
        if(nums==null||nums.length==0)
            return new int[]{first,last};
        else if(nums.length==1)
        {
            if(nums[0]==target)
                return new int[]{0,0};
            else
                return new int[]{-1,-1};
        }
        while(left<=right)
        {
            mid=(left+right)/2;
            
            if(nums[mid]==target)
            {
                first=mid;last=mid;
                while(first>0 && nums[first]==nums[first-1])
                    first--;
                
                while(last<nums.length-1 && nums[last]==nums[last+1])
                    last++;
                    
              break;  
            }
            if(target<nums[mid])
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
    return new int[]{first,last};
    }

}

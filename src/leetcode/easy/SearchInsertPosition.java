package src.leetcode.easy;

public class SearchInsertPosition {

	
	public static void main(String args[])
	{
		int[] nums = new int [] {1,3,5,6};
		int target = 5;
		
		SearchInsertPosition searchPos=new SearchInsertPosition();
		System.out.println(searchPos.searchInsert(nums, target));
		System.out.println(searchPos.searchInsert(nums, 2));
		System.out.println(searchPos.searchInsert(nums, 7));
		System.out.println(searchPos.searchInsert(nums, 0));
		System.out.println(searchPos.searchInsert(new int[] {1}, 0));
		
	}
    public int searchInsert(int[] nums, int target) {
    	if(nums==null ||nums.length==0)
            return 0;

    	int right=nums.length-1;
        int left=0;
        int mid=0;
        
        while(left<=right)
        {
        	mid=(left+right)/2;
        	if(nums[mid]==target)
        		return mid;
        	else if(target>nums[mid])
        		left=mid+1;
        	else
        		right=mid-1;	
        }
        
      return right+1;  
    }
}

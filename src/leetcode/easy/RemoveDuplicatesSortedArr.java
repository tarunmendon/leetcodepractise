package src.leetcode.easy;

import java.util.stream.IntStream;

public class RemoveDuplicatesSortedArr {
	public static void main(String args[]) {
		RemoveDuplicatesSortedArr obj = new RemoveDuplicatesSortedArr();
		int[] arr=new int[] {1,1,1,2,2,3};
		// int[] arr=new int[] {1,2,3,3,4,5};
		//int[] arr = new int[] { 1, 2, 3, 4 };
		System.out.println(obj.removeDuplicates_1(arr));
		IntStream.of(arr).forEach(i -> System.out.print(i + " "));

	}

	public int removeDuplicates(int[] nums) {

		if (nums == null)
			return -1;
		else if (nums.length <= 1)
			return nums.length;

		int j = 0;

		for (int i = 0; i < nums.length - 1; i++)
			if (nums[i] != nums[i + 1])
				nums[j++] = nums[i];

		nums[j++] = nums[nums.length - 1];

		return j;
	}

	public int removeDuplicates_1(int[] nums) {
//https://www.youtube.com/watch?v=zIHe2V5Py3U
		if (nums == null)
			return -1;
		else if (nums.length <= 1)
			return nums.length;

		int index = 1;


		for (int i = 0; i < nums.length - 1; i++)
			if (nums[i] != nums[i + 1])
				nums[index++] = nums[i+1];

		return index;
	}

}

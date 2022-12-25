package src.leetcode;

import java.util.Arrays;
import java.util.List;

public class IntegerToRoman {

	public static void main(String[] args)
	{
		IntegerToRoman obj= new IntegerToRoman();
		System.out.println(obj.intToRoman(1994));
	}
	
	 public String intToRoman(int num) {
	List<String> romanSymbols=Arrays.asList("I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M");
	int nums[]=new int[] {1,4,5,9,10,40,50, 90, 100, 400, 500, 900, 1000};
	StringBuffer out=new StringBuffer();
	int i=nums.length-1;	
	while(i>=0)
	{
		if(nums[i]<=num)
		{	
			out.append(romanSymbols.get(i));
			num-=nums[i];
		}	
		else
			i--;
	}
	
	
	return out.toString();
	 }
}

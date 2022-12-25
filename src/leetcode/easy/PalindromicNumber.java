package src.leetcode.easy;

public class PalindromicNumber {

	public boolean isPalindrome(int x) {
		//We can also reverse the same number and check for palindromic case	
		boolean isPalindrome = true;
			
		if(x<0)
			return false;
		String str=""+x;
		for(int i=0;i<str.length()/2;i++)
		{
			if(str.charAt(i)!=str.charAt(str.length()-1-i))
				return false;
		}
			
		return isPalindrome;
	}

	public static void main(String[] args) {

		PalindromicNumber obj=new PalindromicNumber();
		System.out.println(obj.isPalindrome(111));
	}

}

package src.leetcode.easy;

/*
https://leetcode.com/problems/palindrome-number/description/
 */
public class PalidromeNumber {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        String str_x=""+x;
        int left=0,right=str_x.length()-1;
        while(left<=right)
        {
            if(str_x.charAt(left++)!=str_x.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

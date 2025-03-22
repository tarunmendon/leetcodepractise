package src.leetcode.easy;

public class Problem125_ValidPalindrome {

    public static void main(String[] args) {
        Problem125_ValidPalindrome obj=new Problem125_ValidPalindrome();
        String s="A man, a plan, a canal: Panama";
        System.out.println(s+" is palindrome? "+obj.isPalindrome(s));
        s="race a car";
        System.out.println(s+" is palindrome? "+obj.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        boolean isPalindrome = true;

        if (s == null)
            return false;

        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                i++;
            }

            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;

            } else {
                i++;
                j--;
            }
        }

        return isPalindrome;
    }
}

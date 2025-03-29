package src.leetcode.medium;

import java.util.Arrays;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "  hello world  ";
        ReverseWordsInAString obj = new ReverseWordsInAString();
        String out = obj.reverseWords(s);
        System.out.println(obj.reverseWords(s));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;

        String[] strList = s.split(" ");
        int left = 0, right = strList.length - 1;
        while (left < right) {
            swap(strList, left++, right--);
        }
        return Arrays.stream(strList).filter(str -> str.trim().length() > 0).reduce((str1, str2) -> str1 + " " + str2).get();
    }

    private boolean swap(String[] strList, int left, int right) {
        String temp = strList[left];
        strList[left] = strList[right];
        strList[right] = temp;
        return true;
    }
}

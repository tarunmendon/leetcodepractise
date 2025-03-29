package src.leetcode.easy;

import java.util.HashSet;

public class ReverseVowelInAString {

    public static void main(String[] args) {
        String str = "Marge, let's \"went.\" I await news telegram.";
        ReverseVowelInAString obj = new ReverseVowelInAString();
        String out = obj.reverseVowels(str);
        System.out.println("Reverse Vowel in a string:" + out);
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int right = s.length() - 1;
        char[] ch = s.toCharArray();
        for (int left = 0; left < s.length(); left++) {
            if (isVowel(ch[left])) {
                right = findNextVowel_RtoL(s, right);
                if (left < right) {
                    swap(ch, left, right);
                    right--;
                }
            }
        }
        return new String(ch);
    }

    public boolean swap(char[] ch, int left, int right) {
        char temp = ch[left];
        ch[left] = ch[right];
        ch[right] = temp;
        return true;
    }

    private int findNextVowel_LtoR(String str, int leftPos) {
        while (leftPos < str.length()) {
            if (isVowel(str.charAt(leftPos))) {
                return leftPos;
            }
            leftPos++;
        }
        return Integer.MAX_VALUE - 1;
    }

    private int findNextVowel_RtoL(String str, int rightPos) {
        while (rightPos > 0) {
            if (isVowel(str.charAt(rightPos))) {
                return rightPos;
            }
            rightPos--;
        }
        return Integer.MIN_VALUE;
    }

    private boolean isVowel(char ch) {
        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('A');
        vowelSet.add('e');
        vowelSet.add('E');
        vowelSet.add('i');
        vowelSet.add('I');
        vowelSet.add('o');
        vowelSet.add('O');
        vowelSet.add('u');
        vowelSet.add('U');
        return vowelSet.contains(ch);
    }

    public String reverseVowels_leetCode_Cleaner_Solution(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";

        while (start < end) {
            // Move start pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }

            // Move end pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }

            // Swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            // Move the pointers towards each other
            start++;
            end--;
        }

        String answer = new String(word);
        return answer;
    }
}

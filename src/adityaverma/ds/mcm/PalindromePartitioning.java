package src.adityaverma.ds.mcm;

import java.util.Arrays;

public class PalindromePartitioning {

    int palindromPartition(String s) {
        if (s == null)
            return 0;
        int i = 0, j = s.length() - 1;
        int t[][] = new int[s.length() + 1][s.length() + 1];
        for (int[] val : t) {
            Arrays.fill(val, -1);
        }
        return solve(s, i, j, t);
    }

    int solve(String s, int i, int j, int t[][]) {
        int min = Integer.MAX_VALUE;
        int left, right;
        /*
            i>j is an invalid case. Hence returning 0.
            and i==j means that its only string and no cutting required. Hence returning 0.
         */
        if (i >= j)
            return 0;
     /*   if (i == j)
            return 0;
*/
        if (isPalindrome(s, i, j))
            return 0;
        if (t[i][j] != -1)
            return t[i][j];

        for (int k = i; k <= j - 1; k++) {

            if (t[i][k] != -1) {
                left = t[i][k];
            } else {
                left = solve(s, i, k, t);
            }

            if (t[k + 1][j] != -1) {
                right = t[k + 1][j];
            } else {
                right = solve(s, k + 1, j, t);
            }

            int tmp = 1 + left + right;
            min = Math.min(tmp, min);
        }
        t[i][j] = min;
        return min;
    }


    boolean isPalindrome(String s, int i, int j) {
        if (i > j)
            return true;
        if (i == j)
            return true;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        String s = "abbaceef";
        System.out.println(obj.palindromPartition(s));
    }
}

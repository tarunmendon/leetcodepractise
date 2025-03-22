package src.adityaverma.ds.lcs;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSeq {
    Map<String, String> map_dp;

    LongestCommonSubSeq() {
        map_dp = new HashMap<String, String>();
    }

    public int lcs(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + lcs(X, Y, m - 1, n - 1);
        } else {
            return Math.max(lcs(X, Y, m - 1, n), lcs(X, Y, m, n - 1));
        }
    }

    public String lcs_print(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return "";
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return X.charAt(m - 1) + lcs_print(X, Y, m - 1, n - 1);
        } else {
            String x1 = lcs_print(X, Y, m - 1, n);
            String x2 = lcs_print(X, Y, m, n - 1);
            return x1.length() > x2.length() ? x1 : x2;
        }
    }

    public String lcs_printWithMemoization(String X, String Y, int m, int n) {
        String key = m + "," + n;
        if (m == 0 || n == 0) {
            map_dp.put(key, "");
        }
        if (map_dp.get(key) != null) {
            return map_dp.get(key);
        }

        String result = null;
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            result = X.charAt(m - 1) + lcs_printWithMemoization(X, Y, m - 1, n - 1);
            map_dp.put(key, result);
            return result;
        } else {
            String lcs1 = lcs_printWithMemoization(X, Y, m - 1, n);
            String lcs2 = lcs_printWithMemoization(X, Y, m, n - 1);
            if (lcs1.length() > lcs2.length()) {
                map_dp.put(key, lcs1);
                return lcs1;
            } else {
                map_dp.put(key, lcs2);
                return lcs2;
            }
        }
    }

    public int lcs_topDown(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] t = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            t[i][0] = 0;
        for (int j = 0; j < n + 1; j++)
            t[0][j] = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[m][n];
    }

    public static void main(String[] args) {
        String X = "abcdgh", Y = "abedfhl";
        int m = X.length(), n = Y.length();
        LongestCommonSubSeq obj = new LongestCommonSubSeq();
        System.out.println("Longest Common Subsequence:" + obj.lcs(X, Y, m, n) + " Top down:" + obj.lcs_topDown(X, Y, m, n) + " Output string:" + new StringBuilder(obj.lcs_print(X, Y, m, n)).reverse().toString() + " Output string with memoization:" + new StringBuilder(obj.lcs_printWithMemoization(X, Y, m, n)).reverse().toString());
    }
}

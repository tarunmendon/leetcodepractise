package src.adityaverma.ds.lcs;

import java.util.HashMap;
import java.util.Map;

public class ShortestCommonSuperString {

    Map<String, String> t_dp;

    ShortestCommonSuperString() {
        t_dp = new HashMap<String, String>();
    }

    public String shortestcommonsuperString_lcs(String X, String Y, int m, int n) {
        String key = m + "," + n;

        if (m == 0) {
            return Y.substring(0, n);
        }
        if (n == 0) {
            return X.substring(0, m);
        }

        if (t_dp.get(key) != null) {
            return t_dp.get(key);
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            String result = shortestcommonsuperString_lcs(X, Y, m - 1, n - 1) + X.charAt(m - 1);
            t_dp.put(key, result);
        } else {
            String lcs1 = shortestcommonsuperString_lcs(X, Y, m - 1, n) + X.charAt(m - 1);
            String lcs2 = shortestcommonsuperString_lcs(X, Y, m, n - 1) + Y.charAt(n - 1);
            if (lcs1.length() < lcs2.length()) {
                t_dp.put(key, lcs1);
            } else {
                t_dp.put(key, lcs2);
            }
        }
        return t_dp.get(key);
    }

    public static void main(String[] args) {
        ShortestCommonSuperString obj = new ShortestCommonSuperString();
        String X = "abcdgh", Y = "abedfhl";
        int m = X.length(), n = Y.length();
        String output = obj.shortestcommonsuperString_lcs(X, Y, m, n);
        System.out.println("Shortest common super seq:" + obj.shortestcommonsuperString_lcs(X, Y, m, n) + " Size:" + output.length());
    }
}

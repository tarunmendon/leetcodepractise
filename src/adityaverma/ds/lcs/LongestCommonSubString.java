package src.adityaverma.ds.lcs;

import java.util.Arrays;

public class LongestCommonSubString {

    int maxLength=0;
    int[][]t;
    public int lcsubstring(String X, String Y, int m, int n, int currentLength) {
        /*TODO: Note that this is not the completely correct solution. It fails for most cases
        if (m == 0 || n == 0) {
            t[m][n]= currentLength; // Base case
            return t[m][n];
        }

 /*       if(t[m][n]!=-1)
            return t[m][n];
 */       // If characters match, increment currentLength and recurse
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            currentLength = lcsubstring(X, Y, m - 1, n - 1, currentLength + 1);
            maxLength = Math.max(maxLength, currentLength); // Update global maxLength
            t[m][n]=currentLength;
        }
            // If characters don't match, reset currentLength and continue recursion
            maxLength=Math.max(maxLength,Math.max(lcsubstring(X, Y, m - 1, n, 0),
            lcsubstring(X, Y, m, n - 1, 0)));



        return maxLength; // Return the global maximum
    }

    public int lcsubstring(String X,String Y)
    {
        if(X==null ||Y==null)
            return 0;

        maxLength=0;
        int m=X.length(),n=Y.length();
        t=new int[m+1][n+1];
        for(int[] val:t)
            Arrays.fill(val,-1);

        return lcsubstring(X,Y,m,n,0);
    }

    public int lcsubstring_topDown(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] t = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            t[i][0] = 0;
        for (int j = 0; j < n + 1; j++)
            t[0][j] = 0;

        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    maxVal = Math.max(maxVal, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        String X = "abcdgh", Y = "abedfhl";
        int m = X.length(), n = Y.length();
        LongestCommonSubString obj = new LongestCommonSubString();
        //System.out.println("Longest Common Substring:" + obj.lcsubstring(X, Y, m, n, 0) + " Top down:" + obj.lcsubstring_topDown(X, Y, m, n));

        X = "ABCXYAB";
        Y = "XYABCAB";
        m = X.length(); n = Y.length();
        obj = new LongestCommonSubString();
        System.out.println("Longest Common Substring:" + obj.lcsubstring(X, Y) + " Top down:" + obj.lcsubstring_topDown(X, Y, m, n));

        X = "ABABC";
        Y = "BABCA";
        m = X.length(); n = Y.length();
        obj = new LongestCommonSubString();
//        System.out.println("Longest Common Substring:" + obj.lcsubstring(X, Y, m, n, 0) + " Top down:" + obj.lcsubstring_topDown(X, Y, m, n));

    }
}

package src.adityaverma.ds.mcm;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringRecursive {
    Map<String, Boolean> t = new HashMap<>();

    public static void main(String[] args) {
        String a = "great", b = "rgeat";
        ScrambledStringRecursive obj = new ScrambledStringRecursive();
        System.out.println("Is recursive(" + a + "," + b + "): " + obj.isScrambledString(a, b));
    }

    public boolean isScrambledString(String a, String b) {
        return solve(a, b);
    }

    public boolean solve(String a, String b) {
        if (a == null || b == null)
            return false;
        if (a.length() != b.length())
            return false;

        String key = a + "," + b;
        if (t.containsKey(key)) {
            return t.get(key);
        }
        if (a.equals(b))
            return true;

        boolean flag = false;
        int n = a.length();
        boolean condition1 = false, condition2 = false;
        for (int i = 1; i <= n - 1; i++) {

            if (solve(a.substring(0, i), b.substring(n - i, n)) && solve(a.substring(i, n), b.substring(0, n - i))) {
                condition1 = true;
            }

            if (solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i, n), b.substring(i, n))) {
                condition2 = true;
            }

            if (condition1 == true || condition2 == true) {
                flag = true;
                break;
            }
        }
        t.put(key, flag);
        return flag;
    }

}

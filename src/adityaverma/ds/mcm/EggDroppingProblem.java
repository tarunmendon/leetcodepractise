package src.adityaverma.ds.mcm;

import java.util.Arrays;

public class EggDroppingProblem {
    int[][] t;

    EggDroppingProblem(int e, int f) {
        t = new int[e + 1][f + 1];
        Arrays.stream(t).forEach(row -> Arrays.fill(row, -1));
    }

    public static void main(String[] args) {
        int egg = 2, floor = 5;
        EggDroppingProblem obj = new EggDroppingProblem(egg, floor);
        System.out.println(obj.solve(egg, floor));
    }

    private int solve(int e, int f) {
        if (e == 1)
            return f;
        if (f == 1 || f == 0)
            return f;

        if (t[e][f] != -1)
            return t[e][f];
        int min = Integer.MAX_VALUE;
        int low = 0, high = 0;
        for (int k = 1; k <= f; k++) {
            if (t[e - 1][k - 1] != -1) {
                low = t[e - 1][k - 1];
            } else {
                low = solve(e - 1, k - 1);
            }

            if (t[e][f - k] != -1) {
                high = t[e][f - k];
            } else {
                high = solve(e, f - k);
            }
            int temp = 1 + Math.max(low, high);
            min = Math.min(min, temp);
        }
        return t[e][f] = min;
    }
}

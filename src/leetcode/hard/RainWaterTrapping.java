package src.leetcode.hard;

import java.util.Arrays;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        /*1. Calculate max height to the left - Kadane's algorithm
          2. Calculate max height to the right - Kadane's algorithm
          3. Calcualte(min(maxhl[i],maxhr[i])-height[i]). Sum this together
          Pseudo code from Aditya Verma - Rain Water Trapping Problem
         */
        RainWaterTrapping obj = new RainWaterTrapping();
        System.out.println(obj.trap(height));
    }

    public int trap(int[] height) {
        int maxL[] = maxHeightToLeft(height);
        int maxR[] = maxHeightToRight(height);
        int water[] = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            water[i] = Math.min(maxL[i], maxR[i]) - height[i];
        }
        return Arrays.stream(water).sum();
    }

    public int[] maxHeightToLeft(int[] height) {
        int size=height.length;
        int maxL[] = new int[size];
        maxL[0] = height[0];
        for (int i = 1; i < size; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i]);
        }
        return maxL;
    }

    public int[] maxHeightToRight(int[] height) {
        int size=height.length;
        int maxR[] = new int[size];
        maxR[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i]);
        }
        return maxR;
    }
}

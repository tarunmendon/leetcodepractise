package src.leetcode.easy;

public class Problem69_Sqrt {
    public static void main(String[] args) {
        Problem69_Sqrt obj = new Problem69_Sqrt();
        int val = 8;
        System.out.println("Sqrt of " + val + ":" + obj.mySqrt(val));
    }

    //Gives timeout for large numbers ex - 2147395599
    public int mySqrt_try1(int x) {
        int sqrtDecimal = 1;
        for (int i = 1; i <= x / 2; i++) {
            if (i * i == x) {
                return i;
            } else if (i * i < x) {
                sqrtDecimal = i;
            }
        }
        return sqrtDecimal;
    }

    public int mySqrt(int x) {
        //https://tutorialcup.com/leetcode-solutions/sqrtx-leetcode-solution.htm
        if (x <= 1)
            return x;
        int left = 1, right = x / 2, mid = 0, ans = 0;
        long temp = 0;

        while (left <= right) {
            mid = (left + (right - left) / 2);
            temp = (long)mid * (long )mid;

            if (x == temp) {
                ans = mid;
                break;
            }
            if (temp < x)//go right
            {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

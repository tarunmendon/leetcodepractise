package src.leetcode.easy;

public class Problem70_ClimbingStairs {
    public static void main(String[] args) {
        Problem70_ClimbingStairs obj = new Problem70_ClimbingStairs();
        int n = 6;
        System.out.println("Climbing stairs for n:" + n + " is:" + obj.climbStairs(n));
    }

    public int climbStairs(int n) {
        //https://blog.devgenius.io/leetcode-70-climbing-stairs-get-solution-with-images-1939a8e6d525
    /*
    If N=1 -> 1
       N=2 -> 2
       N=3 -> 3
       N=4 -> 5(From step N=2 and N=3)
       N=5 -> 8(From step N=3 and N=4)
     */
        if (n <= 3)
            return n;
        int a = 2, b = 3, out = 0;
        for (int i = 3; i < n; i++) {
            out = a + b;
            a = b;
            b = out;
        }
        return out;
    }
}
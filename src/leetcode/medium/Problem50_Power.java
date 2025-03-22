package src.leetcode.medium;

public class Problem50_Power {
    public static void main(String[] args) {
        Problem50_Power obj = new Problem50_Power();
        System.out.println(obj.myPow(2.100, 3));
    }

    public double myPow(double x, int n) {
        // return Math.pow(x, n);
        double val = 1;
        if (n == 0)
            return 1;
        if(x==0||x==1)
            return x;
        for (int i = 0; i < Math.abs(n); i++) {
            val = val * x;
        }

        return (n > 0) ? val : (1 / val);
    }
}

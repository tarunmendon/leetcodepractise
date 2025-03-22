package src.leetcode.easy;

//https://leetcode.com/problems/power-of-two/description/
public class PowerOf2 {
public static void main(String[] args) {

}

    public boolean isPowerOfTwo(int n) {
        if(n==0||n<0)
            return false;
        return (0==(n&(n-1)));
    }
}

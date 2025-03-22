package src.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Problem66_PlusOne {

    public static void main(String[] args)
    {
        Problem66_PlusOne obj=new Problem66_PlusOne();
        int[]output=obj.plusOne(new int[]{9,9,9});
        printOutput(output);
        printOutput(obj.plusOne_FromLeetCode(new int[]{9,9,9}));
    }

    private static void printOutput(int[] output) {
        for(int val: output)
        {
            System.out.print(val+" ");
        }
        System.out.println();
    }

    public int[] plusOne(int[] digits) {
    if(digits==null ||digits.length==0)
        return null;
        ArrayList<Integer> out=new ArrayList();
         int sum=0;
        int carryOver=1;
        //compute

        for(int i=digits.length-1;i>=0;i--)
        {
            sum=digits[i]+carryOver;
            if(sum==10)
            {
                out.add(0);
                carryOver=1;
            }
            else {
                out.add(digits[i]+carryOver);
                carryOver = 0;
            }
        }
        if(carryOver==1)
            out.add(carryOver);
        Collections.reverse(out);
        int[] output=new int[out.size()];
        for(int i=0;i<output.length;i++)
            output[i]=out.get(i);

        return output;
    }

    public int[] plusOne_FromLeetCode(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

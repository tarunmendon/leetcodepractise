package src.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;

public class Problem67_AddBinary {
    public static void main(String args[])
    {
     /*   int a=0,b=0,carry=0;
        System.out.println("a^b^carry"+(a^b^carry));
        a=1;b=0;carry=0;
        System.out.println("a^b^carry"+(a^b^carry));
        a=1;b=1;carry=0;
        System.out.println("a^b^carry"+(a^b^carry));
        a=1;b=1;carry=1;
        System.out.println("a^b^carry"+(a^b^carry));*/
 /*   String a="1",b="0";
        int i = a.charAt(0) ^ b.charAt(0);
        System.out.println(i);
*/
        Problem67_AddBinary obj=new Problem67_AddBinary();
        String a="11",b="1";
        System.out.println(a+"+"+b+"="+obj.addBinary(a,b));

        a="1010";b="1011";
        System.out.println(a+"+"+b+"="+obj.addBinary(a,b));

    }
    public String addBinary(String a, String b) {
    int carry=0,t1=0,t2=0;
    ArrayList<Integer> output=new ArrayList<>();
    for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--)
    {
        t1=(i>=0)?a.charAt(i)=='1'?1:0:0;
        t2=(j>=0)?b.charAt(j)=='1'?1:0:0;
        output.add((t1^t2^carry));
        carry=(t1+t2+carry)>1?1:0;
    }
    if(carry==1)
        output.add(carry);
        Collections.reverse(output);
        String strOutput= output.stream().map(val->val.toString()).reduce((acc,val)->acc+val).get();

        return strOutput;
    }

    public String addBinaryLeetCodeSimple(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

package src.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6_ZigzagConversion {

    public static void main(String args[])
    {
        Problem6_ZigzagConversion obj=new Problem6_ZigzagConversion();
        String s="PAYPALISHIRING"; int n=3;
        System.out.println("Zigzag conversion for "+s+" of n:"+n+" window is"+obj.convert(s,n));
    }
    /* not working code*/
    public String convert(String s, int numRows) {
    if(s==null)
        return null;
    if(numRows==1)
        return s;

        List<List<Character>> out=new ArrayList<>();
        for(int k=0;k<numRows;k++)
            out.add(new ArrayList<>());

    int i=0;
            while(i<s.length())
            {
                //go down
                for(int j=0;j<numRows && i<s.length();j++)
                {
                    (out.get(j)).add(s.charAt(i));
                    i++;
                }
                for(int j=(numRows)/2;j>0 && i<s.length();j--) {
                    (out.get(j)).add(s.charAt(i));
                    i++;
                }
            }

            String finalVal="";
    for(int k=0;k<numRows;k++)
    {
        finalVal+=out.get(k).stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(out.get(k));
    }
    //System.out.println(finalVal);
    return finalVal;
    }
}

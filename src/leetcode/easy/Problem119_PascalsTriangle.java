package src.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem119_PascalsTriangle {

    public static void main(String[] args)
    {
        Problem119_PascalsTriangle obj=new Problem119_PascalsTriangle();
        System.out.println(obj.getRow(0));
    }
        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> lst=new ArrayList();

            if(rowIndex==0)
            {
                return  new ArrayList<Integer>();
            }
            else if(rowIndex==1)
            {
                List<Integer> alSubLst=new ArrayList<Integer>();
                alSubLst.add(1);
                lst.add(alSubLst);
            }
            else
            {
                List<Integer> alSubLst=new ArrayList<Integer>();
                alSubLst.add(1);
                lst.add(alSubLst);
                alSubLst=new ArrayList<Integer>();
                alSubLst.add(1);
                alSubLst.add(1);
                lst.add(alSubLst);
            }
            for(int i=2;i<rowIndex;i++)
            {
                List<Integer> newLst=new ArrayList<Integer>();
                List<Integer> prevLst=lst.get(lst.size()-1);
                newLst.add(1);
                for(int j=0;j<prevLst.size()-1;j++)
                    newLst.add(prevLst.get(j)+prevLst.get(j+1));

                newLst.add(1);
                lst.add(newLst);
            }

            return lst.get(lst.size()-1);

        }
}

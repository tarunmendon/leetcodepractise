package src.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesisRecursion {

	public static void main(String[] args)
	{
		GenerateParanthesisRecursion obj=new GenerateParanthesisRecursion();
		System.out.println(obj.generateParenthesis(3));
	}

	 public List<String> generateParenthesis(int n) 
	 {
		 List<String> out=new ArrayList<String>();
		 generateParenthesisRecursion_BackTrack(out,"",n,n,n*2);
		 
		 return out;
	 }
	 
	 public void generateParenthesisRecursion_BackTrack(List<String> out,String str,int open,int close,int total)
	 {
		if(open>close)
			return;
		 if(str.length()==total)
		 {
			 out.add(str.toString());
			 return;
		 }
		 
		 if(open>0)
		 {
			 generateParenthesisRecursion_BackTrack(out,str+"(",open-1,close,total);
		 }
		 if(close>0)
		 {
			 generateParenthesisRecursion_BackTrack(out,str+")",open,close-1,total);
		 }
	 }

}

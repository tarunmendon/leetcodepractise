package src.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates= new int[] {2,3,5};
		int target=8;
		CombinationSum obj=new CombinationSum();
		obj.combinationSum(candidates, target);
	}

	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		 List<List<Integer>> list=new ArrayList<>();
		 
		 unboundedKnapSackCoinChangeMax(candidates,candidates.length,target,list,null);
		// System.out.println();
		// System.out.println(list);
		 return list;
	    }

		public int unboundedKnapSackCoinChangeMax(int[] wt,int N,int weight,List<List<Integer>> targetList,List<Integer> list)
		{
			List<Integer> newList=(list==null)?new ArrayList():list;
			if(N==0||weight<0)
			{
				//newList.clear();
				return 0;
			}	
			if(weight==0)
			{
				targetList.add(new ArrayList(list));
				return 1;
			}	
			if(wt[N-1]<=weight)
			{
				newList.add(wt[N-1]);
				
				int sum=unboundedKnapSackCoinChangeMax(wt, N, weight-wt[N-1],targetList,newList);
				newList.remove(newList.size()-1);
				sum+=unboundedKnapSackCoinChangeMax(wt, N-1, weight,targetList,newList);

				return sum;	
			}
			else
			{
				return unboundedKnapSackCoinChangeMax(wt, N-1, weight,targetList,newList);
			}
		}

}

package src.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Wrong solution -- knapsack doesnot work for duplicates*/
public class CombinationSum2 {

	public static void main(String[] args) {
		int[] candidates= new int[]  {1,1,2,3};
		int target=4;
		CombinationSum2 obj=new CombinationSum2();
		System.out.println(obj.combinationSum2(candidates, target));
	}
	/* Wrong solution -- knapsack doesnot work for duplicates*/
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		 List<List<Integer>> list=new ArrayList<>();
		 Arrays.sort(candidates);
		 int cnt=knapSackProblem(candidates,candidates.length,target,list,null,-1);
		System.out.println(cnt);
		// System.out.println(list);
		 return list;
	    }
	/* Wrong solution -- knapsack doesnot work for duplicates*/
		public int knapSackProblem(int[] wt,int N,int weight,List<List<Integer>> targetList,List<Integer> list,int prev)
		{
			List<Integer> newList=(list==null)?new ArrayList():list;
			if(weight==0)
			{
				targetList.add(new ArrayList(list));
				return 1;
			}
			else if(N==0||weight<0)
				return 0;
			else if (wt[N - 1] <= weight /* && prev!=wt[N-1] */ )
			{
				newList.add(wt[N-1]);
				prev=wt[N-1];
				int sum=knapSackProblem(wt, N-1, weight-wt[N-1],targetList,newList,prev);
				newList.remove(newList.size()-1);
				sum+=knapSackProblem(wt, N-1, weight,targetList,newList,prev);

				return sum;	
			}
			else
			{
				return knapSackProblem(wt, N-1, weight,targetList,newList,prev);
			}
		}

}

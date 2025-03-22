package src.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* Wrong solution -- knapsack doesnot work for duplicates*/
public class Problem40_CombinationSum2 {

    public static void main(String[] args) {
        Problem40_CombinationSum2 obj = new Problem40_CombinationSum2();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(obj.combinationSum2(candidates, target));
    }
    /* Wrong solution -- knapsack doesnot work for duplicates*/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        //Sorted to remove duplicates
        Arrays.sort(candidates);
        boundedKnapSack(candidates, target, candidates.length, out, null,-1);

        return out;
    }
    /* Wrong solution -- knapsack doesnot work for duplicates*/
    public void boundedKnapSack(int[] wt, int weight, int N, List<List<Integer>> out, List<Integer> list,int prev) {
        List<Integer> newList = (list == null) ? new ArrayList<>() : list;
        if (weight == 0) {
            out.add(new ArrayList<>(newList));
            return;
        } else if (N == 0 || weight < 0) {
            return;
        }

        if (wt[N - 1] <= weight && prev!=wt[N-1]) {
            prev=wt[N-1];
            newList.add(wt[N - 1]);
            boundedKnapSack(wt, weight - wt[N - 1], N - 1, out, newList,prev);
            newList.remove(newList.size() - 1);
            boundedKnapSack(wt, weight, N - 1, out, newList,prev);
            return;
        } else {
            boundedKnapSack(wt, weight, N - 1, out, newList,prev);
        }


    }
}

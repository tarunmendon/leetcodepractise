package src.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        CombinationSum obj = new CombinationSum();
        List<List<Integer>> output = null;
        output = obj.combinationSum(candidates, target);
        System.out.println(output);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        unboundedKnapSackCoinChangeMax(candidates, candidates.length, target, list, null);
        return list;
    }

    public void unboundedKnapSackCoinChangeMax(int[] wt, int N, int weight, List<List<Integer>> targetList, List<Integer> list) {
        List<Integer> newList = (list == null) ? new ArrayList() : list;
        if (N == 0 || weight < 0) {
            //newList.clear();
            return;
        }
        if (weight == 0) {
            targetList.add(new ArrayList(list));
            return;
        }
        if (wt[N - 1] <= weight) {
            newList.add(wt[N - 1]);

            unboundedKnapSackCoinChangeMax(wt, N, weight - wt[N - 1], targetList, newList);
            newList.remove(newList.size() - 1);
            unboundedKnapSackCoinChangeMax(wt, N - 1, weight, targetList, newList);

            return;
        } else {
            unboundedKnapSackCoinChangeMax(wt, N - 1, weight, targetList, newList);
            return;
        }
    }

}

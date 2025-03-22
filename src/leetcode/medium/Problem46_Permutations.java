package src.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem46_Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        Problem46_Permutations obj = new Problem46_Permutations();
        System.out.println(obj.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited=new boolean[nums.length];
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> list=new ArrayList<>();
     permute_helper(nums,visited,out,list);
     return out;
    }

    public void permute_helper(int[] nums, boolean[] visited, List<List<Integer>> out, List<Integer> list) {
        if (list.size() == nums.length) {
            out.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                permute_helper(nums, visited, out, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}

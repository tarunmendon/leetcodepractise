package src.adityaverma.ds.tree;


  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class BinaryTreeMaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] result=new int[1];
        result[0]=Integer.MIN_VALUE;
        solve(root, result);
        return result[0];
    }

    int solve(TreeNode root,int[] result)
    {
        /* Aditya Verma solution*/

        /*Base Condition*/
        if(root==null) {
            return 0;
        }

        /*Hypothesis*/
        int left=solve(root.left,result);
        int right=solve(root.right, result);

        int temp = Math.max(left,right)+root.val;
        int ans = Math.max(temp,left+right+root.val);
        result[0] = Math.max(result[0],ans);

        return temp;
    }

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(-1,new TreeNode(2),new TreeNode(-2));
        BinaryTreeMaxPathSum obj=new BinaryTreeMaxPathSum();
        System.out.println(obj.maxPathSum(root));
    }
}
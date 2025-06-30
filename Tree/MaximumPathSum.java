/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] dp=new int[1];
        dp[0]=Integer.MIN_VALUE;
        int res=f(root,dp);
        return Math.max(res,dp[0]);
    }

    int f(TreeNode root,int[] dp){
        if(root==null) return 0;

        int left=Math.max(0,f(root.left,dp));
        int right=Math.max(0,f(root.right,dp));

        dp[0]=Math.max(dp[0],Math.max(left+right+root.val,root.val));

        return Math.max(Math.max(left,right)+root.val,root.val);
    }
}

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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        // boolean[] flag=new boolean[1];
        
        int res=f(root);
        if(res>=5001) return false;
        else return true;
    }

    int f(TreeNode root){
        if(root==null) return 0;
        
        int left=f(root.left);
        // if(left == -1) return -1;
        int right=f(root.right);
        // if(right == -1) return -1;

        if(Math.abs(left-right)>1 ){
            // flag[0]=true;
            // if(flag[0]) return 5001;
            return 5001;
        }
        return 1+Math.max(left,right);
    }
}

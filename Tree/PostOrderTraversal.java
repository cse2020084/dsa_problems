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
    List<Integer> l=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return l;
        // postorderTraversal(root.left);
        // postorderTraversal(root.right);
        // l.add(root.val);
        // return l;

        Stack<TreeNode> st=new Stack<>();
        Stack<TreeNode> res=new Stack<>();

        st.push(root);

        while(!st.isEmpty()){
            TreeNode node=st.pop();
            res.push(node);
            if(node.left!=null) st.push(node.left);
            if(node.right!=null) st.push(node.right);

        }
        

        while(!res.isEmpty()) l.add(res.pop().val);
        return l;
        
    }
}
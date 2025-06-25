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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll=new ArrayList<>();
        Queue<List<TreeNode>> q=new LinkedList<>();

        if(root==null) return ll;
        List<TreeNode> l=new ArrayList<>(); 
        l.add(root);   
        q.offer(l);

        while(!q.isEmpty()){
            l=q.poll();
            // ll.add(l);
            List<TreeNode> list=new ArrayList<>();
            List<Integer> values=new ArrayList<>();
            for(TreeNode e:l){
                if(e.left!=null) list.add(e.left);
                if(e.right!=null) list.add(e.right);
                values.add(e.val);
            }
            if(!list.isEmpty()) q.offer(list);
            ll.add(values);
        }
        return ll;
    }
}
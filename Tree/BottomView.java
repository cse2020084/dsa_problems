/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;
class Node{
    int col;
    TreeNode treeNode;

    public Node(int col,TreeNode treeNode){
        this.col=col;
        this.treeNode=treeNode;
    }
}
public class Solution {
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here. 
        List<Integer> l=new ArrayList<>();
        if(root==null) return l;
        Queue<Node> q=new LinkedList<>();
        TreeMap<Integer,Integer> mp=new TreeMap<>();

        q.offer(new Node(0,root));
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node node=q.poll();
                if(node.treeNode.left!=null) q.offer(new Node(node.col-1,node.treeNode.left));
                if(node.treeNode.right!=null) q.offer(new Node(node.col+1,node.treeNode.right));
                mp.put(node.col,node.treeNode.val);
            }
        }

        // for(Node e:mp.values()){
        //     l.add(e.treeNode.val);
        // }

        for(Integer e:mp.values()) l.add(e);

        return l;



    }
}

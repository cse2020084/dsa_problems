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
    private class Node{
        int row;
        int column;

        public Node(int row, int column){
            this.row=row;
            this.column=column;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Node p = (Node) obj;
            return row == p.row && column==p.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Comparator<Node> comp= (a,b) -> Integer.compare(a.column,b.column);
         Comparator<Node> comp= (a,b) -> {
            if (a.column != b.column)
                return Integer.compare(a.column, b.column);
            else
                return Integer.compare(a.row, b.row);
        };
        TreeMap<Node,List<Integer>> mp=new TreeMap<>(comp);
        List<List<Integer>> ll=new ArrayList<>();
        fillMap(mp,root,0,0);

        while(!mp.isEmpty()){
            int firstKey=mp.firstKey().column;
            PriorityQueue<Node> pq=new PriorityQueue<>((a,b) -> Integer.compare(a.row,b.row));
            List<Integer> l=new ArrayList<>();
            Map<Node,List<Integer>> map=new HashMap<>();
            while(!mp.isEmpty() && mp.firstKey().column==firstKey){
                var e=mp.pollFirstEntry();
                pq.add(e.getKey());
                map.put(e.getKey(),e.getValue());
            }
            while(!pq.isEmpty()){
                Node node=pq.poll();
                List<Integer> list=map.get(node);
                if(list!=null){
                    Collections.sort(list);
                    l.addAll(list);
                }
            }
            ll.add(l);
        }
        return ll;
    }
    private void fillMap(TreeMap<Node,List<Integer>> mp,TreeNode root,int row,int col){
        if(root==null) return;
        Node node=new Node(row,col);
        if(!mp.containsKey(node)){
            mp.put(node,new ArrayList<Integer>());
        }
        mp.get(node).add(root.val);

        fillMap(mp,root.left,row+1,col-1);
        fillMap(mp,root.right,row+1,col+1);
    }
}

class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode node,int index) {
        this.node=node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,1));
        while(!q.isEmpty()) {
            int size=q.size();
            int leftIdx=0;
            int rightIdx=0;
            for(int i=0;i<size;i++) {
                Pair curr = q.poll();
                if(i==0) leftIdx=curr.index;
                if(i==size-1) rightIdx=curr.index;
                if(curr.node.left!=null) q.add(new Pair(curr.node.left,2*curr.index));
                if(curr.node.right!=null) q.add(new Pair(curr.node.right,2*curr.index+1));

            }
            
            maxWidth=Math.max((rightIdx-leftIdx+1),maxWidth);   
        }
        return maxWidth;
  
    }
}
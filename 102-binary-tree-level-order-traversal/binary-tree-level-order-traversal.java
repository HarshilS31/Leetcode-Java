class Pair {
    TreeNode node;
    int level;
    Pair(TreeNode node,int level) {
        this.node=node;
        this.level=level;
    }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(q.size()>0) {
            ArrayList<Integer> arr = new ArrayList<>();
            Pair top = q.poll();
            int currLevel=top.level;
            if(currLevel==ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(currLevel).add(top.node.val);
            if(top.node.left!=null) {
                q.add(new Pair(top.node.left,currLevel+1));
            }
            if(top.node.right!=null) {
                q.add(new Pair(top.node.right,currLevel+1));
            }
        }
        return ans;


        
    }
}
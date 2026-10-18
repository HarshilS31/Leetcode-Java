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
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()) {
            Pair top = q.poll();
            TreeNode currNode = top.node;
            int currLevel=top.level;
            if(currLevel==res.size()){
                res.add(new ArrayList<>());
            }
            res.get(currLevel).add(currNode.val);
            if(currNode.left!=null) q.add(new Pair(currNode.left,currLevel+1));
            if(currNode.right!=null) q.add(new Pair(currNode.right,currLevel+1));
        }
        return res;
    }
}
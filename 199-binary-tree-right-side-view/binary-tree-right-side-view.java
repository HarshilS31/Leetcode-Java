class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        treeView(root,ans,0);
        return ans;
        
    }
    public void treeView(TreeNode node,List<Integer> ans,int level) {
        if(node==null) return;
        if(level>=ans.size()) ans.add(node.val);
        else ans.set(level,node.val);
        treeView(node.left,ans,level+1);
        treeView(node.right,ans,level+1);

    }
}
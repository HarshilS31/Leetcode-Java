class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode node) {
        if(node==null) return;
        flatten(node.right);
        flatten(node.left);
        node.right=prev;
        node.left=null;
        prev=node;       
    }
}
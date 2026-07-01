class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node,TreeNode p,TreeNode q) {
        if(node==null) return node;
        if(p.val>node.val && q.val>node.val) return lowestCommonAncestor(node.right,p,q);
        else if(p.val<node.val && q.val<node.val) return lowestCommonAncestor(node.left,p,q);
        else return node;      
    }
}
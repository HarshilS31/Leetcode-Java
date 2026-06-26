
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode goLeft = lowestCommonAncestor(root.left,p,q);
        TreeNode goRight = lowestCommonAncestor(root.right,p,q);
        if(goLeft==null) return goRight;
        else if(goRight==null) return goLeft;
        else return root;
            
        
    
    }
}
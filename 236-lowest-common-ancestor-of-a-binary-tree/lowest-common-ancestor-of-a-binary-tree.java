class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return root;
        if (p.val==root.val || q.val==root.val) return root;
        boolean pInLeft=exists(root.left,p);
        boolean qInLeft=exists(root.left,q);
        if(pInLeft && qInLeft) return lowestCommonAncestor(root.left,p,q);
        else if(!pInLeft && !qInLeft) return lowestCommonAncestor(root.right,p,q);
        else return root;

        
    }
    public static boolean exists(TreeNode root,TreeNode data) {
        if(root==null) return false;
        if (root.val==data.val) return true;
        
        return exists(root.right,data) || exists(root.left,data);

       

        
    }

    
}
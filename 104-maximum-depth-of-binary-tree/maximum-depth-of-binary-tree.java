class Solution {
    public int maxDepth(TreeNode root) {
        return levels(root);
        
    }
    int levels(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(levels(root.right),levels(root.left));

    
    }
}
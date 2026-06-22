class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        int leftLevels=levels(root.left);
        int rightLevels=levels(root.right);
        if(Math.abs(rightLevels-leftLevels)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }
    int levels(TreeNode root) {
        return root==null ? 0 :1+Math.max(levels(root.left),levels(root.right));


    
    }
}
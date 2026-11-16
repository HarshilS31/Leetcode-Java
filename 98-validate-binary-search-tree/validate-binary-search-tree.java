class Solution {
    public Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return checkBST(root);
    }
    public boolean checkBST(TreeNode root) {
        if(root==null) return true;
        if(!checkBST(root.left)) return false;
        if(prev!=null && root.val<=prev) return false;
        prev=root.val;
        return checkBST(root.right);


    }
}
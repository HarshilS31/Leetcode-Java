class Solution {
    Integer prev=null;
    public boolean isValidBST(TreeNode root) {
        return checkBST(root);
    }
    public boolean checkBST(TreeNode node) {
        if(node==null) return  true;
        if(!checkBST(node.left)) return false;
        if(prev!=null && node.val<=prev) return false;
        prev=node.val;
        return checkBST(node.right);
    }
}
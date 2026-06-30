class Solution {
    Integer prev=null;
    public boolean isValidBST(TreeNode root) { 
        return validateBST(root);


    }   
    public boolean validateBST(TreeNode node) {
        if(node==null) return true;
        if(!validateBST(node.left)) return false;
        if(prev!=null && node.val<=prev) return false;
        prev=node.val;
        return validateBST(node.right);
    }

}
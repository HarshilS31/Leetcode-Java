class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        insertNode(root,val);
        return root;
        
    }
    public void insertNode(TreeNode root,int val) {
        if(root==null) return;
        if(root.val==val) return;
        if(root.val<val) {
            if(root.right==null) {
                root.right = new TreeNode(val);
            }
            else insertNode(root.right,val);
        }
        else {
            if(root.left==null) root.left =  new TreeNode(val);
            else insertNode(root.left,val);
        }
    }
}
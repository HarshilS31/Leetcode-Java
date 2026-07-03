class Solution { 
    TreeNode prev=null;
    TreeNode first = null;
    TreeNode mid = null;
    TreeNode last=null;
    public void recoverTree(TreeNode root) {
        swapNodes(root);
        if(last!=null) {
            int temp=first.val;
            first.val=last.val;
            last.val=temp;

        }
        else {
            int temp=first.val;
            first.val=mid.val;
            mid.val=temp;
    
        }
        
    }
    void swapNodes(TreeNode node) {
        if(node==null) return;
        swapNodes(node.left);
        if(prev!=null && node.val<prev.val) {
            if(first==null) {
                first=prev;
                mid=node;
            }
            else last=node;

        }
        prev=node;
        swapNodes(node.right);
    }
}
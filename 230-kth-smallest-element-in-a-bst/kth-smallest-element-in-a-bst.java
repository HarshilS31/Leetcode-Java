class Solution {
    int count=0;
    int ans=-1;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    
        
    }
    public void inOrder(TreeNode node,int k) {
        if(node==null || count>=k) return;
        inOrder(node.left,k);
        count++;
        if(count==k) ans=node.val;
        inOrder(node.right,k);
    }
}
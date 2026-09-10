class Solution {
    int sum;
    int nodes;
    int avgNodes=0;
    public int averageOfSubtree(TreeNode root) {
        traversal(root);
        return avgNodes;
        
    }
    public void traversal(TreeNode node) {
        if(node==null) return;
        sum=0;
        nodes=0;
        findTreeAvg(node);
        if(sum/nodes==node.val) avgNodes++;
        traversal(node.left);
        traversal(node.right);

    }
    public void findTreeAvg(TreeNode node) {
        if(node==null) return;
        sum+=node.val;
        nodes++;
        findTreeAvg(node.left);
        findTreeAvg(node.right);

        
    }


}
class Solution {
    int avgNodes=0;
    public int averageOfSubtree(TreeNode root) {
        traversal(root);
        return avgNodes;
    }
    public int[] traversal(TreeNode node) {
        if(node==null) return new int[]{0,0};
        int sum=0;
        int nodes=0;
        int[] left  = traversal(node.left);
        int[] right  = traversal(node.right);
        sum+=node.val+left[0]+right[0];
        nodes+=1+left[1]+right[1];
        if(sum/nodes==node.val) avgNodes++;
        return new int[]{sum,nodes};
    }





}
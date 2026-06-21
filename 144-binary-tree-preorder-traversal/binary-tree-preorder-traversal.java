class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        preOrder(root,pre);
        return pre;
        
    }
    void preOrder(TreeNode root,List<Integer> pre) {
        if(root==null) return;
        pre.add(root.val);
        preOrder(root.left,pre);
        preOrder(root.right,pre);
    }
}
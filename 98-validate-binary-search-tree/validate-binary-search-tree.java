class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root,nodes);
        for(int i=1;i<nodes.size();i++) {
            if(nodes.get(i-1)>=nodes.get(i)) return false;
        }
        return true;
    }
    public void inorder(TreeNode node,List<Integer> nodes) {
        if(node==null) return;
        inorder(node.left,nodes);
        nodes.add(node.val);
        inorder(node.right,nodes);
    }

}